package org.erlide.builder.resourcecompiler;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.erlide.builder.CompilerOptions;
import org.erlide.builder.CompilerProblem;

public interface IErlangCompiler {

    String getId();

    Collection<CompilerProblem> compileResource(final IFile file,
            final CompilerOptions options);

}
