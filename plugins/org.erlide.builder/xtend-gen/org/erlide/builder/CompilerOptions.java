package org.erlide.builder;

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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.erlide.builder.BooleanOption;
import org.erlide.builder.CompilerOption;
import org.erlide.builder.DefineOption;
import org.erlide.builder.ModuleOption;
import org.erlide.builder.PathsOption;
import org.erlide.builder.WarningOption;
import org.erlide.common.util.ErlLogger;
import org.erlide.common.util.PreferencesHelper;
import org.erlide.common.util.TermParserException;
import org.erlide.common.util.Tuple;
import org.osgi.service.prefs.BackingStoreException;

@SuppressWarnings("all")
public class CompilerOptions {
  private final static String QUALIFIER = ("org.erlide.erlang" + "/compiler");
  
  private final Map<CompilerOption, Object> options;
  
  private PreferencesHelper helper;
  
  public static OtpErlangList get(final IProject project) {
    try {
      final CompilerOptions prefs = new CompilerOptions(project);
      try {
        prefs.load();
      } catch (final Throwable _t) {
        if (_t instanceof BackingStoreException) {
          final BackingStoreException e1 = (BackingStoreException)_t;
          e1.printStackTrace();
          Status _status = new Status(IStatus.ERROR, "org.erlide.erlang", 
            "could not retrieve compiler options");
          throw new CoreException(_status);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return prefs.export();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CompilerOptions() {
    PreferencesHelper _helper = PreferencesHelper.getHelper(CompilerOptions.QUALIFIER);
    this.helper = _helper;
    HashMap<CompilerOption, Object> _newHashMap = CollectionLiterals.<CompilerOption, Object>newHashMap();
    this.options = _newHashMap;
    for (final CompilerOption option : CompilerOption.ALL_OPTIONS) {
      {
        if ((option instanceof BooleanOption)) {
          boolean _defaultValue = ((BooleanOption) option).getDefaultValue();
          this.options.put(option, Boolean.valueOf(_defaultValue));
        }
        if ((option instanceof DefineOption)) {
          ArrayList<Tuple<String, String>> _arrayList = new ArrayList<Tuple<String, String>>();
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
    return this.helper.hasAnyAtLowestScope();
  }
  
  public void store() throws BackingStoreException {
    for (final CompilerOption option : CompilerOption.ALL_OPTIONS) {
      {
        final Object value = this.options.get(option);
        if ((option instanceof BooleanOption)) {
          final Boolean val1 = ((Boolean) value);
          String _string = val1.toString();
          this.helper.putString(((BooleanOption)option).name, _string);
        } else {
          if ((option instanceof PathsOption)) {
            boolean _notEquals = (!Objects.equal(value, null));
            if (_notEquals) {
              final Iterable<String> avalue = ((Iterable<String>) value);
              String _string_1 = PathsOption.toString(avalue);
              this.helper.putString(((PathsOption)option).name, _string_1);
            } else {
              this.helper.remove(((PathsOption)option).name);
            }
          } else {
            if ((option instanceof ModuleOption)) {
              boolean _notEquals_1 = (!Objects.equal(value, null));
              if (_notEquals_1) {
                final String avalue_1 = ((String) value);
                this.helper.putString(((ModuleOption)option).name, avalue_1);
              } else {
                this.helper.remove(((ModuleOption)option).name);
              }
            } else {
              if ((option instanceof DefineOption)) {
                boolean _notEquals_2 = (!Objects.equal(value, null));
                if (_notEquals_2) {
                  final Collection<Tuple<String, String>> val1_1 = ((Collection<Tuple<String, String>>) value);
                  String _string_2 = val1_1.toString();
                  this.helper.putString(((DefineOption)option).name, _string_2);
                } else {
                  this.helper.remove(((DefineOption)option).name);
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
            _xifexpression = Boolean.parseBoolean(value);
          } else {
            _xifexpression = ((BooleanOption) option).getDefaultValue();
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
                  Tuple<String, String> _tuple = new Tuple<String, String>(_head, _head_1);
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
                    final OtpErlangList val1_3 = ((DefineOption) option).toTerm(((List<Pair<String, String>>) optionValue));
                    boolean _notEquals_2 = (!Objects.equal(val1_3, null));
                    if (_notEquals_2) {
                      OtpErlangObject[] _elements = val1_3.elements();
                      ArrayList<OtpErlangObject> _newArrayList = Lists.<OtpErlangObject>newArrayList(_elements);
                      result.addAll(_newArrayList);
                    }
                  } catch (final Throwable _t) {
                    if (_t instanceof TermParserException) {
                      final TermParserException e = (TermParserException)_t;
                      ErlLogger _instance = ErlLogger.getInstance();
                      _instance.warn(e);
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
  
  @Override
  public String toString() {
    OtpErlangList _export = this.export();
    return _export.toString();
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
      _or = _not;
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
  
  public void setOption(final CompilerOption opt, final List<Pair<String, String>> value) {
    boolean _or = false;
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      _or = true;
    } else {
      int _size = value.size();
      boolean _equals_1 = (_size == 0);
      _or = _equals_1;
    }
    if (_or) {
      this.removeOption(opt);
    } else {
      this.options.put(opt, value);
    }
  }
  
  public void setOption(final CompilerOption opt, final Pair<String, String>... values) {
    boolean _or = false;
    boolean _equals = Objects.equal(values, null);
    if (_equals) {
      _or = true;
    } else {
      int _size = ((List<Pair<String, String>>)Conversions.doWrapArray(values)).size();
      boolean _equals_1 = (_size == 0);
      _or = _equals_1;
    }
    if (_or) {
      this.removeOption(opt);
    } else {
      final List<Pair<String, String>> list = CollectionLiterals.<Pair<String, String>>newArrayList(values);
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
  
  public List<Pair<String, String>> getListOption(final DefineOption option) {
    Object _get = this.options.get(option);
    return ((List<Pair<String, String>>) _get);
  }
}
