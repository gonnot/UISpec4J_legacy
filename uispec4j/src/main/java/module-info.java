module uispec4j {
  requires java.desktop;
  requires static org.objectweb.asm;
  requires static org.junit.jupiter.api;
  requires static org.testng;

  opens org.uispec4j.utils;
  opens org.uispec4j.interception.ui;

  exports org.uispec4j;
  exports org.uispec4j.assertion;
  exports org.uispec4j.extension;
  exports org.uispec4j.finder;
  exports org.uispec4j.xml;
}