package com.bdd.cucumber.entities;

import java.time.LocalDateTime;

public class Transaction {

    private Account account;
    private double value;
    private TransactionType type;
    private LocalDateTime instant;

    public Transaction(Account account, double value, TransactionType type, LocalDateTime instant) {
        this.account = account;
        this.value = value;
        this.type = type;
        this.instant = instant;
    }

    public Account getAccount() {
        return account;
    }

    public double getValue() {
        return value;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getInstant() {
        return instant;
    }

    public boolean isCredit() {
        return this.type == TransactionType.CREDIT;
    }

    public boolean isDebit() {
        return this.type == TransactionType.DEBIT;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((instant == null) ? 0 : instant.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        if (account == null) {
            if (other.account != null)
                return false;
        } else if (!account.equals(other.account))
            return false;
        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
            return false;
        if (type != other.type)
            return false;
        if (instant == null) {
            if (other.instant != null)
                return false;
        } else if (!instant.equals(other.instant))
            return false;
        return true;
    }
}
