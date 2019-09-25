package com.github.tulliocba.money.api.repository.expense_record;

import com.github.tulliocba.money.api.model.ExpenseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRecordRepository extends JpaRepository<ExpenseRecord, Integer>, ExpenseRecordRepositoryQuery {
}
