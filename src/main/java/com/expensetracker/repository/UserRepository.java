package com.expensetracker.repository;

import com.expensetracker.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
    Users findByUsername(String username);

    Users findFirstByUsername(String username);
}
