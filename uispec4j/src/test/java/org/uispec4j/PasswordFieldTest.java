package org.uispec4j;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import javax.swing.*;

public class PasswordFieldTest extends UIComponentTestCase {

  private PasswordField passwordField;
  private JPasswordField jPasswordField;

  @BeforeEach
  final protected void setUp() throws Exception {
    jPasswordField = new JPasswordField();
    passwordField = new PasswordField(jPasswordField);
  }

  public void testGetComponentTypeName() throws Exception {
    Assertions.assertEquals("passwordField", passwordField.getDescriptionTypeName());
  }

  public void testGetDescription() throws Exception {
    Assertions.assertEquals("<passwordField/>", passwordField.getDescription());
  }

  public void testFactory() throws Exception {
    checkFactory(new JPasswordField(), PasswordField.class);
  }

  protected UIComponent createComponent() {
    return passwordField;
  }

  public void testPasswordEquals() throws Exception {
    jPasswordField.setText("pwd");
    assertTrue(passwordField.passwordEquals("pwd"));
    assertFalse(passwordField.passwordEquals("unknown"));
  }

  public void testEnterPassword() throws Exception {
    passwordField.setPassword("pwd");
    Assertions.assertEquals("pwd", new String(jPasswordField.getPassword()));
  }
}
