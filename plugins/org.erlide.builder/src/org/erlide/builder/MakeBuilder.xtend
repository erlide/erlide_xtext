package org.erlide.builder

import org.eclipse.core.resources.IProject

import static extension org.erlide.builder.ProjectBuilderExtensions.*

class MakeBuilder extends ExternalBuilder {

	new() {
		super()
		setupCommands()
	}

	new(IProject project, BuilderMarkerUpdater markerUpdater) {
		super(project, markerUpdater)
		setupCommands()
		loadConfiguration
	} 
	
	new(IProject project, BuilderMarkerUpdater markerUpdater, BuilderExecutor executor) {
		super(project, markerUpdater, executor)
		setupCommands()
		loadConfiguration
	}
	
	def setupCommands() {
		cleanCmdLine = newArrayList("make", "clean")
		fullCmdLine = newArrayList("make", "beam")
		singleCmdLine = newArrayList("make", "-W", "$file")
	}
	
}