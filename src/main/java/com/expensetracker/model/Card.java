package com.expensetracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastFourDigits;
    private LocalDate expirationDate;
    private LocalDate closingDate;
    private LocalDate dueDate;
    private BigDecimal cardLimit;

    public Card() {
    }

    public Card(Long id, String lastFourDigits, LocalDate expirationDate, LocalDate closingDate, LocalDate dueDate, BigDecimal cardLimit) {
        this.id = id;
        this.lastFourDigits = lastFourDigits;
        this.expirationDate = expirationDate;
        this.closingDate = closingDate;
        this.dueDate = dueDate;
        this.cardLimit = cardLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(BigDecimal limit) {
        this.cardLimit = limit;
    }

}
