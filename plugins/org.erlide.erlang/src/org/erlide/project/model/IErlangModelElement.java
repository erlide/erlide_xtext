package org.erlide.project.model;

import org.eclipse.core.resources.IResource;

public interface IErlangModelElement {

    String getName();

    IErlangModelElement getParent();

    IErlangProject getProject();

    IErlangModel getModel();

    IResource getResource();

} // IErlModelElement
