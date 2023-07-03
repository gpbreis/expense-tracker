package com.expensetracker.repository;

import com.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpenseRopository extends JpaRepository<Expense, Long> {

    Optional<Expense> findExpenseByTitle(String title);
}
