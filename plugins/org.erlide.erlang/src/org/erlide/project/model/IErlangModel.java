package org.erlide.project.model;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;

import com.google.inject.Singleton;

@Singleton
public interface IErlangModel extends IErlangModelElement {

    IWorkspace getWorkspace();

    Collection<IErlangProject> getProjects();

    IErlangProject getErlangProject(IProject project);

} // IErlangModel
