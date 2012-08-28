package org.erlide.project.model;

import java.util.Collection;

public interface ILibrary extends IErlangModelElement {

    Collection<IProjectFragment> getFragments();

    Collection<ILibrary> getLibraries();

}
