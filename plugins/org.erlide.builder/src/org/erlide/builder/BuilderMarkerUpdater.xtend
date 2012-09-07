package org.erlide.builder

import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.erlide.common.util.ErlLogger

class BuilderMarkerUpdater {
	
	def void addMarker(IFile file, String markerType, String message, int lineNumber, int severity) {
        var ln = lineNumber
        try {
            val marker = file.createMarker(markerType)
            marker.setAttribute(IMarker::MESSAGE, message)
            marker.setAttribute(IMarker::SEVERITY, severity)
            if (lineNumber == -1) {
                ln = 1
            } else
            	ln = lineNumber
            marker.setAttribute(IMarker::LINE_NUMBER, lineNumber)
        } catch (CoreException e) {
        	ErlLogger::warn("Could not add marker for "+file+": "+e.message)
        }
    }

	
	def void deleteMarkers(IFile file, String markerType) {
        try {
            file.deleteMarkers(markerType, false, IResource::DEPTH_ZERO)
        } catch (CoreException e) {
        	ErlLogger::warn("Could not delete markers for "+file+": "+e.message)
        }
    }

	def clean(IProject project, String markerType) {
		project.deleteMarkers(markerType, false, IResource::DEPTH_INFINITE)
	}
	
}