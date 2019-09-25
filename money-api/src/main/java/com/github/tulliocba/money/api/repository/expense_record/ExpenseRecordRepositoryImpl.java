package com.github.tulliocba.money.api.repository.expense_record;

import com.github.tulliocba.money.api.model.ExpenseRecord;
import com.github.tulliocba.money.api.repository.filter.ExpenseRecordFilter;
import com.github.tulliocba.money.api.repository.projection.ExpenseRecordProjection;
import com.github.tulliocba.money.api.repository.util.PageableDelegate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseRecordRepositoryImpl implements ExpenseRecordRepositoryQuery {

    @Autowired
    private PageableDelegate<ExpenseRecord> expenseRecordPageableDelegate;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<ExpenseRecord> findExpenseRecordBy(ExpenseRecordFilter filter, Pageable pageable) {
        TypedQuery<ExpenseRecord> query = getExpenseRecordTypedQuery(filter);

        List<ExpenseRecord> expenses = query.getResultList();

        return new PageImpl<>(expenseRecordPageableDelegate.getResultPageable(pageable, query), pageable, expenses.size());
    }

    private TypedQuery<ExpenseRecord> getExpenseRecordTypedQuery(ExpenseRecordFilter filter) {
        StringBuilder sql = new StringBuilder("select expenseRecord from ExpenseRecord expenseRecord where 1=1 ");

        if (StringUtils.isNotEmpty(filter.getDescription()))
            sql.append("and expenseRecord.description like :description ");

        if (filter.getInvoiceExpirationFrom() != null)
            sql.append("and expenseRecord.invoiceExpirationDate >= :invoiceDateFrom ");

        if (filter.getInvoiceExpirationTo() != null)
            sql.append("and expenseRecord.invoiceExpirationDate <= :invoiceDateTo ");


        TypedQuery<ExpenseRecord> query = entityManager.createQuery(sql.toString(), ExpenseRecord.class);

        if (StringUtils.isNotEmpty(filter.getDescription()))
            query.setParameter("description", StringUtils.lowerCase("%" + filter.getDescription() + "%"));

        if (filter.getInvoiceExpirationFrom() != null)
            query.setParameter("invoiceDateFrom", filter.getInvoiceExpirationFrom());

        if (filter.getInvoiceExpirationTo() != null)
            query.setParameter("invoiceDateTo", filter.getInvoiceExpirationTo());

        return query;
    }

    @Override
    public Page<ExpenseRecordProjection> digest(ExpenseRecordFilter filter, Pageable pageable) {
        TypedQuery<ExpenseRecord> query = getExpenseRecordTypedQuery(filter);

        int totalSize = query.getResultList().size();

        List<ExpenseRecordProjection> expenses = expenseRecordPageableDelegate.getResultPageable(pageable, query).stream().map(expenseRecord -> new ExpenseRecordProjection(
                expenseRecord.getId(), expenseRecord.getDescription(), expenseRecord.getInvoiceExpirationDate(), expenseRecord.getPayableDate()
                ,expenseRecord.getAmount(), expenseRecord.getObservation(), expenseRecord.getType(),expenseRecord.getCategory().getName(),
                expenseRecord.getPerson().getName()
        )).collect(Collectors.toList());

        return new PageImpl<>(expenses, pageable, totalSize);
    }

}
