package org.erlide.common.util

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.SubProgressMonitor

class ProgressMonitorExtensions {
	
	def with(IProgressMonitor monitor, String task, int ticks, (IProgressMonitor)=>void code) {
		try {
			monitor.beginTask(task, ticks)
			code.apply(monitor)
		} finally {
			monitor.done
		}
	}
	
	def withSub(IProgressMonitor monitor, int ticks, (IProgressMonitor)=>void code) {
		code.apply(new SubProgressMonitor(monitor, ticks))
	}
	
}