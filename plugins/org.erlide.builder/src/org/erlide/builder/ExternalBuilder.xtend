package org.erlide.builder

import java.util.List
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor

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
	
	def protected execute(List<String> cmds, IProgressMonitor monitor) {
		println("EXEC '"+cmds+"' in "+project.name)
		val List<CompilerProblem> result = newArrayList()
        executor.executeProcess(cmds, 
            "/vobs/gsn/product/code/sgsn-w/ups",//project.location.toPortableString(), 
            monitor, new DefaultLineParser()) [
            	problem | result.add(problem)
            ]
        return result
	}
	
}