package org.erlide.builder.compiler;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface IErlangCompiler {

    String getId();

    void compileResource(final IFile file, final CompilerOptions options,
            Procedure1<? super CompilerProblem> resultsHandler);

}
