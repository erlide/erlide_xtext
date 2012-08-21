package org.erlide.builder.compiler;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure4;

public interface IErlangCompiler {

    String getId();

    void compileResource(
            final IFile file,
            final CompilerOptions options,
            Procedure4<? super IFile, ? super String, ? super Integer, ? super Integer> resultsHandler);

}
