package org.erlide.builder

import java.util.Map
import javax.inject.Inject
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.ProgressMonitorWrapper
import org.eclipse.core.runtime.SubMonitor
import org.erlide.common.NatureConstants
import org.erlide.common.util.ErlLogger

import static extension org.erlide.common.util.ErlLogger.*
import org.eclipse.core.runtime.OperationCanceledException

class ErlangBuilder extends IncrementalProjectBuilder {

    public static String BUILDER_ID = "org.erlide.builder.erlangBuilder"
    public static String OLD_BUILDER_ID = "org.erlide.core.erlbuilder"
    public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem"

	@Inject BuilderMarkerUpdater markerUpdater
	@Inject BuildersProvider builderProvider
	@Inject ErlLogger log

	new() {
        BuilderPlugin::instance.injector.injectMembers(this);
	}
	
	new(BuilderMarkerUpdater markerUpdater, BuildersProvider builderProvider) {
		this.markerUpdater = markerUpdater
		this.builderProvider = builderProvider
	}
	
	override protected IProject[] build(int kind, Map<String,String> args, IProgressMonitor _monitor) throws CoreException {
		val startTime = System::currentTimeMillis
		cleanXtextMarkers(project)

		try {
			val monitor = if (_monitor != null) {
				val taskName = " building" + project.name+ ": "
				new BuilderProgressMonitorWrapper(_monitor, taskName) 
			} else 
				_monitor
			val progress = SubMonitor::convert(monitor, 1)

	        val builder = getProjectBuilder(project)
	        if (builder==null) {
	        	// TODO issue warning?
	        } else {
	        	//TODO
	        	switch(kind) {
	        		case FULL_BUILD:
			        	builder.fullBuild(progress.newChild(1))
			        default:
			        	builder.incrementalBuild(getDelta(project), progress.newChild(1))
	        	}
	        }

		} catch (CoreException e) {
			log.error(e)
			throw e
		} catch (OperationCanceledException e) {
			forgetLastBuiltState
			throw e
		} catch (Exception e) {
			log.error(e)
		} finally {
			if (_monitor != null)
				_monitor.done()
			log.info("Build " + getProject().getName() + " in " + (System::currentTimeMillis - startTime) + " ms")
		}
		return getProject().getReferencedProjects();
    }

	override protected clean(IProgressMonitor monitor) throws CoreException {
		val progress = SubMonitor::convert(monitor, 10);
		cleanXtextMarkers(project)
		progress.worked(2)
		try {
	        val builder = getProjectBuilder(project)
	        if (builder==null) {
	        	// TODO issue warning?
	        } else {
	        	builder.clean(progress.newChild(8))
	        }
			markerUpdater.clean(project, MARKER_TYPE)
		} finally {
			if (monitor != null)
				monitor.done();
		}
	}
	
	def getProjectBuilder(IProject project) {
		val bId = SgsnBuilder::ID // TODO get project's config
		val builder = builderProvider.get(bId)
        builder.project = project
        builder.loadConfiguration
        builder
	}
	
	def private cleanXtextMarkers(IProject project) {
		// TODO this removes all xtext markers, which are only created when file is open
		if(project.hasNature(NatureConstants::OLD_NATURE_ID)) {
			newArrayList("erlang.check.fast", 
						"erlang.check.normal", 
						"erlang.check.expensive").forEach [ 
				project.deleteMarkers("org.erlide.erlang.ui."+it, true, IResource::DEPTH_INFINITE)
			]
		}
	}	
}

class BuilderProgressMonitorWrapper extends ProgressMonitorWrapper {
	val String taskName
	
	new(IProgressMonitor monitor, String taskName) {
		super(monitor)
		this.taskName = taskName
	}
	
	override void subTask(String name) {
		super.subTask(taskName + name);
	}
}