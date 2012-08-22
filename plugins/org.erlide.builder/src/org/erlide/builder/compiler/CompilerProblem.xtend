package org.erlide.builder.compiler

import org.eclipse.xtend.lib.Data

@Data
class CompilerProblem {
	String fileName
	String message
	int line
	int severity
	
}