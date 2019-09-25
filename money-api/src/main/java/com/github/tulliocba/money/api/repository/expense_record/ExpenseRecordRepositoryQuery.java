package com.github.tulliocba.money.api.repository.expense_record;

import com.github.tulliocba.money.api.model.ExpenseRecord;
import com.github.tulliocba.money.api.repository.filter.ExpenseRecordFilter;
import com.github.tulliocba.money.api.repository.projection.ExpenseRecordProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExpenseRecordRepositoryQuery {
    Page<ExpenseRecord> findExpenseRecordBy(ExpenseRecordFilter filter, Pageable pageable);

    Page<ExpenseRecordProjection> digest(ExpenseRecordFilter filter, Pageable pageable);
}
