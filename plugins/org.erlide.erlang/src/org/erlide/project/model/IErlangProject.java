package org.erlide.project.model;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.erlide.project.buildpath.BuildpathEntry;

public interface IErlangProject extends IErlangModelElement {

    IProject getWorkspaceProject();

    BuildpathEntry getBuildpath();

    Collection<ICodeUnit> getUnits();

} // IErlangProject
