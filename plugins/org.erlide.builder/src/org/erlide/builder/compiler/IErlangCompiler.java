package org.erlide.builder.compiler;

import java.util.Collection;

import org.eclipse.core.resources.IFile;

public interface IErlangCompiler {

    String getId();

    Collection<CompilerProblem> compileResource(final IFile file,
            final CompilerOptions options);

}
