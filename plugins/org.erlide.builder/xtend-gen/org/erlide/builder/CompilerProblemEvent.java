package org.erlide.builder;

import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.MarkerOperation;

@Data
@SuppressWarnings("all")
public class CompilerProblemEvent {
  private final CompilerProblem _problem;
  
  public CompilerProblem getProblem() {
    return this._problem;
  }
  
  private final IResource _resource;
  
  public IResource getResource() {
    return this._resource;
  }
  
  private final MarkerOperation _op;
  
  public MarkerOperation getOp() {
    return this._op;
  }
  
  public CompilerProblemEvent(final CompilerProblem problem, final IResource resource, final MarkerOperation op) {
    super();
    this._problem = problem;
    this._resource = resource;
    this._op = op;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_problem== null) ? 0 : _problem.hashCode());
    result = prime * result + ((_resource== null) ? 0 : _resource.hashCode());
    result = prime * result + ((_op== null) ? 0 : _op.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CompilerProblemEvent other = (CompilerProblemEvent) obj;
    if (_problem == null) {
      if (other._problem != null)
        return false;
    } else if (!_problem.equals(other._problem))
      return false;
    if (_resource == null) {
      if (other._resource != null)
        return false;
    } else if (!_resource.equals(other._resource))
      return false;
    if (_op == null) {
      if (other._op != null)
        return false;
    } else if (!_op.equals(other._op))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
