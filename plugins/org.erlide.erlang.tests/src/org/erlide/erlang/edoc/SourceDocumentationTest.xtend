package org.erlide.erlang.edoc

import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.erlide.ErlangInjectorProvider
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.junit.Test

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class SourceDocumentationTest extends AbstractXtextTests {
	
	@Test
	def void canRetrieveDocsForFunction() {
		fail("not implemented yet")
	}
	
	@Test
	def void canRetrieveDocsForModule() {
		fail("not implemented yet")
	}
	
	@Test
	def void canRetrieveDocsForRemoteFunction() {
		fail("not implemented yet")
	}
	
	@Test
	def void canRetrieveDocsForLibraryFunction() {
		fail("not implemented yet")
	}
	
	@Test
	def void functionDocsIncludeSpec() {
		fail("not implemented yet")
	}
	
	
}