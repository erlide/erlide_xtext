package org.erlide.project.buildpath.convert

import com.google.common.base.Charsets
import com.google.common.io.Files
import java.io.File
import org.eclipse.core.runtime.IPath

class FileContentProvider extends AbstractContentProvider {
	
	override get(IPath path) {
		Files::readLines(new File(path.toOSString), Charsets::UTF_8)
	}
	
}