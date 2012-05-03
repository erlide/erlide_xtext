package org.erlide.project.model.impl;

import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.impl.ProjectFragment;

@SuppressWarnings("all")
public class GenericProjectFragment extends ProjectFragment {
  public GenericProjectFragment(final IErlangProject project, final String name) {
    super(project, name);
  }
}
