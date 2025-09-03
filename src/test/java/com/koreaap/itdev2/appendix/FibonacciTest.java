package com.koreaap.itdev2.appendix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FibonacciTest {

  @Test
  void shouldReturnZeroWhenInputIsZero() {
    assertEquals(0, Fibonacci.fib(0));
  }
}
