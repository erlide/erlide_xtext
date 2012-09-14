package org.erlide.builder

import org.eclipse.core.resources.IFile

@Data
class AddMarkerEvent {
	IFile file
	CompilerProblem problem
}