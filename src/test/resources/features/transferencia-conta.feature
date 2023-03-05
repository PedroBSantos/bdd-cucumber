# language: pt
@transferencia-conta
Funcionalidade: Transferencia entre contas

  Cenario: 
    Dada duas contas
      | dono    | banco | agencia | saldoInicial |
      | Origem  | XPTO1 | XPTO2   |        500,0 |
      | Destino | XPTO3 | XPTO4   |        100,0 |
    Quando realizada a operação de transferencia de 200,0 reais da conta de origem para a conta de destino
    Entao a conta de origem deve ter saldo igual a 300,0 reais e a conta de destino deve ter saldo igual a 300,0 reais
