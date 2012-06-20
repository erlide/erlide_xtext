package org.erlide.erlang

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.lib.Pair
import java.util.List
import com.google.inject.Inject

class AbstractErlangTests {
	@Inject
	ModelExtensions modelHelper
	
	def EObject getObjectAtOffset(Pair<Module, List<Integer>> src, int index) {
		modelHelper.getObjectAtOffset(src.key, src.value.get(index))
	}
	
}