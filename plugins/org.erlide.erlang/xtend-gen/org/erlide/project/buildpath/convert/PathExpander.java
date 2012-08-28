package org.erlide.project.buildpath.convert;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.project.buildpath.convert.AbstractContentProvider;
import org.erlide.project.buildpath.convert.FileContentProvider;

@SuppressWarnings("all")
public class PathExpander {
  private AbstractContentProvider provider;
  
  public PathExpander() {
    FileContentProvider _fileContentProvider = new FileContentProvider();
    this.provider = _fileContentProvider;
  }
  
  public PathExpander(final AbstractContentProvider provider) {
    this.provider = provider;
  }
  
  public Collection<IPath> expandFileList(final Collection<IPath> files, final Map<String,String> pathVars) {
    final Function1<IPath,Collection<IPath>> _function = new Function1<IPath,Collection<IPath>>() {
        public Collection<IPath> apply(final IPath it) {
          Collection<IPath> _expandFile = PathExpander.this.expandFile(it, pathVars);
          return _expandFile;
        }
      };
    Iterable<Collection<IPath>> _map = IterableExtensions.<IPath, Collection<IPath>>map(files, _function);
    Iterable<IPath> _flatten = Iterables.<IPath>concat(_map);
    ImmutableSet<IPath> _copyOf = ImmutableSet.<IPath>copyOf(((IPath[])Conversions.unwrapArray(_flatten, IPath.class)));
    return _copyOf;
  }
  
  public Collection<IPath> expandFile(final IPath file, final Map<String,String> pathVars) {
    Collection<IPath> _xblockexpression = null;
    {
      final IPath xfile = this.replacePathVar(pathVars, file);
      Collection<IPath> _xifexpression = null;
      String _fileExtension = xfile.getFileExtension();
      boolean _equals = Objects.equal(_fileExtension, "erlidex");
      if (_equals) {
        Collection<IPath> _expandFileContents = this.expandFileContents(xfile, pathVars);
        _xifexpression = _expandFileContents;
      } else {
        ArrayList<IPath> _newArrayList = CollectionLiterals.<IPath>newArrayList(file);
        _xifexpression = _newArrayList;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public Collection<IPath> expandFileContents(final IPath file, final Map<String,String> pathVars) {
    Collection<IPath> _xblockexpression = null;
    {
      final Collection<String> lines = this.provider.get(file);
      final Function1<String,IPath> _function = new Function1<String,IPath>() {
          public IPath apply(final String it) {
            Path _path = new Path(it);
            return ((IPath) _path);
          }
        };
      Iterable<IPath> _map = IterableExtensions.<String, IPath>map(lines, _function);
      final List<IPath> paths = IterableExtensions.<IPath>toList(_map);
      Collection<IPath> _expandFileList = this.expandFileList(paths, pathVars);
      _xblockexpression = (_expandFileList);
    }
    return _xblockexpression;
  }
  
  public IPath replacePathVar(final Map<String,String> pathVars, final IPath path) {
    String[] _segments = path.segments();
    final String head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_segments)));
    boolean _containsKey = pathVars.containsKey(head);
    if (_containsKey) {
      String _get = pathVars.get(head);
      Path _path = new Path(_get);
      IPath _removeFirstSegments = path.removeFirstSegments(1);
      return _path.append(_removeFirstSegments);
    }
    return path;
  }
  
  public Iterable<IPath> replacePathVar(final Map<String,String> pathVars, final Collection<IPath> paths) {
    final Function1<IPath,IPath> _function = new Function1<IPath,IPath>() {
        public IPath apply(final IPath it) {
          IPath _replacePathVar = PathExpander.this.replacePathVar(pathVars, it);
          return _replacePathVar;
        }
      };
    Iterable<IPath> _map = IterableExtensions.<IPath, IPath>map(paths, _function);
    return _map;
  }
}
