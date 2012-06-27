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
import com.google.inject.Provider
import org.eclipse.xtext.resource.XtextResourceSet

import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*
import org.erlide.erlang.Macro

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ErlangLinkingTest {

    @Inject
    ErlangTestingHelper parser
    @Inject
    extension ModelExtensions 
    @Inject
    extension ErlangLinkingHelper
	@Inject
	extension ErlangTestExtensions 
	@Inject
	Provider<XtextResourceSet> resourceSetProvider
	
    @Test
    def void resolve_noLink() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				[§ok, 0].
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.atomReference, is(nullValue))
    } 

    @Test
    def void resolve_localCall() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				§g(3),
				ok.
			§g(X) -> X.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	val tgt = module.getObjectAtMarker(1)
    	assertThat(atom.atomReference, is(tgt))
    } 

    @Test
    def void resolve_localCall_spec() {
    	val module = parser.parse('''
			-module(m).
			-spec §f() -> 'ok'.
			§f() ->
				g(3),
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	val tgt = module.getObjectAtMarker(1)
    	assertThat(atom.atomReference, is(tgt))
    } 

    @Test
    def void resolve_remoteCall() {
    	val module = parser.parse('''
			-module(m).
			-export([g/1]).
			f() ->
				m:§g(3),
				ok.
			§g(X) -> ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	val tgt = module.getObjectAtMarker(1)
    	assertThat(atom.atomReference, is(tgt))
    } 
    
    @Test
    def void resolve_remoteCall_2() {
    	val rset = resourceSetProvider.get()
    	val module = parser.parse('''
			-module(m).
			f() ->
				w:§g(3),
				ok.
        ''', "m.erl", rset)
    	val module2 = parser.parse('''
			-module(w).
			-export([g/1]).
			§g(X) -> ok.
        ''', "w.erl", rset)
    	
    	val atom = module.objectAtMarker as Atom
    	val tgt = module2.objectAtMarker
    	assertThat(atom.atomReference, is(tgt))
    } 
    
    @Test
    def void resolve_remoteCall_bad_1() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				m:§g(3),
				ok.
			g(X) -> ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.atomReference, is(nullValue))
    } 
    
    @Test
    def void resolve_remoteCall_moduleMacro() {
    	val module = parser.parse('''
			-module(m).
			-export([g/1]).
			f() ->
				?MODULE:§g(3),
				ok.
			§g(X) -> X.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	val tgt = module.getObjectAtMarker(1)
    	assertThat(atom.atomReference, is(tgt))
    } 
    
    @Test
    def void resolve_remoteCall_bad() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				W:§g(3),
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.atomReference, is(nullValue))
    } 
    
    @Test
    def void resolve_remoteCall_moduleMacro_bad() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				?MODULE:§g(3),
				ok.
			§g(X) -> X.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.atomReference, is(nullValue))
    } 
    
    @Test
    def void resolve_moduleCall() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				§w:g(3),
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	val tgt = module.getObjectAtMarker(1)
    	// TODO
    	assertThat(atom.atomReference, is(nullValue))
    } 
    
    @Test
    def void resolve_moduleCall_1() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				§w:G(3),
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	val tgt = module.getObjectAtMarker(1)
    	// TODO
    	assertThat(atom.atomReference, is(nullValue))
    } 
    
    @Test
    def void resolve_moduleRef() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				fun §w:g/3,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	// TODO
    	assertThat(atom.atomReference, is(nullValue))
    }
     
    @Test
    def void resolve_functionRef_local() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				fun §g/2,
				ok.
			§g(X,Y) -> ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	val tgt = module.getObjectAtMarker(1)
    	assertThat(atom.atomReference, is(tgt))
    } 
    
    @Test
    def void resolve_functionRef_remote() {
    	val module = parser.parse('''
			-module(m).
			-export([g/2]).
			f() ->
				fun m:§g/2,
				ok.
			§g(X,Y) -> ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	val tgt = module.getObjectAtMarker(1)
    	assertThat(atom.atomReference, is(tgt))
    } 
    
    @Test
    def void resolve_functionRef_remote_bad() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				fun m:§g/2,
				ok.
			§g(X,Y) -> ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.atomReference, is(nullValue))
    } 
    
    @Test
    def void resolve_functionRef_remote_2() {
    	val rset = resourceSetProvider.get()
    	val module = parser.parse('''
			-module(m).
			f() ->
				fun w:§g/2,
				ok.
        ''', "m.erl", rset)
    	val module2 = parser.parse('''
			-module(w).
			-export([g/2]).
			§g(X,Y) -> ok.
        ''', "w.erl", rset)
    	
    	val atom = module.objectAtMarker as Atom
    	val tgt = module2.objectAtMarker
    	assertThat(atom.atomReference, is(tgt))
    } 
    
    @Test
    def void resolve_functionRef_remote_2_bad() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				fun w:§g/2,
				ok.
        ''')
    	val module2 = parser.parse('''
			-module(m).
			§g(X,Y) -> ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.atomReference, is(nullValue))
    } 
    
    @Test
    def void resolve_functionRef_moduleMacro() {
    	val module = parser.parse('''
			-module(m).
			-export([g/2]).
			f() ->
				fun ?MODULE:§g/2,
				ok.
			§g(X,Y) -> ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	val tgt = module.getObjectAtMarker(1)
    	assertThat(atom.atomReference, is(tgt))
    } 
    
    @Test
    def void resolve_functionRef_bad() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				fun W:§g/2,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.atomReference, is(nullValue))
    } 
    
    @Test
    def void resolve_record() {
    	val module = parser.parse('''
			-module(m).
			§-record(myrec, {}).
			f() ->
				#§myrec{},
				ok.
        ''')
    	
    	val atom = module.getObjectAtMarker(1) as Atom
    	val tgt = module.getObjectAtMarker(0)
    	assertThat(atom.atomReference, is(tgt))
    } 
    
    @Test
    def void resolve_record_bad() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				#§myrec{},
				ok.
        ''')
    	
    	val atom = module.getObjectAtMarker(0) as Atom
    	assertThat(atom.atomReference, is(nullValue))
    } 
    
    @Test
    def void resolve_record_1() {
    	val module = parser.parse('''
			-module(m).
			§-record(myrec, {}).
			f() ->
				#§myrec.az,
				ok.
        ''')
    	
    	val atom = module.getObjectAtMarker(1) as Atom
    	val tgt = module.getObjectAtMarker(0)
    	assertThat(atom.atomReference, is(tgt))
    } 
    
    @Test
    def void resolve_recordField() {
    	val module = parser.parse('''
			-module(m).
			-record(myrec, {§ff}).
			f() ->
				#myrec.§ff,
				ok.
        ''')
    	
    	val atom = module.getObjectAtMarker(1) as Atom
    	val tgt = module.getObjectAtMarker(0)
    	assertThat(atom.atomReference, is(tgt))
    } 

    @Test
    def void resolve_recordField_bad() {
    	val module = parser.parse('''
			-module(m).
			f() ->
				#Myrec.§ff,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.atomReference, is(nullValue))
    } 

    @Test
    def void resolve_recordField_bad_1() {
    	val module = parser.parse('''
			-module(m).
			-record(myrec, {gg}).
			f() ->
				#myrec.§ff,
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.atomReference, is(nullValue))
    } 

    @Test
    def void resolve_recordField_1() {
    	val module = parser.parse('''
			-module(m).
			-record(myrec, {§ff}).
			f() ->
				#myrec{§ff=2},
				ok.
        ''')
    	
    	val atom = module.getObjectAtMarker(1) as Atom
    	val tgt = module.getObjectAtMarker(0)
    	assertThat(atom.atomReference, is(tgt))
    }
    
    @Test
    def void resolve_recordField_1_bad() {
    	val module = parser.parse('''
			-module(m).
			-record(myrec, {gg}).
			f() ->
				#Myrec{§ff=2},
				ok.
        ''')
    	
    	val atom = module.objectAtMarker as Atom
    	assertThat(atom.atomReference, is(nullValue))
    } 
 
    @Test
    def void resolve_macro() {
    	val module = parser.parse('''
			-module(m).
			§-define(Z, zz).
			f() ->
				?§Z,
				ok.
        ''')
    	
    	val macro = module.getObjectAtMarker(1) as Macro
    	val tgt = module.getObjectAtMarker(0)
    	assertThat(macro.macroReference, is(tgt))
    } 
 
    @Test
    def void resolve_macro_atom() {
    	val module = parser.parse('''
			-module(m).
			§-define(z, zz).
			f() ->
				?§z,
				ok.
        ''')
    	
    	val macro = module.getObjectAtMarker(1) as Macro
    	val tgt = module.getObjectAtMarker(0)
    	assertThat(macro.macroReference, is(tgt))
    } 
 
    @Test
    def void resolve_macro_1() {
    	val module = parser.parse('''
			-module(m).
			§-define(Z, zz).
			-ifdef(§Z).
			-endif.
        ''')
    	
    	val macro = module.getObjectAtMarker(1) as Macro
    	val tgt = module.getObjectAtMarker(0)
    	assertThat(macro.macroReference, is(tgt))
    } 
 
    @Test
    def void resolve_macro_1_atom() {
    	val module = parser.parse('''
			-module(m).
			§-define(z, zz).
			-ifdef(§z).
			-endif.
        ''')
    	
    	val macro = module.getObjectAtMarker(1) as Macro
    	val tgt = module.getObjectAtMarker(0)
    	assertThat(macro.macroReference, is(tgt))
    } 
 }