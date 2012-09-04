package org.erlide.builder.resourcecompiler;

import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.resourcecompiler.AbstractCompiler;

@SuppressWarnings("all")
public abstract class AbstractExternalProcessCompiler extends AbstractCompiler {
  private final BuilderExecutor _executor;
  
  public BuilderExecutor getExecutor() {
    return this._executor;
  }
  
  public AbstractExternalProcessCompiler(final BuilderExecutor executor) {
    this._executor = executor;
  }
  
  public AbstractExternalProcessCompiler() {
    this(new Function0<BuilderExecutor>() {
      public BuilderExecutor apply() {
        BuilderExecutor _builderExecutor = new BuilderExecutor();
        return _builderExecutor;
      }
    }.apply());
  }
}
