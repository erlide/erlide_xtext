package org.erlide.project.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;

import com.google.common.base.Objects;

@SuppressWarnings("all")
public class ErlangModel extends ErlangModelElement implements IErlangModel {
    private final IWorkspace workspace;

    private final List<IErlangProject> projects;

    public ErlangModel(final IWorkspace workspace) {
        super();
        this.workspace = workspace;
        final ArrayList<IErlangProject> _newArrayList = CollectionLiterals
                .<IErlangProject> newArrayList();
        projects = _newArrayList;
    }

    public Collection<IErlangProject> getProjects() {
        return Collections.<IErlangProject> unmodifiableCollection(projects);
    }

    public IErlangProject getErlangProject(final IProject project) {
        for (final IErlangProject prj : projects) {
            final IProject _workspaceProject = prj.getWorkspaceProject();
            final boolean _equals = Objects.equal(_workspaceProject, project);
            if (_equals) {
                return prj;
            }
        }
        return null;
    }

    public IWorkspace getWorkspace() {
        return workspace;
    }

    public String getName() {
        return "Erlang model";
    }

    public IErlangModelElement getParent() {
        return null;
    }
}
