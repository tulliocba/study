package com.github.tulliocba.money.api.services;

import com.github.tulliocba.money.api.model.ExpenseRecord;
import com.github.tulliocba.money.api.model.Person;
import com.github.tulliocba.money.api.repository.expense_record.ExpenseRecordRepository;
import com.github.tulliocba.money.api.repository.person.PersonRepository;
import com.github.tulliocba.money.api.services.exception.NonExistentPersonOrNotEnabledException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseRecordService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ExpenseRecordRepository expenseRecordRepository;

    public ExpenseRecord saveExpenseRecord(ExpenseRecord expenseRecord) {
        Person person = personRepository.findOne(expenseRecord.getPerson().getId());

        validPersonState(person);

        return expenseRecordRepository.save(expenseRecord);
    }

    private void validPersonState(Person person) {
        if(person == null || person.isNotEnabled())
            throw new NonExistentPersonOrNotEnabledException();
    }

    public ExpenseRecord updateExpense(Integer expenseId, ExpenseRecord expenseRecord) {
        ExpenseRecord expenseBD = expenseRecordRepository.findOne(expenseId);
        BeanUtils.copyProperties(expenseRecord, expenseBD, "id");
        return expenseRecordRepository.save(expenseBD);
    }
}
