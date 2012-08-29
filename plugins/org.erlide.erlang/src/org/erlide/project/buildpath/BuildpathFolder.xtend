package org.erlide.project.buildpath

import java.util.Collection
import java.util.Collections
import java.util.List
import org.eclipse.core.runtime.IPath
import org.eclipse.xtend.lib.Data

@Data
class BuildpathFolder extends BuildpathEntry {

    IPath path;
    FolderKind kind
    List<IPath> inclusionPatterns = newArrayList();
    List<IPath> exclusionPatterns = newArrayList();

    def Collection<IPath> getInclusionPatterns() {
        return Collections::unmodifiableList(_inclusionPatterns)
    }

    def Collection<IPath> getExclusionPatterns() {
        return Collections::unmodifiableList(_exclusionPatterns)
    }

	new(BuildpathApp aParent, BuildpathAttributes attrs, IPath path, FolderKind kind) {
		super(aParent, attrs)
		_path = path
		_kind = kind
	}
	
}

