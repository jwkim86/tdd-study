package com.koreaap.itdev2;

public class Franc extends Money {

  Franc(int amount, String currency) {
    super(amount, currency);
  }

  Money times(int multiplier) {
    return new Franc(amount * multiplier, currency);
  }
}
