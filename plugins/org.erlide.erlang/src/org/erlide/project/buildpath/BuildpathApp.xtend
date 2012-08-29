package org.erlide.project.buildpath

import java.util.Collection
import java.util.Collections

@Data
class BuildpathApp extends BuildpathEntry {

    Collection<BuildpathFolder> folders = newArrayList()
	
	new(BuildpathLibrary parent, BuildpathAttributes attributes) {
		super(parent, attributes)
	}	

	new(BuildpathLibrary parent) {
		super(parent, new BuildpathAttributes())
	}	
	
	def getFolders() {
		return Collections::unmodifiableCollection(_folders)
	}
	
	def addFolder(BuildpathFolder entry) {
		if(_folders.add(entry)){
			entry.parent = this
		}
	}
	
	def removeFolder(BuildpathFolder entry) {
		entry.parent = null;
		_folders.remove(entry)
	}
	
}
