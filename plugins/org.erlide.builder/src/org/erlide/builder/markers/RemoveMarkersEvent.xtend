package org.erlide.builder.markers

import org.eclipse.core.resources.IResource
import org.eclipse.xtend.lib.Data

@Data
class RemoveMarkersEvent {
	IResource resource
	String markerType
}