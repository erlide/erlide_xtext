package org.erlide.formatting;

import com.google.inject.Inject;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.util.ErlangTestingHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ReindentTest extends AbstractXtextTests {
  @Inject
  private ErlangTestingHelper parser;
  
  @Test
  public void reindentPreservesLineBreaks() {
    Assert.fail("not implemented yet");
  }
}
