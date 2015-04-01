package org.erlide.builder.resourcecompiler;

import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.resourcecompiler.AbstractCompiler;

@SuppressWarnings("all")
public abstract class AbstractExternalProcessCompiler extends AbstractCompiler {
  @Property
  private final BuilderExecutor _executor;
  
  public AbstractExternalProcessCompiler(final BuilderExecutor executor) {
    this._executor = executor;
  }
  
  public AbstractExternalProcessCompiler() {
    this(new BuilderExecutor());
  }
  
  @Pure
  public BuilderExecutor getExecutor() {
    return this._executor;
  }
}
