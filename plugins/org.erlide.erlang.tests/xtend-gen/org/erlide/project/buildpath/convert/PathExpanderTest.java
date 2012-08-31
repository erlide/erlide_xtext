package org.erlide.project.buildpath.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.project.buildpath.convert.PathExpander;
import org.erlide.project.buildpath.convert.PeTestContentProvider;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

@SuppressWarnings("all")
public class PathExpanderTest {
  @Test
  public void expandPaths() {
    final Map<String,String> pathVars = CollectionLiterals.<String, String>newHashMap();
    PeTestContentProvider _peTestContentProvider = new PeTestContentProvider();
    PathExpander _pathExpander = new PathExpander(_peTestContentProvider);
    final PathExpander expander = _pathExpander;
    Path _path = new Path("demo.erlidex");
    final Collection<IPath> result = expander.expandFile(_path, pathVars);
    final Function1<IPath,String> _function = new Function1<IPath,String>() {
        public String apply(final IPath it) {
          String _portableString = it.toPortableString();
          return _portableString;
        }
      };
    Iterable<String> _map = IterableExtensions.<IPath, String>map(result, _function);
    List<String> _list = IterableExtensions.<String>toList(_map);
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("AAA", "aaa", "bbb", "BBB");
    List<String> _list_1 = IterableExtensions.<String>toList(_newArrayList);
    Matcher<? super List<String>> _is = Matchers.<List<String>>is(_list_1);
    MatcherAssert.<List<String>>assertThat("expandFile failed", _list, _is);
  }
}
