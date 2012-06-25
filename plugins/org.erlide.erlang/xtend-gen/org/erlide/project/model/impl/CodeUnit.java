package org.erlide.project.model.impl;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.common.util.ErlLogger;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModelElement;

import com.google.common.base.Objects;

@SuppressWarnings("all")
public class CodeUnit extends ErlangModelElement implements ICodeUnit {
    private final ICodeFolder folder;

    private final String name;

    private IFile file;

    public CodeUnit(final ICodeFolder folder, final String name) {
        this.folder = folder;
        this.name = name;
    }

    public IPath getPath() {
        final IFolder _folder = folder.getFolder();
        final IPath _projectRelativePath = _folder.getProjectRelativePath();
        return _projectRelativePath.append(name);
    }

    public String getName() {
        return name;
    }

    public IErlangModelElement getParent() {
        return folder;
    }

    public IResource getResource() {
        final boolean _equals = Objects.equal(file, null);
        if (_equals) {
            final IWorkspace _workspace = ResourcesPlugin.getWorkspace();
            final IWorkspaceRoot _root = _workspace.getRoot();
            final IPath _path = getPath();
            final List<IFile> possibleFiles = (List<IFile>) Conversions
                    .doWrapArray(_root.findFilesForLocation(_path));
            final int _size = possibleFiles.size();
            final boolean _equals_1 = _size == 1;
            if (_equals_1) {
                final IFile _head = IterableExtensions
                        .<IFile> head(possibleFiles);
                file = _head;
            }
            final IPath _path_1 = getPath();
            ErlLogger.warn("not able to find file %s", _path_1);
        }
        return file;
    }

    public void realize() {
        final IPath _path = getPath();
        ErlangModelFactory.createFile(_path);
    }
}
