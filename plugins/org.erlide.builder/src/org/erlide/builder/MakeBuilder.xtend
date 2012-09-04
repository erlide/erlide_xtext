package org.erlide.builder

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.CoreException

class MakeBuilder extends ExternalBuilder {

	new() {
		super()
	}

	new(IProject project, BuilderMarkerUpdater markerUpdater) {
		super(project, markerUpdater)
	}
	
	new(IProject project, BuilderMarkerUpdater markerUpdater, BuilderExecutor executor) {
		super(project, markerUpdater, executor)
	}
	
	override clean(IProgressMonitor monitor) throws CoreException {
		val errors = execute(newArrayList("make", "clean").toList)
	}
	
	override fullBuild(IProgressMonitor monitor) throws CoreException {
		val errors = execute(newArrayList("make", "-B", "beam").toList)
		
		errors.forEach[ println(it) ]
		
	}
	
}