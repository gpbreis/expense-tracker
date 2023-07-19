package com.expensetracker.dto;

import com.expensetracker.model.Person;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CardDto {

    private Long id;
    private String lastFourDigits;
    private LocalDate expirationDate;
    private LocalDate closingDate;
    private LocalDate dueDate;
    private BigDecimal cardLimit;
    private String brand;
    private Person ownerId;

    public CardDto(Long id, String lastFourDigits, LocalDate expirationDate, LocalDate closingDate, LocalDate dueDate, BigDecimal cardLimit, String brand, Person ownerId) {
        this.id = id;
        this.lastFourDigits = lastFourDigits;
        this.expirationDate = expirationDate;
        this.closingDate = closingDate;
        this.dueDate = dueDate;
        this.cardLimit = cardLimit;
        this.brand = brand;
        this.ownerId = ownerId;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Person getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Person ownerId) {
        this.ownerId = ownerId;
    }
}
