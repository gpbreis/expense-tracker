package com.expensetracker.service;

import com.expensetracker.dto.CardDto;
import com.expensetracker.model.Card;

import java.util.List;

public interface CardService {

    List<CardDto> findAllCards();

    Card createCard(CardDto cardDto);
}
