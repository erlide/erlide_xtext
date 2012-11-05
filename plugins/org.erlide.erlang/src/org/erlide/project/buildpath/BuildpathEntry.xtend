package org.erlide.project.buildpath

import org.eclipse.xtend.lib.Property
import org.eclipse.core.resources.IResource

abstract class BuildpathEntry {

    @Property BuildpathEntry parent;
    @Property BuildpathAttributes attributes;

	new(BuildpathEntry aParent, BuildpathAttributes attrs) {
		_parent = aParent
		_attributes = attrs
	}

	new(BuildpathEntry aParent, String aName) {
		this(aParent, new BuildpathAttributes())
	}

	def boolean hasResource(IResource resource) {
		true
	}

}
