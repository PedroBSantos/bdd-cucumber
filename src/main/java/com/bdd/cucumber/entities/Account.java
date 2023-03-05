package com.bdd.cucumber.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Account {
    
    private UUID id;
    private String owner;
    private String bank;
    private String agency;
    private final Set<Transaction> transactions;

    private Account() {
        this.transactions = new HashSet<>();
    }

    public Account(UUID id, String owner, String bank, String agency) {
        this();
        this.id = id;
        this.owner = owner;
        this.bank = bank;
        this.agency = agency;
    }

    public UUID getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getBank() {
        return bank;
    }

    public String getAgency() {
        return agency;
    }

    public double balance() {
        double result = 0.0;
        for (Transaction transaction : transactions) {
            if (transaction.isCredit()) {
                result += transaction.getValue();
                continue;
            }
            result -= transaction.getValue();
        }
        return result;
    }

    public void credit(double value) {
        if (value <= 0.0)
            throw new RuntimeException("Invalid credit value: " + value);
        var transaction = new Transaction(this, value, TransactionType.CREDIT, LocalDateTime.now());
        this.transactions.add(transaction);
    }

    public void debit(double value) {
        if (value <= 0)
            throw new RuntimeException("Invalid debit value: " + value);
        var accountBalance = this.balance();
        if (accountBalance < value)
            throw new RuntimeException("Debit value (" + value  + ") is greater than account balance (" + accountBalance + ")");
        var transaction = new Transaction(this, value, TransactionType.DEBIT, LocalDateTime.now());
        this.transactions.add(transaction);
    }
}
