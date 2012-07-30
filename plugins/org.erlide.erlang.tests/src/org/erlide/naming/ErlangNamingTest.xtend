package org.erlide.naming

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.util.ErlangTestingHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.erlide.erlang.ErlangTestExtensions

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangNamingTest {

    @Inject
    ErlangTestingHelper parser
	@Inject
	IQualifiedNameProvider namer
	@Inject
	IQualifiedNameConverter nameCvtr
	@Inject
	extension ErlangTestExtensions 

	@Test
	def void moduleName() {
        val module = parser.parse('''
            -module(x).
        ''')
        val name = namer.getFullyQualifiedName(module.key)
        assertThat(nameCvtr.toString(name), is("x")) 
	}

	@Test
	def void moduleNameQuoted() {
        val module = parser.parse('''
            -module('X').
        ''')
        val name = namer.getFullyQualifiedName(module.key)
        assertThat(nameCvtr.toString(name), is("'X'")) 
	}

	@Test
	def void headerName() {
        val module = parser.parse('''
            -define(X, x).
        ''')
        val name = namer.getFullyQualifiedName(module.key)
        // the name is generated for this embedded resource
        assertThat(nameCvtr.toString(name), is("__synthetic0_erl")) 
	}

	@Test
	def void typeName() {
        val module = parser.parse('''
            -module(x).
            §-type(y::integer()).
        ''')
        val name = namer.getFullyQualifiedName(module.getObjectAtMarker(0))
        assertThat(nameCvtr.toString(name), is("x:y"))
	}

	@Test
	def void ifdef_name() {
        val module = parser.parse('''
            -module(x).
            -ifdef(M).
            §-record(y, {}).
            -else.
            §-record(y, {}).
            -endif.
        ''')
        val name1 = namer.getFullyQualifiedName(module.getObjectAtMarker(0))
        assertThat(nameCvtr.toString(name1), is("x:y")) 
        val name2 = namer.getFullyQualifiedName(module.getObjectAtMarker(1))
        assertThat(nameCvtr.toString(name2), is("x:y")) 
	}
	
	@Test
	def void exportedFunctionName() {
        val module = parser.parse('''
            -module(x).
            -export([f/0]).
            §f() -> ok.
        ''')
        val name = namer.getFullyQualifiedName(module.getObjectAtMarker(0))
        assertThat(nameCvtr.toString(name), is("x:f/0")) 
	}

	@Test
	def void localFunctionName() {
        val module = parser.parse('''
            -module(x).
            §local() -> ok.
        ''')
        val name = namer.getFullyQualifiedName(module.getObjectAtMarker(0))
        assertThat(nameCvtr.toString(name), is("x:local/0")) 
	}

	@Test
	def void exportedFunctionName_1() {
        val module = parser.parse('''
            -module(x).
            -export([f/0, 'Ff'/1]).
            §'Ff'(X) -> ok.
            §f() -> ok.
        ''')
        val name1 = namer.getFullyQualifiedName(module.getObjectAtMarker(0))
        assertThat(nameCvtr.toString(name1), is("x:'Ff'/1")) 
        val name2 = namer.getFullyQualifiedName(module.getObjectAtMarker(1))
        assertThat(nameCvtr.toString(name2), is("x:f/0")) 
	}

	@Test
	def void macroName() {
        val module = parser.parse('''
            -module(x).
            §-define(X, x).
        ''')
        val name1 = namer.getFullyQualifiedName(module.getObjectAtMarker(0))
        assertThat(nameCvtr.toString(name1), is("x:X")) 
	}

	@Test
	def void recordName() {
        val module = parser.parse('''
            -module(x).
            §-record(y, {}).
        ''')
        val name = namer.getFullyQualifiedName(module.getObjectAtMarker(0))
        assertThat(nameCvtr.toString(name), is("x:y")) 
	}

	@Test
	def void recordName_quoted() {
        val module = parser.parse('''
            -module(x).
            §-record('Y', {}).
        ''')
        val name = namer.getFullyQualifiedName(module.getObjectAtMarker(0))
        assertThat(nameCvtr.toString(name), is("x:'Y'")) 
	}


}
