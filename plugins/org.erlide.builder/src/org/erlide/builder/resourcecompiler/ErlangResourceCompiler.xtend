package org.erlide.builder.resourcecompiler

import java.util.Map
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IConfigurationElement
import org.eclipse.core.runtime.IExtensionRegistry
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.Platform
import org.erlide.builder.AbstractErlangBuilder
import org.erlide.builder.BuilderMarkerUpdater
import org.erlide.project.model.IErlangProject
import org.erlide.builder.CompilerOptions
import org.erlide.builder.ErlangBuilder

class ErlangResourceCompiler extends AbstractErlangBuilder {

    Map<String, IErlangCompiler> compilers

	new(IProject project, BuilderMarkerUpdater markerUpdater) {
		super(project, markerUpdater)
		compilers = newHashMap()
	}
	
	new() {
		super()
		compilers = newHashMap()
	}

	override setProject(IProject project) {
		this.project = project
	}
	
	override getId() {
		^class.name.toLowerCase
	}
	
	override clean(IProgressMonitor monitor) throws CoreException {
		markerUpdater.clean(project, ErlangBuilder::MARKER_TYPE)
	}
	
    def private void compileResource(IResource resource) {
        if (ignoreResource(resource)) {
            return;
        }
        val erlFile = resource as IFile
        markerUpdater.deleteMarkers(erlFile, ErlangBuilder::MARKER_TYPE)
        val compiler = compilers.get(getCompilerId(project))
        if (compiler==null) {
        	// TODO issue warning
        } else {
        	// TODO get options from project
	        val options = new CompilerOptions()
	        println("compile "+erlFile)
        	compiler.compileResource(erlFile, options).forEach [ 
        		markerUpdater.addMarker(erlFile, ErlangBuilder::MARKER_TYPE, message, line, severity)
        	]
        }
	}

	def private ignoreResource(IResource resource) {
		val isFile = resource instanceof IFile
		val erlProject = Platform::adapterManager.getAdapter(project, typeof(IErlangProject))
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

    override void fullBuild(IProgressMonitor monitor) throws CoreException {
        try {
            project.accept [
            	if(monitor.canceled) 
            		throw new OperationCanceledException();
            	compileResource(it);
	            return true
	        ]
        } catch (CoreException e) {
        }
    }

    override void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
        delta.accept [
           	if(monitor.canceled) 
            		throw new OperationCanceledException();
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


	override setMarkerUpdater(BuilderMarkerUpdater markerUpdater) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
}
