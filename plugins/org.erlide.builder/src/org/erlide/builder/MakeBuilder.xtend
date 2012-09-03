package org.erlide.builder

import org.eclipse.core.resources.IncrementalProjectBuilder
import java.util.Map
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor

class MakeBuilder extends IncrementalProjectBuilder {
	
	override protected build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
		val projdir = project.location
		
		return null
	}
	
}