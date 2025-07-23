package com.koreaap.itdev2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TddStudyApplicationTests {

  @Test
  void contextLoads() {}

  @Test
  public void testMultiplication() {
    Money five = Money.dollar(5);
    assertEquals(Money.dollar(10), five.times(2));
    assertEquals(Money.dollar(15), five.times(3));
  }

  @Test
  public void testEquality() {
    assertTrue(Money.dollar(5).equals(Money.dollar(5)));
    assertFalse(Money.dollar(5).equals(Money.dollar(6)));
    assertFalse(Money.franc(5).equals(Money.dollar(5)));
  }

  @Test
  public void testCurrency() {
    assertEquals("USD", Money.dollar(1).currency());
    assertEquals("CHF", Money.franc(1).currency());
  }

  @Test
  public void testSimpleAddition() {
    Money sum = Money.dollar(5).plus(Money.dollar(5));
    assertEquals(Money.dollar(10), sum);

    // Why not like that Money reduce = sum.reduce(bank, "usd")?
    Money reduced = bank.reduce(sum, "usd");
    assertEquals(Money.dollar(10), reduced);
  }

  // TODO: $5 + 10CHF = $10. fx rate 2:1
  // TODO: $5 + $5 = $10
  // TODO: Fix Money round-up error
  // TODO: hashCode()
  // TODO: Equals null
  // TODO: Equals object
  // TODO: testFrancMultiplication을 지워야 할까?
}
