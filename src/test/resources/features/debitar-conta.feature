# language: pt
@debitar-conta
Funcionalidade: Realizar debito em conta

  Cenario: Debitar em conta quando o valor de débito é igual ou inferior ao saldo da conta
    Dado uma conta com saldo inicial de 200,0
    E um valor de débito de 100,0
    Quando uma operação de débito for realizada
    Entao a conta deve ter seu saldo igual a 100,0

  Esquema do Cenario: Debitar em conta quando o valor de débito é superior ao saldo da conta
    Dado uma conta com <saldoInicial> de saldo inicial
    E valor de débito de <valorDebito>
    Quando realizado operação de débito
    Entao deve ser lançada uma exceção

    Exemplos: 
      | saldoInicial | valorDebito |
      |        100,0 |       200,0 |
      |         50,0 |       100,0 |
