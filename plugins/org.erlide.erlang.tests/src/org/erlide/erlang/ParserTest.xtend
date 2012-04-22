package org.erlide.erlang

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.erlide.ErlangInjectorProvider
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ParserTest {
	
	@Inject
	ParseHelper<Module> parser
	
	@Test
	def void moduleAttributeTest() {
		val model = parser.parse('''
		-module(x).
		''')
		val entity = model.forms.head as ModuleAttribute
		assertEquals(entity.tag, "module")
		val mod = entity.name 
		assertEquals(mod, "x") 
	}

	@Test
	def void moduleAttributeTest1() {
		val model = parser.parse('''
		x+1.
		''')
		print(model)
	}

	@Test
	def void specAttributeTest() {
		val model = parser.parse('''
		-spec f()-> void().
		''')
		val entity = model.forms.head as SpecAttribute
		assertEquals(entity.tag, "spec")
//		val mod = entity.body as TypeSpec  
		//assertEquals(mod.value, "x") 
	}

	@Test
	def void typeAttributeTest() {
		val model = parser.parse('''
		-type myType() :: integer().
		''')
		val entity = model.forms.head as TypeAttribute
		assertEquals(entity.tag, "type")
		val key = entity.name 
//		val mod = entity.type as TopType
	}

	@Test
	def void recordAttributeTest() {
		val model = parser.parse('''
		-record(x, {a, b}).
		''')
		val entity = model.forms.head as RecordAttribute
		assertEquals(entity.tag, "record")
//		val mod = entity.name
//		assertEquals(mod, "x") 
	}
	
	@Test
	def void defineAttributeTest_1() {
		val model = parser.parse('''
		-define(X, ofx, abb). 
		''')
		val entity = model.forms.head as DefineAttribute
		assertEquals(entity.tag, "define")
//		val name = entity.name
//		assertEquals(name, "X") 
	}
 
	@Test
	def void defineAttributeTest_2() {
		val model = parser.parse('''
		-define(X).
		''')
		val entity = model.forms.head as DefineAttribute
		assertEquals(entity.tag, "define")
//		val name = entity.name
//		assertEquals(name, "X")
//		assertEquals(entity.value, null) 
	}

	@Test
	def void genericAttributeTest_1() {
		val model = parser.parse('''
		-myTag([x, aa, bb]).
		''')
		val entity = model.forms.head as CustomAttribute
		assertEquals(entity.tag, "myTag")
		val mod = entity.value 
		assertTrue(mod.get(0) instanceof ErlList)
	}

	@Test
	def void LineAttributeTest_1() {
		val model = parser.parse('''
		f() -> ?line ok, ok, ?line ok.
		''')
		val fun = model.forms.head as Function
		val body = fun.clauses.head.body
		assertEquals(3, body.size)
		assertTrue(body.head.line)
		assertFalse(body.tail.head.line)
	}

	@Test
	def void fullStopTest_1() {
		val model = parser.parse('''
		f() -> ok.% comment
		''')
		val fun = model.forms.head as Function
		val body = fun.clauses.head.body
		assertEquals(1, body.size)
		val expr = body.head
		assertTrue(expr instanceof Atom) 
	}

	@Test
	def void fullStopTest_2() {
		val model = parser.parse('''
		f() -> ok.''')
		val fun = model.forms.head as Function
		val body = fun.clauses.head.body
		assertEquals(1, body.size)
		val expr = body.head
		println(expr)
		assertTrue(expr instanceof Atom) 
	}

//	@Test
//	def void docsTest_1() {
//		val model = parser.parse('''
//		-module(x).
//		%% c1
//		%% @doc doc1
//		% ignore
//		%% doc2
//		f() ->
//		    %% @ignore
//			ok.
//		''')
//		val entity = model.forms.get(1) as Function
//		assertEquals(entity.name, "f")
//		val docs = entity.docs
//		assertNotNull(docs)
//		val items = docs.items
//		assertEquals(items.size, 2)
//		assertEquals(items.get(0), "%% @doc doc1\n")
//		assertEquals(items.get(1), "%% doc2\n")
//	}
//
//	@Test
//	def void docsTest_2() {
//		val model = parser.parse('''
//			%% c1
//			%% @doc doc1
//			% ignore
//			%% doc2
//			-module(x).
//			f() ->
//				%% @ignore
//				ok.
//		''')
//		val entity = model as Module
//		val docs = entity.docs
//		assertNotNull(docs)
//		val items = docs.items
//		assertEquals(items.size, 2)
//		assertEquals(items.get(0), "%% @doc doc1\n")
//		assertEquals(items.get(1), "%% doc2\n")
//	}
	
}