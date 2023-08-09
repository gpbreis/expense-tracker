package com.expensetracker.model;

public enum ExpenseTypeEnum {
    CARD("Card"),
    FIXED("Fixed"),
    OTHER("Other");

    private String type;

    ExpenseTypeEnum(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
