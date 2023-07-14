package com.expensetracker.service;

import com.expensetracker.dto.PersonDto;
import com.expensetracker.model.Person;

import java.util.List;

public interface PersonService {

    List<PersonDto> findAllPersons();

    PersonDto findPersonById(Long personId);

    Person createPerson(PersonDto personDto);

    void updatePerson(PersonDto person);
}
