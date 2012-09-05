package org.erlide.builder

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.resources.IFile

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
		val errors = execute(newArrayList("make", "clean").toList, monitor)
	}
	
	override fullBuild(IProgressMonitor monitor) throws CoreException {
		markerUpdater.clean(project)
		val errors = execute(newArrayList("make", "beam").toList, monitor)
		errors.forEach[ 
			println(it) 
			val IFile file = project.findMember(fileName) as IFile
			println("FILE "+fileName+" = "+file)
			if(file!=null) {
				markerUpdater.addMarker(file, message, line, severity)
			}
		]
	}
	
	override incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		delta.accept [
           	if(monitor.canceled) 
           		throw new OperationCanceledException();
           	if (!(resource instanceof IFile)) 
           		return true
            switch (kind) {
	            case IResourceDelta::ADDED:
	                compileResource(resource as IFile, monitor)
	            //case IResourceDelta::REMOVED:
	            case IResourceDelta::CHANGED:
	                compileResource(resource as IFile, monitor)
            }
            return true
        ]
 	}

def compileResource(IFile file, IProgressMonitor monitor) {
	markerUpdater.deleteMarkers(file)
	val errors = execute(newArrayList("make", "-W", file.location.toOSString).toList, monitor)
	errors.forEach[ 
		println(it) 
		markerUpdater.addMarker(file, message, line, severity)
	]
}	

}