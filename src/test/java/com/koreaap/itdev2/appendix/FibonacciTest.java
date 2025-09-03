package com.koreaap.itdev2.appendix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void shouldReturnZeroWhenInputIsZero() {
        assertEquals(0, Fibonacci.fib(0));
    }
}