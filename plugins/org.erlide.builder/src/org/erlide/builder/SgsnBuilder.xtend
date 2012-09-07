package org.erlide.builder

import org.eclipse.core.resources.IProject

import static extension org.erlide.builder.ProjectBuilderExtensions.*

class SgsnBuilder extends ExternalBuilder {
	
	new() {
		super()
		setupCommands()
	}

	new(IProject project, BuilderMarkerUpdater markerUpdater) {
		super(project, markerUpdater)
		setupConfig(project)
		setupCommands()
	} 
	
	new(IProject project, BuilderMarkerUpdater markerUpdater, BuilderExecutor executor) {
		super(project, markerUpdater, executor)
		setupConfig(project)
		setupCommands()
	}
	
	def setupCommands() {
		cleanCmdLine = newArrayList("rm", "-rf", "do3/erlang/")
		fullCmdLine = newArrayList("make", "beam")
		singleCmdLine = newArrayList("make", "-W", "$file")
	}
	
	def setupConfig(IProject project) {
		if(project.location.toPortableString.startsWith("/vobs/gsn")) {
			workingDir = project.linkedContent?.location
			println("WD="+workingDir)
		}
	}
	
}