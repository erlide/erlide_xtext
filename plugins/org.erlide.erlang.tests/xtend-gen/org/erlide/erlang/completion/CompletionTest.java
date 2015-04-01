package org.erlide.erlang.completion;

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
public class CompletionTest extends AbstractXtextTests {
  @Test
  public void completeModule() {
    Assert.fail("not implemented yet");
  }
  
  @Test
  public void completeLocalFunction() {
    Assert.fail("not implemented yet");
  }
  
  @Test
  public void completeRemoteFunction() {
    Assert.fail("not implemented yet");
  }
  
  @Test
  public void completeRecord() {
    Assert.fail("not implemented yet");
  }
  
  @Test
  public void completeRecordField() {
    Assert.fail("not implemented yet");
  }
  
  @Test
  public void completeMacro() {
    Assert.fail("not implemented yet");
  }
  
  @Test
  public void completeVariable() {
    Assert.fail("not implemented yet");
  }
}
