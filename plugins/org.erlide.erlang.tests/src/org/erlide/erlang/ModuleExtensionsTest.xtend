package org.erlide.erlang

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.erlide.ErlangInjectorProvider
import org.junit.Test
import org.junit.runner.RunWith

import static org.erlide.erlang.IsFunRefMatcher.*
import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ErlangInjectorProvider))
class ModuleExtensionsTest extends AbstractErlangTests {
	
    @Inject
    ParseHelper<Module> parser
    @Inject
    extension ModelExtensions 
	
    @Test
    def void moduleName() {
        val module = parser.parse('''
            -module(x).
        ''')
        val myname = module.name 
        assertThat(myname, is("x")) 
    }

    @Test
    def void moduleNameWithComments() {
        val module = parser.parse('''
            %% comment
            -module(x).
        ''')
        val myname = module.name 
        assertThat(myname, is("x")) 
    }
    
    @Test
    def void noModuleName() {
        val module = parser.parse('''
            -include("x").
        ''')
        val myname = module.name 
        assertThat(myname, is(nullValue)) 
    }

    @Test
    def void headerHasNoName() {
        val module = parser.parse('''
            -include("x").
        ''')
        assertThat(module.isHeader, is(true))
    }
    
    @Test
    def void fullModuleHasName() {
        val module = parser.parse('''
            -module(x).
        ''')
        assertThat(module.isHeader, is(false))
    }
 
    @Test
    def void getAttributes() {
        val module = parser.parse('''
            -module(x).
            -define(X, ok).
            foo() -> ok.
            -foo(bar).
        ''')
        val attrs = module.attributes
        assertThat(attrs.size, is(3))
    }
    
    @Test
    def void getCustomAttributesByTag() {
        val module = parser.parse('''
            -module(x).
            -foo(baz).
            -define(X, ok).
            foo() -> ok.
            -foo(bar).
        ''')
        val attrs = module.getCustomAttributesWithTag("foo")
        assertThat(attrs.size, is(2))
        assertThat(attrs.head.tag, is("foo"))
        assertThat(attrs.tail.head.tag, is("foo"))
    }
 
    @Test
    def void getExportFunctions() {
        val module = parser.parse('''
            -module(x).
            -export([bar/0, baz/1]).
            -export([foo/0]).
            bar()->ok.
            baz(X)->ok.
            foo()->ok.
        ''')
        val attrs = module.exportedFunctions
        assertThat(attrs.size, is(3))
        
        assertThat(attrs.head, isFunction("bar", 0))
        assertThat(attrs.tail.head, isFunction("baz", 1))
        assertThat(attrs.tail.tail.head, isFunction("foo", 0))
    }

    @Test
    def void getExportFunRefs() {
        val module = parser.parse('''
            -module(x).
            -export([bar/0, baz/1]).
            -export([foo/0]).
        ''')
        val attrs = module.exportedFunRefs
        assertThat(attrs.size, is(3))
        
        assertThat(attrs.head, isFunRef("bar", 0))
        assertThat(attrs.tail.head, isFunRef("baz", 1))
        assertThat(attrs.tail.tail.head, isFunRef("foo", 0))
    }

    @Test
    def void getFunction() {
        val module = parser.parse('''
            -module(x).
            bar()->ok.
            baz(X)->ok.
            foo()->ok.
        ''')

        val bar = module.getFunction("bar", 0)
        assertThat(bar, is(notNullValue))
        assertThat(bar, isFunction("bar", 0))
    }
    
    @Test
    def void getUndefinedFunction() {
        val module = parser.parse('''
            -module(x).
            bar()->ok.
            baz(X)->ok.
            foo()->ok.
        ''')

        val bar1 = module.getFunction("bar", 1)
        assertThat(bar1, is(nullValue))
    }
 
   @Test
    def void getIncludes() {
        val module = parser.parse('''
            -module(x).
            -include("bar.hrl").
        ''')

        val bar1 = module.includes
        assertThat(bar1.head, is("\"bar.hrl\""))
    }
 
   @Test
    def void getIncludeLibs() {
        val module = parser.parse('''
            -module(x).
            -include_lib("foo.hrl").
        ''')

        val bar1 = module.includeLibs
        assertThat(bar1.head, is("\"foo.hrl\""))
    }
 
   @Test
    def void exportsAll() {
        val module = parser.parse('''
            -module(x).
            -compile(export_all).
        ''')

        val bar1 = module.exportsAll
        assertThat(bar1, is(true))
    }
 
   @Test
    def void exportsAll_no() {
        val module = parser.parse('''
            -module(x).
        ''')

        val bar1 = module.exportsAll
        assertThat(bar1, is(false))
    }
 
   @Test
    def void exportsAll_2() {
        val module = parser.parse('''
            -module(x).
            -compile([debug_info, export_all]).
        ''')

        val bar1 = module.exportsAll
        assertThat(bar1, is(true))
    }
 
   @Test
    def void getParseTransform() {
        val module = parser.parse('''
            -module(x).
            -compile({parse_transform, x}).
        ''')

        val bar1 = module.parseTransforms
        assertThat(bar1.head.sourceText, is("x"))
    }
 
   @Test
    def void getParseTransform_2() {
        val module = parser.parse('''
            -module(x).
            -compile([debug_info, {parse_transform, x}]).
        ''')

        val bar1 = module.parseTransforms
        assertThat(bar1.size, is(1))
        assertThat(bar1.head.sourceText, is("x"))
    }
 
    @Test
    def void getParseTransform_3() {
        val module = parser.parse('''
            -module(x).
            -compile([{parse_transform, x}]).
            -compile({parse_transform, y}).
        ''')

        val bar1 = module.parseTransforms
        assertThat(bar1.size, is(2))
        assertThat(bar1.map[sourceText], hasItem("x"))
        assertThat(bar1.map[sourceText], hasItem("y"))
    }
 
   @Test
    def void getCompileOptions() {
        val module = parser.parse('''
            -module(x).
            -compile([debug_info, {parse_transform, x}]).
            -compile([debug_info, {parse_transform, x}]).
        ''')

        val opts = module.compileOptions
        assertThat(opts.size, is(2))
    }
 
 
//    @Test
//    def void getCompilerOptions_none() {
//        val module = parser.parse('''
//            -module(x).
//        ''')
//
//        val opts = module.compilerOptions
//        assertThat(opts.size, is(0))
//    }
// 
//    @Test
//    def void getCompilerOptions_one() {
//        val module = parser.parse('''
//            -module(x).
//            -compile(export_all).
//        ''')
//
//        val opts = module.compilerOptions
//        assertThat(opts.size, is(1))
//        assertThat(opts.head.name, is("export_all"))
//    }
//
//    @Test
//    def void getCompilerOptions_two() {
//        val module = parser.parse('''
//            -module(x).
//            -compile(export_all).
//            -compile(debug_info).
//        ''')
//
//        val opts = module.compilerOptions
//        assertThat(opts.size, is(2))
//        assertThat(opts.head.name, is("export_all"))
//        assertThat(opts.tail.head.name, is("debug_info"))
//    }
//
//    @Test
//    def void getCompilerOptions_many() {
//        val module = parser.parse('''
//            -module(x).
//            -compile(export_all).
//            -compile([debug_info, warn_export_all]).
//        ''')
//
//        val opts = module.compilerOptions
//        assertThat(opts.size, is(3))
//        assertThat(opts.head.name, is("export_all"))
//        assertThat(opts.tail.head.name, is("debug_info"))
//        assertThat(opts.tail.tail.head.name, is("warn_export_all"))
//    }
//
//    @Test
//    def void getCompilerOptions_many_merged() {
//        val module = parser.parse('''
//            -module(x).
//            -compile([debug_info, export_all]).
//            -compile([debug_info, warn_export_all]).
//        ''')
//
//        val opts = module.compilerOptions
//        assertThat(opts.size, is(3))
//        assertThat(opts.head.name, is("debug_info"))
//        assertThat(opts.tail.head.name, is("export_all"))
//        assertThat(opts.tail.tail.head.name, is("warn_export_all"))
//    }
//
//    @Test
//    def void getCompilerOptions_tuple() {
//        val module = parser.parse('''
//            -module(x).
//            -compile([{d, Macro}]).
//        ''')
//
//        val opts = module.compilerOptions
//        assertThat(opts.size, is(1))
//        val opt = opts.head as DefineOption
//        assertThat(opt.name, is("d"))
//    }

}