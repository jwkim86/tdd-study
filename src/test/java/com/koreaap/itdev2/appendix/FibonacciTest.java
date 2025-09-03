package com.koreaap.itdev2.appendix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FibonacciTest {

  @ParameterizedTest
  @CsvSource({"0,0", "1,1"})
  void shouldBeFibonacci(int input, int expected) {
    assertEquals(expected, Fibonacci.fib(input));
  }
}
