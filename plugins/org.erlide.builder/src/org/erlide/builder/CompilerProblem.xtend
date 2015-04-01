package org.erlide.builder

import org.eclipse.xtend.lib.annotations.Data

@Data
class CompilerProblem {
	String fileName
	String message
	int line
	int severity
}