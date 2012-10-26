package org.erlide.scoping

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.XtextResourceSet
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.Function
import org.erlide.erlang.Module
import org.erlide.erlang.ScopeExtensions
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class GlobalSearchTest {
	@Inject
    ParseHelper<Module> parser
    @Inject
    IQualifiedNameConverter cvtr
	@Inject
	Provider<XtextResourceSet> resourceSetProvider
    @Inject
    extension ScopeExtensions 

	// XXX projects must have all the Xtext nature!!!

	@Test
	def void canFindFunction() {
        val ResourceSet set = resourceSetProvider.get()
		val module_x = parser.parse('''
            -module(x).
            -export([f/0]).
            g(X) -> X.
            f() -> ok.
        ''', set)
		val module_z = parser.parse('''
            -module(z).
            -export([f/0]).
            g(X) -> X.
            f() -> ok.
        ''', set)
        
        val eFuns_x = module_x.exportedFunctions
        val eFuns_z = module_z.exportedFunctions
		val Function f1 = module_x.forms.findFirst[typeof(Function).isAssignableFrom(it.^class)] as Function
		
		println(f1)
		println(set)        
	}	

}