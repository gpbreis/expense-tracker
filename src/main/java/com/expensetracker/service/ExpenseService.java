package com.expensetracker.service;

import com.expensetracker.dto.ExpenseDto;
import com.expensetracker.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDto> findAllExpenses();

    Expense createExpense(ExpenseDto expenseDto);
}
