package com.expensetracker.controller;

import com.expensetracker.dto.PersonDto;
import com.expensetracker.model.Person;
import com.expensetracker.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String createPerson(@Valid @ModelAttribute("person") PersonDto personDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(personDto);
            return "create-person";
        }
        personService.createPerson(personDto);
        return "redirect:/persons";
    }

    @GetMapping("/persons/{personId}/edit")
    public String editPersonForm(@PathVariable("personId") Long personId, Model model) {
        PersonDto person = personService.findPersonById(personId);
        model.addAttribute("person", person);
        return "persons-edit";
    }

    @PostMapping("/persons/{personId}/edit")
    public String updatePerson(@PathVariable("personId") Long personId, @Valid @ModelAttribute("person") PersonDto person, BindingResult result) {
        if (result.hasErrors()) {
            return "persons-edit";
        }
        person.setId(personId);
        personService.updatePerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/persons/{personId}/delete")
    public String deletePerson(@PathVariable("personId") Long personId) {
        personService.delete(personId);
        return "redirect:/persons";
    }

    @GetMapping("/persons/{personId}")
    public String personDetail(@PathVariable("personId") Long personId, Model model) {
        PersonDto personDto = personService.findPersonById(personId);
        model.addAttribute("person", personDto);
        return "persons-detail";
    }

    @GetMapping("/persons/search")
    public String searchPersons(@RequestParam(value = "query") String query, Model model) {
        List<PersonDto> persons = personService.searchPersons(query);
        model.addAttribute("persons", persons);
        return "persons-list";
    }
}
