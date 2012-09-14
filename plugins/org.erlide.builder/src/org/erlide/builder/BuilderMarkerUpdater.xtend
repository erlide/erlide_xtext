package org.erlide.builder

import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import com.google.inject.Inject
import com.google.inject.name.Named
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.erlide.common.util.ErlLogger
import javax.inject.Singleton

@Singleton
class BuilderMarkerUpdater {

	EventBus builderEventBus

	@Inject
	new(@Named("erlangBuilder") EventBus builderEventBus) {
		this.builderEventBus = builderEventBus
		builderEventBus.register(this)		
	}
	
	def void addMarker(IFile file, CompilerProblem problem) {
		addMarker(file, ErlangBuilder::MARKER_TYPE, problem.message, problem.line, problem.severity)
	}
	
	def void addMarker(IFile file, String markerType, String message, int lineNumber, int severity) {
        var ln = lineNumber
        try {
            val marker = file.createMarker(markerType)
            marker.setAttribute(IMarker::MESSAGE, message)
            marker.setAttribute(IMarker::SEVERITY, severity)
            ln = Math::max(lineNumber, 1)
            marker.setAttribute(IMarker::LINE_NUMBER, lineNumber)
        } catch (CoreException e) {
        	ErlLogger::instance.warn("Could not add marker for "+file+": "+e.message)
        }
    }

	
	def void deleteMarkers(IResource resource, String markerType) {
        try {
            resource.deleteMarkers(markerType, false, IResource::DEPTH_ZERO)
        } catch (CoreException e) {
        	ErlLogger::instance.warn("Could not delete markers for "+resource+": "+e.message)
        }
    }

	@Subscribe
	def void handleRemoveMarkers(RemoveMarkersEvent event) {
		ErlLogger::instance.debug(""+event)
		deleteMarkers(event.resource, event.markerType)
	}
	
	@Subscribe
	def void handleAddMarker(AddMarkerEvent event) {
		ErlLogger::instance.debug(""+event)
		addMarker(event.file, event.problem)
	}
	
}