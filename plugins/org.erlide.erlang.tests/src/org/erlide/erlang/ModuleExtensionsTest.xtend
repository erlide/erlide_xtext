package org.erlide.erlang

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.erlide.ErlangInjectorProvider
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*
import static org.erlide.erlang.IsFunRefMatcher.*

import static extension org.erlide.erlang.ModelExtensions.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ModuleExtensionsTest {
	
    @Inject
    ParseHelper<Module> parser
	
    @Test
    def void moduleName() {
        val module = parser.parse('''
            -module(x).
        ''')
        val myname = module.name 
        assertThat(myname, is("x")) 
    }

    @Test
    def void moduleNameWithComments() {
        val module = parser.parse('''
            %% comment
            -module(x).
        ''')
        val myname = module.name 
        assertThat(myname, is("x")) 
    }
    
    @Test
    def void noModuleName() {
        val module = parser.parse('''
            -include("x").
        ''')
        val myname = module.name 
        assertThat(myname, is(nullValue)) 
    }

    @Test
    def void headerHasNoName() {
        val module = parser.parse('''
            -include("x").
        ''')
        assertThat(module.isHeader, is(true))
    }
    
    @Test
    def void fullModuleHasName() {
        val module = parser.parse('''
            -module(x).
        ''')
        assertThat(module.isHeader, is(false))
    }
 
    @Test
    def void getAttributes() {
        val module = parser.parse('''
            -module(x).
            -define(X, ok).
            foo() -> ok.
            -foo(bar).
        ''')
        val attrs = module.attributes
        assertThat(attrs.size, is(3))
    }
    
    @Test
    def void getCustomAttributesByTag() {
        val module = parser.parse('''
            -module(x).
            -foo(baz).
            -define(X, ok).
            foo() -> ok.
            -foo(bar).
        ''')
        val attrs = module.getCustomAttributesWithTag("foo")
        assertThat(attrs.size, is(2))
        assertThat(attrs.head.tag, is("foo"))
        assertThat(attrs.tail.head.tag, is("foo"))
    }
 
    @Test
    def void getExportFunctions() {
        val module = parser.parse('''
            -module(x).
            -export([bar/0, baz/1]).
            -export([foo/0]).
            bar()->ok.
            baz(X)->ok.
            foo()->ok.
        ''')
        val attrs = module.exportedFunctions
        assertThat(attrs.size, is(3))
        
        assertThat(attrs.head, isFunction("bar", 0))
        assertThat(attrs.tail.head, isFunction("baz", 1))
        assertThat(attrs.tail.tail.head, isFunction("foo", 0))
    }

    @Test
    def void getExportFunRefs() {
        val module = parser.parse('''
            -module(x).
            -export([bar/0, baz/1]).
            -export([foo/0]).
        ''')
        val attrs = module.exportedFunRefs
        assertThat(attrs.size, is(3))
        
        assertThat(attrs.head, isFunRef("bar", 0))
        assertThat(attrs.tail.head, isFunRef("baz", 1))
        assertThat(attrs.tail.tail.head, isFunRef("foo", 0))
    }

    @Test
    def void getFunction() {
        val module = parser.parse('''
            -module(x).
            bar()->ok.
            baz(X)->ok.
            foo()->ok.
        ''')

        val bar = module.getFunction("bar", 0)
        assertThat(bar, is(notNullValue))
        assertThat(bar, isFunction("bar", 0))
    }
    
    @Test
    def void getUndefinedFunction() {
        val module = parser.parse('''
            -module(x).
            bar()->ok.
            baz(X)->ok.
            foo()->ok.
        ''')

        val bar1 = module.getFunction("bar", 1)
        assertThat(bar1, is(nullValue))
    }
 
}