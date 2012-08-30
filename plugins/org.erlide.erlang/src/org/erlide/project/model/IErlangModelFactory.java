package org.erlide.project.model;

import org.eclipse.core.resources.IProject;

/**
 * The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model.
 */
public interface IErlangModelFactory {

    IErlangModel getModel();

    IErlangProject createErlangProject(IProject workspaceProject);

    ICodeUnit createCodeUnit(IErlangProject folder, String name);

    IBinaryCodeUnit createBinaryCodeUnit(IErlangProject folder, String name);

} // IErlModelFactory
