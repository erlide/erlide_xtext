package org.erlide.builder.markers

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
import org.erlide.builder.markers.RemoveMarkersEvent
import org.erlide.builder.markers.AddMarkerEvent
import org.erlide.builder.CompilerProblem

@Singleton
class BuilderMarkerUpdater {

	EventBus builderEventBus

	@Inject
	new(@Named("erlangBuilder") EventBus builderEventBus) {
		this.builderEventBus = builderEventBus
		builderEventBus.register(this)		
	}
	
	def void addMarker(IFile file, String markerType, CompilerProblem problem) {
        var ln = problem.line
        try {
            val marker = file.createMarker(markerType)
            marker.setAttribute(IMarker::MESSAGE, problem.message)
            marker.setAttribute(IMarker::SEVERITY, problem.severity)
            ln = Math::max(problem.line, 1)
            marker.setAttribute(IMarker::LINE_NUMBER, ln)
        } catch (CoreException e) {
        	ErlLogger::instance.warn("Could not add marker for "+file+": "+e.message)
        }
    }

	
	def void deleteMarkers(IResource resource, String markerType) {
        try {
            resource.deleteMarkers(markerType, false, IResource::DEPTH_INFINITE)
        } catch (CoreException e) {
        	ErlLogger::instance.warn("Could not delete markers for "+resource+": "+e.message)
        }
    }

	@Subscribe
	def void handleRemoveMarkers(RemoveMarkersEvent event) {
		//ErlLogger::instance.debug(""+event)
		deleteMarkers(event.resource, event.markerType)
	}
	
	@Subscribe
	def void handleAddMarker(AddMarkerEvent event) {
		//ErlLogger::instance.debug(""+event)
		addMarker(event.file, event.markerType, event.problem)
	}
	
}