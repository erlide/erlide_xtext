package org.erlide.project.buildpath.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.erlide.project.buildpath.IBuildpathContainer;
import org.erlide.project.buildpath.IBuildpathContainer.ContainerKind;
import org.erlide.project.buildpath.IBuildpathEntry;
import org.erlide.project.buildpath.IBuildpathFolder;
import org.erlide.project.buildpath.IBuildpathFolder.FolderKind;
import org.erlide.project.buildpath.convert.OldErlangProjectProperties;
import org.erlide.project.buildpath.convert.OldProjectBuildpathConverter;
import org.erlide.project.buildpath.convert.PathExpander;
import org.erlide.project.buildpath.convert.TestContentProvider;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class OldProjectBuildpathConverterTest {
  private PathExpander expander;
  
  private Collection<IPath> externals;
  
  @Before
  public void prepare() {
    TestContentProvider _testContentProvider = new TestContentProvider();
    PathExpander _pathExpander = new PathExpander(_testContentProvider);
    this.expander = _pathExpander;
    Path _path = new Path("foo");
    HashMap<String,String> _newHashMap = CollectionLiterals.<String, String>newHashMap();
    Collection<IPath> _expandFile = this.expander.expandFile(_path, _newHashMap);
    this.externals = _expandFile;
  }
  
  @Test
  public void emptyProperties() {
    OldErlangProjectProperties _oldErlangProjectProperties = new OldErlangProjectProperties();
    final OldErlangProjectProperties props = _oldErlangProjectProperties;
    OldProjectBuildpathConverter _oldProjectBuildpathConverter = new OldProjectBuildpathConverter();
    final OldProjectBuildpathConverter converter = _oldProjectBuildpathConverter;
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar");
    final IBuildpathEntry entry = converter.convert(props, "projname", _newArrayList, this.externals);
    String _debugPrint = this.debugPrint(entry);
    InputOutput.<String>println(_debugPrint);
  }
  
  @Test
  public void demoProperties() {
    OldErlangProjectProperties _oldErlangProjectProperties = new OldErlangProjectProperties();
    final OldErlangProjectProperties props = _oldErlangProjectProperties;
    Path _path = new Path("s1");
    Path _path_1 = new Path("s2");
    IPath[] paths = ((IPath[])Conversions.unwrapArray(CollectionLiterals.<Path>newArrayList(_path, _path_1), IPath.class));
    final IPath[] _converted_paths = (IPath[])paths;
    props.setSourceDirs(((Collection<IPath>)Conversions.doWrapArray(_converted_paths)));
    Path _path_2 = new Path("i1/i1");
    Path _path_3 = new Path("i2");
    ArrayList<Path> _newArrayList = CollectionLiterals.<Path>newArrayList(_path_2, _path_3);
    paths = ((IPath[])Conversions.unwrapArray(_newArrayList, IPath.class));
    OldProjectBuildpathConverter _oldProjectBuildpathConverter = new OldProjectBuildpathConverter();
    final OldProjectBuildpathConverter converter = _oldProjectBuildpathConverter;
    final IPath[] _converted_paths_1 = (IPath[])paths;
    props.setIncludeDirs(((Collection<IPath>)Conversions.doWrapArray(_converted_paths_1)));
    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("bar");
    final IBuildpathEntry entry = converter.convert(props, "projname", _newArrayList_1, this.externals);
    String _debugPrint = this.debugPrint(entry);
    InputOutput.<String>println(_debugPrint);
  }
  
  private String _debugPrint(final IBuildpathContainer container) {
    StringConcatenation _builder = new StringConcatenation();
    ContainerKind _kind = container.getKind();
    _builder.append(_kind, "");
    _builder.append(" \'");
    String _name = container.getName();
    _builder.append(_name, "");
    _builder.append("\' {");
    _builder.newLineIfNotEmpty();
    {
      Collection<IBuildpathEntry> _children = container.getChildren();
      for(final IBuildpathEntry e : _children) {
        _builder.append("\t");
        String _debugPrint = this.debugPrint(e);
        _builder.append(_debugPrint, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _debugPrint(final IBuildpathFolder folder) {
    StringConcatenation _builder = new StringConcatenation();
    FolderKind _kind = folder.getKind();
    _builder.append(_kind, "");
    _builder.append(" @path=\'");
    IPath _path = folder.getPath();
    _builder.append(_path, "");
    _builder.append("\'");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private String _debugPrint(final IBuildpathEntry entry) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Entry { \'");
    String _name = entry.getName();
    _builder.append(_name, "");
    _builder.append("\' }");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private String debugPrint(final IBuildpathEntry container) {
    if (container instanceof IBuildpathContainer) {
      return _debugPrint((IBuildpathContainer)container);
    } else if (container instanceof IBuildpathFolder) {
      return _debugPrint((IBuildpathFolder)container);
    } else if (container != null) {
      return _debugPrint(container);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(container).toString());
    }
  }
}
