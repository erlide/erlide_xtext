package org.erlide.common.process

import org.eclipse.core.resources.IFile

class OutputParser {
	
	@Property IFile file
	@Property var (IFile, String, int, int)=>void callback

	new(IFile file, (IFile, String, int, int)=>void callback) {
		this.file = file
		this.callback = callback
	}
	
	def void parseLine(String line) {
	}
	
}