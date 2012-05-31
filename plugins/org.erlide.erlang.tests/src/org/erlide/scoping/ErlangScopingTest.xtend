package org.erlide.scoping

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.Module
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangScopingTest {

    @Inject
    ParseHelper<Module> parser
    
    @Inject
    ResourceDescriptionsProvider indexProvider

	@Test
	def void exportedFunctions() {
		val module = parser.parse('''
            -module(x).
            f() -> ok.
            g(X) -> X.
        ''')
        val res = module.eResource
 		val descriptionIndex = indexProvider.getResourceDescriptions(res);
		val descr = descriptionIndex.getResourceDescription(res.getURI());
        println(descr)
    }
}