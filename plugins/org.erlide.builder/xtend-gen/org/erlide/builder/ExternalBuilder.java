package org.erlide.builder;

import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.AbstractErlangBuilder;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.DefaultLineParser;

@SuppressWarnings("all")
public abstract class ExternalBuilder extends AbstractErlangBuilder {
  private BuilderExecutor executor;
  
  public ExternalBuilder() {
    super();
    BuilderExecutor _builderExecutor = new BuilderExecutor();
    this.executor = _builderExecutor;
  }
  
  public ExternalBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater) {
    super(project, markerUpdater);
    BuilderExecutor _builderExecutor = new BuilderExecutor();
    this.executor = _builderExecutor;
  }
  
  public ExternalBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater, final BuilderExecutor executor) {
    super(project, markerUpdater);
    this.executor = executor;
  }
  
  protected List<CompilerProblem> execute(final List<String> cmds, final IProgressMonitor monitor) {
    String _plus = ("EXEC \'" + cmds);
    String _plus_1 = (_plus + "\' in ");
    IProject _project = this.getProject();
    String _name = _project.getName();
    String _plus_2 = (_plus_1 + _name);
    InputOutput.<String>println(_plus_2);
    final List<CompilerProblem> result = CollectionLiterals.<CompilerProblem>newArrayList();
    DefaultLineParser _defaultLineParser = new DefaultLineParser();
    final Procedure1<CompilerProblem> _function = new Procedure1<CompilerProblem>() {
        public void apply(final CompilerProblem problem) {
          result.add(problem);
        }
      };
    this.executor.executeProcess(cmds, 
      "/vobs/gsn/product/code/sgsn-w/ups", monitor, _defaultLineParser, _function);
    return result;
  }
}
