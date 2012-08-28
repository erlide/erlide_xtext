package org.erlide.project.buildpath;

import java.util.Collection;

public interface IBuildpathContainer extends IBuildpathEntry {

    public enum ContainerKind {
        ROOT, FRAGMENT, LIBRARY, OTP;
    }

    Collection<IBuildpathEntry> getChildren();

    ContainerKind getKind();

    void addChild(IBuildpathEntry entry);

    void removeChild(IBuildpathEntry entry);

}
