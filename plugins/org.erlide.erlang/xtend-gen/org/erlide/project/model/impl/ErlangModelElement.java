package org.erlide.project.model.impl;

import org.eclipse.core.resources.IResource;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;

@SuppressWarnings("all")
public class ErlangModelElement implements IErlangModelElement {
  protected ErlangModelElement() {
  }
  
  public IErlangProject getProject() {
    return this.<IErlangProject>getParentOfType(IErlangProject.class);
  }
  
  public IErlangModel getModel() {
    return this.<IErlangModel>getParentOfType(IErlangModel.class);
  }
  
  @SuppressWarnings("unchecked")
  private <T extends Object> T getParentOfType(final Class<? extends T> clazz) {
    IErlangModelElement crt = this;
    Class<? extends Object> _class = crt.getClass();
    boolean _isAssignableFrom = _class.isAssignableFrom(clazz);
    boolean _not = (!_isAssignableFrom);
    boolean _while = _not;
    while (_while) {
      IErlangModelElement _parent = crt.getParent();
      crt = _parent;
      Class<? extends Object> _class_1 = crt.getClass();
      boolean _isAssignableFrom_1 = _class_1.isAssignableFrom(clazz);
      boolean _not_1 = (!_isAssignableFrom_1);
      _while = _not_1;
    }
    return ((T) crt);
  }
  
  public String getName() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public IErlangModelElement getParent() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public IResource getResource() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Abstract operation");
    throw _unsupportedOperationException;
  }
  
  public void realize() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Abstract operation");
    throw _unsupportedOperationException;
  }
}
