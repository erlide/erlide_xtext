package org.erlide.project.model.impl;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.erlide.project.model.IBinaryCodeUnit;
import org.erlide.project.model.ICodeFolder;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelFactory;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IExternalErlangProject;
import org.erlide.project.model.IProjectFragment;

@SuppressWarnings("all")
public class ErlangModelFactory implements IErlangModelFactory {
    private final ErlangModel erlModel;
    private static IErlangModelFactory instance;

    private ErlangModelFactory() {
        final IWorkspace _workspace = ResourcesPlugin.getWorkspace();
        final ErlangModel _erlangModel = new ErlangModel(_workspace);
        this.erlModel = _erlangModel;
    }

    public static IErlangModelFactory getInstance() {
        if (instance == null) {
            instance = new ErlangModelFactory();
        }
        return instance;
    }

    public IErlangModel getModel() {
        return this.erlModel;
    }

    public IErlangProject createErlangProject(final IProject workspaceProject) {
        final ErlangProject _erlangProject = new ErlangProject(this.erlModel,
                workspaceProject);
        return _erlangProject;
    }

    public IExternalErlangProject createExternalErlangProject() {
        final ExternalErlangProject _externalErlangProject = new ExternalErlangProject(
                this.erlModel);
        return _externalErlangProject;
    }

    public ICodeFolder createCodeFolder(final IProjectFragment project,
            final IPath path) {
        final CodeFolder _codeFolder = new CodeFolder(path);
        return _codeFolder;
    }

    public IProjectFragment createErlangProjectFragment(
            final IErlangProject project, final String name) {
        final GenericProjectFragment _genericProjectFragment = new GenericProjectFragment(
                project, name);
        return _genericProjectFragment;
    }

    public IProjectFragment createBterlProjectFragment(
            final IErlangProject project, final String name,
            final IProjectFragment parent) {
        final BterlProjectFragment _bterlProjectFragment = new BterlProjectFragment(
                project, name, parent);
        return _bterlProjectFragment;
    }

    public ICodeUnit createCodeUnit(final ICodeFolder folder, final String name) {
        final CodeUnit _codeUnit = new CodeUnit(folder, name);
        return _codeUnit;
    }

    public IBinaryCodeUnit createBinaryCodeUnit(final ICodeFolder folder,
            final String name) {
        final BinaryCodeUnit _binaryCodeUnit = new BinaryCodeUnit(folder, name);
        return _binaryCodeUnit;
    }

    public static void createFolder(final IPath fullPath) {
        final boolean _equals = ObjectExtensions
                .operator_equals(fullPath, null);
        if (_equals) {
            return;
        }
        try {
            final String _string = fullPath.toString();
            final File _file = new File(_string);
            final File f = _file;
            f.mkdirs();
        } catch (final Throwable _t) {
            if (_t instanceof Exception) {
                final Exception e = (Exception) _t;
                final String _string_1 = fullPath.toString();
                final String _plus = StringExtensions.operator_plus(
                        "could not create folder ", _string_1);
                InputOutput.<String> println(_plus);
            } else {
                throw Exceptions.sneakyThrow(_t);
            }
        }
    }

    public static void createFile(final IPath fullPath) {
        final boolean _equals = ObjectExtensions
                .operator_equals(fullPath, null);
        if (_equals) {
            return;
        }
        try {
            final String _string = fullPath.toString();
            final File _file = new File(_string);
            final File f = _file;
            f.createNewFile();
        } catch (final Throwable _t) {
            if (_t instanceof Exception) {
                final Exception e = (Exception) _t;
                final String _string_1 = fullPath.toString();
                final String _plus = StringExtensions.operator_plus(
                        "could not create file ", _string_1);
                InputOutput.<String> println(_plus);
            } else {
                throw Exceptions.sneakyThrow(_t);
            }
        }
    }
}
