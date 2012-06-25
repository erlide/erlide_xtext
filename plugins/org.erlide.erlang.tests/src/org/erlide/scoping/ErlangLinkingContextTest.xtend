package org.erlide.scoping

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.Module
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangLinkingContextTest {

    @Inject
    ParseHelper<Module> parser
    @Inject
    extension ModelExtensions 
    @Inject
    extension ErlangLinkingHelper 

	@Test 
	def void simpleAtom() {
		val module = parser.parse('''
			-module(m).
			f() ->
				g(3),
				ok.
			g(X) -> ok.
        ''')
        
        val refs = module.eResource.allContents.filter[!eCrossReferences.empty].map[
        	eCrossReferences.head
        ].filter[!eIsProxy].toList

		// TODO more work here!

		println(refs.size)
		println(refs.head.sourceText)
		println(refs.head.linkableContext)
	}
	
}
