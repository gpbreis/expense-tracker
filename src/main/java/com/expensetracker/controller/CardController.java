package com.expensetracker.controller;

import com.expensetracker.dto.CardDto;
import com.expensetracker.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CardController {

    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/cards")
    public String listCards(Model model) {

        List<CardDto> cards = cardService.findAllCards();
        model.addAttribute("cards", cards);
        return "cards-list";
    }
}
