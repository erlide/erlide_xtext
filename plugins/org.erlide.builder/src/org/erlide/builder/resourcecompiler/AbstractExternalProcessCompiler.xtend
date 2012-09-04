package org.erlide.builder.resourcecompiler

import org.erlide.builder.BuilderExecutor

abstract class AbstractExternalProcessCompiler extends AbstractCompiler {
	
	@Property val BuilderExecutor executor
	
	new(BuilderExecutor executor) {
		this._executor = executor
	}
	
	new () {
		this(new org.erlide.builder.BuilderExecutor())
	}
	
}