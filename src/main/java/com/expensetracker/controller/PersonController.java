package com.expensetracker.controller;

import com.expensetracker.dto.PersonDto;
import com.expensetracker.model.Person;
import com.expensetracker.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/persons/create")
    public String createPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "create-person";
    }

    @PostMapping("/persons/create")
    public String createPerson(@ModelAttribute("person") Person person) {
        personService.createPerson(person);
        return "redirect:/persons";
    }
}
