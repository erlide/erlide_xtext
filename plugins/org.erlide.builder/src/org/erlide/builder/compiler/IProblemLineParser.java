package org.erlide.builder.compiler;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface IProblemLineParser {

    void parseLine(String line, IFile file,
            Procedure1<? super CompilerProblem> callback);

}
