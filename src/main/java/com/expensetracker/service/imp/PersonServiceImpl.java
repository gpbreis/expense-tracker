package com.expensetracker.service.imp;

import com.expensetracker.dto.PersonDto;
import com.expensetracker.model.Person;
import com.expensetracker.repository.PersonRopository;
import com.expensetracker.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRopository personRopository;

    public PersonServiceImpl(PersonRopository personRopository) {
        this.personRopository = personRopository;
    }


    @Override
    public List<PersonDto> findAllPersons() {
        List<Person> persons = personRopository.findAll();
        return persons.stream().map(person -> mapToPersonDto(person)).collect(Collectors.toList());
    }

    private PersonDto mapToPersonDto(Person person) {
        PersonDto personDto = new PersonDto(person.getId(),
                                            person.getName(),
                                            person.getBirthDate(),
                                            person.getSex(),
                                            person.getAge(),
                                            person.getSalary());
        return personDto;
    }
}
