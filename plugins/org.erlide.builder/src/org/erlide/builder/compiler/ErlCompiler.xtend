package org.erlide.builder.compiler

import java.io.File
import org.eclipse.core.resources.IFile
import org.erlide.builder.BuilderPlugin

import static org.erlide.builder.compiler.ErlCompiler.*

public class ErlCompiler extends AbstractExternalProcessCompiler {
	
	public static val String COMPILER_ID = BuilderPlugin::PLUGIN_ID+".compiler.erl"
	
	override getId() {
		COMPILER_ID
	}
	
    override compileResource(IFile file, CompilerOptions options, (CompilerProblem)=>void resultsHandler) {
        launchProcess(file, newArrayList("erlc", file.getName()), 
            file.getParent().getLocation().toPortableString(), resultsHandler)
    }
    
  
}
