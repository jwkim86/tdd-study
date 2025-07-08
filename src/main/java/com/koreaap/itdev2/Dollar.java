package com.koreaap.itdev2;

public class Dollar {

  Dollar(int amount) {
    this.amount = amount;
  }

  Dollar times(int multiplier) {
    return new Dollar(amount * multiplier);
  }

  int amount;
}
