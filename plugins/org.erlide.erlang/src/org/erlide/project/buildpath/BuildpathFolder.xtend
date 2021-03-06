package org.erlide.project.buildpath

import java.util.Collection
import java.util.Collections
import java.util.List
import org.eclipse.core.runtime.IPath
import org.eclipse.xtend.lib.annotations.Data

@Data
class BuildpathFolder extends BuildpathEntry {

    IPath path;
    FolderKind kind
    List<IPath> inclusionPatterns = newArrayList();
    List<IPath> exclusionPatterns = newArrayList();

    def Collection<IPath> getInclusionPatterns() {
        return Collections::unmodifiableList(this.inclusionPatterns)
    }

    def Collection<IPath> getExclusionPatterns() {
        return Collections::unmodifiableList(this.exclusionPatterns)
    }

	new(BuildpathApp aParent, BuildpathAttributes attrs, IPath path, FolderKind kind) {
		super(aParent, attrs)
		this.path = path
		this.kind = kind
	}

}

