package org.erlide.erlang;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2;
import org.eclipselabs.xtext.utils.unittesting.XtextTest;
import org.erlide.ErlangInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner2.class)
@InjectWith(ErlangInjectorProvider.class)
public class RulesTest extends XtextTest {

	@Test
	public void keywords() {
		testParserRule("spec", "AtomOrKw");
		testParserRule("type", "Expression");
		testParserRule("opaque", "Expression");
		testParserRule("record", "Expression");
		testParserRule("define", "Expression");
	}

	@Test
	public void numbers() {
		testParserRule("33", "INTEGER");
		testParserRule("5#33", "INTEGER");
		testParserRule("33.4", "FLOAT");
		testParserRule("33.1e4", "FLOAT");
		testParserRule("33.1e+4", "FLOAT");
		testParserRule("33.1E-4", "FLOAT");

		testParserRuleErrors("33e4", "FLOAT", "mismatched input");
		testParserRuleErrors("33e+4", "FLOAT", "mismatched input");
	}

	@Test
	public void names() {
		testParserRule("?aa", "ExprMax");
		testParserRule("aa", "ExprMax");
		testParserRule("AAa", "ExprMax");
	}

	@Test
	public void macros() {
		testParserRule("?AA", "Macro");
		testParserRule("? AA", "Macro");
		// testParserRuleErrors("? AA", "Macro",
		// "no viable alternative at input ' '");
		testParserRule("?aa", "Macro");
		testParserRule("?_A", "Macro");
		testParserRule("??A", "Macro");
	}

	@Test
	public void funRefs() {
		testParserRule("fun aa/2", "FunExpr");
		testParserRule("fun mm:aa/2", "FunExpr");
		testParserRule("fun ?mm:aa/2", "FunExpr");
		testParserRule("fun mm:?aa/2", "FunExpr");
		testParserRule("fun Mmm:Aaa/2", "FunExpr");
	}

	@Test
	public void strings() {
		testParserRule("\"hej\"\n \"hej\"", "ErlString");
		testParserRule("\"hej\"\"hej\"", "ErlString");
		testParserRule("\"hej\" \"hej\"", "ErlString");
		testParserRule("\"hej\" ?m \"hej\"", "ErlString");
	}

	@Test
	public void records() {
		testParserRule("#rec{}", "Expr700");
		testParserRule("#rec{a=2}", "Expr700");
		testParserRule("V#rec{}", "Expr700");
		testParserRule("Z#rec.a", "Expr700");
		testParserRule("Z#Rec.a", "Expr700");
		testParserRule("#rec{}", "Expr700");
		testParserRule("#rec.a#rec{}", "Expr700");
		testParserRule("X#rec.a#rec{}", "Expression");
	}

	@Test
	public void funCalls() {
		testParserRule("aa()", "Expr700");
		testParserRule("aa:bb()", "Expr700");
		testParserRule("aa(2,?X3,4)", "Expr700");
		testParserRule("?M:aa()", "Expr700");
		testParserRule("?M:aa()", "Expression");
		testParserRule("aa:?F()", "Expr700");
		testParserRule("aa:?F()", "Expression");
		testParserRule("ZZ:aa()", "Expr700");
		testParserRule("aa:AA()", "Expr700");
		testParserRule("(A#aa.f)()", "Expr700");
	}

	@Test
	public void exprs() {
		testParserRule("{a}", "Expression");
		testParserRule("{?a}", "Expression");
	}

	@Test
	public void types() {
		testParserRule("-type a() :: b(). ", "Attribute");
		testParserRule("-type(a()::b()). ", "Attribute");
	}

	@Test
	public void lists() {
		testParserRule("[]", "List");
		testParserRule("[2]", "List");
		testParserRule("[2,3,4]", "List");
		testParserRule("[2,3|5]", "List");
		testParserRule("[2,3|5]", "Expression");

		testParserRule("[X || X<-K, Y<-[]]", "ListComprehension");
		testParserRule("[X || X<-K, Y<-[]]", "Expression");
	}

	@Test
	public void binaries() {
		testParserRule("<<>>", "Binary");
		testParserRule("<<X>>", "Binary");
		testParserRule("<<2,4,6>>", "Binary");
		testParserRule("<<2,<<4,6>> >>", "Binary");
		testParserRule("<<2,<<4,6>> >>", "Expression");
		testParserRule("<<\"2,4\",6>>", "Binary");
		testParserRule("<< X || Y<=x:y() >>", "BinaryComprehension");
		testParserRule("<< X || X<=x:y() >>", "Expression");
		testParserRule("<< ?X || X<=?x:y(3) >>", "BinaryComprehension");

		testParserRule("<<2:8,4,6>>", "Binary");
		testParserRule("<<2,4/integer,6>>", "Binary");
		testParserRule("<<2,4:X/integer-signed-unit:4,6>>", "Binary");

	}

	@Test
	public void tryExpr() {
		testParserRule("try x catch X -> ok end", "TryExpr");
		testParserRule("try x catch throw:X -> ok end", "TryExpr");
		testParserRule("try x catch _:X -> ok end", "TryExpr");
		testParserRule("try x catch _:#r{} -> ok end", "TryExpr");
	}
}
