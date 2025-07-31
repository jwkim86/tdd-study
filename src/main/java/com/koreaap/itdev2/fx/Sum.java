package com.koreaap.itdev2.fx;

public class Sum extends Expression {
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

  public Expression times(int multiplier) {
    return new Sum(augend.times(multiplier), addend.times(multiplier));
  }
}
