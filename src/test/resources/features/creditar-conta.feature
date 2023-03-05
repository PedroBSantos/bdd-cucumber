# language: pt
@creditar-conta
Funcionalidade: Realizando crédito em uma conta

  Cenario: Creditar um valor superior a 0,0 em uma conta
    Dado uma conta com saldo inicial igual a 100,0
    E um valor de crédito de 200,0
    Quando realizar operação de crédito
    Entao o saldo da conta deve ser igual a 300,0
