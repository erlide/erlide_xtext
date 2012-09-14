package org.erlide.builder

import org.eclipse.core.resources.IProject

import static extension org.erlide.builder.ProjectBuilderExtensions.*

class MakeBuilder extends ExternalBuilder {

	new() {
		super()
		setupCommands()
	}

	new(IProject project, BuilderExecutor executor) {
		super(project, executor, null)
		setupCommands()
		loadConfiguration
	}
	
	def setupCommands() {
		cleanCmdLine = newArrayList("make", "clean")
		fullCmdLine = newArrayList("make", "beam")
		singleCmdLine = newArrayList("make", "-W", "$file")
	}
	
}