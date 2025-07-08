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
    Dollar five = new Dollar(5);
    Dollar product = five.times(2);
    assertEquals(10, product.amount);
    product = five.times(3);
    assertEquals(15, product.amount);
  }

  @Test
  public void testEquality() {
    assertTrue(new Dollar(5).equals(new Dollar(5)));
    assertFalse(new Dollar(5).equals(new Dollar(6)));
  }

  // TODO: $5 + 10CHF = $10. fx rate 2:1
  // TODO: change amount to private
  // TODO: Fix Money round-up error
  // TODO: equals()
  // TODO: hashCode()
}
