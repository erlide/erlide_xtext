package org.erlide.project.model;

import java.util.Collection;

import org.erlide.project.buildpath.BuildpathLibrary;

public interface IProjectFragment extends IErlangModelElement {

    BuildpathLibrary getBuildpathEntry();

    public enum ContentKind {
        SOURCE, STATIC
    }

    ContentKind getContentKind();

    Collection<ICodeFolder> getFolders();

} // IProjectFragment
