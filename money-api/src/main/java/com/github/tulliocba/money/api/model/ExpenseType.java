package com.github.tulliocba.money.api.model;

public enum ExpenseType {
    REVENUE("Receita"), EXPENSE("Despesa");

    private String description;

    ExpenseType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
