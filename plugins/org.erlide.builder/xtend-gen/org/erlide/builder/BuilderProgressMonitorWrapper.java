package org.erlide.builder;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ProgressMonitorWrapper;

@SuppressWarnings("all")
public class BuilderProgressMonitorWrapper extends ProgressMonitorWrapper {
  private final String taskName;
  
  public BuilderProgressMonitorWrapper(final IProgressMonitor monitor, final String taskName) {
    super(monitor);
    this.taskName = taskName;
  }
  
  public void subTask(final String name) {
    String _plus = (this.taskName + name);
    super.subTask(_plus);
  }
}
