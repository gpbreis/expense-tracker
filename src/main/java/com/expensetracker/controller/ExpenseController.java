package com.expensetracker.controller;

import com.expensetracker.dto.CardDto;
import com.expensetracker.dto.ExpenseDto;
import com.expensetracker.dto.PersonDto;
import com.expensetracker.model.Expense;
import com.expensetracker.service.CardService;
import com.expensetracker.service.ExpenseService;
import com.expensetracker.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExpenseController {

    private ExpenseService expenseService;
    private CardService cardService;
    private PersonService personService;

    public ExpenseController(ExpenseService expenseService, CardService cardService, PersonService personService) {
        this.expenseService = expenseService;
        this.cardService = cardService;
        this.personService = personService;
    }

    @GetMapping("/expenses")
    public String listExpenses(Model model) {

        List<ExpenseDto> expenses = expenseService.findAllExpenses();
        model.addAttribute("expenses", expenses);
        return "expenses-list";
    }

    @GetMapping("/expenses/create")
    public String createExpense(Model model) {
        Expense expense = new Expense();
        List<PersonDto> persons = personService.findAllPersons();
        List<CardDto> cards = cardService.findAllCards();
        model.addAttribute("expense", expense);
        model.addAttribute("persons", persons);
        model.addAttribute("cards", cards);
        return "create-expense";
    }

}
