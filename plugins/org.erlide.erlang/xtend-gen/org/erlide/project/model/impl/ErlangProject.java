package org.erlide.project.model.impl;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.erlide.project.model.ICodeUnit;
import org.erlide.project.model.IErlangModel;
import org.erlide.project.model.IErlangModelElement;
import org.erlide.project.model.IErlangProject;
import org.erlide.project.model.impl.ErlangModelElement;

@SuppressWarnings("all")
public class ErlangProject extends ErlangModelElement implements IErlangProject, IResourceChangeListener {
  private IErlangModel model;
  
  private List<ICodeUnit> units;
  
  private IProject workspaceProject;
  
  private boolean closed;
  
  public ErlangProject(final IErlangModel model, final IProject project) {
    super();
    this.model = model;
    ArrayList<ICodeUnit> _newArrayList = CollectionLiterals.<ICodeUnit>newArrayList();
    this.units = _newArrayList;
    this.workspaceProject = project;
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    _workspace.addResourceChangeListener(this);
    boolean _isOpen = project.isOpen();
    if (_isOpen) {
      this.open();
    }
  }
  
  public List<IProject> getReferencedProjects() {
    this.open();
    try {
      return ((List<IProject>)Conversions.doWrapArray(this.workspaceProject.getReferencedProjects()));
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Collection<ICodeUnit> getUnits() {
    this.open();
    return Collections.<ICodeUnit>unmodifiableCollection(this.units);
  }
  
  public IProject getWorkspaceProject() {
    return this.workspaceProject;
  }
  
  public String toString() {
    String _string = super.toString();
    StringBuffer _stringBuffer = new StringBuffer(_string);
    final StringBuffer result = _stringBuffer;
    result.append(" (workspaceProject: ");
    result.append(this.workspaceProject);
    result.append(")");
    return result.toString();
  }
  
  public String getName() {
    return this.workspaceProject.getName();
  }
  
  public IErlangModelElement getParent() {
    return this.model;
  }
  
  public IResource getResource() {
    return this.workspaceProject;
  }
  
  private boolean open() {
    boolean _xblockexpression = false;
    {
      String _plus = ("OPEN " + this);
      InputOutput.<String>println(_plus);
      boolean _closed = this.closed = false;
      _xblockexpression = (_closed);
    }
    return _xblockexpression;
  }
  
  private boolean close() {
    boolean _xblockexpression = false;
    {
      String _plus = ("CLOSE " + this);
      InputOutput.<String>println(_plus);
      boolean _closed = this.closed = true;
      _xblockexpression = (_closed);
    }
    return _xblockexpression;
  }
  
  public void resourceChanged(final IResourceChangeEvent event) {
    try {
      int _type = event.getType();
      boolean _notEquals = (_type != IResourceChangeEvent.POST_CHANGE);
      if (_notEquals) {
        return;
      }
      IResourceDelta _delta = event.getDelta();
      final Function1<IResourceDelta,Boolean> _function = new Function1<IResourceDelta,Boolean>() {
          public Boolean apply(final IResourceDelta delta) {
            IResource _resource = delta.getResource();
            IErlangProject _project = ErlangProject.this.getProject();
            boolean _equals = Objects.equal(_resource, _project);
            if (_equals) {
              IErlangProject _project_1 = ErlangProject.this.getProject();
              String _plus = ("CHANGE IN PROJECT " + _project_1);
              String _plus_1 = (_plus + " ");
              int _flags = delta.getFlags();
              String _plus_2 = (_plus_1 + Integer.valueOf(_flags));
              InputOutput.<String>println(_plus_2);
              int _flags_1 = delta.getFlags();
              final int _switchValue = _flags_1;
              boolean _matched = false;
              if (!_matched) {
                int _flags_2 = delta.getFlags();
                boolean _match = ErlangProject.this.match(_flags_2, IResourceDelta.OPEN);
                if (_match) {
                  _matched=true;
                  if (ErlangProject.this.closed) {
                    ErlangProject.this.open();
                  } else {
                    ErlangProject.this.close();
                  }
                }
              }
              if (!_matched) {
                int _flags_3 = delta.getFlags();
                boolean _match_1 = ErlangProject.this.match(_flags_3, IResourceDelta.DESCRIPTION);
                if (_match_1) {
                  _matched=true;
                }
              }
              if (!_matched) {
                int _flags_4 = delta.getFlags();
                boolean _match_2 = ErlangProject.this.match(_flags_4, IResourceDelta.REMOVED);
                if (_match_2) {
                  _matched=true;
                  IWorkspace _workspace = ResourcesPlugin.getWorkspace();
                  _workspace.removeResourceChangeListener(ErlangProject.this);
                }
              }
            }
            return true;
          }
        };
      _delta.accept(new IResourceDeltaVisitor() {
          public boolean visit(IResourceDelta delta) {
            return _function.apply(delta);
          }
      });
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private boolean match(final int v, final int flag) {
    int _bitwiseAnd = (v & flag);
    boolean _notEquals = (_bitwiseAnd != 0);
    return _notEquals;
  }
}
