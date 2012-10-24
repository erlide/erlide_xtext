package org.erlide.erlang.edoc;

import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.erlide.ErlangInjectorProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class OtpDocumentationTest extends AbstractXtextTests {
  @Test
  public void canRetrieveOtpDocsForFunction() {
    Assert.fail("not implemented yet");
  }
  
  @Test
  public void canRetrieveOtpDocsForModule() {
    Assert.fail("not implemented yet");
  }
}
