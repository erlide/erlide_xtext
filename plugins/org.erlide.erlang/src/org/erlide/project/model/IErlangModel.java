package org.erlide.project.model;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.google.inject.Singleton;

@Singleton
public interface IErlangModel extends IErlangModelElement {

    @NonNull
    IWorkspace getWorkspace();

    @NonNull
    Collection<IErlangProject> getProjects();

    @Nullable
    IErlangProject getErlangProject(IProject project);

} // IErlangModel
