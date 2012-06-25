package org.erlide.project.model.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IProjectFragment;

@SuppressWarnings("all")
public class ProjectFragment extends ErlangModelElement implements
        IProjectFragment {
    private final IErlangProject project;

    private final String name;

    protected Set<ICodeFolder> sourceFolders;

    protected Set<ICodeFolder> includeFolders;

    protected IPath docPath;

    protected IPath privPath;

    public ProjectFragment(final IErlangProject project, final String name) {
        super();
        this.project = project;
        this.name = name;
        final HashSet<ICodeFolder> _newHashSet = CollectionLiterals
                .<ICodeFolder> newHashSet();
        sourceFolders = _newHashSet;
        final HashSet<ICodeFolder> _newHashSet_1 = CollectionLiterals
                .<ICodeFolder> newHashSet();
        includeFolders = _newHashSet_1;
    }

    public Collection<ICodeFolder> getSourceFolders() {
        return Collections.<ICodeFolder> unmodifiableCollection(sourceFolders);
    }

    public Collection<ICodeFolder> getIncludeFolders() {
        return Collections.<ICodeFolder> unmodifiableCollection(includeFolders);
    }

    public String getName() {
        return name;
    }

    public IErlangModelElement getParent() {
        return project;
    }

    public void addSourceFolder(final ICodeFolder folder) {
        sourceFolders.add(folder);
    }

    public boolean removeSourceFolder(final ICodeFolder folder) {
        final boolean _remove = sourceFolders.remove(folder);
        return _remove;
    }

    public void addIncludeFolder(final ICodeFolder folder) {
        sourceFolders.add(folder);
    }

    public boolean removeIncludeFolder(final ICodeFolder folder) {
        final boolean _remove = sourceFolders.remove(folder);
        return _remove;
    }

    public void setDocPath(final IPath path) {
        docPath = path;
    }

    public void setPrivPath(final IPath path) {
        privPath = path;
    }

    public IResource getResource() {
        return null;
    }

    public void realize() {
        final Procedure1<ICodeFolder> _function = new Procedure1<ICodeFolder>() {
            public void apply(final ICodeFolder it) {
                it.realize();
            }
        };
        IterableExtensions.<ICodeFolder> forEach(sourceFolders, _function);
        final Procedure1<ICodeFolder> _function_1 = new Procedure1<ICodeFolder>() {
            public void apply(final ICodeFolder it) {
                it.realize();
            }
        };
        IterableExtensions.<ICodeFolder> forEach(includeFolders, _function_1);
        ErlangModelFactory.createFolder(docPath);
        ErlangModelFactory.createFolder(privPath);
    }
}
