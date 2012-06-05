package org.erlide.scoping

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.Module
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*
import org.erlide.erlang.Function

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangLinkingTest {

    @Inject
    ParseHelper<Module> parser
    @Inject
    IQualifiedNameConverter cvtr;
    @Inject
    extension ModelExtensions 
	
	@Test
	def void funcallRef() {
		val module = parser.parse('''
			-module(m).
			f() ->
				m:g(3),
				g(3).
			g(X) -> ok.
        ''')
        
        val refs = module.eResource.allContents.filter[!eCrossReferences.empty].map[
        	eCrossReferences.head
        ].filter[!eIsProxy].toList

        assertThat(refs.size, is(1))
        assertThat(refs.head, is(instanceOf(typeof(Function))))
        assertThat(refs.head as Function, is(module.getFunction("g", 1)))
    }
    
}