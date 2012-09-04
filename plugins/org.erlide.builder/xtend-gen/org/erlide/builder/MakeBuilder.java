package org.erlide.builder;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.ExternalBuilder;

@SuppressWarnings("all")
public class MakeBuilder extends ExternalBuilder {
  public MakeBuilder() {
    super();
  }
  
  public MakeBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater) {
    super(project, markerUpdater);
  }
  
  public MakeBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater, final BuilderExecutor executor) {
    super(project, markerUpdater, executor);
  }
  
  public void clean(final IProgressMonitor monitor) throws CoreException {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("make", "clean");
    List<String> _list = IterableExtensions.<String>toList(_newArrayList);
    final List<CompilerProblem> errors = this.execute(_list);
  }
  
  public void fullBuild(final IProgressMonitor monitor) throws CoreException {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("make", "-B", "beam");
    List<String> _list = IterableExtensions.<String>toList(_newArrayList);
    final List<CompilerProblem> errors = this.execute(_list);
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem it) {
          InputOutput.<CompilerProblem>println(it);
        }
      };
    IterableExtensions.<CompilerProblem>forEach(errors, _function);
  }
}
