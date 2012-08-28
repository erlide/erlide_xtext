/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.erlide.project.buildpath;

import java.util.Collection;

import org.eclipse.core.runtime.IPath;

import com.google.common.collect.Lists;

public class BuildpathUtils {

    /**
     * Name of the User Library Container id.
     */
    public static final String USER_LIBRARY_CONTAINER_ID = "org.erlide.USER_LIBRARY"; //$NON-NLS-1$
    private static final Collection<IPath> INCLUDE_ALL = Lists.newArrayList();
    private static final Collection<IPath> EXCLUDE_NONE = Lists.newArrayList();
    private static final BuildpathAttributes NO_EXTRA_ATTRIBUTES = new BuildpathAttributes();
    private static final BuildpathAttributes OPTIONAL_ATTRIBUTES = new BuildpathAttributes(
            "optional", "true");

    // /**
    // * Creates and returns a new buildpath entry of kind
    // <code>CPE_SOURCE</code>
    // * for the project's source folder identified by the given absolute
    // * workspace-relative path using the given inclusion and exclusion
    // patterns
    // * to determine which source files are included, and the given output path
    // * to control the output location of generated files.
    // * <p>
    // * The source folder is referred to using an absolute path relative to the
    // * workspace root, e.g. <code>/Project/src</code>. A project's source
    // * folders are located with that project. That is, a source buildpath
    // entry
    // * specifying the path <code>/P1/src</code> is only usable for project
    // * <code>P1</code>.
    // * </p>
    // * <p>
    // * The inclusion patterns determines the initial set of source files that
    // * are to be included; the exclusion patterns are then used to reduce this
    // * set. When no inclusion patterns are specified, the initial file set
    // * includes all relevent files in the resource tree rooted at the source
    // * entry's path. On the other hand, specifying one or more inclusion
    // * patterns means that all <b>and only</b> files matching at least one of
    // * the specified patterns are to be included. If exclusion patterns are
    // * specified, the initial set of files is then reduced by eliminating
    // files
    // * matched by at least one of the exclusion patterns. Inclusion and
    // * exclusion patterns look like relative file paths with wildcards and are
    // * interpreted relative to the source entry's path. File patterns are
    // * case-sensitive can contain '**', '*' or '?' wildcards (see
    // * {@link IBuildpathEntry#getExclusionPatterns()} for the full description
    // * of their syntax and semantics). The resulting set of files are included
    // * in the corresponding package fragment root; all package fragments
    // within
    // * the root will have children of type <code>ISourceModule</code>.
    // * </p>
    // * <p>
    // * For example, if the source folder path is <code>/Project/src</code>,
    // * there are no inclusion filters, and the exclusion pattern is
    // * <code>com/xyz/tests/&#42;&#42;</code>, then source files like
    // * <code>/Project/src/com/xyz/Foo.java</code> and
    // * <code>/Project/src/com/xyz/utils/Bar.java</code> would be included,
    // * whereas <code>/Project/src/com/xyz/tests/T1.java</code> and
    // * <code>/Project/src/com/xyz/tests/quick/T2.java</code> would be
    // excluded.
    // * </p>
    // * <p>
    // * Additionally, a source entry can be associated with a specific output
    // * location. By doing so, the script builder will ensure that the
    // generated
    // * ".class" files will be issued inside this output location, as opposed
    // to
    // * be generated into the project default output location (when output
    // * location is <code>null</code>). Note that multiple source entries may
    // * target the same output location. The output location is referred to
    // using
    // * an absolute path relative to the workspace root, e.g.
    // * <code>"/Project/bin"</code>, it must be located inside the same project
    // * as the source folder.
    // * </p>
    // * <p>
    // * Also note that all sources/binaries inside a project are contributed as
    // a
    // * whole through a project entry (see
    // * <code>BuildpathUtils.newProjectEntry</code> ). Particular source
    // entries
    // * cannot be selectively exported.
    // * </p>
    // * <p>
    // * The <code>extraAttributes</code> list contains name/value pairs that
    // must
    // * be persisted with this entry. If no extra attributes are provided, an
    // * empty array must be passed in.<br>
    // * Note that this list should not contain any duplicate name.
    // * </p>
    // *
    // * @param path
    // * the absolute workspace-relative path of a source folder
    // * @param inclusionPatterns
    // * the possibly empty list of inclusion patterns represented as
    // * relative paths
    // * @param exclusionPatterns
    // * the possibly empty list of exclusion patterns represented as
    // * relative paths
    // * @param specificOutputLocation
    // * the specific output location for this source entry (
    // * <code>null</code> if using project default ouput location)
    // * @param extraAttributes
    // * the possibly empty list of extra attributes to persist with
    // * this entry
    // * @return a new source buildpath entry with the given exclusion patterns
    // * @see IBuildpoathEntry#getInclusionPatterns()
    // * @see IBuildpoathEntry#getExclusionPatterns()
    // * @see IBuildpoathEntry#getOutputLocation()
    // *
    // */
    // public static IBuildpathEntry newSourceEntry(final IPath path,
    // final Collection<IPath> inclusionPatterns,
    // final Collection<IPath> exclusionPatterns,
    // final BuildpathAttributes extraAttributes) {
    //
    //        Assert.isNotNull(path, "Source path cannot be null"); //$NON-NLS-1$
    // if (!path.isAbsolute()) {
    //            Assert.isTrue(false, "Path for IBuildpathEntry must be absolute"); //$NON-NLS-1$
    // }
    // if (exclusionPatterns == null) {
    //            Assert.isTrue(false, "Exclusion pattern set cannot be null"); //$NON-NLS-1$
    // }
    // if (inclusionPatterns == null) {
    //            Assert.isTrue(false, "Inclusion pattern set cannot be null"); //$NON-NLS-1$
    // }
    //
    // return new BuildpathFolder(IProjectFragment.K_SOURCE,
    // IBuildpathEntry.BPE_SOURCE, path, false, inclusionPatterns,
    // exclusionPatterns, null, false, extraAttributes, false);
    // }
    //
    // /**
    // * Creates and returns a new buildpath entry of kind
    // * <code>CPE_PROJECT</code> for the project identified by the given
    // absolute
    // * path.
    // * <p>
    // * A project entry is used to denote a prerequisite project on a
    // buildpath.
    // * The referenced project will be contributed as a whole, either as
    // sources
    // * (in the script Model, it contributes all its package fragment roots) or
    // * as binaries (when building, it contributes its whole output location).
    // * </p>
    // * <p>
    // * A project reference allows to indirect through another project,
    // * independently from its internal layout.
    // * </p>
    // * <p>
    // * The prerequisite project is referred to using an absolute path relative
    // * to the workspace root.
    // * </p>
    // * <p>
    // * The access rules determine the set of accessible source files in the
    // * project. If the list of access rules is empty then all files in this
    // * project are accessible. See {@link IAccessRule} for a detailed
    // * description of access rules.
    // * </p>
    // * <p>
    // * The <code>combineAccessRules</code> flag indicates whether access rules
    // * of one (or more) exported entry of the project should be combined with
    // * the given access rules. If they should be combined, the given access
    // * rules are considered first, then the entry's access rules are
    // considered.
    // * </p>
    // * <p>
    // * The <code>extraAttributes</code> list contains name/value pairs that
    // must
    // * be persisted with this entry. If no extra attributes are provided, an
    // * empty array must be passed in.<br>
    // * Note that this list should not contain any duplicate name.
    // * </p>
    // * <p>
    // * The <code>isExported</code> flag indicates whether this entry is
    // * contributed to dependent projects. If not exported, dependent projects
    // * will not see any of the classes from this entry. If exported, dependent
    // * projects will concatenate the accessible files patterns of this entry
    // * with the accessible files patterns of the projects, and they will
    // * concatenate the non accessible files patterns of this entry with the
    // non
    // * accessible files patterns of the project.
    // * </p>
    // *
    // * @param path
    // * the absolute path of the prerequisite project
    // * @param accessRules
    // * the possibly empty list of access rules for this entry
    // * @param combineAccessRules
    // * whether the access rules of the project's exported entries
    // * should be combined with the given access rules
    // * @param extraAttributes
    // * the possibly empty list of extra attributes to persist with
    // * this entry
    // * @param isExported
    // * indicates whether this entry is contributed to dependent
    // * projects in addition to the output location
    // * @return a new project buildpath entry
    // *
    // */
    // public static IBuildpathEntry newProjectEntry(final IPath path,
    // final BuildpathAttributes extraAttributes, final boolean isExported) {
    //
    // if (!path.isAbsolute()) {
    //            Assert.isTrue(false, "Path for IBuildpathEntry must be absolute"); //$NON-NLS-1$
    // }
    //
    // return new BuildpathEntry(IProjectFragment.K_SOURCE,
    // IBuildpathEntry.BPE_PROJECT, path, isExported, INCLUDE_ALL, // inclusion
    // // patterns
    // EXCLUDE_NONE, // exclusion patterns
    // extraAttributes, false);
    // }
    //
    // /**
    // * Creates and returns a new buildpath entry of kind
    // * <code>CPE_CONTAINER</code> for the given path. This method is fully
    // * equivalent to calling {@link #newContainerEntry(IPath,
    // * Collection<IBuildpathAttribute>, boolean)
    // * newContainerEntry(containerPath, new IAccessRule[0], new
    // * IBuildpathAttribute[0], isExported)}.
    // *
    // * @param containerPath
    // * the path identifying the container, it must be formed of at
    // * least one segment (ID+hints)
    // * @param isExported
    // * a boolean indicating whether this entry is contributed to
    // * dependent projects in addition to the output location
    // * @return a new container buildpath entry
    // *
    // * @see BuildpathUtils#getBuildpathContainer(IPath, IErlangProject)
    // * @see BuildpathUtils#setBuildpathContainer(IPath, IErlangProject[],
    // * IBuildpathContainer[], IProgressMonitor)
    // *
    // */
    // public static IBuildpathEntry newContainerEntry(final IPath
    // containerPath,
    // final boolean isExported) {
    // return newContainerEntry(containerPath, NO_EXTRA_ATTRIBUTES, isExported);
    // }
    //
    // /**
    // * Creates and returns a new buildpath entry of kind
    // * <code>CPE_CONTAINER</code> for the given path. The path of the
    // container
    // * will be used during resolution so as to map this container entry to a
    // set
    // * of other buildpath entries the container is acting for.
    // * <p>
    // * A container entry allows to express indirect references to a set of
    // * libraries, projects and variable entries, which can be interpreted
    // * differently for each script project where it is used. A buildpath
    // * container entry can be resolved using
    // * <code>BuildpathUtils.getResolvedBuildpathContainer</code>, and updated
    // * with <code>BuildpathUtils.buildpathContainerChanged</code>
    // * <p>
    // * A container is exclusively resolved by a
    // * <code>BuildpathContainerInitializer</code> registered onto the
    // extension
    // * point "org.eclipse.dltk.core.buildpathContainerInitializer".
    // * <p>
    // * A container path must be formed of at least one segment, where:
    // * <ul>
    // * <li>the first segment is a unique ID identifying the target container,
    // * there must be a container initializer registered onto this ID through
    // the
    // * extension point
    // "org.eclipse.dltk.core.buildpathContainerInitializer".</li>
    // * <li>the remaining segments will be passed onto the initializer, and can
    // * be used as additional hints during the initialization phase.</li>
    // * </ul>
    // * The access rules determine the set of accessible source and source
    // files
    // * in the container. If the list of access rules is empty, then all files
    // in
    // * this container are accessible. See {@link IAccessRule} for a detailed
    // * description of access rules. Note that if an entry defined by the
    // * container defines access rules, then these access rules are combined
    // with
    // * the given access rules. The given access rules are considered first,
    // then
    // * the entry's access rules are considered.
    // * </p>
    // * <p>
    // * The <code>extraAttributes</code> list contains name/value pairs that
    // must
    // * be persisted with this entry. If no extra attributes are provided, an
    // * empty array must be passed in.<br>
    // * Note that this list should not contain any duplicate name.
    // * </p>
    // * <p>
    // * The <code>isExported</code> flag indicates whether this entry is
    // * contributed to dependent projects. If not exported, dependent projects
    // * will not see any of the classes from this entry. If exported, dependent
    // * projects will concatenate the accessible files patterns of this entry
    // * with the accessible files patterns of the projects, and they will
    // * concatenate the non accessible files patterns of this entry with the
    // non
    // * accessible files patterns of the project.
    // * </p>
    // * <p>
    // * Note that this operation does not attempt to validate buildpath
    // * containers or access the resources at the given paths.
    // * </p>
    // *
    // * @param containerPath
    // * the path identifying the container, it must be formed of at
    // * least one segment (ID+hints)
    // * @param accessRules
    // * the possibly empty list of access rules for this entry
    // * @param extraAttributes
    // * the possibly empty list of extra attributes to persist with
    // * this entry
    // * @param isExported
    // * a boolean indicating whether this entry is contributed to
    // * dependent projects in addition to the output location
    // * @return a new container buildpath entry
    // *
    // * @see BuildpathUtils#getBuildpathContainer(IPath, IErlangProject)
    // * @see BuildpathUtils#setBuildpathContainer(IPath, IErlangProject[],
    // * IBuildpathContainer[], IProgressMonitor)
    // * @see BuildpathUtils#newContainerEntry(IPath, boolean)
    // * @see BuildpathUtils#newAccessRule(IPath, int)
    // *
    // */
    // public static IBuildpathEntry newContainerEntry(final IPath
    // containerPath,
    // final BuildpathAttributes extraAttributes, final boolean isExported) {
    //
    // if (containerPath == null) {
    //            Assert.isTrue(false, "Container path cannot be null"); //$NON-NLS-1$
    // } else if (containerPath.segmentCount() < 1) {
    // Assert.isTrue(
    // false,
    //                    "Illegal buildpath container path: \'" + containerPath.makeRelative().toString() + "\', must have at least one segment (containerID+hints)"); //$NON-NLS-1$//$NON-NLS-2$
    // }
    // final BuildpathEntry entry = new BuildpathEntry(
    // IProjectFragment.K_SOURCE, IBuildpathEntry.BPE_CONTAINER,
    // containerPath, isExported, INCLUDE_ALL, EXCLUDE_NONE,
    // extraAttributes, false);
    //
    // entry.setIsContainerEntry(true);
    // return entry;
    // }
    //
    // /**
    // * Runs the given action as an atomic script model operation.
    // * <p>
    // * After running a method that modifies elements, registered listeners
    // * receive after-the-fact notification of what just transpired, in the
    // form
    // * of a element changed event. This method allows clients to call a number
    // * of methods that modify elements and only have element changed event
    // * notifications reported at the end of the entire batch.
    // * </p>
    // * <p>
    // * If this method is called outside the dynamic scope of another such
    // call,
    // * this method runs the action and then reports a single element changed
    // * event describing the net effect of all changes done to elements by the
    // * action.
    // * </p>
    // * <p>
    // * If this method is called in the dynamic scope of another such call,
    // this
    // * method simply runs the action.
    // * </p>
    // *
    // * @param action
    // * the action to perform
    // * @param monitor
    // * a progress monitor, or <code>null</code> if progress reporting
    // * and cancellation are not desired
    // * @exception CoreException
    // * if the operation failed.
    // *
    // */
    // public static void run(final IWorkspaceRunnable action,
    // final IProgressMonitor monitor) throws CoreException {
    // run(action, ResourcesPlugin.getWorkspace().getRoot(), monitor);
    // }
    //
    // /**
    // * Runs the given action as an atomic script model operation.
    // * <p>
    // * After running a method that modifies elements, registered listeners
    // * receive after-the-fact notification of what just transpired, in the
    // form
    // * of a element changed event. This method allows clients to call a number
    // * of methods that modify elements and only have element changed event
    // * notifications reported at the end of the entire batch.
    // * </p>
    // * <p>
    // * If this method is called outside the dynamic scope of another such
    // call,
    // * this method runs the action and then reports a single element changed
    // * event describing the net effect of all changes done to elements by the
    // * action.
    // * </p>
    // * <p>
    // * If this method is called in the dynamic scope of another such call,
    // this
    // * method simply runs the action.
    // * </p>
    // * <p>
    // * The supplied scheduling rule is used to determine whether this
    // operation
    // * can be run simultaneously with workspace changes in other threads. See
    // * <code>IWorkspace.run(...)</code> for more details.
    // * </p>
    // *
    // * @param action
    // * the action to perform
    // * @param rule
    // * the scheduling rule to use when running this operation, or
    // * <code>null</code> if there are no scheduling restrictions for
    // * this operation.
    // * @param monitor
    // * a progress monitor, or <code>null</code> if progress reporting
    // * and cancellation are not desired
    // * @exception CoreException
    // * if the operation failed.
    // *
    // */
    // public static void run(final IWorkspaceRunnable action,
    // final ISchedulingRule rule, final IProgressMonitor monitor)
    // throws CoreException {
    // final IWorkspace workspace = ResourcesPlugin.getWorkspace();
    // if (workspace.isTreeLocked()) {
    // action.run(monitor);
    // } else {
    // // use IWorkspace.run(...) to ensure that a build will be done in
    // // autobuild mode
    // workspace.run(action, rule, IWorkspace.AVOID_UPDATE, monitor);
    // }
    // }
    //
    // /**
    // * Resolve a variable path (helper method).
    // *
    // * @param variablePath
    // * the given variable path
    // * @return the resolved variable path or <code>null</code> if none
    // */
    // public static IPath getResolvedVariablePath(final IPath variablePath) {
    //
    // if (variablePath == null) {
    // return null;
    // }
    // final int count = variablePath.segmentCount();
    // if (count == 0) {
    // return null;
    // }
    //
    // // lookup variable
    // final String variableName = variablePath.segment(0);
    // IPath resolvedPath = BuildpathUtils.getBuildpathVariable(variableName);
    // if (resolvedPath == null) {
    // return null;
    // }
    //
    // // append path suffix
    // if (count > 1) {
    // resolvedPath = resolvedPath.append(variablePath
    // .removeFirstSegments(1));
    // }
    // return resolvedPath;
    // }
    //
    // /**
    // * Answers the project specific value for a given buildpath container. In
    // * case this container path could not be resolved, then will answer
    // * <code>null</code>. Both the container path and the project context are
    // * supposed to be non-null.
    // * <p>
    // * The containerPath is a formed by a first ID segment followed with extra
    // * segments, which can be used as additional hints for resolution. If no
    // * container was ever recorded for this container path onto this project
    // * (using <code>setBuildpathContainer</code>, then a
    // * <code>buildpathContainerInitializer</code> will be activated if any was
    // * registered for this container ID onto the extension point
    // * "org.eclipse.dltk.core.buildpathContainerInitializer".
    // * <p>
    // * There is no assumption that the returned container must answer the
    // exact
    // * same containerPath when requested
    // * <code>IBuildpathContainer#getPath</code>. Indeed, the containerPath is
    // * just an indication for resolving it to an actual container object.
    // * <p>
    // * buildpath container values are persisted locally to the workspace, but
    // * are not preserved from a session to another. It is thus highly
    // * recommended to register a <code>buildpathContainerInitializer</code>
    // for
    // * each referenced container (through the extension point
    // * "org.eclipse.dltk.core.buildpathContainerInitializer").
    // * <p>
    // *
    // * @param containerPath
    // * the name of the container, which needs to be resolved
    // * @param project
    // * a specific project in which the container is being resolved
    // * @return the corresponding buildpath container or <code>null</code> if
    // * unable to find one.
    // *
    // * @exception ModelException
    // * if an exception occurred while resolving the container, or
    // * if the resolved container contains illegal entries
    // * (contains BPE_CONTAINER entries or null entries).
    // *
    // * @see buildpathContainerInitializer
    // * @see IBuildpathContainer
    // * @see #setbuildpathContainer(IPath, IErlangProject[],
    // * IBuildpathContainer[], IProgressMonitor)
    // *
    // */
    // public static IBuildpathContainer getBuildpathContainer(
    // final IPath containerPath, final IErlangProject project)
    // throws ModelException {
    // final ModelManager manager = ModelManager.getModelManager();
    // final IBuildpathContainer container = manager.getBuildpathContainer(
    // containerPath, project);
    // if (container == ModelManager.CONTAINER_INITIALIZATION_IN_PROGRESS) {
    // return manager.getPreviousSessionContainer(containerPath, project);
    // }
    // return container;
    // }
    //
    // public static IBuildpathEntry newExtLibraryEntry(final IPath path) {
    //
    // return newLibraryEntry(path, NO_EXTRA_ATTRIBUTES,
    // false/* not exported */, true);
    // }
    //
    // public static IBuildpathEntry newLibraryEntry(final IPath path,
    // final BuildpathAttributes extraAttributes,
    // final Collection<IPath> include, final Collection<IPath> exclude,
    // final boolean isExported, final boolean externalLib) {
    //
    // if (path == null) {
    //            Assert.isTrue(false, "Library path cannot be null"); //$NON-NLS-1$
    // }
    // if (!path.isAbsolute()) {
    //            Assert.isTrue(false, "Path for IBuildpathEntry must be absolute"); //$NON-NLS-1$
    // }
    // return new BuildpathEntry(IProjectFragment.K_BINARY,
    // IBuildpathEntry.BPE_LIBRARY,
    // ScriptProject.canonicalizedPath(path), isExported, include, // inclusion
    // // patterns
    // exclude, // exclusion patterns
    // extraAttributes, externalLib);
    // }
    //
    // public static IBuildpathEntry newBuiltinEntry(final IPath path,
    // final BuildpathAttributes extraAttributes,
    // final Collection<IPath> include, final Collection<IPath> exclude,
    // final boolean isExported, final boolean externalLib) {
    //
    // if (path == null) {
    //            Assert.isTrue(false, "Library path cannot be null"); //$NON-NLS-1$
    // }
    // return new BuildpathEntry(IProjectFragment.K_BINARY,
    // IBuildpathEntry.BPE_LIBRARY, path, isExported, include, // inclusion
    // // patterns
    // exclude, // exclusion patterns
    // extraAttributes, externalLib);
    // }
    //
}
