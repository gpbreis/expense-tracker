package com.expensetracker.service.imp;

import com.expensetracker.dto.ExpenseDto;
import com.expensetracker.model.Expense;
import com.expensetracker.repository.ExpenseRopository;
import com.expensetracker.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRopository expenseRopository;

    public ExpenseServiceImpl(ExpenseRopository expenseRopository) {
        this.expenseRopository = expenseRopository;
    }

    public List<ExpenseDto> findAllExpenses() {
        List<Expense> expenses = expenseRopository.findAll();
        return expenses.stream().map(expense -> mapToExpenseDto(expense)).collect(Collectors.toList());
    }
    private ExpenseDto mapToExpenseDto(Expense expense) {
        ExpenseDto expenseDto = new ExpenseDto(expense.getId(),
                                                expense.getTitle(),
                                                expense.getContent(),
                                                expense.getValue(),
                                                expense.getExpenseDate(),
                                                expense.getCreatedOn(),
                                                expense.getUpdatedOn(),
                                                expense.getCardId());
        return expenseDto;
    }
}
