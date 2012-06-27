package org.erlide.erlang

import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Factory
import org.hamcrest.Matcher

class IsFunRefMatcher extends BaseMatcher {

	String name
	int arity
	extension ModelExtensions = new ModelExtensions

	new(String name, int arity) {
		this.name = name
		this.arity = arity
	}
	
	override describeTo(Description description) {
		description.appendText(name+"/"+arity)
	}
	
	@Factory
	def static Matcher<Function> isFunction(String name, int arity) {
		new org.erlide.erlang.IsFunRefMatcher(name, arity)
	}

	@Factory
	def static Matcher<FunRef> isFunRef(String name, int arity) {
		new org.erlide.erlang.IsFunRefMatcher(name, arity)
	}

	def dispatch matches(Function item) {
		item.name==name && item.arity==arity
	}
	
	def dispatch matches(FunRef item) {
		item.function==name && item.arity==Integer::toString(arity)
	}

	def dispatch matches(Object item) {
		false
	}
	
}