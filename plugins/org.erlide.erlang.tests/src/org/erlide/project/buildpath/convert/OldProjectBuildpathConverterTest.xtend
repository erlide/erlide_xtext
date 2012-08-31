package org.erlide.project.buildpath.convert

import java.util.Collection
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.erlide.project.buildpath.BuildpathApp
import org.erlide.project.buildpath.BuildpathEntry
import org.erlide.project.buildpath.BuildpathFolder
import org.erlide.project.buildpath.BuildpathLibrary
import org.junit.Before
import org.junit.Test

import static org.erlide.project.buildpath.convert.AbstractContentProvider.*
import org.erlide.project.buildpath.convert.OldErlangProjectProperties

class OldProjectBuildpathConverterTest {

	PathExpander expander
	Collection<IPath> externals

	@Before
	def void prepare() {
		expander = new PathExpander(new OpbTestContentProvider())
		externals = expander.expandFile(new Path("foo"), newHashMap())
	}

    @Test
    def void emptyProperties() {
    	val props = new OldErlangProjectProperties()
    	val converter = new OldProjectBuildpathConverter()
    	val BuildpathEntry entry = converter.convert(props, "projname", newArrayList("foo", "bar"), externals)
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
    	val BuildpathEntry entry = converter.convert(props, "projname", newArrayList("bar"), externals)
    	println(entry.debugPrint)
    }
    
    def private dispatch String debugPrint(BuildpathLibrary container) {
    	'''
    		LIB '«container.name»' {
    			«FOR e: container.apps»
    				«e.debugPrint»
    			«ENDFOR»
    			«FOR e: container.libraries»
    				«e.debugPrint»
    			«ENDFOR»
    		}
    	'''
    }
    def private dispatch String debugPrint(BuildpathApp container) {
    	'''
    		APP {
    			«FOR e: container.folders»
    				«e.debugPrint»
    			«ENDFOR»
    		}
    	'''
    }
    def private dispatch String debugPrint(BuildpathFolder folder) {
    	'''
    		«folder.kind» path='«folder.path»' inc=«folder.inclusionPatterns» exc=«folder.exclusionPatterns»
    	'''
    }

}

class OpbTestContentProvider extends AbstractContentProvider {
	
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
