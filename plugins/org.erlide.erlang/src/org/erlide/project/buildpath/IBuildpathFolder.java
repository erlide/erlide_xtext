package org.erlide.project.buildpath;

import java.util.Collection;

import org.eclipse.core.runtime.IPath;

public interface IBuildpathFolder extends IBuildpathEntry {

    public enum FolderKind {
        SOURCE, INCLUDE, EBIN, DOC, TEST, PRIV;
    }

    IPath getPath();

    FolderKind getKind();

    Collection<IPath> getInclusionPatterns();

    Collection<IPath> getExclusionPatterns();

}
