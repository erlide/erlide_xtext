package org.erlide.builder.resourcecompiler

import java.util.List
import org.eclipse.core.resources.IFile
import org.erlide.builder.BuilderPlugin

import static org.erlide.builder.resourcecompiler.ErlCompiler.*

public class ErlCompiler extends AbstractExternalProcessBuilder {
	
	public static val String COMPILER_ID = BuilderPlugin::PLUGIN_ID + ".compiler.erl"
	
	override getId() {
		COMPILER_ID
	}
	
    override compileResource(IFile file, CompilerOptions options) {
    	val List<CompilerProblem> result = newArrayList()
        executeProcess(file, newArrayList("erlc", file.getName()), 
            file.getParent().getLocation().toPortableString(), new DefaultLineParser()) [ 
            	problem | result.add(problem) 
            ]
        return result
    }
  
}
