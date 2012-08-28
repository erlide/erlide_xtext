package org.erlide.project.buildpath

import java.util.Collection
import java.util.Collections
import java.util.List
import org.eclipse.core.runtime.IPath
import org.erlide.project.buildpath.IBuildpathFolder$FolderKind
import org.erlide.project.buildpath.BuildpathEntry
import org.erlide.project.buildpath.BuildpathAttributes
import org.erlide.project.buildpath.IBuildpathContainer

class BuildpathFolder extends BuildpathEntry implements IBuildpathFolder {

    @Property IPath path;
    @Property FolderKind kind;
    List<IPath> inclusionPatterns = newArrayList();
    List<IPath> exclusionPatterns = newArrayList();

    override Collection<IPath> getInclusionPatterns() {
        return Collections::unmodifiableList(inclusionPatterns)
    }

    override Collection<IPath> getExclusionPatterns() {
        return Collections::unmodifiableList(exclusionPatterns)
    }

	new(IBuildpathContainer aParent, String aName, BuildpathAttributes attrs, IPath path, FolderKind kind) {
		super(aParent, aName, attrs)
		_path = path
		_kind = kind
	}
}
