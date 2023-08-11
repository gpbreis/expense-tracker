package com.expensetracker.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private BigDecimal value;
    private LocalDate expenseDate;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
    private ExpenseTypeEnum type;
    private int installment;
    private BigDecimal installmentValue;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card cardId;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personId;

    public Expense() {
    }

    public Expense(Long id, String title, String content, BigDecimal value, LocalDate expenseDate, LocalDateTime createdOn, LocalDateTime updatedOn, Card cardId, Person personId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.value = value;
        this.expenseDate = expenseDate;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.cardId = cardId;
        this.personId = personId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public ExpenseTypeEnum getType() {
        return type;
    }

    public void setType(ExpenseTypeEnum type) {
        this.type = type;
    }
}
