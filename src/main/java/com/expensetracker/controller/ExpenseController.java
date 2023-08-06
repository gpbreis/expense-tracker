package com.expensetracker.controller;

import com.expensetracker.dto.ExpenseDto;
import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public String listExpenses(Model model) {

        List<ExpenseDto> expenses = expenseService.findAllExpenses();
        model.addAttribute("expenses", expenses);
        return "expenses-list";
    }

    @GetMapping("/expenses/create")
    public String createExpense(Model model) {
        Expense person = new Expense();
        model.addAttribute("person", person);
        return "create-expense";
    }

}
