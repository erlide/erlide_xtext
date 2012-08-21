package org.erlide.builder.compiler

import java.io.File
import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.erlide.builder.BuilderPlugin

public class ErlCompiler extends AbstractCompiler {
	
	public static val String COMPILER_ID = BuilderPlugin::PLUGIN_ID+".compiler.erl"
	
	override getId() {
		COMPILER_ID
	}
	
    override compileResource(IFile file, CompilerOptions options, (IFile, String, int, int)=>void resultsHandler) {
        launchProcess(file, newArrayList("erlc", file.getName()), new File(
            file.getParent().getLocation().toPortableString()), resultsHandler)
    }
    
    override protected void parseLine(String line, IFile file, (IFile, String, int, int)=>void callback) {
        val List<String> parts = line.split(": ")
        val List<String> heads = parts.head.split(":") 
        val warning = parts.size==3
        val msg = if(warning) parts.get(2) else parts.get(1) 
        val severity = if(warning) IMarker::SEVERITY_WARNING else IMarker::SEVERITY_ERROR
        val nline = Integer::parseInt(heads.tail.head)
        
        callback.apply(file, msg, nline, severity)                
    }
  
}
