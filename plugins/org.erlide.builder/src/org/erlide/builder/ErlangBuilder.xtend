package org.erlide.builder

import java.util.Map
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

	BuilderMarkerUpdater markerUpdater;

	new() {
		this(new BuilderMarkerUpdater(MARKER_TYPE), new BuildersProvider())
	}
	
	new(BuilderMarkerUpdater markerUpdater, BuildersProvider builderProvider) {
		builderProvider.loadBuilders()
		
		this.markerUpdater = markerUpdater
	}
	
	override protected IProject[] build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
        val builder = new MakeBuilder(project, markerUpdater); //builders.get(project)
        if (builder==null) {
        	// TODO issue warning?
        } else {
        	//TODO
        	builder.fullBuild(monitor)
        }
        project.refreshLocal(IResource::DEPTH_INFINITE,
                new SubProgressMonitor(monitor, 10))
        return null
    }

	override protected clean(IProgressMonitor monitor) throws CoreException {
        val builder = new MakeBuilder(project, markerUpdater); //builders.get(project)
        if (builder==null) {
        	// TODO issue warning?
        } else {
        	builder.clean(monitor)
        }
		markerUpdater.clean(project)
	}
	
}
