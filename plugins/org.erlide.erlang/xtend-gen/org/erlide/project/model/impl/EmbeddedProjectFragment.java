package org.erlide.project.model.impl;

import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IProjectFragment;
import org.erlide.project.model.impl.ProjectFragment;

@SuppressWarnings("all")
public class EmbeddedProjectFragment extends ProjectFragment {
  private IProjectFragment parent;
  
  public EmbeddedProjectFragment(final IErlangProject project, final String name, final IProjectFragment parent) {
    super(project, name);
    this.parent = parent;
  }
}
