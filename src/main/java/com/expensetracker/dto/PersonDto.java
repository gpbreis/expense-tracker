package com.expensetracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class PersonDto {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private char sex;
    private int age;
    private BigDecimal salary;

    public PersonDto() {
    }

    public PersonDto(Long id, String name, LocalDate birthDate, char sex, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.age = Period.between(birthDate, LocalDate.now()).getYears();
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
