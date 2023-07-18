package com.expensetracker.repository;

import com.expensetracker.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRopository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonByName(String name);

    @Query("SELECT p FROM person p WHERE p.name LIKE CONCAT('%', :query, '%')")
    List<Person> searchPersons(String query);
}
