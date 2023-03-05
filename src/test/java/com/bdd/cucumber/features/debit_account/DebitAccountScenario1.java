package com.bdd.cucumber.features.debit_account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import com.bdd.cucumber.entities.Account;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class DebitAccountScenario1 {

    private Account account;
    private double debitValue;

    @Dado("uma conta com saldo inicial de {double}")
    public void step1(double intialBalance) {
        this.account = new Account(UUID.randomUUID(), "XPTO1", "XPTO2", "XPTO3");
        this.account.credit(intialBalance);
    }

    @E("um valor de débito de {double}")
    public void step2(double debitValue) {
        this.debitValue = debitValue;
    }

    @Quando("uma operação de débito for realizada")
    public void step3() {
        this.account.debit(this.debitValue);
    }

    @Entao("a conta deve ter seu saldo igual a {double}")
    public void step4(double finalBalance) {
        assertEquals(finalBalance, this.account.balance());
    }
}
