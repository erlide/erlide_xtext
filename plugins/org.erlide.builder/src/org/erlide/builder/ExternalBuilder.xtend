package org.erlide.builder

import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.xtend.lib.Property

import static extension org.erlide.builder.ProjectBuilderExtensions.*
import org.eclipse.core.runtime.Path

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
		markerUpdater.clean(project, ErlangBuilder::MARKER_TYPE)
		execute(cleanCmdLine, monitor) []
		monitor.worked(1)
	}
	
	override fullBuild(IProgressMonitor monitor) throws CoreException {
		clean(monitor)
		// TODO cmdline
		execute(fullCmdLine, monitor) [ 
			val fPath = project.getPathInProject(new Path(fileName))
			val IFile file = project.findMember(fPath) as IFile
			if(file!=null) {
				markerUpdater.addMarker(file, it)
				monitor.worked(1)
			}
		]
	}
	
	override incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		delta.accept [
           	if (!(resource instanceof IFile)) 
           		return true
           	monitor.worked(1)
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
		val cmd = fillCmdLine(singleCmdLine, file.name)
		execute(cmd, monitor) [ 
			println("SINGLE "+it) 
			markerUpdater.addMarker(file, it)
			monitor.worked(1)
		]
	}
	
	def private fillCmdLine(List<String> cmds, String file) {
		cmds.map [ if(it=="$file") file else it ]
	}
	
	def private execute(List<String> cmds, IProgressMonitor monitor, (CompilerProblem)=>void callback) {
		println("EXEC '"+cmds+"' in "+workingDir)
        executor.executeProcess(cmds, workingDir.toOSString, monitor, new DefaultLineParser(), callback)
	}
	
	override loadConfiguration() {
		// TODO load from preferences
		// - working directory
		// - cmd lines
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
}