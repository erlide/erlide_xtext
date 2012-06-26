package org.erlide.erlang.util

import com.google.common.collect.Lists
import java.util.List
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.xbase.lib.Pair
import org.erlide.erlang.Module
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.common.util.URI
import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtext.resource.XtextResourceSet

class ErlangTestingHelper {
	@Inject
	ParseHelper<Module> parser

	public val MARKER = "§"

	def Pair<Module, List<Integer>> parse(String string) {
		val res = extractMarkers(string)
		return parser.parse(res.key) -> res.value 
	}
	
	def Pair<Module, List<Integer>> parse(String string, String uri, ResourceSet rset) {
		val res = extractMarkers(string)
		return parser.parse(res.key, URI::createURI(uri), rset) -> res.value 
	}
	
	def Pair<String, List<Integer>> extractMarkers(String string) {
		val parts = string.split(MARKER)
		var List<Integer> list = newArrayList()
		if(parts.size==1){
			if(string.contains(MARKER)){
				list.add(parts.get(0).length)
				return parts.get(0) -> list
			} else{
				return string -> list
			}
		}
		list = Lists::newArrayList(parts.map[length])
		list.remove(parts.size-1)
		val List<Integer> result = newArrayList()
		list.fold(0)[crt, old|
			val anew = crt+old
			result.add(anew)
			anew
		]
		return parts.join -> result
	}

}