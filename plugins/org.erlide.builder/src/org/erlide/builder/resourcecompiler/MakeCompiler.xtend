package org.erlide.builder.resourcecompiler

import java.util.List
import org.eclipse.core.resources.IFile
import org.erlide.builder.BuilderPlugin
import org.erlide.builder.CompilerOptions
import org.erlide.builder.CompilerProblem
import org.erlide.builder.DefaultLineParser

import static org.erlide.builder.resourcecompiler.MakeCompiler.*

public class MakeCompiler extends AbstractExternalProcessCompiler {
	
	public static val String COMPILER_ID = BuilderPlugin::PLUGIN_ID + ".compiler.make"
	
	override getId() {
		COMPILER_ID
	}
	
    override compileResource(IFile file, CompilerOptions options) {
    	val List<CompilerProblem> result = newArrayList()
        executor.executeProcess(newArrayList("make", file.getName()), 
            file.getParent().getLocation().toPortableString(), 
            new DefaultLineParser()) [
            	problem | result.add(problem)
            ]
        return result
    }
    
}
