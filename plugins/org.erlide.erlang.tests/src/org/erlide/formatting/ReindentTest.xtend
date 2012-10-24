package org.erlide.formatting

import com.google.inject.Inject
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.util.ErlangTestingHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ReindentTest extends AbstractXtextTests {
	
	@Inject
    ErlangTestingHelper parser
    
    @Test
    def void reindentPreservesLineBreaks() {
    	// use example that would be re-lined by full formatter
    	fail("not implemented yet")
    }
    
    // TODO: what cases to test for?
    // Just a large file with many different cases?
	
}
