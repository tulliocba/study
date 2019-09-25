package com.github.tulliocba.money.api.repository.projection;

import com.github.tulliocba.money.api.model.ExpenseType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseRecordProjection {
    private Integer id;
    private String description;
    private LocalDate invoiceExpirationDate;
    private LocalDate payableDate;
    private BigDecimal amount;
    private String observation;
    private ExpenseType type;
    private String category;
    private String person;

    public ExpenseRecordProjection(Integer id, String description,
                                   LocalDate invoiceExpirationDate,
                                   LocalDate payableDate,
                                   BigDecimal amount, String observation,
                                   ExpenseType type, String category,
                                   String person) {
        this.id = id;
        this.description = description;
        this.invoiceExpirationDate = invoiceExpirationDate;
        this.payableDate = payableDate;
        this.amount = amount;
        this.observation = observation;
        this.type = type;
        this.category = category;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getInvoiceExpirationDate() {
        return invoiceExpirationDate;
    }

    public void setInvoiceExpirationDate(LocalDate invoiceExpirationDate) {
        this.invoiceExpirationDate = invoiceExpirationDate;
    }

    public LocalDate getPayableDate() {
        return payableDate;
    }

    public void setPayableDate(LocalDate payableDate) {
        this.payableDate = payableDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
