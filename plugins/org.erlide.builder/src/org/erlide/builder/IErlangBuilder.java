package org.erlide.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IErlangBuilder {

    String getId();

    void setProject(IProject project);

    void loadConfiguration();

    void clean(IProgressMonitor monitor) throws CoreException;

    void fullBuild(IProgressMonitor monitor) throws CoreException;

    void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor)
            throws CoreException;

}
