package org.erlide.project.buildpath.convert

import com.google.common.collect.ImmutableSet
import java.util.Collection
import java.util.Map
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import java.util.List

class PathExpander {
	
	AbstractContentProvider provider
	
	new() {
		this.provider = new FileContentProvider()
	}
	
	// used for testing
	new(AbstractContentProvider provider) {
		this.provider = provider
	}
	
	def Collection<IPath> expandFileList(Collection<IPath> files, Map<String, String> pathVars) {
		ImmutableSet::copyOf(files.map[ expandFile(it, pathVars) ].flatten)
	}
	
	def Collection<IPath> expandFile(IPath file, Map<String, String> pathVars) {
		val xfile = replacePathVar(pathVars, file)
		if(xfile.fileExtension=="erlidex"){
			expandFileContents(xfile, pathVars)
		} else {
			newArrayList(file)
		}
	}
	
	def Collection<IPath> expandFileContents(IPath file, Map<String, String> pathVars) {
		val lines = provider.get(file)
		val paths = lines.map[new Path(it) as IPath].toList
		expandFileList(paths, pathVars)
	}
	
	// TODO move to pathVars class
	def replacePathVar(Map<String, String> pathVars, IPath path) {
		val head = path.segments.head
		if (pathVars.containsKey(head)) {
			return new Path(pathVars.get(head)).append(path.removeFirstSegments(1))
		}
		return path
	}
	
	// TODO move to pathVars class
	def replacePathVar(Map<String, String> pathVars, Collection<IPath> paths) {
		paths.map [ replacePathVar(pathVars, it) ]
	}

}