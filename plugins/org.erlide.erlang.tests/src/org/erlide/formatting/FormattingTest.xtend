package org.erlide.formatting

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.resource.XtextResource
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.util.ErlangTestingHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*
import org.junit.Before
import org.erlide.erlang.ErlangTestSetup

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class FormattingTest extends AbstractXtextTests {
	
	@Inject
    ErlangTestingHelper parser
	
	def dumpCode(String code) {
		val XtextResource r = getResourceFromString(code)
		println(NodeModelUtils::compactDump(r.getParseResult().getRootNode(), false));
	}
	
	def String serializeFormatted(EObject obj) {
		return getSerializer().serialize(obj, SaveOptions::newBuilder().format().getOptions())
	}

	@Test
	def void test() {
		val String code = '''
            -module (x) .'''
        val module = parser.parse(code)
        val actual = serializeFormatted(module.key)
        assertThat(actual, is(code)) 
	}
	
	@Before
	override void setUp() throws Exception {
		super.setUp();
		with(typeof(ErlangTestSetup));
	}
	
}