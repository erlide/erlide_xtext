package org.erlide.builder;

import java.util.Map;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

@SuppressWarnings("all")
public class MakeBuilder extends IncrementalProjectBuilder {
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor monitor) throws CoreException {
    IProject _project = this.getProject();
    final IPath projdir = _project.getLocation();
    return null;
  }
}
