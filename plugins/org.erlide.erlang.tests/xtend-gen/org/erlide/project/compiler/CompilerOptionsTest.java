package org.erlide.project.compiler;

import junit.framework.Assert;

import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Test;

import com.ericsson.otp.erlang.OtpErlangList;
import com.google.common.base.Splitter;

@SuppressWarnings("all")
public class CompilerOptionsTest {
    private static String DEF_VALUES = "nowarn_export_all,nowarn_export_vars,nowarn_shadow_vars,warn_unused_function,warn_deprecated_function,nowarn_obsolete_guard,nowarn_unused_import,warn_unused_vars,warn_unused_record";

    @Test
    public void test_0() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _plus = "[" + CompilerOptionsTest.DEF_VALUES;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_1() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        prefs.setOption(CompilerOption.DEBUG_INFO, true);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _plus = "[debug_info," + CompilerOptionsTest.DEF_VALUES;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_2() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        prefs.setOption(CompilerOption.DEBUG_INFO, false);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _plus = "[" + CompilerOptionsTest.DEF_VALUES;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }

    @SuppressWarnings(value = "unchecked")
    @Test
    public void test_3() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        final Pair<String, String> _mappedTo = Pair.<String, String> of(
                "Macro", null);
        prefs.setOption(CompilerOption.DEFINE, _mappedTo);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _plus = "[{d,\'Macro\'}," + CompilerOptionsTest.DEF_VALUES;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }

    @SuppressWarnings(value = "unchecked")
    @Test
    public void test_4() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        final Pair<String, String> _mappedTo = Pair.<String, String> of(
                "Macro", "[value,1]");
        prefs.setOption(CompilerOption.DEFINE, _mappedTo);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _plus = "[{d,\'Macro\',[value,1]},"
                + CompilerOptionsTest.DEF_VALUES;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_5() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        prefs.setOption(CompilerOption.WARN_UNUSED_FUNCTION, true);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _plus = "[" + CompilerOptionsTest.DEF_VALUES;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_6() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        prefs.setOption(CompilerOption.WARN_UNUSED_FUNCTION, false);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String expect = "[nowarn_export_all,nowarn_export_vars,nowarn_shadow_vars,nowarn_unused_function,warn_deprecated_function,nowarn_obsolete_guard,nowarn_unused_import,warn_unused_vars,warn_unused_record]";
        Assert.assertEquals(expect, actual);
    }

    @SuppressWarnings(value = "unchecked")
    @Test
    public void test_7() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        final Pair<String, String> _mappedTo = Pair.<String, String> of(
                "Macro", null);
        prefs.setOption(CompilerOption.DEFINE, _mappedTo);
        prefs.removeOption(CompilerOption.DEFINE);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _plus = "[" + CompilerOptionsTest.DEF_VALUES;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_8() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        prefs.setOption(CompilerOption.WARN_EXPORT_ALL, true);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _substring = CompilerOptionsTest.DEF_VALUES.substring(2);
        final String _plus = "[" + _substring;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_9() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        prefs.setOption(CompilerOption.WARN_EXPORT_ALL, false);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _plus = "[" + CompilerOptionsTest.DEF_VALUES;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }

    private Iterable<String> parseIncludes(final String s) {
        final Splitter _on = Splitter.on(",");
        final Splitter _trimResults = _on.trimResults();
        final Splitter _omitEmptyStrings = _trimResults.omitEmptyStrings();
        return _omitEmptyStrings.split(s);
    }

    @Test
    public void test_10() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        final Iterable<String> _parseIncludes = parseIncludes("");
        prefs.setPathOption(CompilerOption.INCLUDE_DIRS, _parseIncludes);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _plus = "[" + CompilerOptionsTest.DEF_VALUES;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_11() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        final Iterable<String> _parseIncludes = parseIncludes("/tmp/x");
        prefs.setPathOption(CompilerOption.INCLUDE_DIRS, _parseIncludes);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _plus = "[{i,[\"/tmp/x\"]},"
                + CompilerOptionsTest.DEF_VALUES;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test_12() {
        final CompilerOptions _compilerOptions = new CompilerOptions();
        final CompilerOptions prefs = _compilerOptions;
        final Iterable<String> _parseIncludes = parseIncludes("/tmp/x,/tmp/y");
        prefs.setPathOption(CompilerOption.INCLUDE_DIRS, _parseIncludes);
        final OtpErlangList _export = prefs.export();
        final String actual = _export.toString();
        final String _plus = "[{i,[\"/tmp/x\",\"/tmp/y\"]},"
                + CompilerOptionsTest.DEF_VALUES;
        final String expect = _plus + "]";
        Assert.assertEquals(expect, actual);
    }
}
