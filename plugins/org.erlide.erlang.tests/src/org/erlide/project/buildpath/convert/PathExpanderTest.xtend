package org.erlide.project.buildpath.convert

import java.util.Map
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.junit.Test

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*
import org.erlide.project.buildpath.convert.PathExpander

class PathExpanderTest {
	
	@Test
	def void expandPaths() {
		val Map<String, String> pathVars = newHashMap()
		val expander = new PathExpander(new PeTestContentProvider())
		
		val result = expander.expandFile(new Path("demo.erlidex"), pathVars)
		assertThat("expandFile failed", 
			result.map[toPortableString].toList, 
			is(newArrayList("AAA", "aaa","bbb","BBB").toList)
		)
	}
}

class PeTestContentProvider extends AbstractContentProvider {
	
	override get(IPath path) {
		switch path.toPortableString {
			case "demo.erlidex": {
				newArrayList("AAA", "inc1.erlidex", "BBB", "bbb")
			}
			case "inc1.erlidex": {
				newArrayList("aaa", "bbb")
			}
			default:
				newArrayList()
		}
	}
	
}