package org.erlide.builder.resourcecompiler

import com.ericsson.otp.erlang.OtpErlang
import com.ericsson.otp.erlang.OtpErlangAtom
import com.ericsson.otp.erlang.OtpErlangList
import com.ericsson.otp.erlang.OtpErlangObject
import com.ericsson.otp.erlang.OtpErlangString
import com.google.common.base.Joiner
import com.google.common.base.Splitter
import com.google.common.base.Strings
import java.util.Collection
import java.util.List
import org.eclipse.core.runtime.Assert
import org.erlide.common.util.TermParser

import org.eclipse.xtext.xbase.lib.Pair

abstract class CompilerOption {

	public static BooleanOption COMPRESSED = new BooleanOption(
			"compressed",
			false,
			"Compress beam file",
			"The compiler will compress the generated object code, which can be useful for embedded systems")
	public static BooleanOption DEBUG_INFO = new BooleanOption(
			"debug_info", false, "Debug info",
			"Include debug info in BEAM file")
	public static BooleanOption ENCRYPT_DEBUG_INFO = new BooleanOption(
			"encrypt_debug_info", false, "Encrypt debug info",
			"Encrypt debug info, the key will be read from .erlang.crypt")
	public static DefineOption DEFINE = new DefineOption("d", newArrayList("Name", "Value"), "", "")

	public static WarningOption WARN_UNUSED_RECORD = new WarningOption(
			"warn_unused_record", true, "Unused records", "Unused records")
	public static WarningOption WARN_UNUSED_VARS = new WarningOption(
			"warn_unused_vars", true, "Unused variables", "Unused variables")
	public static WarningOption WARN_UNUSED_IMPORT = new WarningOption(
			"warn_unused_import", false, "Unused imports",
			"Unused imported functions")
	public static WarningOption WARN_OBSOLETE_GUARD = new WarningOption(
			"warn_obsolete_guard", false, "Obsolete guards",
			"Old type testing BIFs such as pid/1 and list/1")
	public static WarningOption WARN_DEPRECATED_FUNCTION = new WarningOption(
			"warn_deprecated_function", true, "Deprecated functions",
			"Call to a function known by the compiler to be deprecated")
	public static WarningOption WARN_UNUSED_FUNCTION = new WarningOption(
			"warn_unused_function", true, "Unused functions",
			"Local functions are not being called")
	public static  WarningOption WARN_SHADOW_VARS = new WarningOption(
			"warn_shadow_vars",
			false,
			"Shadowed variables",
			"Warn for \"fresh\" variables in functional objects or list comprehensions with the same name as some already defined variable")
	public static  WarningOption WARN_EXPORT_VARS = new WarningOption(
			"warn_export_vars",
			false,
			"Implicitely exported variables",
			"Warn for implicitly exported variables referred to after the primitives where they were first defined")
	public static  WarningOption WARN_EXPORT_ALL = new WarningOption(
			"warn_export_all", false, "Use of export_all",
			"The compiler option export_all")
	public static PathsOption INCLUDE_DIRS = new PathsOption("i",
			"Additional include dirs: ", "Comma-separated list of paths")
	public static ModuleOption PARSE_TRANSFORM = new ModuleOption(
			"parse_transform", "Global parse transform module: ",
			"Specify a module to be used as a global parse transform")

	public static  Collection<WarningOption> WARNINGS = 
			newArrayList(WARN_EXPORT_ALL, WARN_EXPORT_VARS, WARN_SHADOW_VARS,
					WARN_UNUSED_FUNCTION, WARN_DEPRECATED_FUNCTION,
					WARN_OBSOLETE_GUARD, WARN_UNUSED_IMPORT, WARN_UNUSED_VARS,
					WARN_UNUSED_RECORD)
	public static  Collection<CompilerOption> ALL_OPTIONS = 
			newArrayList(INCLUDE_DIRS, PARSE_TRANSFORM, DEFINE, COMPRESSED,
					DEBUG_INFO, ENCRYPT_DEBUG_INFO, WARN_EXPORT_ALL,
					WARN_EXPORT_VARS, WARN_SHADOW_VARS, WARN_UNUSED_FUNCTION,
					WARN_DEPRECATED_FUNCTION, WARN_OBSOLETE_GUARD,
					WARN_UNUSED_IMPORT, WARN_UNUSED_VARS, WARN_UNUSED_RECORD)

	public val String name
	public val String description
	public val String tooltip

	new(String name,  String description, String tooltip) {
		this.name = name
		this.description = description
		this.tooltip = tooltip
	}

	def static CompilerOption find(String data) {
		for (CompilerOption option : ALL_OPTIONS) {
			if (data.equals(option.name)) {
				return option
			}
		}
		throw new IllegalArgumentException(
				"Invalid value for compiler option: " + data)
	}
}

class BooleanOption extends CompilerOption {
	boolean defaultValue

	new(String name, boolean defaultValue, String description, String tooltip) {
		super(name, description, tooltip)
		this.defaultValue = defaultValue
	}

	def boolean getDefaultValue() {
		defaultValue
	}

	def OtpErlangObject toTerm(boolean currentValue) {
		if (currentValue) {
			new OtpErlangAtom(name)
		} else {
			null
		}
	}
}

class WarningOption extends BooleanOption {

	new(String name, boolean defaultValue, String description,  String tooltip) {
		super(name, defaultValue, description, tooltip)
	}

	override OtpErlangObject toTerm(boolean currentValue) {
		if (currentValue) {
			new OtpErlangAtom(name)
		} else {
			new OtpErlangAtom("no" + name)
		}
	}
}

class DefineOption extends CompilerOption {
	List<String> fieldLabels

	new(String name, String[] fieldLabels,
			 String description,  String tooltip) {
		super(name, description, tooltip)
		this.fieldLabels = fieldLabels
		Assert::isLegal(fieldLabels.size == 2)
	}

	def String[] getFieldLabels() {
		return fieldLabels
	}

	def OtpErlangList toTerm(Collection<Pair<String, String>> values) {
		val List<OtpErlangObject> defines = newArrayList()
		for (Pair<String, String> value : values) {
			val String key = value.key
			val String val1 = value.value

			val OtpErlangAtom tag = new OtpErlangAtom(name)
			val OtpErlangAtom okey = new OtpErlangAtom(key)
			if (Strings::isNullOrEmpty(val1)) {
				defines.add(OtpErlang::mkTuple(tag, okey))
			} else {
				 val OtpErlangObject ovalue = TermParser::getParser().parse(val1)
				defines.add(OtpErlang::mkTuple(tag, okey, ovalue))
			}
		}
		return OtpErlang::mkList(defines)
	}
}

class ModuleOption extends CompilerOption {
	new(String name, String description, String tooltip) {
		super(name, description, tooltip)
	}

	def OtpErlangObject toTerm(String value) {
		OtpErlang::mkTuple(new OtpErlangAtom(name), new OtpErlangAtom(value))
	}

	def static String toString(String value) {
		value
	}

	def static String fromString(String string) {
		string
	}
}

class PathsOption extends CompilerOption {
	new(String name, String description, String tooltip) {
		super(name, description, tooltip)
	}

	def OtpErlangObject toTerm(Iterable<String> value) {
		val List<OtpErlangObject> result = newArrayList()
		for ( String path : value) {
			result.add(new OtpErlangString(path))
		}
		OtpErlang::mkTuple(new OtpErlangAtom(name), OtpErlang::mkList(result))
	}

	def static String toString(Iterable<String> value) {
		Joiner::on(',').join(value)
	}

	def static Iterable<String> fromString(String string) {
		Splitter::on(',').trimResults().omitEmptyStrings().split(string)
	}

}

