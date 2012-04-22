package org.erlide.builder;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure4;

public class ErlangBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "org.erlide.project.ui.erlangBuilder";
	private static final String MARKER_TYPE = "org.erlide.project.ui.erlangProblem";

	class SampleDeltaVisitor implements IResourceDeltaVisitor {
		@Override
		public boolean visit(final IResourceDelta delta) throws CoreException {
			final IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				compileResource(resource);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				compileResource(resource);
				break;
			}
			// return true to continue visiting children.
			return true;
		}
	}

	class SampleResourceVisitor implements IResourceVisitor {
		@Override
		public boolean visit(final IResource resource) {
			compileResource(resource);
			// return true to continue visiting children.
			return true;
		}
	}

	public static void addMarker(final IFile file, final String message,
			int lineNumber, final int severity) {
		try {
			final IMarker marker = file.createMarker(MARKER_TYPE);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			if (lineNumber == -1) {
				lineNumber = 1;
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
		} catch (final CoreException e) {
		}
	}

	@Override
	protected IProject[] build(final int kind,
			@SuppressWarnings("rawtypes") final Map args,
			final IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			final IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	private void compileResource(final IResource resource) {
		if (!(resource instanceof IFile) || !isErlangResource(resource)) {
			return;
		}
		deleteMarkers((IFile) resource);
		SimpleErlangBuilder.compileResource((IFile) resource,
				new Procedure4<IFile, String, Integer, Integer>() {
					@Override
					public void apply(final IFile file, final String message,
							final Integer lineNumber, final Integer severity) {
						addMarker(file, message, lineNumber, severity);
					}
				});
	}

	private boolean isErlangResource(final IResource resource) {
		return "erl".equals(resource.getProjectRelativePath()
				.getFileExtension());
	}

	private void deleteMarkers(final IFile file) {
		try {
			file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
		} catch (final CoreException ce) {
		}
	}

	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		try {
			getProject().accept(new SampleResourceVisitor());
		} catch (final CoreException e) {
		}
	}

	protected void incrementalBuild(final IResourceDelta delta,
			final IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new SampleDeltaVisitor());
	}

}
