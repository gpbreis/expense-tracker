package com.expensetracker.model;

public enum ExpenseTypeEnum {
    CARD("Card"),
    FIXED("Fixed");

    private String type;

    ExpenseTypeEnum(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
