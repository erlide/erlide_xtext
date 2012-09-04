package org.erlide.builder;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.builder.BooleanOption;
import org.erlide.builder.DefineOption;
import org.erlide.builder.ModuleOption;
import org.erlide.builder.PathsOption;
import org.erlide.builder.WarningOption;

@SuppressWarnings("all")
public abstract class CompilerOption {
  public static BooleanOption COMPRESSED = new Function0<BooleanOption>() {
    public BooleanOption apply() {
      BooleanOption _booleanOption = new BooleanOption(
        "compressed", 
        false, 
        "Compress beam file", 
        "The compiler will compress the generated object code, which can be useful for embedded systems");
      return _booleanOption;
    }
  }.apply();
  
  public static BooleanOption DEBUG_INFO = new Function0<BooleanOption>() {
    public BooleanOption apply() {
      BooleanOption _booleanOption = new BooleanOption(
        "debug_info", false, "Debug info", 
        "Include debug info in BEAM file");
      return _booleanOption;
    }
  }.apply();
  
  public static BooleanOption ENCRYPT_DEBUG_INFO = new Function0<BooleanOption>() {
    public BooleanOption apply() {
      BooleanOption _booleanOption = new BooleanOption(
        "encrypt_debug_info", false, "Encrypt debug info", 
        "Encrypt debug info, the key will be read from .erlang.crypt");
      return _booleanOption;
    }
  }.apply();
  
  public static DefineOption DEFINE = new Function0<DefineOption>() {
    public DefineOption apply() {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("Name", "Value");
      DefineOption _defineOption = new DefineOption("d", ((String[])Conversions.unwrapArray(_newArrayList, String.class)), "", "");
      return _defineOption;
    }
  }.apply();
  
  public static WarningOption WARN_UNUSED_RECORD = new Function0<WarningOption>() {
    public WarningOption apply() {
      WarningOption _warningOption = new WarningOption(
        "warn_unused_record", true, "Unused records", "Unused records");
      return _warningOption;
    }
  }.apply();
  
  public static WarningOption WARN_UNUSED_VARS = new Function0<WarningOption>() {
    public WarningOption apply() {
      WarningOption _warningOption = new WarningOption(
        "warn_unused_vars", true, "Unused variables", "Unused variables");
      return _warningOption;
    }
  }.apply();
  
  public static WarningOption WARN_UNUSED_IMPORT = new Function0<WarningOption>() {
    public WarningOption apply() {
      WarningOption _warningOption = new WarningOption(
        "warn_unused_import", false, "Unused imports", 
        "Unused imported functions");
      return _warningOption;
    }
  }.apply();
  
  public static WarningOption WARN_OBSOLETE_GUARD = new Function0<WarningOption>() {
    public WarningOption apply() {
      WarningOption _warningOption = new WarningOption(
        "warn_obsolete_guard", false, "Obsolete guards", 
        "Old type testing BIFs such as pid/1 and list/1");
      return _warningOption;
    }
  }.apply();
  
  public static WarningOption WARN_DEPRECATED_FUNCTION = new Function0<WarningOption>() {
    public WarningOption apply() {
      WarningOption _warningOption = new WarningOption(
        "warn_deprecated_function", true, "Deprecated functions", 
        "Call to a function known by the compiler to be deprecated");
      return _warningOption;
    }
  }.apply();
  
  public static WarningOption WARN_UNUSED_FUNCTION = new Function0<WarningOption>() {
    public WarningOption apply() {
      WarningOption _warningOption = new WarningOption(
        "warn_unused_function", true, "Unused functions", 
        "Local functions are not being called");
      return _warningOption;
    }
  }.apply();
  
  public static WarningOption WARN_SHADOW_VARS = new Function0<WarningOption>() {
    public WarningOption apply() {
      WarningOption _warningOption = new WarningOption(
        "warn_shadow_vars", 
        false, 
        "Shadowed variables", 
        "Warn for \"fresh\" variables in functional objects or list comprehensions with the same name as some already defined variable");
      return _warningOption;
    }
  }.apply();
  
  public static WarningOption WARN_EXPORT_VARS = new Function0<WarningOption>() {
    public WarningOption apply() {
      WarningOption _warningOption = new WarningOption(
        "warn_export_vars", 
        false, 
        "Implicitely exported variables", 
        "Warn for implicitly exported variables referred to after the primitives where they were first defined");
      return _warningOption;
    }
  }.apply();
  
  public static WarningOption WARN_EXPORT_ALL = new Function0<WarningOption>() {
    public WarningOption apply() {
      WarningOption _warningOption = new WarningOption(
        "warn_export_all", false, "Use of export_all", 
        "The compiler option export_all");
      return _warningOption;
    }
  }.apply();
  
  public static PathsOption INCLUDE_DIRS = new Function0<PathsOption>() {
    public PathsOption apply() {
      PathsOption _pathsOption = new PathsOption("i", 
        "Additional include dirs: ", "Comma-separated list of paths");
      return _pathsOption;
    }
  }.apply();
  
  public static ModuleOption PARSE_TRANSFORM = new Function0<ModuleOption>() {
    public ModuleOption apply() {
      ModuleOption _moduleOption = new ModuleOption(
        "parse_transform", "Global parse transform module: ", 
        "Specify a module to be used as a global parse transform");
      return _moduleOption;
    }
  }.apply();
  
  public static Collection<WarningOption> WARNINGS = new Function0<Collection<WarningOption>>() {
    public Collection<WarningOption> apply() {
      ArrayList<WarningOption> _newArrayList = CollectionLiterals.<WarningOption>newArrayList(CompilerOption.WARN_EXPORT_ALL, CompilerOption.WARN_EXPORT_VARS, CompilerOption.WARN_SHADOW_VARS, 
        CompilerOption.WARN_UNUSED_FUNCTION, CompilerOption.WARN_DEPRECATED_FUNCTION, 
        CompilerOption.WARN_OBSOLETE_GUARD, CompilerOption.WARN_UNUSED_IMPORT, CompilerOption.WARN_UNUSED_VARS, 
        CompilerOption.WARN_UNUSED_RECORD);
      return _newArrayList;
    }
  }.apply();
  
  public static Collection<CompilerOption> ALL_OPTIONS = new Function0<Collection<CompilerOption>>() {
    public Collection<CompilerOption> apply() {
      ArrayList<CompilerOption> _newArrayList = CollectionLiterals.<CompilerOption>newArrayList(CompilerOption.INCLUDE_DIRS, CompilerOption.PARSE_TRANSFORM, CompilerOption.DEFINE, CompilerOption.COMPRESSED, 
        CompilerOption.DEBUG_INFO, CompilerOption.ENCRYPT_DEBUG_INFO, CompilerOption.WARN_EXPORT_ALL, 
        CompilerOption.WARN_EXPORT_VARS, CompilerOption.WARN_SHADOW_VARS, CompilerOption.WARN_UNUSED_FUNCTION, 
        CompilerOption.WARN_DEPRECATED_FUNCTION, CompilerOption.WARN_OBSOLETE_GUARD, 
        CompilerOption.WARN_UNUSED_IMPORT, CompilerOption.WARN_UNUSED_VARS, CompilerOption.WARN_UNUSED_RECORD);
      return _newArrayList;
    }
  }.apply();
  
  public final String name;
  
  public final String description;
  
  public final String tooltip;
  
  public CompilerOption(final String name, final String description, final String tooltip) {
    this.name = name;
    this.description = description;
    this.tooltip = tooltip;
  }
  
  public static CompilerOption find(final String data) {
    for (final CompilerOption option : CompilerOption.ALL_OPTIONS) {
      boolean _equals = data.equals(option.name);
      if (_equals) {
        return option;
      }
    }
    String _plus = ("Invalid value for compiler option: " + data);
    IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus);
    throw _illegalArgumentException;
  }
}
