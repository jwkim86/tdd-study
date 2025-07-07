package com.koreaap.itdev2;

public class Dollar {

  Dollar(int amount) {
    this.amount = amount;
  }

  void times(int multiplier) {
    amount *= multiplier;
  }

  int amount;
}
