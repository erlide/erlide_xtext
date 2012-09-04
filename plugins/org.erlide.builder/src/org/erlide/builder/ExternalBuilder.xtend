package org.erlide.builder

import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.resources.IProject
import org.erlide.builder.BuilderMarkerUpdater
import java.util.List

abstract class ExternalBuilder extends AbstractErlangBuilder {

	BuilderExecutor executor

	new() {
		super()
		this.executor = new BuilderExecutor()
	}

	new(IProject project, BuilderMarkerUpdater markerUpdater) {
		super(project, markerUpdater)
		this.executor = new BuilderExecutor()
	}
	
	new(IProject project, BuilderMarkerUpdater markerUpdater, BuilderExecutor executor) {
		super(project, markerUpdater)
		this.executor = executor
	}
	
	override incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		fullBuild(monitor)
	}

	def protected execute(List<String> cmds) {
		println("run '"+cmds+"' in "+project.name)
		val List<CompilerProblem> result = newArrayList()
        executor.executeProcess(cmds, 
            "/vobs/gsn/product/code/sgsn-w/ups",//project.location.toPortableString(), 
            new DefaultLineParser()) [
            	problem | result.add(problem)
            ]
        return result
	}
	
}