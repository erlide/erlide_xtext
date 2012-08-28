package org.erlide.project.model;

import java.util.Collection;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;

public interface ICodeFolder extends IErlangModelElement {

    Collection<ICodeUnit> getCodeUnits();

    IFolder getFolder();

    IPath getPath();

} // ICodeFolder
