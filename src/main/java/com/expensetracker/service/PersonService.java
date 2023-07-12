package com.expensetracker.service;

import com.expensetracker.dto.PersonDto;
import com.expensetracker.model.Person;

import java.util.List;

public interface PersonService {

    List<PersonDto> findAllPersons();

    Person createPerson(Person person);
}
