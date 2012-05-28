package org.erlide.project.compiler;

import com.ericsson.otp.erlang.OtpErlangList;
import com.google.common.base.Splitter;
import junit.framework.Assert;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.project.compiler.CompilerOption;
import org.erlide.project.compiler.CompilerOptions;
import org.junit.Test;

@SuppressWarnings("all")
public class CompilerOptionsTest {
  private static String DEF_VALUES = "nowarn_export_all,nowarn_export_vars,nowarn_shadow_vars,warn_unused_function,warn_deprecated_function,nowarn_obsolete_guard,nowarn_unused_import,warn_unused_vars,warn_unused_record";
  
  @Test
  public void test_0() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _plus = ("[" + CompilerOptionsTest.DEF_VALUES);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
  
  @Test
  public void test_1() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    prefs.setOption(CompilerOption.DEBUG_INFO, true);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _plus = ("[debug_info," + CompilerOptionsTest.DEF_VALUES);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
  
  @Test
  public void test_2() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    prefs.setOption(CompilerOption.DEBUG_INFO, false);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _plus = ("[" + CompilerOptionsTest.DEF_VALUES);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
  
  @SuppressWarnings(value = "unchecked")
  @Test
  public void test_3() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    Pair<String,String> _mappedTo = Pair.<String, String>of("Macro", null);
    prefs.setOption(CompilerOption.DEFINE, _mappedTo);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _plus = ("[{d,\'Macro\'}," + CompilerOptionsTest.DEF_VALUES);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
  
  @SuppressWarnings(value = "unchecked")
  @Test
  public void test_4() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    Pair<String,String> _mappedTo = Pair.<String, String>of("Macro", "[value,1]");
    prefs.setOption(CompilerOption.DEFINE, _mappedTo);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _plus = ("[{d,\'Macro\',[value,1]}," + CompilerOptionsTest.DEF_VALUES);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
  
  @Test
  public void test_5() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    prefs.setOption(CompilerOption.WARN_UNUSED_FUNCTION, true);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _plus = ("[" + CompilerOptionsTest.DEF_VALUES);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
  
  @Test
  public void test_6() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    prefs.setOption(CompilerOption.WARN_UNUSED_FUNCTION, false);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    final String expect = "[nowarn_export_all,nowarn_export_vars,nowarn_shadow_vars,nowarn_unused_function,warn_deprecated_function,nowarn_obsolete_guard,nowarn_unused_import,warn_unused_vars,warn_unused_record]";
    Assert.assertEquals(expect, actual);
  }
  
  @SuppressWarnings(value = "unchecked")
  @Test
  public void test_7() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    Pair<String,String> _mappedTo = Pair.<String, String>of("Macro", null);
    prefs.setOption(CompilerOption.DEFINE, _mappedTo);
    prefs.removeOption(CompilerOption.DEFINE);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _plus = ("[" + CompilerOptionsTest.DEF_VALUES);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
  
  @Test
  public void test_8() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    prefs.setOption(CompilerOption.WARN_EXPORT_ALL, true);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _substring = CompilerOptionsTest.DEF_VALUES.substring(2);
    String _plus = ("[" + _substring);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
  
  @Test
  public void test_9() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    prefs.setOption(CompilerOption.WARN_EXPORT_ALL, false);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _plus = ("[" + CompilerOptionsTest.DEF_VALUES);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
  
  private Iterable<String> parseIncludes(final String s) {
    Splitter _on = Splitter.on(",");
    Splitter _trimResults = _on.trimResults();
    Splitter _omitEmptyStrings = _trimResults.omitEmptyStrings();
    return _omitEmptyStrings.split(s);
  }
  
  @Test
  public void test_10() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    Iterable<String> _parseIncludes = this.parseIncludes("");
    prefs.setPathOption(CompilerOption.INCLUDE_DIRS, _parseIncludes);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _plus = ("[" + CompilerOptionsTest.DEF_VALUES);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
  
  @Test
  public void test_11() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    Iterable<String> _parseIncludes = this.parseIncludes("/tmp/x");
    prefs.setPathOption(CompilerOption.INCLUDE_DIRS, _parseIncludes);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _plus = ("[{i,[\"/tmp/x\"]}," + CompilerOptionsTest.DEF_VALUES);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
  
  @Test
  public void test_12() {
    CompilerOptions _compilerOptions = new CompilerOptions();
    final CompilerOptions prefs = _compilerOptions;
    Iterable<String> _parseIncludes = this.parseIncludes("/tmp/x,/tmp/y");
    prefs.setPathOption(CompilerOption.INCLUDE_DIRS, _parseIncludes);
    OtpErlangList _export = prefs.export();
    final String actual = _export.toString();
    String _plus = ("[{i,[\"/tmp/x\",\"/tmp/y\"]}," + CompilerOptionsTest.DEF_VALUES);
    final String expect = (_plus + "]");
    Assert.assertEquals(expect, actual);
  }
}
