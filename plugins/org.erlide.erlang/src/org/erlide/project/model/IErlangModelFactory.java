package org.erlide.project.model;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

/**
 * The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model.
 */
public interface IErlangModelFactory {

    IErlangModel getModel();

    IErlangProject createErlangProject(IProject workspaceProject);

    IProjectFragment createErlangProjectFragment(IErlangProject project,
            String name);

    IProjectFragment createBterlProjectFragment(IErlangProject project,
            String name, IProjectFragment parent);

    ICodeFolder createCodeFolder(IProjectFragment project, IPath path);

    ICodeUnit createCodeUnit(ICodeFolder folder, String name);

    IBinaryCodeUnit createBinaryCodeUnit(ICodeFolder folder, String name);

} // IErlModelFactory
