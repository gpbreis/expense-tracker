package com.expensetracker.repository;

import com.expensetracker.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findCardByLastFourDigits(String lastFourDigits);
}
