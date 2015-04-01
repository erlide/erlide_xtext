package org.erlide.erlang.util;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.erlide.ErlangInjectorProvider;
import org.erlide.erlang.util.ErlangTestingHelper;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ErlangInjectorProvider.class)
@SuppressWarnings("all")
public class ErlangTestingHelperTest {
  @Inject
  private ErlangTestingHelper parser;
  
  @Test
  public void noMarkers() {
    final String input = "1234567890";
    final Pair<String, List<Integer>> module = this.parser.extractMarkers(input);
    String _key = module.getKey();
    Matcher<? super String> _is = Matchers.<String>is(input);
    MatcherAssert.<String>assertThat(_key, _is);
    List<Integer> _value = module.getValue();
    int _size = _value.size();
    Matcher<? super Integer> _is_1 = Matchers.<Integer>is(Integer.valueOf(0));
    MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is_1);
  }
  
  @Test
  public void oneMarker() {
    final Pair<String, List<Integer>> module = this.parser.extractMarkers("12345�67890");
    String _key = module.getKey();
    Matcher<? super String> _is = Matchers.<String>is("1234567890");
    MatcherAssert.<String>assertThat(_key, _is);
    List<Integer> _value = module.getValue();
    int _size = _value.size();
    Matcher<? super Integer> _is_1 = Matchers.<Integer>is(Integer.valueOf(1));
    MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is_1);
    List<Integer> _value_1 = module.getValue();
    Integer _head = IterableExtensions.<Integer>head(_value_1);
    Matcher<? super Integer> _is_2 = Matchers.<Integer>is(Integer.valueOf(5));
    MatcherAssert.<Integer>assertThat(_head, _is_2);
  }
  
  @Test
  public void severalMarkers() {
    final Pair<String, List<Integer>> module = this.parser.extractMarkers("12345�678�90");
    String _key = module.getKey();
    Matcher<? super String> _is = Matchers.<String>is("1234567890");
    MatcherAssert.<String>assertThat(_key, _is);
    List<Integer> _value = module.getValue();
    int _size = _value.size();
    Matcher<? super Integer> _is_1 = Matchers.<Integer>is(Integer.valueOf(2));
    MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is_1);
    List<Integer> _value_1 = module.getValue();
    Integer _head = IterableExtensions.<Integer>head(_value_1);
    Matcher<? super Integer> _is_2 = Matchers.<Integer>is(Integer.valueOf(5));
    MatcherAssert.<Integer>assertThat(_head, _is_2);
    List<Integer> _value_2 = module.getValue();
    Iterable<Integer> _tail = IterableExtensions.<Integer>tail(_value_2);
    Integer _head_1 = IterableExtensions.<Integer>head(_tail);
    Matcher<? super Integer> _is_3 = Matchers.<Integer>is(Integer.valueOf(8));
    MatcherAssert.<Integer>assertThat(_head_1, _is_3);
  }
  
  @Test
  public void firstMarker() {
    final Pair<String, List<Integer>> module = this.parser.extractMarkers("�1234567890");
    String _key = module.getKey();
    Matcher<? super String> _is = Matchers.<String>is("1234567890");
    MatcherAssert.<String>assertThat(_key, _is);
    List<Integer> _value = module.getValue();
    int _size = _value.size();
    Matcher<? super Integer> _is_1 = Matchers.<Integer>is(Integer.valueOf(1));
    MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is_1);
    List<Integer> _value_1 = module.getValue();
    Integer _head = IterableExtensions.<Integer>head(_value_1);
    Matcher<? super Integer> _is_2 = Matchers.<Integer>is(Integer.valueOf(0));
    MatcherAssert.<Integer>assertThat(_head, _is_2);
  }
  
  @Test
  public void lastMarker() {
    final Pair<String, List<Integer>> module = this.parser.extractMarkers("1234567890�");
    String _key = module.getKey();
    Matcher<? super String> _is = Matchers.<String>is("1234567890");
    MatcherAssert.<String>assertThat(_key, _is);
    List<Integer> _value = module.getValue();
    int _size = _value.size();
    Matcher<? super Integer> _is_1 = Matchers.<Integer>is(Integer.valueOf(1));
    MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is_1);
    List<Integer> _value_1 = module.getValue();
    Integer _head = IterableExtensions.<Integer>head(_value_1);
    Matcher<? super Integer> _is_2 = Matchers.<Integer>is(Integer.valueOf(10));
    MatcherAssert.<Integer>assertThat(_head, _is_2);
  }
  
  @Test
  public void succesiveMarkers() {
    final Pair<String, List<Integer>> module = this.parser.extractMarkers("123456��7890");
    String _key = module.getKey();
    Matcher<? super String> _is = Matchers.<String>is("1234567890");
    MatcherAssert.<String>assertThat(_key, _is);
    List<Integer> _value = module.getValue();
    int _size = _value.size();
    Matcher<? super Integer> _is_1 = Matchers.<Integer>is(Integer.valueOf(2));
    MatcherAssert.<Integer>assertThat(Integer.valueOf(_size), _is_1);
    List<Integer> _value_1 = module.getValue();
    Integer _head = IterableExtensions.<Integer>head(_value_1);
    Matcher<? super Integer> _is_2 = Matchers.<Integer>is(Integer.valueOf(6));
    MatcherAssert.<Integer>assertThat(_head, _is_2);
    List<Integer> _value_2 = module.getValue();
    Iterable<Integer> _tail = IterableExtensions.<Integer>tail(_value_2);
    Integer _head_1 = IterableExtensions.<Integer>head(_tail);
    Matcher<? super Integer> _is_3 = Matchers.<Integer>is(Integer.valueOf(6));
    MatcherAssert.<Integer>assertThat(_head_1, _is_3);
  }
}
