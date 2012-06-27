package org.erlide.erlang.util;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.erlang.Module;

@SuppressWarnings("all")
public class ErlangTestingHelper {
  @Inject
  private ParseHelper<Module> parser;
  
  public final String MARKER = "\u00A7";
  
  public Pair<Module,List<Integer>> parse(final String string) {
    final Pair<String,List<Integer>> res = this.extractMarkers(string);
    try {
      String _key = res.getKey();
      Module _parse = this.parser.parse(_key);
      List<Integer> _value = res.getValue();
      return Pair.<Module, List<Integer>>of(_parse, _value);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Pair<Module,List<Integer>> parse(final String string, final String uri, final ResourceSet rset) {
    final Pair<String,List<Integer>> res = this.extractMarkers(string);
    try {
      String _key = res.getKey();
      URI _createURI = URI.createURI(uri);
      Module _parse = this.parser.parse(_key, _createURI, rset);
      List<Integer> _value = res.getValue();
      return Pair.<Module, List<Integer>>of(_parse, _value);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Pair<String,List<Integer>> extractMarkers(final String string) {
    final String[] parts = string.split(this.MARKER);
    List<Integer> list = CollectionLiterals.<Integer>newArrayList();
    int _size = ((List<String>)Conversions.doWrapArray(parts)).size();
    boolean _equals = (_size == 1);
    if (_equals) {
      boolean _contains = string.contains(this.MARKER);
      if (_contains) {
        String _get = ((List<String>)Conversions.doWrapArray(parts)).get(0);
        int _length = _get.length();
        list.add(Integer.valueOf(_length));
        String _get_1 = ((List<String>)Conversions.doWrapArray(parts)).get(0);
        return Pair.<String, List<Integer>>of(_get_1, list);
      } else {
        return Pair.<String, List<Integer>>of(string, list);
      }
    }
    final Function1<String,Integer> _function = new Function1<String,Integer>() {
        public Integer apply(final String it) {
          int _length = it.length();
          return Integer.valueOf(_length);
        }
      };
    List<Integer> _map = ListExtensions.<String, Integer>map(((List<String>)Conversions.doWrapArray(parts)), _function);
    ArrayList<Integer> _newArrayList = Lists.<Integer>newArrayList(_map);
    list = _newArrayList;
    int _size_1 = ((List<String>)Conversions.doWrapArray(parts)).size();
    int _minus = (_size_1 - 1);
    list.remove(_minus);
    final List<Integer> result = CollectionLiterals.<Integer>newArrayList();
    final Function2<Integer,Integer,Integer> _function_1 = new Function2<Integer,Integer,Integer>() {
        public Integer apply(final Integer crt, final Integer old) {
          int _xblockexpression = (int) 0;
          {
            final int anew = ((crt).intValue() + (old).intValue());
            result.add(Integer.valueOf(anew));
            _xblockexpression = (anew);
          }
          return Integer.valueOf(_xblockexpression);
        }
      };
    IterableExtensions.<Integer, Integer>fold(list, Integer.valueOf(0), _function_1);
    String _join = IterableExtensions.join(((Iterable<? extends Object>)Conversions.doWrapArray(parts)));
    return Pair.<String, List<Integer>>of(_join, result);
  }
}
