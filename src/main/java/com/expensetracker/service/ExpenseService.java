package com.expensetracker.service;

import com.expensetracker.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDto> findAllExpenses();
}
