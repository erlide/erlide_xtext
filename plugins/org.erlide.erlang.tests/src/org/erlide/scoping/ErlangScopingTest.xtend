package org.erlide.scoping

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.ErlangPackage$Literals
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.Module
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.emf.ecore.resource.Resource

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangScopingTest {

    @Inject
    ParseHelper<Module> parser
    @Inject
    IResourceServiceProvider$Registry resourceProviderRegistry
    @Inject
    IQualifiedNameConverter cvtr;
    @Inject
    extension ModelExtensions 
	
	@Test
	def void allContents() {
		val module = parser.parse('''
            -module(x).
            f() -> ok.
            -ifdef(A).
            g(X) -> X.
            -else.
            -ifdef(B).
            g(X) -> X.
            -endif.
            -endif.
        ''')
        val eFuns = module.getAllContents
        assertThat(eFuns.size, is(4))
	}

	@Test
	def void noExportedFunctions() {
		val module = parser.parse('''
            -module(x).
            f() -> ok.
            g(X) -> X.
        ''')
        val eFuns = module.exportedFunctions
        assertThat(eFuns.size, is(0))
    }
    
	@Test
	def void exportedFunctions() {
		val module = parser.parse('''
            -module(x).
            -export([f/0]).
            g(X) -> X.
            f() -> ok.
        ''')
        val eobjs = module.exportedDescriptions
        println(eobjs)
        val eFuns = module.exportedFunctions
        assertThat(eFuns.size, is(1))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("x:f/0"))
    }
    
	@Test
	def void exportedFunctionsIfdef() {
		val module = parser.parse('''
            -module(x).
            -export([f/0, f/1]).
            -ifdef(Z).
            f() -> ok.
            -else.
            f(X) -> ok.
            -endif.
        ''')
        val eFuns = module.exportedFunctions
        assertThat(eFuns.size, is(2))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("x:f/0"))
        assertThat(cvtr.toString(eFuns.tail.head.qualifiedName), is("x:f/1"))
    }
    
	@Test
	def void exportedMacros() {
		val module = parser.parse('''
            -module(x).
            -define(XX, xx).
        ''')
        val eFuns = module.exportedMacros
        assertThat(eFuns.size, is(1))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("x:XX"))
    }
    
	@Test
	def void exportedMacrosHeader() {
		val module = parser.parse('''
            -define(XX, xx).
        ''')
        val eFuns = module.exportedMacros
        assertThat(eFuns.size, is(1))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("__synthetic0_erl:XX"))
    }
    
	@Test
	def void exportedRecords() {
		val module = parser.parse('''
            -module(x).
            -record(rec, {}).
        ''')
        val eFuns = module.exportedRecords
        assertThat(eFuns.size, is(1))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("x:rec"))
    }

	@Test
	def void exportedRecordsHeader() {
		val module = parser.parse('''
            -record(rec, {}).
        ''')
        val eFuns = module.exportedRecords
        assertThat(eFuns.size, is(1))
        assertThat(cvtr.toString(eFuns.head.qualifiedName), is("__synthetic0_erl:rec"))
    }
 
 	def getIndexProvider(Resource res) {
 		resourceProviderRegistry.getResourceServiceProvider(res.URI).resourceDescriptionManager
 	}
    
	def getDescription(Module module) {
		val res = module.eResource
 		getIndexProvider(res).getResourceDescription(res)
	}

	def getExportedDescriptions(Module module) {
        module.description.exportedObjects
	}

	def getExportedFunctions(Module module) {
        module.description.getExportedObjectsByType(ErlangPackage$Literals::FUNCTION)
	}

	def getExportedMacros(Module module) {
        module.description.getExportedObjectsByType(ErlangPackage$Literals::DEFINE_ATTRIBUTE)
	}

	def getExportedRecords(Module module) {
        module.description.getExportedObjectsByType(ErlangPackage$Literals::RECORD_ATTRIBUTE)
	}

}