package org.erlide.builder

import com.google.common.eventbus.EventBus
import com.google.inject.Inject
import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.xtend.lib.Property
import org.erlide.common.util.ErlLogger

import static extension org.erlide.builder.ProjectBuilderExtensions.*
import java.util.ArrayList
import org.eclipse.core.runtime.NullProgressMonitor

abstract class ExternalBuilder extends AbstractErlangBuilder {

	@Inject BuilderExecutor executor
	@Inject ErlLogger log
	
	@Property IPath workingDir
	@Property List<String> cleanCmdLine
	@Property List<String> fullCmdLine
	@Property List<String> singleCmdLine
	
	val List<String> NONE = newArrayList()

	new() {
		super()
		cleanCmdLine = NONE
		fullCmdLine = NONE
		singleCmdLine = NONE
	}

	new(IProject project, BuilderExecutor executor, EventBus eventBus) {
		super(project, eventBus)
		this.executor = executor
		cleanCmdLine = NONE
		fullCmdLine = NONE
		singleCmdLine = NONE
	}
	
	override clean(IProgressMonitor monitor) {
		val progress = SubMonitor::convert(monitor, 1)
		try {
			removeMarkers(project, ErlangBuilder::MARKER_TYPE)
			execute(cleanCmdLine, progress) []
			progress.worked(1)
		} finally {
			monitor?.done
		}
	}
	
	override fullBuild(IProgressMonitor monitor) throws CoreException {
		val work = estimateWork(fullCmdLine, 1)
		val progress = SubMonitor::convert(monitor, work)
		try {
			clean(progress.newChild(1))
			// TODO cmdline
			execute(fullCmdLine, progress) [ 
				val fPath = project.getPathInProject(new Path(fileName))
				val file = project.findMember(fPath)
				switch file {
					IFile: {
						if(file!=null) {
							addMarker(file, it)
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
		val work = estimateWork(fullCmdLine)
		val progress = SubMonitor::convert(monitor, work);
		try {
			delta.accept [
	           	if (!(resource instanceof IFile)) 
	           		return true
	           	if (progress.canceled) 
	           		throw new OperationCanceledException()
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
		val cmd = fillCmdLine(singleCmdLine, file.name)
		val work = estimateWork(cmd, 2)
		val progress = SubMonitor::convert(monitor, work);
		try {
			removeMarkers(file, ErlangBuilder::MARKER_TYPE)
			progress.worked(1)
			// TODO cmdline
			execute(cmd, progress) [ 
				addMarker(file, it)
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
		log.debug("EXEC '"+cmds+"' in "+workingDir)
        executor.executeProcess(cmds, workingDir.toOSString, monitor, new DefaultLineParser(), callback)
	}
	
	override loadConfiguration() {
		// TODO load from preferences
		// - working directory
		// - cmd lines
		
		if(project.location.toPortableString.startsWith("/vobs/gsn")) {
			workingDir = project.linkedContent?.location
			log.debug("WD="+workingDir)
		}
	}

	def estimateWork(List<String> cmds) {
		estimateWork(cmds, 0)
	}
	
	def estimateWork(List<String> cmds, int extra) {
		try {
			val myCmds = new ArrayList(cmds)
			myCmds.add(1, "-dn")
			println("EXC::"+myCmds)
			val List<String> result = newArrayList
	        executor.executeProcess(myCmds, workingDir.toOSString, new NullProgressMonitor(), new ToBuildLineParser()) [
	        	println("### "+it)
				result.add(it)			        	
	        ]
			val guess = result.size
			
			if(guess==0) 
				IProgressMonitor::UNKNOWN 
			else 
				guess+extra
		} catch (Throwable e) {
			IProgressMonitor::UNKNOWN 
		}
	}
	
}

