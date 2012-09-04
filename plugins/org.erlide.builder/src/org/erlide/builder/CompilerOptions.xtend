package org.erlide.builder

import com.ericsson.otp.erlang.OtpErlang
import com.ericsson.otp.erlang.OtpErlangList
import com.ericsson.otp.erlang.OtpErlangObject
import com.google.common.base.Strings
import com.google.common.collect.Lists
import java.util.ArrayList
import java.util.Collection
import java.util.List
import java.util.Map
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.erlide.common.util.ErlLogger
import org.erlide.common.util.TermParserException
import org.erlide.common.util.Tuple
import org.osgi.service.prefs.BackingStoreException

import org.eclipse.xtext.xbase.lib.Pair
import org.erlide.common.util.PreferencesHelper

class CompilerOptions {

    static val String QUALIFIER = "org.erlide.erlang" + "/compiler"
    val Map<CompilerOption, Object> options
    private PreferencesHelper helper

    def static OtpErlangList get(IProject project) {
        val prefs = new CompilerOptions(project)
        try {
            prefs.load()
        } catch (BackingStoreException e1) {
            e1.printStackTrace()
            throw new CoreException(
                    new Status(IStatus::ERROR, "org.erlide.erlang",
                            "could not retrieve compiler options"))
        }
        return prefs.export()
    }

    new() {
        helper = PreferencesHelper::getHelper(QUALIFIER)
        options = newHashMap()
        for (CompilerOption option : CompilerOption::ALL_OPTIONS) {
            if (option instanceof BooleanOption) {
                options.put(option, (option as BooleanOption).getDefaultValue())
            }
            if (option instanceof DefineOption) {
                options.put(option, new ArrayList<Tuple<String, String>>())
            }
        }
    }

    new(IProject project) {
        this()
        helper = PreferencesHelper::getHelper(QUALIFIER, project)
    }

    def boolean hasOptionsAtLowestScope() {
        helper.hasAnyAtLowestScope()
    }

    def void store() throws BackingStoreException {
        for (CompilerOption option : CompilerOption::ALL_OPTIONS) {
            val value = options.get(option)
            if (option instanceof BooleanOption) {
                val val1 = value as Boolean
                helper.putString(option.name, val1.toString())
            } else if (option instanceof PathsOption) {
                if (value != null) {
                    val avalue = value as Iterable<String> 
                    helper.putString(option.name, PathsOption::toString(avalue))
                } else {
                    helper.remove(option.name)
                }
            } else if (option instanceof ModuleOption) {
                if (value != null) {
                    val avalue = value as String
                    helper.putString(option.name, avalue)
                } else {
                    helper.remove(option.name)
                }
            } else if (option instanceof DefineOption) {
                if (value != null) {
                    val val1 = value as Collection<Tuple<String, String>>
                    helper.putString(option.name, val1.toString())
                } else {
                    helper.remove(option.name)
                }
            }
        }
        helper.flush()
    }

    def void load() throws BackingStoreException {
        options.clear()
        for (CompilerOption option : CompilerOption::ALL_OPTIONS) {
            val String value = helper.getString(option.name, null)
            if (option instanceof BooleanOption) {
            	val avalue = if(value != null) Boolean::parseBoolean(value) 
                			 else (option as BooleanOption).getDefaultValue()
                options.put(option, avalue)
            } else if (option instanceof PathsOption) {
                if (!value.isNullOrEmpty) {
                    options.put(option, PathsOption::fromString(value))
                }
            } else if (option instanceof ModuleOption) {
                if (!value.isNullOrEmpty) {
                    options.put(option, value)
                }
            } else if (option instanceof DefineOption) {
                if (value != null) {
                    val str = value.split(",")
                    options.put(option, new Tuple<String, String>(str.head, str.tail.head))
                }
            }
        }
        options.put(CompilerOption::DEBUG_INFO, true)
    }

    def OtpErlangList export() {
        val List<OtpErlangObject> result = newArrayList
        for (CompilerOption option : CompilerOption::ALL_OPTIONS) {
            val optionValue = options.get(option)
            if (optionValue != null) {
                if (option instanceof BooleanOption) {
                    val val1 = (option as BooleanOption).toTerm((optionValue as Boolean).booleanValue())
                    if (val1 != null) {
                        result.add(val1)
                    }
                } else if (option instanceof PathsOption) {
                    val value = optionValue as Iterable<String> 
                    val val1 = (option as PathsOption).toTerm(value)
                    result.add(val1)
                } else if (option instanceof ModuleOption) {
                    val value = optionValue as String
                    val val1 = (option as ModuleOption).toTerm(value)
                    result.add(val1)
                } else if (option instanceof DefineOption) {
                    try {
                        val val1 = (option as DefineOption).toTerm(optionValue as List<Pair<String, String>>)
                        if (val1 != null) {
                            result.addAll(Lists::newArrayList(val1.elements()))
                        }
                    } catch (TermParserException e) {
                        ErlLogger::warn(e)
                    }
                }
            }
        }
        return OtpErlang::mkList(result)
    }

    override String toString() {
        export().toString()
    }

    def void removeAllProjectSpecificSettings() {
        helper.removeAllAtLowestScope()
    }

    def void removeOption(CompilerOption opt) {
        if (opt instanceof WarningOption) {
            options.put(opt, (opt as WarningOption).getDefaultValue())
        } else {
            options.remove(opt)
        }
    }

    def void setPathOption(CompilerOption opt,
            Iterable<String> value) {
        if (value == null || !value.iterator().hasNext()) {
            removeOption(opt)
        } else {
            options.put(opt, value)
        }
    }

    def void setSimpleOption(CompilerOption opt, String value) {
        val newvalue = value.trim()
        if (Strings::isNullOrEmpty(newvalue)) {
            removeOption(opt)
        } else {
            options.put(opt, value)
        }
    }

    def void setOption(CompilerOption opt, List<Pair<String, String>> value) {
        if (value == null || value.size() == 0) {
            removeOption(opt)
        } else {
            options.put(opt, value)
        }
    }

    def void setOption(CompilerOption opt, Pair<String, String>... values) {
        if (values == null || values.size == 0) {
            removeOption(opt)
        } else {
            val List<Pair<String, String>> list = newArrayList(values)
            setOption(opt, list)
        }
    }

    def void setOption(CompilerOption opt,
            boolean selection) {
        options.put(opt, selection)
    }

    def boolean getBooleanOption(CompilerOption opt) {
        val Object value = options.get(opt)
        if (opt instanceof BooleanOption) {
            return (value as Boolean).booleanValue()
        } else {
            return value != null
        }
    }

    def Iterable<String> getPathsOption(PathsOption option) {
        options.get(option) as Iterable<String>
    }

    def String getSimpleOption(ModuleOption option) {
        options.get(option) as String
    }

    def List<Pair<String, String>> getListOption(DefineOption option) {
        options.get(option) as List<Pair<String, String>>
    }

}
