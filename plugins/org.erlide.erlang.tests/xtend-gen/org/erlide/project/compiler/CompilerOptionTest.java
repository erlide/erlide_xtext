package org.erlide.project.compiler;

import com.ericsson.otp.erlang.OtpErlangList;
import com.ericsson.otp.erlang.OtpErlangObject;
import java.util.ArrayList;
import junit.framework.Assert;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.common.util.TermParserException;
import org.erlide.project.compiler.BooleanOption;
import org.erlide.project.compiler.CompilerOption;
import org.erlide.project.compiler.DefineOption;
import org.erlide.project.compiler.WarningOption;
import org.junit.Test;

@SuppressWarnings("all")
public class CompilerOptionTest {
  @Test
  public void testFind() {
    final WarningOption option = CompilerOption.WARN_EXPORT_ALL;
    Assert.assertEquals("warn_export_all", option.name);
    Class<? extends Object> _class = option.getClass();
    Assert.assertEquals(WarningOption.class, _class);
  }
  
  @Test
  public void testToTerm_1() throws TermParserException {
    final WarningOption option = CompilerOption.WARN_EXPORT_ALL;
    final OtpErlangObject actual = option.toTerm(true);
    final String expected = "warn_export_all";
    String _string = actual.toString();
    Assert.assertEquals(expected, _string);
  }
  
  @Test
  public void testToTerm_2() throws TermParserException {
    final WarningOption option = CompilerOption.WARN_EXPORT_ALL;
    final OtpErlangObject actual = option.toTerm(false);
    final String expected = "nowarn_export_all";
    String _string = actual.toString();
    Assert.assertEquals(expected, _string);
  }
  
  @Test
  public void testToTerm_3() throws TermParserException {
    final BooleanOption option = CompilerOption.DEBUG_INFO;
    final OtpErlangObject actual = option.toTerm(true);
    final String expected = "debug_info";
    String _string = actual.toString();
    Assert.assertEquals(expected, _string);
  }
  
  @Test
  public void testToTerm_4() throws TermParserException {
    final BooleanOption option = CompilerOption.DEBUG_INFO;
    final OtpErlangObject actual = option.toTerm(false);
    final Object expected = null;
    Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void testToTerm_5() throws TermParserException {
    final DefineOption option = CompilerOption.DEFINE;
    Pair<String,String> _mappedTo = Pair.<String, String>of("Macro", "[hej,1]");
    final ArrayList<Pair<String,String>> values = CollectionLiterals.<Pair<String,String>>newArrayList(_mappedTo);
    final OtpErlangList actual = option.toTerm(values);
    final String expected = "[{d,\'Macro\',[hej,1]}]";
    String _string = actual.toString();
    Assert.assertEquals(expected, _string);
  }
  
  @Test
  public void testToTerm_5a() throws TermParserException {
    final DefineOption option = CompilerOption.DEFINE;
    Pair<String,String> _mappedTo = Pair.<String, String>of("Macro", "");
    final ArrayList<Pair<String,String>> values = CollectionLiterals.<Pair<String,String>>newArrayList(_mappedTo);
    final OtpErlangList actual = option.toTerm(values);
    final String expected = "[{d,\'Macro\'}]";
    String _string = actual.toString();
    Assert.assertEquals(expected, _string);
  }
  
  @Test
  public void testToTerm_6() throws TermParserException {
    final WarningOption option = CompilerOption.WARN_EXPORT_ALL;
    final OtpErlangObject actual = option.toTerm(false);
    final String expected = "nowarn_export_all";
    String _string = actual.toString();
    Assert.assertEquals(expected, _string);
  }
}
