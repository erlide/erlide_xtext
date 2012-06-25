package org.erlide.scoping

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.Function
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.Module
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

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
	def void localCallRef() {
		val module = parser.parse('''
			-module(m).
			-export([g/1]).
			f() ->
				g(3),
				ok.
			g(X) -> ok.
        ''')
        
        val refs = module.eResource.allContents.filter[!eCrossReferences.empty].map[
        	eCrossReferences.head
        ].filter[!eIsProxy].toList

        assertThat(refs.size, is(2))
        assertThat(refs.head, is(instanceOf(typeof(Function))))
        assertThat(refs.head as Function, is(module.getFunction("g", 1)))
    }
    
	@Test
	def void remoteCallRef() {
		val module = parser.parse('''
			-module(m).
			f() ->
				m:g(3),
				ok.
			g(X) -> ok.
        ''')
        
        val refs = module.eResource.allContents.filter[!eCrossReferences.empty].map[
        	eCrossReferences.head
        ].filter[!eIsProxy].toList

        println(">>>"+refs.map[it.sourceText])
        assertThat(refs.size, is(2))
        assertThat(refs.head, is(instanceOf(typeof(Module))))
        assertThat(refs.head as Module, is(module))
        assertThat(refs.tail.head, is(instanceOf(typeof(Function))))
        assertThat(refs.tail.head as Function, is(module.getFunction("g", 1)))
    }
    
	@Test
	def void funRef() {
		println("----------------------------------------------")
		val module = parser.parse('''
			-module(m).
			f() ->
				fun m:g/1,
				ok.
			g(X) -> ok.
        ''')
        
        val refs = module.eResource.allContents.filter[!eCrossReferences.empty].map[
        	eCrossReferences.head
        ].filter[!eIsProxy].toList

        assertThat(refs.size, is(2))
        println(">>>"+refs.map[it.sourceText])
        assertThat(refs.tail.head, is(instanceOf(typeof(Function))))
        assertThat(refs.tail.head as Function, is(module.getFunction("g", 1)))
    }
    
}