package com.kalbanq_servlet.entity;

import java.util.Date;
import java.util.UUID;

public class Account {
    private UUID id;
    private AccountType accountType;
    private String accountNumber;
    private double sold;
    private long accountLimit;
    private double downPayment;
    private PaymentType dawnPaymentType;
    private Date createdAt;
    private Date updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public long getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(long accountLimit) {
        this.accountLimit = accountLimit;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public PaymentType getDawnPaymentType() {
        return dawnPaymentType;
    }

    public void setDawnPaymentType(PaymentType dawnPaymentType) {
        this.dawnPaymentType = dawnPaymentType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
