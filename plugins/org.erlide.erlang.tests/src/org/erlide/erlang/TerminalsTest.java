package org.erlide.erlang;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.erlide.ErlangInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner2.class)
@InjectWith(ErlangInjectorProvider.class)
public class TerminalsTest extends XtextTest {

	@Test
	public void numbers() {
		testTerminal("33", "INT");
		testTerminal("6#33", "BASED_INT");
		testTerminal("16#af", "BASED_INT");
		testTerminal("36#VLad", "BASED_INT");
		testTerminal("4e5", "EXT_INT");
		testTerminal("4e+5", "EXT_INT");
		testTerminal("4e-5", "EXT_INT");

		testNotTerminal("33a", "INT");
		testNotTerminal("3a3", "INT");
		testNotTerminal("a33", "INT");
		testNotTerminal("64#33", "BASED_INT");
		testNotTerminal("4a#33", "BASED_INT");
		testNotTerminal("4#3a3", "BASED_INT");
		testNotTerminal("4 #33", "BASED_INT");
	}

	@Test
	public void comments() {
		testTerminal("% 33\n", "SL_COMMENT");
	}

	@Test
	public void atoms() {
		testTerminal("hej", "ATOM");
		testTerminal("'h\\'ej'", "ATOM");
		testTerminal("'h\nej'", "ATOM");
		testTerminal("höj", "ATOM");
		testTerminal("'A'", "ATOM");
		testTerminal("'5'", "ATOM");
		testTerminal("'\\xfEs'", "ATOM");
		testTerminal("'\\x{facE}s'", "ATOM");
		testTerminal("' '", "ATOM");
		testTerminal("'_'", "ATOM");
		testTerminal("''", "ATOM");
		testTerminal("hej.hej", "ATOM", "'.'", "ATOM");
	}

	@Test
	public void variables() {
		testTerminal("_", "VARIABLE");
	}

	@Test
	public void strings() {
		testTerminal("\"hej\"", "STRING");
		testTerminal("\"he\\\"j\"", "STRING");
		testTerminal("\"he\nj\"", "STRING");
		testTerminal("\"h\\bej\"", "STRING");
		testTerminal("\"hej\"", "STRING");
		testTerminal("\"hej\"", "STRING");
		testTerminal("\"hej\"", "STRING");
		testTerminal("\"hej\" \"hej\"", "STRING", "WS", "STRING");
	}

	@Test
	public void others() {
		testTerminal("fun", "'fun'");
		testTerminal("fun mm:aa/2", "'fun'", "WS", "ATOM", "':'", "ATOM",
				"'/'", "INT");
		testTerminal("fun aa/2", "'fun'", "WS", "ATOM", "'/'", "INT");
		testTerminal("fun MM:?aa/2", "'fun'", "WS", "VARIABLE", "':'", "'?'",
				"ATOM", "'/'", "INT");

		testTerminal("{a}", "'{'", "ATOM", "'}'");
	}

	@Test
	public void keywords() {
		testKeyword("after");
		testKeyword("and");
		testKeyword("andalso");
		testKeyword("band");
		testKeyword("begin");
		testKeyword("bnot");
		testKeyword("bor");
		testKeyword("bsl");
		testKeyword("bsr");
		testKeyword("bxor");
		testKeyword("case");
		testKeyword("catch");
		testKeyword("cond");
		testKeyword("div");
		testKeyword("end");
		testKeyword("fun");
		testKeyword("if");
		testKeyword("let");
		testKeyword("not");
		testKeyword("of");
		testKeyword("or");
		testKeyword("orelse");
		testKeyword("query");
		testKeyword("receive");
		testKeyword("rem");
		testKeyword("try");
		testKeyword("when");
		testKeyword("xor");

		testKeyword("spec");
	}

	@Test
	public void binaries() {
		testTerminal("A= <<1>>", "VARIABLE", "'='", "WS", "'<<'", "INT", "'>>'");
		testTerminal("A=<<1>>", "VARIABLE", "'=<'", "'<'", "INT", "'>>'");
	}

}
