package org.erlide.builder.compiler

import org.eclipse.core.resources.IFile

@Data
class CompilerProblem {
	IFile file
	String message
	int line
	int severity
}