package org.erlide.project.model.impl;

import com.google.common.base.Objects;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;

@SuppressWarnings("all")
public abstract class ErlangModelElement implements IErlangModelElement {
  protected ErlangModelElement() {
  }
  
  @Override
  public IErlangProject getProject() {
    return this.<IErlangProject>getParentOfType(IErlangProject.class);
  }
  
  @Override
  public IErlangModel getModel() {
    return this.<IErlangModel>getParentOfType(IErlangModel.class);
  }
  
  @SuppressWarnings("unchecked")
  private <T extends Object> T getParentOfType(final Class<? extends T> clazz) {
    IErlangModelElement crt = this;
    while (((!Objects.equal(crt, null)) && (!crt.getClass().isAssignableFrom(clazz)))) {
      IErlangModelElement _parent = crt.getParent();
      crt = _parent;
    }
    return ((T) crt);
  }
}
