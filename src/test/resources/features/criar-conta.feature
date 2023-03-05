# language: pt
@criar-conta
Funcionalidade: Criação de conta

  Esquema do Cenario: Conta apos criação deve possuir saldo igual a 0,0
    Dado os dados de uma conta: nome do dono '<dono>', banco '<banco>' e a agência '<agencia>'
    Quando a conta for criada
    Entao deve possuir saldo inicial igual a 0,0

    Exemplos: 
      | dono  | banco | agencia |
      | XPTO1 | XPTO2 | XPTO3   |
