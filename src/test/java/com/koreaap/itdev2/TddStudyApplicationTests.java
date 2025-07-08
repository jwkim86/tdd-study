package com.koreaap.itdev2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TddStudyApplicationTests {

  @Test
  void contextLoads() {}

  @Test
  public void testMultiplication() {
    Dollar five = new Dollar(5);
    five.times(2);
    assertEquals(10, five.amount);
    five.times(3);
    assertEquals(15, five.amount);
  }

  // TODO: $5 + 10CHF = $10. fx rate 2:1
  // TODO: change amount to private
  // TODO: Fix Dollar class side effect
  // TODO: Fix Money round-up error
}
