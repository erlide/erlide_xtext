package org.erlide.builder

import org.eclipse.core.runtime.ProgressMonitorWrapper
import org.eclipse.core.runtime.IProgressMonitor

class BuilderProgressMonitorWrapper extends ProgressMonitorWrapper {
	val String taskName
	
	new(IProgressMonitor monitor, String taskName) {
		super(monitor)
		this.taskName = taskName
	}
	
	override void subTask(String name) {
		super.subTask(taskName + name);
	}
}
