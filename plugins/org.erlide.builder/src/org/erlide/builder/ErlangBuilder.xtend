package org.erlide.builder

import java.util.Map
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IConfigurationElement
import org.eclipse.core.runtime.IExtensionRegistry
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Platform
import org.eclipse.core.runtime.SubProgressMonitor
import org.erlide.builder.compiler.CompilerOptions
import org.erlide.builder.compiler.ErlCompiler
import org.erlide.builder.compiler.IErlangCompiler
import org.erlide.project.model.IErlangProject

import static org.eclipse.core.resources.IncrementalProjectBuilder.*
import static org.erlide.builder.ErlangBuilder.*

class ErlangBuilder extends IncrementalProjectBuilder {

    public static String BUILDER_ID = "org.erlide.builder.erlangBuilder"
    public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem"

    Map<String, IErlangCompiler> compilers;
	BuilderMarkerUpdater markerUpdater;

	new() {
		compilers = newHashMap()
		markerUpdater = new BuilderMarkerUpdater(MARKER_TYPE)
	}
	
	override protected IProject[] build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
		loadCompilers()
	    if (kind == FULL_BUILD) {
            fullBuild(monitor)
        } else {
            val IResourceDelta delta = getDelta(getProject())
            if (delta == null) {
                fullBuild(monitor)
            } else {
                incrementalBuild(delta, monitor)
            }
        }
        project.refreshLocal(IResource::DEPTH_INFINITE,
                new SubProgressMonitor(monitor, 10))
        return null
    }

	override protected clean(IProgressMonitor monitor) throws CoreException {
		markerUpdater.clean(project)
	}
	
    def private void compileResource(IResource resource) {
        if (ignoreResource(resource)) {
            return;
        }
        val erlFile = resource as IFile
        markerUpdater.deleteMarkers(erlFile)
        val compiler = compilers.get(getCompilerId(project))
        if (compiler==null) {
        	// TODO issue warning
        } else {
        	// TODO get options from project
	        val options = new CompilerOptions()
        	compiler.compileResource(erlFile, options).forEach [ 
        		markerUpdater.addMarker(erlFile, message, line, severity)
        	]
        }
	}

	def private ignoreResource(IResource resource) {
		val isFile = resource instanceof IFile
		val erlProject = Platform::adapterManager.getAdapter(project, typeof(IErlangProject))
		println("!!! "+project+" "+erlProject) 
		// TODO check project setting
		val onSourcePath = true || erlProject!=null && true
		return !isFile || !isErlangResource(resource) || !onSourcePath 
	}

	def private String getCompilerId(IProject project) {
		// TODO get compilerId from project settings
		ErlCompiler::COMPILER_ID
	}

    def private boolean isErlangResource(IResource resource) {
        return resource.projectRelativePath.fileExtension == "erl"
    }

    def protected void fullBuild(IProgressMonitor monitor)
            throws CoreException {
        try {
            getProject().accept [
            	compileResource(it);
	            return true
	        ]
        } catch (CoreException e) {
        }
    }

    def void incrementalBuild(IResourceDelta delta,
            IProgressMonitor monitor) throws CoreException {
        delta.accept [
            switch (kind) {
            case IResourceDelta::ADDED:
                compileResource(resource)
            //case IResourceDelta::REMOVED:
            case IResourceDelta::CHANGED:
                compileResource(resource)
            }
            return true
        ]
    }

    def private void loadCompilers() {
        val IExtensionRegistry reg = Platform::getExtensionRegistry()
        val IConfigurationElement[] elements = reg.getConfigurationElementsFor("org.erlide.builder.compilers")
        for (element : elements) {
            try {
            	val compiler = element.createExecutableExtension("class") as IErlangCompiler
                compilers.put(compiler.id, compiler);
            } catch (CoreException e) {
                // ignore
            }
        }
    }

}
