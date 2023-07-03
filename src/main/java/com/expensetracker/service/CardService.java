package com.expensetracker.service;

import com.expensetracker.dto.CardDto;

import java.util.List;

public interface CardService {

    List<CardDto> findAllCards();
}
