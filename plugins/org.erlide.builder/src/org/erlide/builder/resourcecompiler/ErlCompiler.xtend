package org.erlide.builder.resourcecompiler

import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.NullProgressMonitor
import org.erlide.builder.BuilderPlugin
import org.erlide.builder.CompilerOptions
import org.erlide.builder.CompilerProblem
import org.erlide.builder.DefaultLineParser

public class ErlCompiler extends AbstractExternalProcessCompiler {
	
	public static val String COMPILER_ID = BuilderPlugin::PLUGIN_ID + ".compiler.erl"
	
	override getId() {
		COMPILER_ID
	}
	
    override compileResource(IFile file, CompilerOptions options) {
    	val List<CompilerProblem> result = newArrayList()
        executor.withHandler(new DefaultLineParser(), [ 
            	problem | result.add(problem) 
            ]
        ) [ executeProcess(newArrayList("erlc", file.getName()), 
            file.getParent().getLocation().toPortableString(), new NullProgressMonitor())
        ] 
        return result
    }
  
}
