package com.koreaap.itdev2;

public class Dollar {

  Dollar(int amount) {
    this.amount = amount;
  }

  Dollar times(int multiplier) {
    amount *= multiplier;
    return null;
  }

  int amount;
}
