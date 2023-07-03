package com.expensetracker.repository;

import com.expensetracker.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRopository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonByName(String name);
}
