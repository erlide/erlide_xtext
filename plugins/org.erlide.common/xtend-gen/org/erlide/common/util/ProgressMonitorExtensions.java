package org.erlide.common.util;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ProgressMonitorExtensions {
  public void with(final IProgressMonitor monitor, final String task, final int ticks, final Procedure1<? super IProgressMonitor> code) {
    try {
      monitor.beginTask(task, ticks);
      code.apply(monitor);
    } finally {
      monitor.done();
    }
  }
  
  public void withSub(final IProgressMonitor monitor, final int ticks, final Procedure1<? super IProgressMonitor> code) {
    SubProgressMonitor _subProgressMonitor = new SubProgressMonitor(monitor, ticks);
    code.apply(_subProgressMonitor);
  }
}
