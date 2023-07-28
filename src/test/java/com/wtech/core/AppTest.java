package com.wtech.core;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class AppTest {

  @Test
  void should_add_two_numbers() {
    assertThat(1 + 1, is(equalTo(2)));
  }
}