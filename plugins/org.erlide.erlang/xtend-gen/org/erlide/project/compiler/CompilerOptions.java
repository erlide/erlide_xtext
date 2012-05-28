package org.erlide.project.compiler;

import com.ericsson.otp.erlang.OtpErlang;
import com.ericsson.otp.erlang.OtpErlangList;
import com.ericsson.otp.erlang.OtpErlangObject;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.erlide.common.util.ErlLogger;
import org.erlide.common.util.TermParserException;
import org.erlide.common.util.Tuple;
import org.erlide.project.PreferencesHelper;
import org.erlide.project.compiler.BooleanOption;
import org.erlide.project.compiler.CompilerOption;
import org.erlide.project.compiler.DefineOption;
import org.erlide.project.compiler.ModuleOption;
import org.erlide.project.compiler.PathsOption;
import org.erlide.project.compiler.WarningOption;
import org.osgi.service.prefs.BackingStoreException;

@SuppressWarnings("all")
public class CompilerOptions {
  private final static String QUALIFIER = new Function0<String>() {
    public String apply() {
      String _plus = ("org.erlide.erlang" + "/compiler");
      return _plus;
    }
  }.apply();
  
  private final Map<CompilerOption,Object> options;
  
  private PreferencesHelper helper;
  
  public static OtpErlangList get(final IProject project) {
    try {
      CompilerOptions _compilerOptions = new CompilerOptions(project);
      final CompilerOptions prefs = _compilerOptions;
      try {
        prefs.load();
      } catch (final Throwable _t) {
        if (_t instanceof BackingStoreException) {
          final BackingStoreException e1 = (BackingStoreException)_t;
          e1.printStackTrace();
          Status _status = new Status(IStatus.ERROR, "org.erlide.erlang", 
            "could not retrieve compiler options");
          CoreException _coreException = new CoreException(_status);
          throw _coreException;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return prefs.export();
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CompilerOptions() {
    PreferencesHelper _helper = PreferencesHelper.getHelper(CompilerOptions.QUALIFIER);
    this.helper = _helper;
    HashMap<CompilerOption,Object> _newHashMap = CollectionLiterals.<CompilerOption, Object>newHashMap();
    this.options = _newHashMap;
    for (final CompilerOption option : CompilerOption.ALL_OPTIONS) {
      {
        if ((option instanceof BooleanOption)) {
          boolean _defaultValue = ((BooleanOption) option).getDefaultValue();
          this.options.put(option, Boolean.valueOf(_defaultValue));
        }
        if ((option instanceof DefineOption)) {
          ArrayList<Tuple<String,String>> _arrayList = new ArrayList<Tuple<String,String>>();
          this.options.put(option, _arrayList);
        }
      }
    }
  }
  
  public CompilerOptions(final IProject project) {
    this();
    PreferencesHelper _helper = PreferencesHelper.getHelper(CompilerOptions.QUALIFIER, project);
    this.helper = _helper;
  }
  
  public boolean hasOptionsAtLowestScope() {
    boolean _hasAnyAtLowestScope = this.helper.hasAnyAtLowestScope();
    return _hasAnyAtLowestScope;
  }
  
  public void store() throws BackingStoreException {
    for (final CompilerOption option : CompilerOption.ALL_OPTIONS) {
      {
        final Object value = this.options.get(option);
        if ((option instanceof BooleanOption)) {
          final Boolean val1 = ((Boolean) value);
          String _string = val1.toString();
          this.helper.putString(option.name, _string);
        } else {
          if ((option instanceof PathsOption)) {
            boolean _notEquals = (!Objects.equal(value, null));
            if (_notEquals) {
              final Iterable<String> avalue = ((Iterable<String>) value);
              String _string_1 = PathsOption.toString(avalue);
              this.helper.putString(option.name, _string_1);
            } else {
              this.helper.remove(option.name);
            }
          } else {
            if ((option instanceof ModuleOption)) {
              boolean _notEquals_1 = (!Objects.equal(value, null));
              if (_notEquals_1) {
                final String avalue_1 = ((String) value);
                this.helper.putString(option.name, avalue_1);
              } else {
                this.helper.remove(option.name);
              }
            } else {
              if ((option instanceof DefineOption)) {
                boolean _notEquals_2 = (!Objects.equal(value, null));
                if (_notEquals_2) {
                  final Collection<Tuple<String,String>> val1_1 = ((Collection<Tuple<String,String>>) value);
                  String _string_2 = val1_1.toString();
                  this.helper.putString(option.name, _string_2);
                } else {
                  this.helper.remove(option.name);
                }
              }
            }
          }
        }
      }
    }
    this.helper.flush();
  }
  
  public void load() throws BackingStoreException {
    this.options.clear();
    for (final CompilerOption option : CompilerOption.ALL_OPTIONS) {
      {
        final String value = this.helper.getString(option.name, null);
        if ((option instanceof BooleanOption)) {
          boolean _xifexpression = false;
          boolean _notEquals = (!Objects.equal(value, null));
          if (_notEquals) {
            boolean _parseBoolean = Boolean.parseBoolean(value);
            _xifexpression = _parseBoolean;
          } else {
            boolean _defaultValue = ((BooleanOption) option).getDefaultValue();
            _xifexpression = _defaultValue;
          }
          final boolean avalue = _xifexpression;
          this.options.put(option, Boolean.valueOf(avalue));
        } else {
          if ((option instanceof PathsOption)) {
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
            boolean _not = (!_isNullOrEmpty);
            if (_not) {
              Iterable<String> _fromString = PathsOption.fromString(value);
              this.options.put(option, _fromString);
            }
          } else {
            if ((option instanceof ModuleOption)) {
              boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(value);
              boolean _not_1 = (!_isNullOrEmpty_1);
              if (_not_1) {
                this.options.put(option, value);
              }
            } else {
              if ((option instanceof DefineOption)) {
                boolean _notEquals_1 = (!Objects.equal(value, null));
                if (_notEquals_1) {
                  final String[] str = value.split(",");
                  String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(str)));
                  Iterable<String> _tail = IterableExtensions.<String>tail(((Iterable<String>)Conversions.doWrapArray(str)));
                  String _head_1 = IterableExtensions.<String>head(_tail);
                  Tuple<String,String> _tuple = new Tuple<String,String>(_head, _head_1);
                  this.options.put(option, _tuple);
                }
              }
            }
          }
        }
      }
    }
    this.options.put(CompilerOption.DEBUG_INFO, Boolean.valueOf(true));
  }
  
  public OtpErlangList export() {
    final List<OtpErlangObject> result = CollectionLiterals.<OtpErlangObject>newArrayList();
    for (final CompilerOption option : CompilerOption.ALL_OPTIONS) {
      {
        final Object optionValue = this.options.get(option);
        boolean _notEquals = (!Objects.equal(optionValue, null));
        if (_notEquals) {
          if ((option instanceof BooleanOption)) {
            boolean _booleanValue = ((Boolean) optionValue).booleanValue();
            final OtpErlangObject val1 = ((BooleanOption) option).toTerm(_booleanValue);
            boolean _notEquals_1 = (!Objects.equal(val1, null));
            if (_notEquals_1) {
              result.add(val1);
            }
          } else {
            if ((option instanceof PathsOption)) {
              final Iterable<String> value = ((Iterable<String>) optionValue);
              final OtpErlangObject val1_1 = ((PathsOption) option).toTerm(value);
              result.add(val1_1);
            } else {
              if ((option instanceof ModuleOption)) {
                final String value_1 = ((String) optionValue);
                final OtpErlangObject val1_2 = ((ModuleOption) option).toTerm(value_1);
                result.add(val1_2);
              } else {
                if ((option instanceof DefineOption)) {
                  try {
                    final OtpErlangList val1_3 = ((DefineOption) option).toTerm(((List<Pair<String,String>>) optionValue));
                    boolean _notEquals_2 = (!Objects.equal(val1_3, null));
                    if (_notEquals_2) {
                      OtpErlangObject[] _elements = val1_3.elements();
                      ArrayList<OtpErlangObject> _newArrayList = Lists.<OtpErlangObject>newArrayList(((Iterable<? extends OtpErlangObject>)Conversions.doWrapArray(_elements)));
                      result.addAll(_newArrayList);
                    }
                  } catch (final Throwable _t) {
                    if (_t instanceof TermParserException) {
                      final TermParserException e = (TermParserException)_t;
                      ErlLogger.warn(e);
                    } else {
                      throw Exceptions.sneakyThrow(_t);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return OtpErlang.mkList(result);
  }
  
  public String toString() {
    OtpErlangList _export = this.export();
    String _string = _export.toString();
    return _string;
  }
  
  public void removeAllProjectSpecificSettings() {
    this.helper.removeAllAtLowestScope();
  }
  
  public void removeOption(final CompilerOption opt) {
    if ((opt instanceof WarningOption)) {
      boolean _defaultValue = ((WarningOption) opt).getDefaultValue();
      this.options.put(opt, Boolean.valueOf(_defaultValue));
    } else {
      this.options.remove(opt);
    }
  }
  
  public void setPathOption(final CompilerOption opt, final Iterable<String> value) {
    boolean _or = false;
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      _or = true;
    } else {
      Iterator<String> _iterator = value.iterator();
      boolean _hasNext = _iterator.hasNext();
      boolean _not = (!_hasNext);
      _or = (_equals || _not);
    }
    if (_or) {
      this.removeOption(opt);
    } else {
      this.options.put(opt, value);
    }
  }
  
  public void setSimpleOption(final CompilerOption opt, final String value) {
    final String newvalue = value.trim();
    boolean _isNullOrEmpty = Strings.isNullOrEmpty(newvalue);
    if (_isNullOrEmpty) {
      this.removeOption(opt);
    } else {
      this.options.put(opt, value);
    }
  }
  
  public void setOption(final CompilerOption opt, final List<Pair<String,String>> value) {
    boolean _or = false;
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      _or = true;
    } else {
      int _size = value.size();
      boolean _equals_1 = (_size == 0);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      this.removeOption(opt);
    } else {
      this.options.put(opt, value);
    }
  }
  
  public void setOption(final CompilerOption opt, final Pair<String,String>... values) {
    boolean _or = false;
    boolean _equals = Objects.equal(values, null);
    if (_equals) {
      _or = true;
    } else {
      int _size = ((List<Pair<String,String>>)Conversions.doWrapArray(values)).size();
      boolean _equals_1 = (_size == 0);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      this.removeOption(opt);
    } else {
      final List<Pair<String,String>> list = CollectionLiterals.<Pair<String,String>>newArrayList(values);
      this.setOption(opt, list);
    }
  }
  
  public void setOption(final CompilerOption opt, final boolean selection) {
    this.options.put(opt, Boolean.valueOf(selection));
  }
  
  public boolean getBooleanOption(final CompilerOption opt) {
    final Object value = this.options.get(opt);
    if ((opt instanceof BooleanOption)) {
      return ((Boolean) value).booleanValue();
    } else {
      return (!Objects.equal(value, null));
    }
  }
  
  public Iterable<String> getPathsOption(final PathsOption option) {
    Object _get = this.options.get(option);
    return ((Iterable<String>) _get);
  }
  
  public String getSimpleOption(final ModuleOption option) {
    Object _get = this.options.get(option);
    return ((String) _get);
  }
  
  public List<Pair<String,String>> getListOption(final DefineOption option) {
    Object _get = this.options.get(option);
    return ((List<Pair<String,String>>) _get);
  }
}
