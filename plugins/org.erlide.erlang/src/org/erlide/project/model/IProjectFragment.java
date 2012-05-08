package org.erlide.project.model;

import java.util.Collection;

public interface IProjectFragment extends IErlangModelElement {

    Collection<ICodeFolder> getSourceFolders();

    Collection<ICodeFolder> getIncludeFolders();

} // IProjectFragment
