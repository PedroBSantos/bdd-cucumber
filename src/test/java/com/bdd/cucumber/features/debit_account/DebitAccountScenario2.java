package com.bdd.cucumber.features.debit_account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import com.bdd.cucumber.entities.Account;

import io.cucumber.java.an.E;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class DebitAccountScenario2 {
    
    private Account account;
    private double debitValue;
    private RuntimeException exception;

    @Dado("uma conta com {double} de saldo inicial")
    public void step1(double initialBalance) {
        this.account = new Account(UUID.randomUUID(), "XPTO1", "XPTO2", "XPTO3");
        this.account.credit(initialBalance);
    }

    @E("valor de débito de {double}")
    public void step2(double debitValue) {
        this.debitValue = debitValue;
    }

    @Quando("realizado operação de débito")
    public void step3() {
        try {
            this.account.debit(this.debitValue);
        } catch (RuntimeException exception) {
            this.exception = exception;
        }
    }

    @Entao("deve ser lançada uma exceção")
    public void step4() {
        assertNotNull(this.exception);
        assertEquals("Debit value (" + this.debitValue  + ") is greater than account balance (" + this.account.balance() + ")", this.exception.getMessage());
    }
}
