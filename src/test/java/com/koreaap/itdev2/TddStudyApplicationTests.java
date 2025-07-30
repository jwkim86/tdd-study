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
    Money five = Money.dollar(5);
    Expression sum = five.plus(five);
    Bank bank = new Bank();
    // Why not like that Money reduce = sum.reduce(bank, "usd")?
    Money reduced = bank.reduce(sum, "USD");
    assertEquals(Money.dollar(10), reduced);
  }

  @Test
  public void testPlusReturnSum() {
    Money five = Money.dollar(5);
    Expression result = five.plus(five);
    Sum sum = (Sum) result;
    assertEquals(five, sum.augend);
    assertEquals(five, sum.addend);
  }

  @Test
  public void testReduceSum() {
    Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
    Bank bank = new Bank();
    Money result = bank.reduce(sum, "USD");
    assertEquals(Money.dollar(7), result);
  }

  @Test
  public void testReduceMoney() {
    Bank bank = new Bank();
    Money result = bank.reduce(Money.dollar(1), "USD");
    assertEquals(Money.dollar(1), result);
  }

  @Test
  public void testReduceMoneyDifferentCurrency() {
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    Money result = bank.reduce(Money.franc(2), "USD");
    assertEquals(Money.dollar(1), result);
  }

  @Test
  public void testArrayEquals() {
    assertArrayEquals(new Object[] {"abc"}, new Object[] {"abc"});
  }

  @Test
  public void testIdentityRate() {
    assertEquals(1, new Bank().rate("USD", "USD"));
  }

  @Test
  public void testMixedAddition() {
    Money fiveFucks = Money.dollar(5);
    Money tenFrancs = Money.franc(10);
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    Money result = bank.reduce(fiveFucks.plus(tenFrancs), "USD");
    assertEquals(Money.dollar(10), result);
  }

  // TODO: $5 + 10CHF = $10. fx rate 2:1
  // TODO: $5 + $5에서 Money 반환하기
}
