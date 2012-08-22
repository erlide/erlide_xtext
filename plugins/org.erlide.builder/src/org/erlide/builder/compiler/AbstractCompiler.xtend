package org.erlide.builder.compiler

abstract class AbstractCompiler implements IErlangCompiler {

	protected var IProblemLineParser lineParser
	
    override void setLineParser(IProblemLineParser parser) {
    	lineParser = parser
    }
}