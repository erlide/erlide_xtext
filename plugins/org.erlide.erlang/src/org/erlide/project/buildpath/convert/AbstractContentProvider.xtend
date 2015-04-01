package org.erlide.project.buildpath.convert

import java.util.Collection
import java.util.Collections
import org.eclipse.core.runtime.IPath

class AbstractContentProvider {
	
	public static val Collection<String> NOTHING = Collections::unmodifiableCollection(newArrayList())
	
	def Collection<String> get(IPath path) {
		return NOTHING 
	}
}