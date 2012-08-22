package org.erlide.builder

import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IMarker

class BuilderMarkerUpdater {
	
	String markerType
	
	new(String type) {
		markerType = type
	}
	
	def void addMarker(IFile file, String message, int lineNumber, int severity) {
        var ln = lineNumber
        try {
            val marker = file.createMarker(markerType)
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

	
	def void deleteMarkers(IFile file) {
        try {
            file.deleteMarkers(markerType, false, IResource::DEPTH_ZERO);
        } catch (CoreException ce) {
        }
    }

	
}