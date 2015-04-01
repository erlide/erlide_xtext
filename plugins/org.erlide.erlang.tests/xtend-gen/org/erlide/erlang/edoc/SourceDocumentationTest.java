package org.erlide.erlang.edoc;

import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.erlide.ErlangInjectorProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class SourceDocumentationTest extends AbstractXtextTests {
  @Test
  public void canRetrieveDocsForFunction() {
    Assert.fail("not implemented yet");
  }
  
  @Test
  public void canRetrieveDocsForModule() {
    Assert.fail("not implemented yet");
  }
  
  @Test
  public void canRetrieveDocsForRemoteFunction() {
    Assert.fail("not implemented yet");
  }
  
  @Test
  public void canRetrieveDocsForLibraryFunction() {
    Assert.fail("not implemented yet");
  }
  
  @Test
  public void functionDocsIncludeSpec() {
    Assert.fail("not implemented yet");
  }
}
