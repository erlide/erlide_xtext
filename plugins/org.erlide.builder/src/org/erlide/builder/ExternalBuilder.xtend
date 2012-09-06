package org.erlide.builder

import java.util.List
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.Property
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.runtime.OperationCanceledException

abstract class ExternalBuilder extends AbstractErlangBuilder {

	BuilderExecutor executor
	@Property IPath workingDir
	@Property List<String> cleanCmdLine
	@Property List<String> fullCmdLine
	@Property List<String> singleCmdLine
	
	val List<String> NONE = newArrayList()

	new() {
		super()
		this.executor = new BuilderExecutor()
		cleanCmdLine = NONE
		fullCmdLine = NONE
		singleCmdLine = NONE
	}

	new(IProject project, BuilderMarkerUpdater markerUpdater) {
		this(project, markerUpdater, new BuilderExecutor())
	}
	
	new(IProject project, BuilderMarkerUpdater markerUpdater, BuilderExecutor executor) {
		super(project, markerUpdater)
		this.executor = executor
		cleanCmdLine = NONE
		fullCmdLine = NONE
		singleCmdLine = NONE
	}
	
	override clean(IProgressMonitor monitor) {
		execute(cleanCmdLine, monitor)
	}
	
	override fullBuild(IProgressMonitor monitor) throws CoreException {
		markerUpdater.clean(project, ErlangBuilder::MARKER_TYPE)
		// TODO cmdline
		val errors = execute(fullCmdLine, monitor)
		errors.forEach[ 
			println(it) 
			val IFile file = project.findMember(fileName) as IFile
			println("FILE "+fileName+" = "+file)
			if(file!=null) {
				markerUpdater.addMarker(file, ErlangBuilder::MARKER_TYPE, message, line, severity)
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
	                singleBuild(resource as IFile, monitor)
	            //case IResourceDelta::REMOVED:
	            case IResourceDelta::CHANGED:
	                singleBuild(resource as IFile, monitor)
            }
            return true
        ]
	}

	def singleBuild(IFile file, IProgressMonitor monitor) {
		markerUpdater.deleteMarkers(file, ErlangBuilder::MARKER_TYPE)
		// TODO cmdline
		val errors = execute(singleCmdLine, monitor)
		errors.forEach[ 
			println(it) 
			markerUpdater.addMarker(file, ErlangBuilder::MARKER_TYPE, message, line, severity)
		]
	}
	
	def private execute(List<String> cmds, IProgressMonitor monitor) {
		println("EXEC '"+cmds+"' in "+project.name)
		val List<CompilerProblem> result = newArrayList()
        executor.executeProcess(cmds, 
            "/vobs/gsn/product/code/sgsn-w/ups",//project.location.toPortableString(), 
            monitor, new DefaultLineParser()) [
            	problem | result.add(problem)
            ]
        return result
	}
	
	override loadConfiguration() {
		// TODO load from preferences
		// - working directory
		// - cmd lines
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
}