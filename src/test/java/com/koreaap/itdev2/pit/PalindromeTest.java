package com.koreaap.itdev2.pit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeTest {
  @Test
  public void whenPalindrom_thenAccept() {
    Palindrome palindromeTester = new Palindrome();
    assertTrue(palindromeTester.isPalindrome("noon"));
  }
}
