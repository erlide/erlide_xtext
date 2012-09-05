package org.erlide.builder.resourcecompiler

import java.util.List
import org.eclipse.core.resources.IFile
import org.erlide.builder.BuilderPlugin
import org.erlide.builder.CompilerOptions
import org.erlide.builder.CompilerProblem
import org.erlide.builder.DefaultLineParser

import static org.erlide.builder.resourcecompiler.ErlCompiler.*
import org.eclipse.core.runtime.NullProgressMonitor

public class ErlCompiler extends AbstractExternalProcessCompiler {
	
	public static val String COMPILER_ID = BuilderPlugin::PLUGIN_ID + ".compiler.erl"
	
	override getId() {
		COMPILER_ID
	}
	
    override compileResource(IFile file, CompilerOptions options) {
    	val List<CompilerProblem> result = newArrayList()
        executor.executeProcess(newArrayList("erlc", file.getName()), 
            file.getParent().getLocation().toPortableString(), new NullProgressMonitor(), 
            new DefaultLineParser()) [ 
            	problem | result.add(problem) 
            ]
        return result
    }
  
}
