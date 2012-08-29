package org.erlide.builder.compiler

import java.util.List
import org.eclipse.core.resources.IMarker

class DefaultLineParser implements IProblemLineParser {
	
	override parseLine(String line) {
        val List<String> parts = line.split(":")
        val warning = parts.get(2)==" Warning"
        val msg = parts.tail.tail.join(":").trim
        val severity = if(warning) IMarker::SEVERITY_WARNING else IMarker::SEVERITY_ERROR
        val nline = Integer::parseInt(parts.tail.head)
        
        new CompilerProblem(null, msg, nline, severity)
    }

}