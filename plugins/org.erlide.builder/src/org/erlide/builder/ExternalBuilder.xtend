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
		val progress = SubMonitor::convert(monitor, 100)
		removeMarkers(project, ErlangBuilder::MARKER_TYPE)
		execute(cleanCmdLine, progress) []
		progress.worked(100)
	}
	
	override fullBuild(IProgressMonitor monitor) throws CoreException {
		var progress = SubMonitor::convert(monitor, 100)
		val work = estimateWork(fullCmdLine)
		progress.worked(10)
		progress = SubMonitor::convert(progress.newChild(90), work)
		
		for (i: 0..work) {
			Thread::sleep(10)
			progress.newChild(1)
		}
		Thread::sleep(1000)
		 
//		execute(fullCmdLine, progress) [ 
//			val fPath = project.getPathInProject(new Path(fileName))
//			val file = project.findMember(fPath)
//			switch file {
//				IFile: {
//					addMarker(file, it)
//				}
//			}
//		]
	}
	
	override incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		val work = estimateWork(fullCmdLine)
		val progress = SubMonitor::convert(monitor, work) 
		delta.accept [
           	if (!(resource instanceof IFile)) 
           		return true
           	if (progress.canceled) 
           		throw new OperationCanceledException()
            switch (kind) {
	            case IResourceDelta::ADDED:
	                singleBuild(resource as IFile, progress)
	            //case IResourceDelta::REMOVED:
	            case IResourceDelta::CHANGED:
	                singleBuild(resource as IFile, progress)
            }
            return true
        ]
	}

	def singleBuild(IFile file, IProgressMonitor monitor) {
		val cmd = fillCmdLine(singleCmdLine, file.name)
		val work = estimateWork(cmd, 1)
		val progress = SubMonitor::convert(monitor, work);
		removeMarkers(file, ErlangBuilder::MARKER_TYPE)
		execute(cmd, progress) [ 
			addMarker(file, it)
		]
	}
	
	def private fillCmdLine(List<String> cmds, String file) {
		cmds.map [ if(it=="$file") file else it ]
	}
	
	def private execute(List<String> cmds, IProgressMonitor monitor, (CompilerProblem)=>void callback) {
		log.debug("EXEC '"+cmds+"' in "+workingDir)
		executor.withHandler(new ProgressLineParser(), [ monitor.worked(1) ]) [
			withHandler(new DefaultLineParser(), callback) [
        		executeProcess(cmds, workingDir.toOSString, monitor)
    		]
        ]
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
			val List<String> result = newArrayList
			
			executor.withHandler(new ToBuildLineParser(), [ result.add(it) ]) [
        		executeProcess(myCmds, workingDir.toOSString, new NullProgressMonitor())
	        ]
			
			val guess = result.size
			println("GUESS work::"+(guess+extra))
			
			if(guess==0) 
				IProgressMonitor::UNKNOWN 
			else 
				guess+extra
		} catch (Throwable e) {
			IProgressMonitor::UNKNOWN 
		}
	}
	
}

