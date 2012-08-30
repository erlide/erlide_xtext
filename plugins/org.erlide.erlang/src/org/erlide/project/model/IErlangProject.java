package org.erlide.project.model;

import java.util.Collection;

import org.eclipse.core.resources.IProject;

public interface IErlangProject extends IErlangModelElement {

    IProject getWorkspaceProject();

    Collection<ICodeUnit> getUnits();

} // IErlangProject
