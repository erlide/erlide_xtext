package org.erlide.scoping

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.Function
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.Module
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*
import org.erlide.erlang.util.ErlangTestingHelper
import org.erlide.erlang.ErlangTestExtensions

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangLinkingHelperTest {
	
    @Inject
    ErlangTestingHelper parser
    @Inject
    extension ModelExtensions
    @Inject
    extension ErlangLinkingHelper
	@Inject
	extension ErlangTestExtensions 
    
    @Test
    def void macro() {
    	val module = parser.parse('''
			-module(m).
			-define(X, x).
			f() ->
				g(§?X),
				ok.
			g(X) -> ok.
        ''')
    	
    	println(module.objectAtMarker.sourceText)
    	println(module.objectAtMarker.eContainer.sourceText)
    	println(module.objectAtMarker.classify)
    } 
    
    @Test
    def void noLink() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				§g(3),
				ok.
			g(X) -> ok.
        ''')
    	
    	println(module.getObjectAtMarker.sourceText)
    } 
}