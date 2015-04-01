package org.erlide.builder.resourcecompiler;

import java.util.Collection;
import org.eclipse.core.resources.IFile;
import org.erlide.builder.CompilerOptions;
import org.erlide.builder.CompilerProblem;
import org.erlide.builder.resourcecompiler.AbstractCompiler;

@SuppressWarnings("all")
public class InternalCompiler extends AbstractCompiler {
  @Override
  public String getId() {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
  
  @Override
  public Collection<CompilerProblem> compileResource(final IFile file, final CompilerOptions options) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }
}
