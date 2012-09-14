package org.erlide.builder

import org.eclipse.core.resources.IResource
import org.eclipse.xtend.lib.Data

@Data
class CompilerProblemEvent {
	CompilerProblem problem
	IResource resource
	MarkerOperation op
}