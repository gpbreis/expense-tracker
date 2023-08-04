package com.expensetracker.controller;

import com.expensetracker.dto.CardDto;
import com.expensetracker.dto.PersonDto;
import com.expensetracker.model.Card;
import com.expensetracker.service.CardService;
import com.expensetracker.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CardController {

    private CardService cardService;
    private PersonService personService;

    public CardController(CardService cardService, PersonService personService) {
        this.cardService = cardService;
        this.personService = personService;
    }

    @GetMapping("/cards")
    public String listCards(Model model) {

        List<CardDto> cards = cardService.findAllCards();
        model.addAttribute("cards", cards);
        return "cards-list";
    }

    @GetMapping("/cards/create")
    public String createCard(Model model) {
        Card card = new Card();
        List<PersonDto> person = personService.findAllPersons();
        model.addAttribute("persons", person);
        model.addAttribute("card", card);
        return "create-card";
    }

    @PostMapping("/cards/create")
    public String createCard(@Valid @ModelAttribute("card") CardDto cardDto, @ModelAttribute("persons") PersonDto personDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(cardDto);
            model.addAttribute("persons", personDto);
            return "create-card";
        }
        cardService.createCard(cardDto);
        return "redirect:/cards";
    }
}
