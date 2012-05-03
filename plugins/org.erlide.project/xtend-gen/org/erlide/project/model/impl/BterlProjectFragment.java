package org.erlide.project.model.impl;

import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.IProjectFragment;
import org.erlide.project.model.impl.EmbeddedProjectFragment;

@SuppressWarnings("all")
public class BterlProjectFragment extends EmbeddedProjectFragment {
  public BterlProjectFragment(final IErlangProject project, final String name, final IProjectFragment parent) {
    super(project, name, parent);
  }
}
