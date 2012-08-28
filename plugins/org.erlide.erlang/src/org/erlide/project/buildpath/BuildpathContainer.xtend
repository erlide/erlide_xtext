package org.erlide.project.buildpath

import java.util.Collection
import org.eclipse.xtend.lib.Property
import java.util.Collections
import org.erlide.project.buildpath.IBuildpathContainer$ContainerKind

class BuildpathContainer extends BuildpathEntry implements
        IBuildpathContainer {

    @Property ContainerKind kind
    Collection<IBuildpathEntry> children = newArrayList()
	
	new(IBuildpathContainer parent, String name, BuildpathAttributes attributes, ContainerKind kind) {
		super(parent, name, attributes)
		_kind = kind
	}	

	new(IBuildpathContainer parent, String name, ContainerKind kind) {
		super(parent, name, new BuildpathAttributes())
		_kind = kind
	}	


	override addChild(IBuildpathEntry entry) {
		children.add(entry)
		entry.setParent(this)
	}
	
	override removeChild(IBuildpathEntry entry) {
		children.remove(entry)
		entry.setParent(null)
	}
	

	override getChildren() {
		return Collections::unmodifiableCollection(children)
	}
	
}
