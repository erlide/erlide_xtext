package org.erlide.project.model.impl;

import org.eclipse.core.runtime.IPath;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.impl.ProjectFragment;

@SuppressWarnings("all")
public class OtpProjectFragment extends ProjectFragment {
  public OtpProjectFragment(final IErlangProject project, final String name, final IPath root) {
    super(project, name);
  }
}
