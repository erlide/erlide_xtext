package org.erlide.project.model;

import java.util.Collection;

import org.eclipse.core.resources.IFolder;

public interface IProjectFragment extends IErlangModelElement {

    Collection<IProjectFragment> getFragments();

    public enum ContentKind {
        SOURCE, STATIC
    }

    ContentKind getContentKind();

    Collection<ICodeFolder> getSourceFolders();

    Collection<ICodeFolder> getIncludeFolders();

    Collection<ICodeFolder> getDocFolders();

    Collection<ICodeFolder> getTestFolders();

    Collection<IFolder> getPrivateFolders();

} // IProjectFragment
