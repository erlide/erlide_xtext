package org.erlide.erlang

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject

class ErlangTestExtensions {
	@Inject
	ModelExtensions modelHelper

	def EObject getObjectAtMarker(Pair<Module, List<Integer>> src, int index) {
		if(index>=src.value.size)
			return null
		val pos = src.value.get(index)
		modelHelper.getObjectAtOffset(src.key, pos)
	}

	def EObject getObjectAtMarker(Pair<Module, List<Integer>> src) {
		getObjectAtMarker(src, 0)
	}

}
