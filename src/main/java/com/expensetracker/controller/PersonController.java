package com.expensetracker.controller;

import com.expensetracker.dto.PersonDto;
import com.expensetracker.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public String listPersons(Model model) {

        List<PersonDto> persons = personService.findAllPersons();
        model.addAttribute("persons", persons);
        return "persons-list";
    }
}
