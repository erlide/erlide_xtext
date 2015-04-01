/*******************************************************************************
 * Copyright (c) 2004 Eric Merritt and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Vlad Dumitrescu
 *******************************************************************************/

package org.erlide.project.buildpath.convert;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;

import com.ericsson.otp.erlang.RuntimeVersion;
import com.google.common.collect.Lists;

public final class OldErlangProjectProperties {

    private static final String ERLANG_CORE_PLUGIN_ID = "org.erlide.core";

    private IProject project;

    private Collection<IPath> sourceDirs = PathSerializer
            .unpackList(ProjectPreferencesConstants.DEFAULT_SOURCE_DIRS);
    private Collection<IPath> outputDirs = PathSerializer
            .unpackList(ProjectPreferencesConstants.DEFAULT_OUTPUT_DIR);
    private Collection<IPath> includeDirs = PathSerializer
            .unpackList(ProjectPreferencesConstants.DEFAULT_INCLUDE_DIRS);
    private String externalIncludesFile = ProjectPreferencesConstants.DEFAULT_EXTERNAL_INCLUDES;
    private String externalModulesFile = ProjectPreferencesConstants.DEFAULT_EXTERNAL_MODULES;
    private RuntimeVersion runtimeVersion = new RuntimeVersion(
            ProjectPreferencesConstants.DEFAULT_RUNTIME_VERSION);
    private boolean nukeOutputOnClean = false;

    public OldErlangProjectProperties() {
    }

    public OldErlangProjectProperties(final IProject prj) {
        super();
        project = prj;
        final IEclipsePreferences root = new ProjectScope(project)
        .getNode(ERLANG_CORE_PLUGIN_ID);
        // TODO load() should not be in constructor!
        load(root);
    }

    private void load(final IEclipsePreferences node) {
        if (project == null) {
            return;
        }

        final String sourceDirsStr = node.get(
                ProjectPreferencesConstants.SOURCE_DIRS,
                ProjectPreferencesConstants.DEFAULT_SOURCE_DIRS);
        sourceDirs = PathSerializer.unpackList(sourceDirsStr);
        final String includeDirsStr = node.get(
                ProjectPreferencesConstants.INCLUDE_DIRS,
                ProjectPreferencesConstants.DEFAULT_INCLUDE_DIRS);
        includeDirs = PathSerializer.unpackList(includeDirsStr);
        final String outputDirsStr = node.get(
                ProjectPreferencesConstants.OUTPUT_DIR,
                ProjectPreferencesConstants.DEFAULT_OUTPUT_DIR);
        outputDirs = PathSerializer.unpackList(outputDirsStr);
        runtimeVersion = new RuntimeVersion(node.get(
                ProjectPreferencesConstants.RUNTIME_VERSION, null));
        externalModulesFile = node.get(
                ProjectPreferencesConstants.PROJECT_EXTERNAL_MODULES,
                ProjectPreferencesConstants.DEFAULT_EXTERNAL_MODULES);
        externalIncludesFile = node.get(
                ProjectPreferencesConstants.EXTERNAL_INCLUDES,
                ProjectPreferencesConstants.DEFAULT_EXTERNAL_INCLUDES);
        setNukeOutputOnClean(node.getBoolean(
                ProjectPreferencesConstants.NUKE_OUTPUT_ON_CLEAN, false));
    }

    public Collection<IPath> getIncludeDirs() {
        return Collections.unmodifiableCollection(includeDirs);
    }

    public void setIncludeDirs(final Collection<IPath> includeDirs2) {
        includeDirs = Lists.newArrayList(includeDirs2);
    }

    @Deprecated
    public IPath getOutputDir() {
        try {
            return outputDirs.iterator().next();
        } catch (final Exception e) {
            return null;
        }
    }

    public Collection<IPath> getOutputDirs() {
        return outputDirs;
    }

    @Deprecated
    public void setOutputDir(final IPath dir) {
        setOutputDirs(Lists.newArrayList(dir));
    }

    public void setOutputDirs(final Collection<IPath> dirs) {
        outputDirs = Lists.newArrayList(dirs);
    }

    public Collection<IPath> getSourceDirs() {
        return Collections.unmodifiableCollection(sourceDirs);
    }

    public void setSourceDirs(final Collection<IPath> sourceDirs2) {
        sourceDirs = Lists.newArrayList(sourceDirs2);
    }

    public String getExternalIncludesFile() {
        return externalIncludesFile;
    }

    public void setExternalIncludesFile(final String file) {
        externalIncludesFile = file;
    }

    public void setExternalModulesFile(final String externalModules) {
        externalModulesFile = externalModules;
    }

    public String getExternalModulesFile() {
        return externalModulesFile;
    }

    public RuntimeVersion getRuntimeVersion() {
        return runtimeVersion;
    }

    public void preferenceChange(final PreferenceChangeEvent event) {
        final IEclipsePreferences root = new ProjectScope(project)
        .getNode(ERLANG_CORE_PLUGIN_ID);
        load(root);
    }

    public void setRuntimeVersion(final RuntimeVersion runtimeVersion) {
        this.runtimeVersion = runtimeVersion;
    }

    public boolean isNukeOutputOnClean() {
        return nukeOutputOnClean;
    }

    public void setNukeOutputOnClean(final boolean nukeOutputOnClean) {
        this.nukeOutputOnClean = nukeOutputOnClean;
    }

}
