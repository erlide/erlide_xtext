package org.erlide.scoping

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.Module
import org.erlide.erlang.ScopeExtensions
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangGlobalScopingTest {

    @Inject
    ParseHelper<Module> parser
    @Inject
    IQualifiedNameConverter cvtr
    @Inject
    extension ModelExtensions 
    @Inject
    extension ScopeExtensions 
	
	@Test
	def void allContents() {
		val module = parser.parse('''
            -module(x).
            f() -> ok.
            -ifdef(A).
            g(X) -> X.
            -else.
            -ifdef(B).
            g(X) -> X.
            -endif.
            -endif.
        ''')
        val eFuns = module.getAllContents
        assertThat(eFuns.size, is(4))
	}

	@Test
	def void noExportedFunctions() {
		val module = parser.parse('''
            -module(x).
            f() -> ok.
            g(X) -> X.
        ''')
        val eFuns = module.exportedFunctions
        assertThat(eFuns.size, is(0))
    }
    
	@Test
	def void exportedFunctions() {
		val module = parser.parse('''
            -module(x).
            -export([f/0]).
            g(X) -> X.
            f() -> ok.
        ''')
        val eFuns = module.exportedFunctions
        assertThat(eFuns.size, is(1))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("x:f/0"))
    }
    
	@Test
	def void exportedFunctions_multipleExports() {
		val module = parser.parse('''
            -module(x).
            -export([f/0]).
            -export([g/1]).
            g(X) -> X.
            f() -> ok.
        ''')
        val eFuns = module.exportedFunctions
        assertThat(eFuns.size, is(2))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("x:g/1"))
        assertThat(cvtr.toString(eFuns.tail.head.qualifiedName), is("x:f/0"))
    }
    
	@Test
	def void exportedFunctions_exportAll() {
		val module = parser.parse('''
            -module(x).
            -compile([export_all]).
            g(X) -> X.
            f() -> ok.
        ''')
        val eFuns = module.exportedFunctions
        assertThat(eFuns.size, is(2))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("x:g/1"))
        assertThat(cvtr.toString(eFuns.tail.head.qualifiedName), is("x:f/0"))
    }

	@Test
	def void exportedFunctionsIfdef() {
		val module = parser.parse('''
            -module(x).
            -export([f/0, f/1]).
            -ifdef(Z).
            f() -> ok.
            -else.
            f(X) -> ok.
            -endif.
        ''')
        val eFuns = module.exportedFunctions
        assertThat(eFuns.size, is(2))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("x:f/0"))
        assertThat(cvtr.toString(eFuns.tail.head.qualifiedName), is("x:f/1"))
    }
    
	@Test
	def void exportedFunctionsIfdef_nested() {
		val module = parser.parse('''
            -module(x).
            -ifdef(Z).
            -export([f/0]).
            f() -> ok.
            -else.
            -export([g/1]).
            g(X) -> ok.
            -endif.
        ''')
        val eFuns = module.exportedFunctions
        assertThat(eFuns.size, is(2))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("x:f/0"))
        assertThat(cvtr.toString(eFuns.tail.head.qualifiedName), is("x:g/1"))
    }
    
	@Test
	def void exportedFunctionsIfdef_deepNested() {
		val module = parser.parse('''
            -module(x).
            -ifdef(Z).
            -export([f/0]).
            f() -> ok.
            -ifdef(Z).
            -export([ff/0]).
            ff() -> ok.
            -else.
            -export([fg/1]).
            fg(X) -> ok.
            -endif.
            -else.
            -export([g/1]).
            g(X) -> ok.
            -ifdef(Z).
            -export([gf/0]).
            gf() -> ok.
            -else.
            -export([gg/1]).
            gg(X) -> ok.
            -endif.
            -endif.
        ''')
        val eFuns = module.exportedFunctions
        assertThat(eFuns.size, is(6))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("x:f/0"))
        assertThat(cvtr.toString(eFuns.last.qualifiedName), is("x:gg/1"))
    }
    
	@Test
	def void exportedMacros() {
		val module = parser.parse('''
            -module(x).
            -define(XX, xx).
        ''')
        val macros = module.exportedMacros
        assertThat(macros.size, is(1))
        assertThat(cvtr.toString(macros.head.qualifiedName), is("x:XX"))
    }
    
	@Test
	def void exportedMacrosHeader() {
		val module = parser.parse('''
            -define(XX, xx).
        ''')
        val macros = module.exportedMacros
        assertThat(macros.size, is(1))
        assertThat(cvtr.toString(macros.head.qualifiedName), is("__synthetic0_erl:XX"))
    }
    
	@Test
	def void exportedRecords() {
		val module = parser.parse('''
            -module(x).
            -record(rec, {}).
        ''')
        val recs = module.exportedRecords
        assertThat(recs.size, is(1))
        assertThat(cvtr.toString(recs.head.qualifiedName), is("x:rec"))
    }

	@Test
	def void exportedRecordsHeader() {
		val module = parser.parse('''
            -record(rec, {}).
        ''')
        val recs = module.exportedRecords
        assertThat(recs.size, is(1))
        assertThat(cvtr.toString(recs.head.qualifiedName), is("__synthetic0_erl:rec"))
    }
 

}
