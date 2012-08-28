package org.erlide.project.buildpath.convert

import org.erlide.project.buildpath.IBuildpathContainer
import org.erlide.project.buildpath.IBuildpathEntry
import org.erlide.project.buildpath.IBuildpathFolder
import org.junit.Test
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.IPath
import org.junit.Before
import java.util.Collection

class OldProjectBuildpathConverterTest {

	PathExpander expander
	Collection<IPath> externals

	@Before
	def void prepare() {
		expander = new PathExpander(new TestContentProvider())
		externals = expander.expandFile(new Path("foo"), newHashMap())
	}

    @Test
    def void emptyProperties() {
    	val props = new OldErlangProjectProperties()
    	val converter = new OldProjectBuildpathConverter()
    	val IBuildpathEntry entry = converter.convert(props, "projname", newArrayList("foo", "bar"), externals)
    	println(entry.debugPrint)
    }
    
    @Test
    def void demoProperties() {
    	val props = new OldErlangProjectProperties()
    	var IPath[] paths = newArrayList(new Path("s1"), new Path("s2"))
    	props.setSourceDirs(paths)
    	paths = newArrayList(new Path("i1/i1"), new Path("i2"))
    	val converter = new OldProjectBuildpathConverter()
    	props.setIncludeDirs(paths)
    	val IBuildpathEntry entry = converter.convert(props, "projname", newArrayList("bar"), externals)
    	println(entry.debugPrint)
    }
    
    def private dispatch String debugPrint(IBuildpathContainer container) {
    	'''
    		«container.kind» '«container.name»' {
    			«FOR e: container.children»
    				«e.debugPrint»
    			«ENDFOR»
    		}
    	'''
    }
    def private dispatch String debugPrint(IBuildpathFolder folder) {
    	'''
    		«folder.kind» @path='«folder.path»'
    	'''
    }
    def private dispatch String debugPrint(IBuildpathEntry entry) {
    	'''
    		Entry { '«entry.name»' }
    	'''
    }

}

class TestContentProvider extends AbstractContentProvider {
	
	override get(IPath path) {
		switch path.toPortableString {
			case "demo.erlidex": {
				newArrayList("AAA")
			}
			default:
				NOTHING
		}
	}
	
}
