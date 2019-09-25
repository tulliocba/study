package com.github.tulliocba.money.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "expense_record")
public class ExpenseRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String description;

    @NotNull
    @Column(name = "invoice_expiration_date")
    private LocalDate invoiceExpirationDate;

    @Column(name = "payable_date")
    private LocalDate payableDate;

    @NotNull
    private BigDecimal amount;

    private String observation;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ExpenseType type;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

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

    public LocalDate getPayableDate() {
        return payableDate;
    }

    public void setPayableDate(LocalDate payableDate) {
        this.payableDate = payableDate;
    }

    public LocalDate getInvoiceExpirationDate() {
        return invoiceExpirationDate;
    }

    public void setInvoiceExpirationDate(LocalDate invoiceExpirationDate) {
        this.invoiceExpirationDate = invoiceExpirationDate;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseRecord that = (ExpenseRecord) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
