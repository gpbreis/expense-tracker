package com.expensetracker.service;

import com.expensetracker.dto.RegistrationDto;

public interface UserService {

    void saveUser(RegistrationDto registrationDto);
}
