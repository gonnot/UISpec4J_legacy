package org.uispec4j;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.uispec4j.utils.AssertionFailureNotDetectedError;
import org.uispec4j.xml.XmlAssert;

import javax.swing.*;
import java.awt.*;

public class WindowForAwtWindowTest extends WindowTestCase {
  @Test
  public void test() throws Exception {
    Window window = createWindow();
    Assertions.assertEquals("", window.getTitle());
  }

  @Test
  public void testWindowManagesMenuBars() throws Exception {
    Window window = new Window(new Frame());
    try {
      window.getMenuBar();
      throw new AssertionFailureNotDetectedError();
    }
    catch (AssertionError e) {
      Assertions.assertEquals("This component has no menu bar", e.getMessage());
    }
  }

  @Test
  public void testGetTitle() throws Exception {
    Assertions.assertEquals("", createWindow().getTitle());
  }

  @Test
  public void testAssertTitleEquals() throws Exception {
    final Window window = createWindow();
    assertTrue(window.titleEquals(""));
    checkAssertionFails(window.titleEquals("title"),
                        "Unexpected title - ==> expected: <title> but was: <>");
  }

  @Test
  public void testAssertTitleContains() throws Exception {
    final Window window = createWindow();
    assertTrue(window.titleContains(""));
    checkAssertionFails(window.titleContains("title"),
                        "expected to contain:<title> but was: <> ==> expected: <true> but was: <false>");
  }

  @Test
  public void testGetDescription() throws Exception {
    Window window = createWindow();
    window.getAwtComponent().setName("myFrame");

    JTextField textField = new JTextField();
    textField.setName("myText");
    addComponent(window, textField);

    XmlAssert.assertEquivalent("<window title=''>" +
                               "  <textBox name='myText'/>" +
                               "</window>",
                               window.getDescription());
  }

  protected boolean supportsMenuBars() {
    return false;
  }

  protected Window createWindowWithMenu(JMenuBar jMenuBar) {
    throw new AssertionError("not supported");
  }

  protected Window createWindowWithTitle(String title) {
    throw new AssertionError("not supported");
  }

  protected void close(Window window) {
    java.awt.Window awtWindow = (java.awt.Window)window.getAwtComponent();
    awtWindow.setVisible(false);
  }

  protected UIComponent createComponent() {
    return createWindow();
  }

  protected Window createWindow() {
    java.awt.Window awtWindow = new java.awt.Window(new Frame());
    return new Window(awtWindow);
  }
}
