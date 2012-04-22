package org.erlide.project.model;

import java.util.Collection;

import org.eclipse.core.resources.IProject;

public interface IErlangProject extends IErlangModelElement {

    Collection<IErlangProject> getReferencedProjects();

    Collection<IProjectFragment> getSourceFragments();

    Collection<IProjectFragment> getBinaryFragments();

    IProject getWorkspaceProject();

} // IErlangProject
