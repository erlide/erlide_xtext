package org.erlide.project.buildpath

import org.erlide.project.buildpath.BuildpathAttributes
import org.erlide.project.buildpath.IBuildpathContainer

abstract class BuildpathEntry implements IBuildpathEntry {

    @Property IBuildpathContainer parent;
    @Property String name;
    @Property BuildpathAttributes attributes;

	new(IBuildpathContainer aParent, String aName, BuildpathAttributes attrs) {
		_parent = aParent
		_name = aName
		_attributes = attrs
	}

	new(IBuildpathContainer aParent, String aName) {
		this(aParent, aName, new org.erlide.project.buildpath.BuildpathAttributes())
	}

}
