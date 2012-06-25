package org.erlide.project.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.common.util.ErlLogger;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IProjectFragment;

import com.google.common.base.Objects;

@SuppressWarnings("all")
public class ErlangProject extends ErlangModelElement implements IErlangProject {
    private final IErlangModel model;

    private final List<IErlangProject> referencedProjects;

    private final List<IProjectFragment> sourceFragments;

    private final List<IProjectFragment> binaryFragments;

    private final IProject workspaceProject;

    public ErlangProject(final IErlangModel model, final IProject project) {
        super();
        this.model = model;
        final ArrayList<IErlangProject> _newArrayList = CollectionLiterals
                .<IErlangProject> newArrayList();
        referencedProjects = _newArrayList;
        final ArrayList<IProjectFragment> _newArrayList_1 = CollectionLiterals
                .<IProjectFragment> newArrayList();
        sourceFragments = _newArrayList_1;
        final ArrayList<IProjectFragment> _newArrayList_2 = CollectionLiterals
                .<IProjectFragment> newArrayList();
        binaryFragments = _newArrayList_2;
        workspaceProject = project;
    }

    public List<IErlangProject> getReferencedProjects() {
        return referencedProjects;
    }

    public Collection<IProjectFragment> getSourceFragments() {
        return Collections
                .<IProjectFragment> unmodifiableCollection(sourceFragments);
    }

    public Collection<IProjectFragment> getBinaryFragments() {
        return Collections
                .<IProjectFragment> unmodifiableCollection(binaryFragments);
    }

    public IProject getWorkspaceProject() {
        return workspaceProject;
    }

    public String toString() {
        final String _string = super.toString();
        final StringBuffer _stringBuffer = new StringBuffer(_string);
        final StringBuffer result = _stringBuffer;
        result.append(" (workspaceProject: ");
        result.append(workspaceProject);
        result.append(")");
        return result.toString();
    }

    public String getName() {
        return workspaceProject.getName();
    }

    public IErlangModelElement getParent() {
        return model;
    }

    public IResource getResource() {
        return workspaceProject;
    }

    public void realize() {
        final boolean _notEquals = !Objects.equal(workspaceProject, null);
        if (_notEquals) {
            final String _name = getName();
            ErlLogger.error("Workspace project must exist for %s", _name);
        }
        final Procedure1<IProjectFragment> _function = new Procedure1<IProjectFragment>() {
            public void apply(final IProjectFragment it) {
                it.realize();
            }
        };
        IterableExtensions.<IProjectFragment> forEach(sourceFragments,
                _function);
    }
}
