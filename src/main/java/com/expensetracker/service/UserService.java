package com.expensetracker.service;

import com.expensetracker.dto.RegistrationDto;
import com.expensetracker.model.Users;

public interface UserService {

    void saveUser(RegistrationDto registrationDto);

    Users findByEmail(String email);

    Users findByUsername(String username);
}
