package org.erlide.builder

import java.util.Map
import javax.inject.Inject
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.SubProgressMonitor

import static org.erlide.builder.ErlangBuilder.*

class ErlangBuilder extends IncrementalProjectBuilder {

    public static String BUILDER_ID = "org.erlide.builder.erlangBuilder"
    public static String OLD_BUILDER_ID = "org.erlide.core.erlbuilder"
    public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem"

	@Inject BuilderMarkerUpdater markerUpdater
	@Inject BuildersProvider builderProvider

	new() {
        BuilderPlugin::instance.injector.injectMembers(this);
	}
	
	new(BuilderMarkerUpdater markerUpdater, BuildersProvider builderProvider) {
		this.markerUpdater = markerUpdater
		this.builderProvider = builderProvider
	}
	
	override protected IProject[] build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
        val builder = getProjectBuilder(project)
        if (builder==null) {
        	// TODO issue warning?
        } else {
        	//TODO
        	switch(kind) {
        		case FULL_BUILD:
		        	builder.fullBuild(monitor)
		        default:
		        	builder.incrementalBuild(getDelta(project), monitor)
        	}
        }
        project.refreshLocal(IResource::DEPTH_INFINITE, new SubProgressMonitor(monitor, 10))
        return null
    }

	override protected clean(IProgressMonitor monitor) throws CoreException {
        val builder = getProjectBuilder(project)
        if (builder==null) {
        	// TODO issue warning?
        } else {
        	builder.clean(monitor)
        }
		markerUpdater.clean(project, MARKER_TYPE)
	}
	
	def getProjectBuilder(IProject project) {
		val bId = SgsnBuilder::ID // TODO get project's config
		val builder = builderProvider.get(bId)
        builder.project = project
        builder.loadConfiguration
        builder
	}	
}
