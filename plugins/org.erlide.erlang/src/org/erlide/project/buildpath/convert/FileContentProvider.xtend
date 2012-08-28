package org.erlide.project.buildpath.convert

import org.eclipse.core.runtime.IPath
import com.google.common.io.Files
import java.io.File
import com.google.common.base.Charsets

class FileContentProvider extends AbstractContentProvider {
	
	override get(IPath path) {
		Files::readLines(new File(path.toOSString), Charsets::UTF_8)
	}
	
}