package com.techelevator.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private LocalDate transDate;

    private BigDecimal amount;

    private String description;

    public Transaction() {}

    public Transaction(LocalDate transDate, BigDecimal amount, String description) {
        this.transDate = transDate;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getTransDate() {
        return transDate;
    }

    public void setTransDate(LocalDate transDate) {
        this.transDate = transDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transDate=" + transDate +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
