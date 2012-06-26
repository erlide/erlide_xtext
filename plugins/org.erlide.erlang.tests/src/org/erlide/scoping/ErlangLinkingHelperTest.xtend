package org.erlide.scoping

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.erlide.ErlangInjectorProvider
import org.erlide.erlang.Atom
import org.erlide.erlang.ErlangTestExtensions
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.util.ErlangTestingHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangLinkingHelperTest {
	
    @Inject
    ErlangTestingHelper parser
    @Inject
    extension ModelExtensions
    @Inject
    extension ErlangLinkingHelper
	@Inject
	extension ErlangTestExtensions 
    
    @Test
    def void classify_noLink() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				§ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::NONE))
    } 

    @Test
    def void classify_localCall() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				§g(3),
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::FUNCTION_CALL_LOCAL))
    } 

    @Test
    def void classify_remoteCall() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				w:§g(3),
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::FUNCTION_CALL_REMOTE))
    } 
    
    @Test
    def void classify_remoteCall_moduleMacro() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				?MODULE:§g(3),
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::FUNCTION_CALL_REMOTE))
    } 
    
    @Test
    def void classify_remoteCall_bad() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				W:§g(3),
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::NONE))
    } 
    
    @Test
    def void classify_moduleCall() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				§w:g(3),
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::MODULE))
    } 
    
    @Test
    def void classify_moduleCall_1() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				§w:G(3),
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::MODULE))
    } 
    
    @Test
    def void classify_moduleRef() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				fun §w:g/3,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::MODULE))
    }
     
    @Test
    def void classify_functionRef() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				fun w:§g/2,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::FUNCTION_REF))
    } 
    
    @Test
    def void classify_functionRef_moduleMacro() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				fun ?MODULE:§g/2,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::FUNCTION_REF))
    } 
    
    @Test
    def void classify_functionRef_bad() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				fun W:§g/2,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::NONE))
    } 
    
    @Test
    def void classify_functionRef_local() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				fun §g/2,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::FUNCTION_REF))
    } 
    
    @Test
    def void classify_record() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				#§myrec{},
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::RECORD))
    } 
    
    @Test
    def void classify_record_1() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				#§myrec.az,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::RECORD))
    } 
    
    @Test
    def void classify_recordField() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				#myrec.§ff,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::RECORD_FIELD))
    } 

    @Test
    def void classify_recordField_bad() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				#Myrec.§ff,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::NONE))
    } 

    @Test
    def void classify_recordField_1() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				#myrec{§ff=2},
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::RECORD_FIELD))
    }
    
    @Test
    def void classify_recordField_1_bad() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				#Myrec{§ff=2},
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.classifyAtom, is(ErlangLinkCategory::NONE))
    } 
 
	
     
}