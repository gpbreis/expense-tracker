package com.expensetracker.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class PersonDto {

    private Long id;
    @NotEmpty(message = "{message.personName.empty}")
    private String name;
    @PastOrPresent(message = "{message.personBirth.valid}")
    private LocalDate birthdate;
    private char sex;
    private int age;
    @PositiveOrZero(message = "{message.personSalary.min}")
    @Max(value = Long.MAX_VALUE, message = "{message.personSalary.max}")
    private BigDecimal salary;

    public PersonDto() {
    }

    public PersonDto(Long id, String name, LocalDate birthdate, char sex, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        this.age = Period.between(birthdate, LocalDate.now()).getYears();
        this.salary = salary;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
