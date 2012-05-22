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
import static extension org.erlide.erlang.ModelExtensions.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class FunctionExtensionsTest {
	
	@Inject
	ParseHelper<Module> parser
	
    @Test
    def void isExported() {
        val module = parser.parse('''
            -module(x).
            -export([ff/0]).
            ff() -> ok.
            gg() -> ok.
        ''')
        val ff = module.getFunction("ff", 0)
        assertThat(ff.isExported, is(true))
        val gg = module.getFunction("gg", 0)
        assertThat(gg.isExported, is(false))
    }

    @Test
    def void getSpec_old() {
        val module = parser.parse('''
			-module(x).
			-export([ff/0]).
			-spec ff/0 :: any() -> any().
			ff() -> ok.
			ff(X) -> ok.
        ''')
        val ff = module.getFunction("ff", 0)
        assertThat(ff.spec, is(notNullValue))
        assertThat(ff.spec, is(module.getSpec("ff", 0)))
        val gg = module.getFunction("ff", 1)
        assertThat(gg.spec, is(nullValue))
        assertThat(module.getSpec("gg", 0), is(nullValue))
    }
    
   @Test
    def void getSpec() {
        val module = parser.parse('''
			-module(x).
			-export([ff/0]).
			-spec ff(any()) -> any().
			ff() -> ok.
			ff(X) -> ok.
        ''')
        val ff = module.getFunction("ff", 1)
        assertThat(ff.spec, is(notNullValue))
        assertThat(ff.spec, is(module.getSpec("ff", 1)))
        val gg = module.getFunction("ff", 0)
        assertThat(gg.spec, is(nullValue))
        assertThat(module.getSpec("gg", 0), is(nullValue))
    }

}