package org.erlide.builder

import java.util.Map
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IConfigurationElement
import org.eclipse.core.runtime.IExtensionRegistry
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Platform
import org.eclipse.core.runtime.SubProgressMonitor
import org.erlide.builder.compiler.ErlCompiler

import static org.erlide.builder.ErlangBuilder.*

class ErlangBuilder extends IncrementalProjectBuilder {

    public static String BUILDER_ID = "org.erlide.builder.erlangBuilder"
    public static String OLD_BUILDER_ID = "org.erlide.core.erlbuilder"
    public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem"

    Map<String, IncrementalProjectBuilder> builders;
	BuilderMarkerUpdater markerUpdater;

	new() {
		builders = newHashMap()
		loadBuilders()
		
		markerUpdater = new BuilderMarkerUpdater(MARKER_TYPE)
	}
	
	override protected IProject[] build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
        val compiler = builders.get(getCompilerId(project))
        if (compiler==null) {
        	// TODO issue warning?
        } else {
        	compiler.build(kind, args, monitor)
        }
        project.refreshLocal(IResource::DEPTH_INFINITE,
                new SubProgressMonitor(monitor, 10))
        return null
    }

	override protected clean(IProgressMonitor monitor) throws CoreException {
        val compiler = builders.get(getCompilerId(project))
        if (compiler==null) {
        	// TODO issue warning?
        } else {
        	compiler.clean(monitor)
        }
		markerUpdater.clean(project)
	}
	
	def private String getCompilerId(IProject project) {
		// TODO get compilerId from project settings
		ErlCompiler::COMPILER_ID
	}

    def private void loadBuilders() {
        val IExtensionRegistry reg = Platform::getExtensionRegistry()
        val IConfigurationElement[] elements = reg.getConfigurationElementsFor("org.erlide.builder.builders")
        for (element : elements) {
            try {
            	val compiler = element.createExecutableExtension("class") as IncrementalProjectBuilder
            	// TODO fix id
                builders.put(getCompilerId(null), compiler);
            } catch (CoreException e) {
                // ignore
            }
        }
    }

}
