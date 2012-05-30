package org.erlide.naming

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.ConditionalFormBlock
import org.erlide.erlang.Module
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*
import org.erlide.erlang.Function
import org.erlide.erlang.FunExpr

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangNamingTest {

    @Inject
    ParseHelper<Module> parser
	@Inject
	IQualifiedNameProvider namer
	@Inject
	IQualifiedNameConverter nameCvtr

	@Test
	def void moduleName() {
        val module = parser.parse('''
            -module(x).
        ''')
        val name = namer.getFullyQualifiedName(module)
        assertThat(nameCvtr.toString(name), is("x")) 
	}

	@Test
	def void moduleNameQuoted() {
        val module = parser.parse('''
            -module('X').
        ''')
        val name = namer.getFullyQualifiedName(module)
        assertThat(nameCvtr.toString(name), is("'X'")) 
	}

	@Test
	def void headerName() {
        val module = parser.parse('''
            -define(X, x).
        ''')
        val name = namer.getFullyQualifiedName(module)
        // the name is generated for this embedded resource
        assertThat(nameCvtr.toString(name), is("__synthetic0.erl,hrl")) 
	}

	@Test
	def void recordName() {
        val module = parser.parse('''
            -module(x).
            -record(y, {}).
        ''')
        val name = namer.getFullyQualifiedName(module.forms.tail.head)
        assertThat(nameCvtr.toString(name), is("x:#y_1")) 
	}

	@Test
	def void ifdefName() {
        val module = parser.parse('''
            -module(x).
            -ifdef(M).
            -record(y, {}).
            -else.
            -record(y, {}).
            -endif.
        ''')
        val dfn = module.forms.get(1) as ConditionalFormBlock
        val name1 = namer.getFullyQualifiedName(dfn.ifForms.head)
        assertThat(nameCvtr.toString(name1), is("x:#y_1")) 
        val name2 = namer.getFullyQualifiedName(dfn.elseForms.head)
        assertThat(nameCvtr.toString(name2), is("x:#y_2")) 
	}
	
	@Test
	def void functionName() {
        val module = parser.parse('''
            -module(x).
            f() -> ok.
        ''')
        val name = namer.getFullyQualifiedName(module.forms.tail.head)
        assertThat(nameCvtr.toString(name), is("x:f/0")) 
	}

	@Test
	def void functionName_1() {
        val module = parser.parse('''
            -module(x).
            f(X) -> ok.
            f() -> ok.
        ''')
        val name1 = namer.getFullyQualifiedName(module.forms.tail.head)
        assertThat(nameCvtr.toString(name1), is("x:f/1")) 
        val name2 = namer.getFullyQualifiedName(module.forms.tail.tail.head)
        assertThat(nameCvtr.toString(name2), is("x:f/0")) 
	}

	@Test
	def void functionClause() {
        val module = parser.parse('''
            -module(x).
            f(a) -> ok;
            f(b) -> ok.
        ''')
        val clauses = (module.forms.tail.head as Function).clauses
        val name1 = namer.getFullyQualifiedName(clauses.head)
        assertThat(nameCvtr.toString(name1), is("x:f/1:0")) 
        val name2 = namer.getFullyQualifiedName(clauses.tail.head)
        assertThat(nameCvtr.toString(name2), is("x:f/1:1")) 
	}

	@Test
	def void functionInline() {
        val module = parser.parse('''
            -module(x).
            f() -> fun() -> ok end.
        ''')
        val fun = (module.forms.tail.head as Function).clauses.head.body.head as FunExpr
        val name1 = namer.getFullyQualifiedName(fun)
        assertThat(nameCvtr.toString(name1), is("x:f/0:0:fun_0")) 
	}

	@Test
	def void functionInline_2() {
        val module = parser.parse('''
            -module(x).
            f() -> ok, fun() -> ok end.
        ''')
        val fun = (module.forms.get(1) as Function).clauses.head.body.get(1) as FunExpr
        val name1 = namer.getFullyQualifiedName(fun)
        assertThat(nameCvtr.toString(name1), is("x:f/0:0:fun_1")) 
	}

	@Test
	def void functionClauseInline() {
        val module = parser.parse('''
            -module(x).
            f() -> fun() -> ok end.
        ''')
        val fun = (module.forms.tail.head as Function).clauses.head.body.head as FunExpr
        val name1 = namer.getFullyQualifiedName(fun.clauses.head)
        assertThat(nameCvtr.toString(name1), is("x:f/0:0:fun_0:0")) 
	}

	@Test
	def void macroName() {
        val module = parser.parse('''
            -module(x).
            -define(X, x).
        ''')
        val obj = module.forms.tail.head
        val name1 = namer.getFullyQualifiedName(obj)
        assertThat(nameCvtr.toString(name1), is("x:?X")) 
	}



	
}