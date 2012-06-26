package org.erlide.erlang

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.lib.Pair
import java.util.List
import com.google.inject.Inject

class ErlangTestExtensions {
	@Inject
	ModelExtensions modelHelper
	
	def EObject getObjectAtMarker(Pair<Module, List<Integer>> src, int index) {
		modelHelper.getObjectAtOffset(src.key, src.value.get(index))
	}
	
	def EObject getObjectAtMarker(Pair<Module, List<Integer>> src) {
		getObjectAtMarker(src, 0)
	}
	
}