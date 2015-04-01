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
import org.erlide.project.buildpath.BuildpathApp;
import org.erlide.project.buildpath.BuildpathEntry;
import org.erlide.project.buildpath.BuildpathFolder;
import org.erlide.project.buildpath.BuildpathLibrary;
import org.erlide.project.buildpath.convert.OldErlangProjectProperties;
import org.erlide.project.buildpath.convert.OldProjectBuildpathConverter;
import org.erlide.project.buildpath.convert.OpbTestContentProvider;
import org.erlide.project.buildpath.convert.PathExpander;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class OldProjectBuildpathConverterTest {
  private PathExpander expander;
  
  private Collection<IPath> externals;
  
  @Before
  public void prepare() {
    OpbTestContentProvider _opbTestContentProvider = new OpbTestContentProvider();
    PathExpander _pathExpander = new PathExpander(_opbTestContentProvider);
    this.expander = _pathExpander;
    Path _path = new Path("foo");
    HashMap<String, String> _newHashMap = CollectionLiterals.<String, String>newHashMap();
    Collection<IPath> _expandFile = this.expander.expandFile(_path, _newHashMap);
    this.externals = _expandFile;
  }
  
  @Test
  public void emptyProperties() {
    final OldErlangProjectProperties props = new OldErlangProjectProperties();
    final OldProjectBuildpathConverter converter = new OldProjectBuildpathConverter();
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar");
    final BuildpathEntry entry = converter.convert(props, "projname", _newArrayList, this.externals);
    String _debugPrint = this.debugPrint(entry);
    InputOutput.<String>println(_debugPrint);
  }
  
  @Test
  public void demoProperties() {
    final OldErlangProjectProperties props = new OldErlangProjectProperties();
    Path _path = new Path("s1");
    Path _path_1 = new Path("s2");
    IPath[] paths = ((IPath[])Conversions.unwrapArray(CollectionLiterals.<IPath>newArrayList(_path, _path_1), IPath.class));
    final IPath[] _converted_paths = (IPath[])paths;
    props.setSourceDirs(((Collection<IPath>)Conversions.doWrapArray(_converted_paths)));
    Path _path_2 = new Path("i1/i1");
    Path _path_3 = new Path("i2");
    ArrayList<IPath> _newArrayList = CollectionLiterals.<IPath>newArrayList(_path_2, _path_3);
    paths = ((IPath[])Conversions.unwrapArray(_newArrayList, IPath.class));
    final OldProjectBuildpathConverter converter = new OldProjectBuildpathConverter();
    final IPath[] _converted_paths_1 = (IPath[])paths;
    props.setIncludeDirs(((Collection<IPath>)Conversions.doWrapArray(_converted_paths_1)));
    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("bar");
    final BuildpathEntry entry = converter.convert(props, "projname", _newArrayList_1, this.externals);
    String _debugPrint = this.debugPrint(entry);
    InputOutput.<String>println(_debugPrint);
  }
  
  private String _debugPrint(final BuildpathLibrary container) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("LIB \'�container.name�\' {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�FOR e: container.apps�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�e.debugPrint�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�FOR e: container.libraries�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�e.debugPrint�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _debugPrint(final BuildpathApp container) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("APP {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�FOR e: container.folders�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�e.debugPrint�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _debugPrint(final BuildpathFolder folder) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�folder.kind� path=\'�folder.path�\' inc=�folder.inclusionPatterns� exc=�folder.exclusionPatterns�");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String debugPrint(final BuildpathEntry container) {
    if (container instanceof BuildpathApp) {
      return _debugPrint((BuildpathApp)container);
    } else if (container instanceof BuildpathFolder) {
      return _debugPrint((BuildpathFolder)container);
    } else if (container instanceof BuildpathLibrary) {
      return _debugPrint((BuildpathLibrary)container);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(container).toString());
    }
  }
}
