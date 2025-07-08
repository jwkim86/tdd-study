package com.koreaap.itdev2;

public class Franc extends Money {

  Franc(int amount) {
    this.amount = amount;
  }

  Franc times(int multiplier) {
    return new Franc(amount * multiplier);
  }

  @Override
  public boolean equals(Object object) {
    Money dollar = (Franc) object;
    return amount == dollar.amount;
  }
}
