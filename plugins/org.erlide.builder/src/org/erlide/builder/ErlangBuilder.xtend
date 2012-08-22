package org.erlide.builder

import java.util.Map
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
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
import org.erlide.builder.compiler.ErlCompiler
import org.erlide.builder.compiler.IErlangCompiler

import static org.eclipse.core.resources.IncrementalProjectBuilder.*
import static org.erlide.builder.ErlangBuilder.*

class ErlangBuilder extends IncrementalProjectBuilder {

    public static String BUILDER_ID = "org.erlide.builder.erlangBuilder"
    public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem"

    Map<String, IErlangCompiler> compilers;

	new() {
		compilers = newHashMap()
	}
	
    def static void addMarker(IFile file, String message,
            int lineNumber, int severity) {
        var ln = lineNumber
        try {
            val marker = file.createMarker(MARKER_TYPE)
            marker.setAttribute(IMarker::MESSAGE, message)
            marker.setAttribute(IMarker::SEVERITY, severity)
            if (lineNumber == -1) {
                ln = 1
            } else
            	ln = lineNumber
            marker.setAttribute(IMarker::LINE_NUMBER, lineNumber);
        } catch (CoreException e) {
        }
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
        getProject().refreshLocal(IResource::DEPTH_INFINITE,
                new SubProgressMonitor(monitor, 10))
        return null
    }

    def private void compileResource(IResource resource) {
        if (!(resource instanceof IFile) || !isErlangResource(resource)) {
            return;
        }
        deleteMarkers(resource as IFile)
        //TODO get project's compiler setting
        compilers.get(ErlCompiler::COMPILER_ID).compileResource(resource as IFile, null) 
        	[ addMarker(file, message, line, severity) ]
	}

    def private boolean isErlangResource(IResource resource) {
        return resource.projectRelativePath.fileExtension == "erl"
    }

    def void deleteMarkers(IFile file) {
        try {
            file.deleteMarkers(MARKER_TYPE, false, IResource::DEPTH_ZERO);
        } catch (CoreException ce) {
        }
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
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
