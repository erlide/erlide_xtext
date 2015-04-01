package org.erlide.builder;

import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.erlide.builder.AbstractErlangBuilder;

@SuppressWarnings("all")
public class ResourceBuilder extends AbstractErlangBuilder {
  @Override
  public void clean(final IProgressMonitor monitor) throws CoreException {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  @Override
  public void fullBuild(final IProgressMonitor monitor) throws CoreException {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  @Override
  public void incrementalBuild(final IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
}
