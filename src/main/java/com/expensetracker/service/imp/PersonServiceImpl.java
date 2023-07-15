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

    @Override
    public PersonDto findPersonById(Long personId) {
        Person person = personRopository.findById(personId).get();
        return mapToPersonDto(person);
    }

    @Override
    public Person createPerson(PersonDto personDto) {
        Person person = mapToPerson(personDto);
        return personRopository.save(person);
    }

    @Override
    public void updatePerson(PersonDto personDto) {
        Person person = mapToPerson(personDto);
        personRopository.save(person);
    }

    @Override
    public void delete(Long personId) {
        personRopository.deleteById(personId);
    }

    private Person mapToPerson(PersonDto person) {
        return new Person(person.getId(),
                                    person.getName(),
                                    person.getBirthdate(),
                                    person.getSex(),
                                    person.getSalary());
    }

    private PersonDto mapToPersonDto(Person person) {
        PersonDto personDto = new PersonDto(person.getId(),
                                            person.getName(),
                                            person.getBirthdate(),
                                            person.getSex(),
                                            person.getSalary());
        return personDto;
    }
}
