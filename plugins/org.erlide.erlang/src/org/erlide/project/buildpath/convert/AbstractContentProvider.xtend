package org.erlide.project.buildpath.convert

import org.eclipse.core.runtime.IPath
import java.util.Collection
import java.util.Collections

class AbstractContentProvider {
	
	public static val Collection<String> NOTHING = Collections::unmodifiableCollection(newArrayList())
	
	def Collection<String> get(IPath path) {
		return NOTHING 
	}
}