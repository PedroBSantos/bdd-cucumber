package com.bdd.cucumber.features.create_account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import com.bdd.cucumber.entities.Account;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CreateAccountScenario1 {
    
    private Account account;
    private String owner;
    private String bank;
    private String agency;

    @Dado("os dados de uma conta: nome do dono {string}, banco {string} e a agência {string}")
    public void step1(String owner, String bank, String agency) {
        this.owner = owner;
        this.bank = bank;
        this.agency = agency;
    }

    @Quando("a conta for criada")
    public void step2() {
        this.account = new Account(UUID.randomUUID(), owner, bank, agency);
    }

    @Entao("deve possuir saldo inicial igual a {double}")
    public void step3(double initialBalance) {
        assertEquals(initialBalance, this.account.balance());
    }
}
