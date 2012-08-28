package org.erlide.project.buildpath;

public interface IBuildpathEntry {

    String getName();

    IBuildpathContainer getParent();

    void setParent(IBuildpathContainer parent);

    BuildpathAttributes getAttributes();

}
