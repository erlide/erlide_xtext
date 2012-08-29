package org.erlide.project.buildpath

import java.util.Collection
import java.util.Collections

@Data
class BuildpathLibrary extends BuildpathEntry {

    String name;
    Collection<BuildpathLibrary> libraries = newHashSet()
    Collection<BuildpathApp> apps = newHashSet()
	
	new(BuildpathLibrary parent, String name, BuildpathAttributes attributes) {
		super(parent, attributes)
		_name = name
	}	

	new(BuildpathLibrary parent, String name) {
		super(parent, new BuildpathAttributes())
		_name = name
	}	


	def dispatch void addChild(BuildpathLibrary entry) {
		println("ADD "+entry.name+" TO "+System::identityHashCode(this))
		if(_libraries.add(entry)) {
			println("OK")
			entry.setParent(this)
		}
	}
	def dispatch addChild(BuildpathApp entry) {
		if(_apps.add(entry))
			entry.setParent(this)
	}
	
	def removeChild(BuildpathEntry entry) {
		entry.setParent(null)
		//TODO children.remove(entry)
	}

	def getLibraries() {
		return Collections::unmodifiableCollection(_libraries)
	}
	
	def getApps() {
		return Collections::unmodifiableCollection(_apps)
	}
	
}
