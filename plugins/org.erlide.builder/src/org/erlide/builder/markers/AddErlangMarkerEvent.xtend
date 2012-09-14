package org.erlide.builder.markers

import org.eclipse.core.resources.IFile
import org.erlide.builder.CompilerProblem
import org.erlide.builder.ErlangBuilder

class AddErlangMarkerEvent extends AddMarkerEvent {
	
	new(IFile file, CompilerProblem problem) {
		super(file, ErlangBuilder::MARKER_TYPE, problem)
	}
	
}