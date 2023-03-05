package com.bdd.cucumber.features.credit_account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import com.bdd.cucumber.entities.Account;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;

public class CreditAccountScenario1 {

    private Account account;
    private double creditValue;

    @Dado("uma conta com saldo inicial igual a {double}")
    public void step1(double initialBalance) {
        this.account = new Account(UUID.randomUUID(), "XPTO1", "XPTO2", "XPTO3");
        this.account.credit(initialBalance);
    }

    @E("um valor de crédito de {double}")
    public void step2(double creditValue) {
        this.creditValue = creditValue;
    }

    @Quando("realizar operação de crédito")
    public void step3() {
        this.account.credit(this.creditValue);
    }

    @Entao("o saldo da conta deve ser igual a {double}")
    public void step4(double finalBalance) {
        assertEquals(finalBalance, this.account.balance());
    }
}
