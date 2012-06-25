package org.erlide.project.model.impl;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IProjectFragment;

@SuppressWarnings("all")
public class ModelResourceListener implements IResourceChangeListener {
    private final IErlangModel model;

    public ModelResourceListener(final IErlangModel model) {
        this.model = model;
        final IWorkspace _workspace = ResourcesPlugin.getWorkspace();
        _workspace.addResourceChangeListener(this);
    }

    public void dispose() {
        final IWorkspace _workspace = ResourcesPlugin.getWorkspace();
        _workspace.removeResourceChangeListener(this);
    }

    public void resourceChanged(final IResourceChangeEvent event) {
        updateModel(model, event);
    }

    protected void _updateModel(final IErlangModel model,
            final IResourceChangeEvent event) {
        final Collection<IErlangProject> _projects = model.getProjects();
        final Procedure1<IErlangProject> _function = new Procedure1<IErlangProject>() {
            public void apply(final IErlangProject it) {
                ModelResourceListener.this.updateModel(it, event);
            }
        };
        IterableExtensions.<IErlangProject> forEach(_projects, _function);
    }

    protected void _updateModel(final IErlangProject project,
            final IResourceChangeEvent event) {
        final Collection<IProjectFragment> _sourceFragments = project
                .getSourceFragments();
        final Procedure1<IProjectFragment> _function = new Procedure1<IProjectFragment>() {
            public void apply(final IProjectFragment it) {
                ModelResourceListener.this.updateModel(it, event);
            }
        };
        IterableExtensions.<IProjectFragment> forEach(_sourceFragments,
                _function);
        final Collection<IProjectFragment> _binaryFragments = project
                .getBinaryFragments();
        final Procedure1<IProjectFragment> _function_1 = new Procedure1<IProjectFragment>() {
            public void apply(final IProjectFragment it) {
                ModelResourceListener.this.updateModel(it, event);
            }
        };
        IterableExtensions.<IProjectFragment> forEach(_binaryFragments,
                _function_1);
    }

    protected void _updateModel(final IProjectFragment fragment,
            final IResourceChangeEvent event) {
        final Collection<ICodeFolder> _sourceFolders = fragment
                .getSourceFolders();
        final Procedure1<ICodeFolder> _function = new Procedure1<ICodeFolder>() {
            public void apply(final ICodeFolder it) {
                ModelResourceListener.this.updateModel(it, event);
            }
        };
        IterableExtensions.<ICodeFolder> forEach(_sourceFolders, _function);
        final Collection<ICodeFolder> _includeFolders = fragment
                .getIncludeFolders();
        final Procedure1<ICodeFolder> _function_1 = new Procedure1<ICodeFolder>() {
            public void apply(final ICodeFolder it) {
                ModelResourceListener.this.updateModel(it, event);
            }
        };
        IterableExtensions.<ICodeFolder> forEach(_includeFolders, _function_1);
    }

    protected void _updateModel(final ICodeFolder folder,
            final IResourceChangeEvent event) {
        final Collection<ICodeUnit> _codeUnits = folder.getCodeUnits();
        final Procedure1<ICodeUnit> _function = new Procedure1<ICodeUnit>() {
            public void apply(final ICodeUnit it) {
                ModelResourceListener.this.updateModel(it, event);
            }
        };
        IterableExtensions.<ICodeUnit> forEach(_codeUnits, _function);
    }

    protected void _updateModel(final ICodeUnit unit,
            final IResourceChangeEvent event) {
    }

    public void updateModel(final IErlangModelElement folder,
            final IResourceChangeEvent event) {
        if (folder instanceof ICodeFolder) {
            _updateModel((ICodeFolder) folder, event);
            return;
        } else if (folder instanceof ICodeUnit) {
            _updateModel((ICodeUnit) folder, event);
            return;
        } else if (folder instanceof IErlangModel) {
            _updateModel((IErlangModel) folder, event);
            return;
        } else if (folder instanceof IErlangProject) {
            _updateModel((IErlangProject) folder, event);
            return;
        } else if (folder instanceof IProjectFragment) {
            _updateModel((IProjectFragment) folder, event);
            return;
        } else {
            throw new IllegalArgumentException("Unhandled parameter types: "
                    + Arrays.<Object> asList(folder, event).toString());
        }
    }
}
