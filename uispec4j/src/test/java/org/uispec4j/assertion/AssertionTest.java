package org.uispec4j.assertion;

import org.junit.jupiter.api.Assertions;
import org.uispec4j.utils.UnitTestCase;

public class AssertionTest extends UnitTestCase {
  public void testIsTrue() throws Exception {
    Assertions.assertTrue(DummyAssertion.TRUE.isTrue());
    Assertions.assertFalse(DummyAssertion.FALSE.isTrue());
  }
}