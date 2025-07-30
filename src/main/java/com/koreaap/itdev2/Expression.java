package com.koreaap.itdev2;

public interface Expression {
  Money reduce(Bank bank, String to);
}
