package org.erlide.builder

import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.xtend.lib.Property

import static extension org.erlide.builder.ProjectBuilderExtensions.*
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.core.runtime.SubProgressMonitor
import org.eclipse.core.resources.IResource
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
		val progress = SubMonitor::convert(monitor, 1)
		try {
			markerUpdater.clean(project, ErlangBuilder::MARKER_TYPE)
			execute(cleanCmdLine, progress) []
			progress.worked(1)
		} finally {
			monitor?.done
		}
	}
	
	override fullBuild(IProgressMonitor monitor) throws CoreException {
		val progress = SubMonitor::convert(monitor, IProgressMonitor::UNKNOWN)
		try {
			clean(progress.newChild(10))
			// TODO cmdline
			execute(fullCmdLine, progress) [ 
				val fPath = project.getPathInProject(new Path(fileName))
				val file = project.findMember(fPath)
				switch file {
					IFile: {
						if(file!=null) {
							markerUpdater.addMarker(file, it)
							progress.worked(1)
						}
					}
				}
			]
		} finally {
			monitor?.done
		}
	}
	
	override incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		val progress = SubMonitor::convert(monitor, IProgressMonitor::UNKNOWN);
		try {
			delta.accept [
	           	if (!(resource instanceof IFile)) 
	           		return true
	           	if (progress.canceled) 
	           		throw new OperationCanceledException()
	           	progress.worked(1)
	            switch (kind) {
		            case IResourceDelta::ADDED:
		                singleBuild(resource as IFile, progress.newChild(1))
		            //case IResourceDelta::REMOVED:
		            case IResourceDelta::CHANGED:
		                singleBuild(resource as IFile, progress.newChild(1))
	            }
	            return true
	        ]
        } finally {
        	monitor?.done
        }
	}

	def singleBuild(IFile file, IProgressMonitor monitor) {
		val progress = SubMonitor::convert(monitor, 2);
		try {
			markerUpdater.deleteMarkers(file, ErlangBuilder::MARKER_TYPE)
			progress.worked(1)
			// TODO cmdline
			val cmd = fillCmdLine(singleCmdLine, file.name)
			execute(cmd, progress) [ 
				markerUpdater.addMarker(file, it)
				progress.worked(1)
			]
		} finally {
			monitor?.done
		}
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
		
		if(project.location.toPortableString.startsWith("/vobs/gsn")) {
			workingDir = project.linkedContent?.location
			println("WD="+workingDir)
		}
	}
	
}