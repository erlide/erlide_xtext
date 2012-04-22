package org.erlide.project.model;

public interface IErlangModelElement {

    String getName();

    IErlangModelElement getParent();

    IErlangProject getProject();

    IErlangModel getModel();

} // IErlModelElement
