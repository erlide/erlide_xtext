package org.erlide.project.model;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;

public interface IErlangModelElement {

    String getName();

    IErlangModelElement getParent();

    IErlangProject getProject();

    IErlangModel getModel();

    IResource getResource();

    /**
     * Specifies default path to put beam files created from sources in this
     * element. If null, use parent's value.
     * 
     * @return the path to the ebin folder
     */
    IPath getOutputPath();

} // IErlModelElement
