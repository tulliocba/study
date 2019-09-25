package com.github.tulliocba.money.api.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ExpenseRecordFilter {
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate invoiceExpirationFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate InvoiceExpirationTo;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getInvoiceExpirationFrom() {
        return invoiceExpirationFrom;
    }

    public void setInvoiceExpirationFrom(LocalDate invoiceExpirationFrom) {
        this.invoiceExpirationFrom = invoiceExpirationFrom;
    }

    public LocalDate getInvoiceExpirationTo() {
        return InvoiceExpirationTo;
    }

    public void setInvoiceExpirationTo(LocalDate invoiceExpirationTo) {
        InvoiceExpirationTo = invoiceExpirationTo;
    }
}
