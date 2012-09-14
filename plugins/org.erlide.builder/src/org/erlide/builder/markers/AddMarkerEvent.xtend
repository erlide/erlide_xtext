package org.erlide.builder.markers

import org.eclipse.core.resources.IFile
import org.erlide.builder.CompilerProblem

@Data
class AddMarkerEvent {
	IFile file
	String markerType
	CompilerProblem problem
}