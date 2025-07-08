package com.koreaap.itdev2;

public class Dollar extends Money {

  Dollar(int amount) {
    this.amount = amount;
  }

  Dollar times(int multiplier) {
    return new Dollar(amount * multiplier);
  }

  @Override
  public boolean equals(Object object) {
    Money dollar = (Money) object;
    return amount == dollar.amount;
  }
}
