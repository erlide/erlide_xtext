package org.erlide.erlang.edoc

import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.erlide.ErlangInjectorProvider
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.junit.Test

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class OtpDocumentationTest extends AbstractXtextTests {

	@Test
	def void canRetrieveOtpDocsForFunction() {
		fail("not implemented yet")
	}

	@Test
	def void canRetrieveOtpDocsForModule() {
		fail("not implemented yet")
	}

}
