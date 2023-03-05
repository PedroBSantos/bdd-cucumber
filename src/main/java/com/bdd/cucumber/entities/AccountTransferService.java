package com.bdd.cucumber.entities;

public class AccountTransferService {

    public void transfer(Account from, Account to, double value) {
        from.debit(value);
        to.credit(value);
    }
}
