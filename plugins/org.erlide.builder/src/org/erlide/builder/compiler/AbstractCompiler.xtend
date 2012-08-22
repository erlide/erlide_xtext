package org.erlide.builder.compiler

abstract class AbstractCompiler implements IErlangCompiler {

	protected var IProblemLineParser lineParser
	
    def void setLineParser(IProblemLineParser parser) {
    	lineParser = parser
    }
}