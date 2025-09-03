package com.koreaap.itdev2.appendix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FibonacciTest {

  @Test
  void shouldBeItIsFibonacci() {
    int cases[][] = {{0, 0}, {1, 1}};
    for (int[] c : cases) {
      assertEquals(c[1], Fibonacci.fib(c[0]));
    }
  }
}
