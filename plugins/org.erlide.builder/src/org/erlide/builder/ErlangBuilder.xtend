package org.erlide.builder

import java.util.Map
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.SubProgressMonitor

import static org.eclipse.core.resources.IncrementalProjectBuilder.*

class ErlangBuilder extends IncrementalProjectBuilder {

    public static String BUILDER_ID = "org.erlide.builder.erlangBuilder"
    public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem"


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
        SimpleErlangBuilder::compileResource(resource as IFile) 
        	[ file, message, lineNumber, severity |
            	addMarker(file, message, lineNumber, severity)
			]
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

}
