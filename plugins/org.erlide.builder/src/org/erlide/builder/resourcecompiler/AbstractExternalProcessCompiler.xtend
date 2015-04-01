package org.erlide.builder.resourcecompiler

import org.eclipse.xtend.lib.Property
import org.erlide.builder.BuilderExecutor

abstract class AbstractExternalProcessCompiler extends AbstractCompiler {
	
	@Property val BuilderExecutor executor
	
	new(BuilderExecutor executor) {
		this._executor = executor
	}
	
	new () {
		this(new BuilderExecutor())
	}
	
}