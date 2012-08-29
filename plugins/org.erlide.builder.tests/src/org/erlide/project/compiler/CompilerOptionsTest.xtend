package org.erlide.project.compiler

import com.google.common.base.Splitter
import junit.framework.Assert
import org.junit.Test

class CompilerOptionsTest {
    private static String DEF_VALUES = "nowarn_export_all,nowarn_export_vars,nowarn_shadow_vars,warn_unused_function,warn_deprecated_function,nowarn_obsolete_guard,nowarn_unused_import,warn_unused_vars,warn_unused_record"

    @Test
    def void test_0() {
        val prefs = new CompilerOptions()
        val actual = prefs.export().toString()
        val expect = "[" + DEF_VALUES + "]"
        Assert::assertEquals(expect, actual)
    }

    @Test
    def void test_1() {
        val prefs = new CompilerOptions()
        prefs.setOption(CompilerOption::DEBUG_INFO, true)
        val actual = prefs.export().toString()
        val expect = "[debug_info," + DEF_VALUES + "]"
        Assert::assertEquals(expect, actual)
    }

    @Test
    def void test_2() {
        val prefs = new CompilerOptions()
        prefs.setOption(CompilerOption::DEBUG_INFO, false)
        val actual = prefs.export().toString()
        val expect = "[" + DEF_VALUES + "]"
        Assert::assertEquals(expect, actual)
    }

    @SuppressWarnings("unchecked")
    @Test
    def void test_3() {
        val prefs = new CompilerOptions()
        prefs.setOption(CompilerOption::DEFINE, "Macro"->null)
        val actual = prefs.export().toString()
        val expect = "[{d,'Macro'}," + DEF_VALUES + "]"
        Assert::assertEquals(expect, actual)
    }

    @SuppressWarnings("unchecked")
    @Test
    def void test_4() {
        val prefs = new CompilerOptions()
        prefs.setOption(CompilerOption::DEFINE, "Macro"->"[value,1]")
        val actual = prefs.export().toString()
        val expect = "[{d,'Macro',[value,1]}," + DEF_VALUES + "]"
        Assert::assertEquals(expect, actual)
    }

    @Test
    def void test_5() {
        val prefs = new CompilerOptions()
        prefs.setOption(CompilerOption::WARN_UNUSED_FUNCTION, true)
        val actual = prefs.export().toString()
        val expect = "[" + DEF_VALUES + "]"
        Assert::assertEquals(expect, actual)
    }

    @Test
    def void test_6() {
        val prefs = new CompilerOptions()
        prefs.setOption(CompilerOption::WARN_UNUSED_FUNCTION, false)
        val actual = prefs.export().toString()
        val expect = "[nowarn_export_all,nowarn_export_vars,nowarn_shadow_vars,nowarn_unused_function,warn_deprecated_function,nowarn_obsolete_guard,nowarn_unused_import,warn_unused_vars,warn_unused_record]"
        Assert::assertEquals(expect, actual)
    }

    @SuppressWarnings("unchecked")
    @Test
    def void test_7() {
        val prefs = new CompilerOptions()
        prefs.setOption(CompilerOption::DEFINE, "Macro"->null)
        prefs.removeOption(CompilerOption::DEFINE)
        val actual = prefs.export().toString()
        val expect = "[" + DEF_VALUES + "]"
        Assert::assertEquals(expect, actual)
    }

    @Test
    def void test_8() {
        val prefs = new CompilerOptions()
        prefs.setOption(CompilerOption::WARN_EXPORT_ALL, true)
        val actual = prefs.export().toString()
        val expect = "[" + DEF_VALUES.substring(2) + "]"
        Assert::assertEquals(expect, actual)
    }

    @Test
    def void test_9() {
        val prefs = new CompilerOptions()
        prefs.setOption(CompilerOption::WARN_EXPORT_ALL, false)
        val actual = prefs.export().toString()
        val expect = "[" + DEF_VALUES + "]"
        Assert::assertEquals(expect, actual)
    }

    def private Iterable<String> parseIncludes(String s) {
        return Splitter::on(',').trimResults().omitEmptyStrings().split(s)
    }

    @Test
    def void test_10() {
        val prefs = new CompilerOptions()
        prefs.setPathOption(CompilerOption::INCLUDE_DIRS, parseIncludes(""))
        val actual = prefs.export().toString()
        val expect = "[" + DEF_VALUES + "]"
        Assert::assertEquals(expect, actual)
    }

    @Test
    def void test_11() {
        val prefs = new CompilerOptions()
        prefs.setPathOption(CompilerOption::INCLUDE_DIRS, parseIncludes("/tmp/x"))
        val actual = prefs.export().toString()
        val expect = "[{i,[\"/tmp/x\"]}," + DEF_VALUES + "]"
        Assert::assertEquals(expect, actual)
    }

    @Test
    def void test_12() {
        val prefs = new CompilerOptions()
        prefs.setPathOption(CompilerOption::INCLUDE_DIRS, parseIncludes("/tmp/x,/tmp/y"))
        val actual = prefs.export().toString()
        val expect = "[{i,[\"/tmp/x\",\"/tmp/y\"]}," + DEF_VALUES + "]"
        Assert::assertEquals(expect, actual)
    }

}
