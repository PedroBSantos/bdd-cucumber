package com.bdd.cucumber.features.transfer_account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import com.bdd.cucumber.entities.Account;
import com.bdd.cucumber.entities.AccountTransferService;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dada;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class TransferAccountScenario1 {

    private Account from;
    private Account to;

    @Dada("duas contas")
    public void step1(DataTable dataTable) {
        var contas = dataTable.asMaps();
        contas.forEach(conta -> {
            var owner = conta.get("dono");
            var bank = conta.get("banco");
            var agency = conta.get("agencia");
            var initialBalance = Double.parseDouble(conta.get("saldoInicial").replace(',', '.'));
            if (owner.equals("Origem")) {
                this.from = new Account(UUID.randomUUID(), owner, bank, agency);
                this.from.credit(initialBalance);
            }
            if (owner.equals("Destino")) {
                this.to = new Account(UUID.randomUUID(), owner, bank, agency);
                this.to.credit(initialBalance);
            }
        });
    }

    @Quando("realizada a operação de transferencia de {double} reais da conta de origem para a conta de destino")
    public void step3(double transferValue) {
        var service = new AccountTransferService();
        service.transfer(from, to, transferValue);
    }

    @Entao("a conta de origem deve ter saldo igual a {double} reais e a conta de destino deve ter saldo igual a {double} reais")
    public void step4(double originAccountBalance, double destinyAccountBalance) {
        assertEquals(originAccountBalance, this.from.balance());
        assertEquals(destinyAccountBalance, this.to.balance());
    }
}
