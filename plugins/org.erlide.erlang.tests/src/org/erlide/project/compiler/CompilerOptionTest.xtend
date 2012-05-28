package org.erlide.project.compiler

import junit.framework.Assert
import org.erlide.common.util.TermParserException
import org.junit.Test 

class CompilerOptionTest {

    @Test
    def void testFind() {
        val option = CompilerOption::WARN_EXPORT_ALL
        Assert::assertEquals("warn_export_all", option.name)
        Assert::assertEquals(typeof(WarningOption), option.getClass())
    }

    @Test
    def void testToTerm_1() throws TermParserException {
        val option = CompilerOption::WARN_EXPORT_ALL
        val actual = option.toTerm(true)
        val expected = "warn_export_all"
        Assert::assertEquals(expected, actual.toString())
    }

    @Test
    def void testToTerm_2() throws TermParserException {
        val option = CompilerOption::WARN_EXPORT_ALL
        val actual = option.toTerm(false)
        val expected = "nowarn_export_all"
        Assert::assertEquals(expected, actual.toString())
    }

    @Test
    def void testToTerm_3() throws TermParserException {
        val option = CompilerOption::DEBUG_INFO
        val actual = option.toTerm(true)
        val expected = "debug_info"
        Assert::assertEquals(expected, actual.toString())
    }

    @Test
    def void testToTerm_4() throws TermParserException {
        val option = CompilerOption::DEBUG_INFO
        val actual = option.toTerm(false)
        val expected = null
        Assert::assertEquals(expected, actual)
    }

    @Test
    def void testToTerm_5() throws TermParserException {
        val option = CompilerOption::DEFINE
        val values = newArrayList("Macro"->"[hej,1]")
        val actual = option.toTerm(values)
        val expected = "[{d,'Macro',[hej,1]}]"
        Assert::assertEquals(expected, actual.toString())
    }

    @Test
    def void testToTerm_5a() throws TermParserException {
        val option = CompilerOption::DEFINE
        val values = newArrayList("Macro"->"")
        val actual = option.toTerm(values)
        val expected = "[{d,'Macro'}]"
        Assert::assertEquals(expected, actual.toString())
    }

    @Test
    def void testToTerm_6() throws TermParserException {
        val option = CompilerOption::WARN_EXPORT_ALL
        val actual = option.toTerm(false)
        val expected = "nowarn_export_all"
        Assert::assertEquals(expected, actual.toString())
    }

}
