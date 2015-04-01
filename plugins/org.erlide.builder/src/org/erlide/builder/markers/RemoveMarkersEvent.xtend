package org.erlide.builder.markers

import org.eclipse.core.resources.IResource
import org.eclipse.xtend.lib.annotations.Data

@Data
class RemoveMarkersEvent {
	IResource resource
	String markerType
}