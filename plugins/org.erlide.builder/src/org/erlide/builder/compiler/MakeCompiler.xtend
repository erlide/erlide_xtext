package org.erlide.builder.compiler

import java.util.List
import org.eclipse.core.resources.IFile
import org.erlide.builder.BuilderPlugin

import static org.erlide.builder.compiler.MakeCompiler.*

public class MakeCompiler extends AbstractExternalProcessCompiler {
	
	public static val String COMPILER_ID = BuilderPlugin::PLUGIN_ID + ".compiler.make"
	
	override getId() {
		COMPILER_ID
	}
	
    override compileResource(IFile file, CompilerOptions options) {
    	val List<CompilerProblem> result = newArrayList()
        executeProcess(file, newArrayList("make", file.getName()), 
            file.getParent().getLocation().toPortableString(), 
            new DefaultLineParser()) [
            	problem | result.add(problem)
            ]
        return result
    }
    
}
