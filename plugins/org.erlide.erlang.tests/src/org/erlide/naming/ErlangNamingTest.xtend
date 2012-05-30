package org.erlide.naming

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.Module
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.erlide.erlang.IfdefAttribute
import org.erlide.erlang.ConditionalFormBlock

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangNamingTest {

    @Inject
    ParseHelper<Module> parser
	@Inject
	IQualifiedNameProvider namer
	@Inject
	IQualifiedNameConverter nameCvtr

	@Test
	def void moduleName() {
        val module = parser.parse('''
            -module(x).
        ''')
        val name = namer.getFullyQualifiedName(module)
        assertThat(name.toString, is("x")) 
	}

	@Test
	def void recordName() {
        val module = parser.parse('''
            -module(x).
            -record(y, {}).
        ''')
        val name = namer.getFullyQualifiedName(module.forms.tail.head)
        assertThat(nameCvtr.toString(name), is("x:#y_1")) 
	}

	@Test
	def void ifdefName() {
        val module = parser.parse('''
            -module(x).
            -ifdef(M).
            -record(y, {}).
            -else.
            -record(y, {}).
            -endif.
        ''')
        val dfn = module.forms.get(1) as ConditionalFormBlock
        val name1 = namer.getFullyQualifiedName(dfn.ifForms.head)
        assertThat(nameCvtr.toString(name1), is("x:#y_1")) 
        val name2 = namer.getFullyQualifiedName(dfn.elseForms.head)
        assertThat(nameCvtr.toString(name2), is("x:#y_2")) 
	}
}