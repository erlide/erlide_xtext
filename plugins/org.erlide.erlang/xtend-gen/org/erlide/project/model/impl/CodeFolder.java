package org.erlide.project.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IProjectFragment;

import com.google.common.base.Objects;

@SuppressWarnings("all")
public class CodeFolder extends ErlangModelElement implements ICodeFolder {
    private List<ICodeUnit> sourceUnits;

    private IFolder folder = null;

    private IPath path = null;

    private IPath outputPath = null;

    private IProjectFragment fragment;

    public CodeFolder(final IPath aPath) {
        super();
        path = aPath;
    }

    public List<ICodeUnit> getCodeUnits() {
        final boolean _equals = Objects.equal(sourceUnits, null);
        if (_equals) {
            final ArrayList<ICodeUnit> _newArrayList = CollectionLiterals
                    .<ICodeUnit> newArrayList();
            sourceUnits = _newArrayList;
        }
        return sourceUnits;
    }

    public IPath getPath() {
        return path;
    }

    public IFolder getFolder() {
        return folder;
    }

    public IPath setFolder(final IFolder folder) {
        IPath _xblockexpression = null;
        {
            this.folder = folder;
            final IPath _projectRelativePath = folder.getProjectRelativePath();
            final IPath _path = path = _projectRelativePath;
            _xblockexpression = _path;
        }
        return _xblockexpression;
    }

    public IPath getOutputPath() {
        return outputPath;
    }

    public IPath setOutputPath(final IPath newOutputPath) {
        final IPath _outputPath = outputPath = newOutputPath;
        return _outputPath;
    }

    public String toString() {
        final StringConcatenation _builder = new StringConcatenation();
        final String _string = super.toString();
        _builder.append(_string, "");
        _builder.append(" (folder: ");
        final IPath _projectRelativePath = folder.getProjectRelativePath();
        _builder.append(_projectRelativePath, "");
        _builder.append(", outputPath: ");
        _builder.append(outputPath, "");
        _builder.append(")");
        final String _string_1 = _builder.toString();
        return _string_1;
    }

    public String getName() {
        return folder == null ? (String) null : folder.getName();
    }

    public IErlangModelElement getParent() {
        return fragment;
    }

    public IResource getResource() {
        return folder;
    }

    public void realize() {
        ErlangModelFactory.createFolder(path);
        final Procedure1<ICodeUnit> _function = new Procedure1<ICodeUnit>() {
            public void apply(final ICodeUnit it) {
                it.realize();
            }
        };
        IterableExtensions.<ICodeUnit> forEach(sourceUnits, _function);
        ErlangModelFactory.createFolder(outputPath);
    }
}
