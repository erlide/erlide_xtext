package org.erlide.project.buildpath

import java.util.Collection
import java.util.Collections
import org.eclipse.xtend.lib.annotations.Data

@Data
class BuildpathLibrary extends BuildpathEntry {

    String name;
    Collection<BuildpathLibrary> libraries = newHashSet()
    Collection<BuildpathApp> apps = newHashSet()

	new(BuildpathLibrary parent, String name, BuildpathAttributes attributes) {
		super(parent, attributes)
		this.name = name
	}

	new(BuildpathLibrary parent, String name) {
		super(parent, new BuildpathAttributes())
		this.name = name
	}


	def dispatch addChild(BuildpathLibrary entry) {
		println("ADD "+entry.name+" TO "+System::identityHashCode(this))
		if(libraries.add(entry)) {
			println("OK")
			entry.setParent(this)
		}
	}
	def dispatch addChild(BuildpathApp entry) {
		if(apps.add(entry))
			entry.setParent(this)
	}

	def removeChild(BuildpathEntry entry) {
		entry.setParent(null)
		//TODO children.remove(entry)
	}

	def getLibraries() {
		return Collections::unmodifiableCollection(libraries)
	}

	def getApps() {
		return Collections::unmodifiableCollection(apps)
	}

}
