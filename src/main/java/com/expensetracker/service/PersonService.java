package com.expensetracker.service;

import com.expensetracker.dto.PersonDto;

import java.util.List;

public interface PersonService {

    List<PersonDto> findAllPersons();
}
