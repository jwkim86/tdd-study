package com.koreaap.itdev2;

public class Sum implements Expression {
  public Sum(Expression augend, Expression addend) {
    this.augend = augend;
    this.addend = addend;
  }

  Expression augend;
  Expression addend;

  public Money reduce(Bank bank, String to) {
    int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
    return new Money(amount, to);
  }

  @Override
  public Expression plus(Expression tenFrancs) {
    return new Sum(this, addend);
  }
}
