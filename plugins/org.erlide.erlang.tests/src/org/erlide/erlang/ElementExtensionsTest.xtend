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

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ElementExtensionsTest extends AbstractErlangTests {
	
	@Inject
	ParseHelper<Module> parser
    @Inject
    extension ModelExtensions 
	
    @Test
    def void getModule() {
        val module = parser.parse('''
            -module(x).
            -export([ff/0]).
            ff() -> ok.
            gg() -> ok.
        ''')
        val ff = module.getFunction("ff", 0)
        assertThat(ff.module, is(module))
        val fexpr = ff.clauses.head.body.head
        assertThat(fexpr.module, is(module))
    }

}