package org.erlide.naming

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.util.ErlangTestingHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangTestingHelperTest {

    @Inject
    ErlangTestingHelper parser

	@Test
	def void noMarkers() {
		val String input = "1234567890"
        val module = parser.extractMarkers(input)
    	assertThat(module.key, is(input))
    	assertThat(module.value.size, is(0))  
	}
	
	@Test
	def void oneMarker() {
        val module = parser.extractMarkers("12345§67890")
    	assertThat(module.key, is("1234567890"))
    	assertThat(module.value.size, is(1))
    	assertThat(module.value.head, is(5))
    	  
	}
	@Test
	def void severalMarkers() {
        val module = parser.extractMarkers("12345§678§90")
    	assertThat(module.key, is("1234567890"))
    	assertThat(module.value.size, is(2))
    	assertThat(module.value.head, is(5))
    	assertThat(module.value.tail.head, is(8))
	}

	@Test
	def void firstMarker() {
        val module = parser.extractMarkers("§1234567890")
    	assertThat(module.key, is("1234567890"))
    	assertThat(module.value.size, is(1))
    	assertThat(module.value.head, is(0))
    	  
	}

	@Test
	def void lastMarker() {
        val module = parser.extractMarkers("1234567890§")
    	assertThat(module.key, is("1234567890"))
    	assertThat(module.value.size, is(1))
    	assertThat(module.value.head, is(10))
    	  
	}
	
	@Test
	def void succesiveMarkers() {
        val module = parser.extractMarkers("123456§§7890")
    	assertThat(module.key, is("1234567890"))
    	assertThat(module.value.size, is(2))
    	assertThat(module.value.head, is(6))
    	assertThat(module.value.tail.head, is(6))
    	  
	}
	
}