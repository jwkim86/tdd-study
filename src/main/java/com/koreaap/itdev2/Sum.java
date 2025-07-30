package com.koreaap.itdev2;

public class Sum implements Expression {
  public Sum(Money augend, Money addend) {
    this.augend = augend;
    this.addend = addend;
  }

  Money augend;
  Money addend;

  public Money reduce(Bank bank, String to) {
    int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
    return new Money(amount, to);
  }
}
