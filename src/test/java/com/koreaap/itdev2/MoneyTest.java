package com.koreaap.itdev2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  public void shouldReturnStringWithAmountAndCurrency() {
    // Given
    Money money = new Money(5, "USD");

    // When
    String result = money.toString();

    // Then
    assertEquals("5 USD", result);
  }
}
