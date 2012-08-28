package org.erlide.project.buildpath.convert;

import com.ericsson.otp.erlang.RuntimeVersion;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.project.buildpath.BuildpathContainer;
import org.erlide.project.buildpath.BuildpathFolder;
import org.erlide.project.buildpath.IBuildpathContainer;
import org.erlide.project.buildpath.IBuildpathContainer.ContainerKind;
import org.erlide.project.buildpath.IBuildpathEntry;
import org.erlide.project.buildpath.IBuildpathFolder;
import org.erlide.project.buildpath.IBuildpathFolder.FolderKind;
import org.erlide.project.buildpath.convert.IOldProjectBuildpathConverter;
import org.erlide.project.buildpath.convert.OldErlangProjectProperties;
import org.erlide.project.buildpath.convert.PathExpander;
import org.erlide.project.buildpath.convert.PathSerializer;

@SuppressWarnings("all")
public class OldProjectBuildpathConverter implements IOldProjectBuildpathConverter {
  public IBuildpathEntry convert(final IProject project) {
    try {
      IBuildpathEntry _xblockexpression = null;
      {
        PathExpander _pathExpander = new PathExpander();
        Path _path = new Path(".settings/modules.erlidex");
        HashMap<String,String> _newHashMap = CollectionLiterals.<String, String>newHashMap();
        final Collection<IPath> externals = _pathExpander.expandFile(_path, _newHashMap);
        OldErlangProjectProperties _oldProjectProperties = this.getOldProjectProperties(project);
        String _name = project.getName();
        IProject[] _referencedProjects = project.getReferencedProjects();
        final Function1<IProject,String> _function = new Function1<IProject,String>() {
            public String apply(final IProject it) {
              String _name = it.getName();
              return _name;
            }
          };
        List<String> _map = ListExtensions.<IProject, String>map(((List<IProject>)Conversions.doWrapArray(_referencedProjects)), _function);
        IBuildpathEntry _convert = this.convert(_oldProjectProperties, _name, _map, externals);
        _xblockexpression = (_convert);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IBuildpathEntry convert(final OldErlangProjectProperties properties, final String name, final Collection<String> refProjects, final Collection<IPath> externals) {
    String _debugPrint = this.debugPrint(properties);
    String _plus = ("CONVERTING " + _debugPrint);
    InputOutput.<String>println(_plus);
    BuildpathContainer _buildpathContainer = new BuildpathContainer(null, "root", ContainerKind.ROOT);
    final BuildpathContainer result = _buildpathContainer;
    final IBuildpathContainer crt = this.newContainer(result, name, ContainerKind.FRAGMENT);
    Collection<IPath> _sourceDirs = properties.getSourceDirs();
    final Procedure1<IPath> _function = new Procedure1<IPath>() {
        public void apply(final IPath it) {
          String _lastSegment = it.lastSegment();
          OldProjectBuildpathConverter.this.newFolder(crt, _lastSegment, it, FolderKind.SOURCE);
        }
      };
    IterableExtensions.<IPath>forEach(_sourceDirs, _function);
    Collection<IPath> _includeDirs = properties.getIncludeDirs();
    final Procedure1<IPath> _function_1 = new Procedure1<IPath>() {
        public void apply(final IPath it) {
          String _lastSegment = it.lastSegment();
          OldProjectBuildpathConverter.this.newFolder(crt, _lastSegment, it, FolderKind.INCLUDE);
        }
      };
    IterableExtensions.<IPath>forEach(_includeDirs, _function_1);
    Collection<IPath> _outputDirs = properties.getOutputDirs();
    final Procedure1<IPath> _function_2 = new Procedure1<IPath>() {
        public void apply(final IPath it) {
          String _lastSegment = it.lastSegment();
          OldProjectBuildpathConverter.this.newFolder(crt, _lastSegment, it, FolderKind.EBIN);
        }
      };
    IterableExtensions.<IPath>forEach(_outputDirs, _function_2);
    RuntimeVersion _runtimeVersion = properties.getRuntimeVersion();
    String _string = _runtimeVersion.toString();
    final IBuildpathContainer otp = this.newContainer(result, _string, ContainerKind.OTP);
    final Procedure1<String> _function_3 = new Procedure1<String>() {
        public void apply(final String it) {
          OldProjectBuildpathConverter.this.newContainer(result, it, ContainerKind.LIBRARY);
        }
      };
    IterableExtensions.<String>forEach(refProjects, _function_3);
    try {
      final Function1<IPath,String> _function_4 = new Function1<IPath,String>() {
          public String apply(final IPath it) {
            String[] _segments = it.segments();
            String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_segments)));
            return _head;
          }
        };
      Iterable<String> _map = IterableExtensions.<IPath, String>map(externals, _function_4);
      final Set<String> roots = IterableExtensions.<String>toSet(_map);
      for (final String root : roots) {
        this.newContainer(result, root, ContainerKind.LIBRARY);
      }
    } catch (final Throwable _t) {
      if (_t instanceof FileNotFoundException) {
        final FileNotFoundException e = (FileNotFoundException)_t;
        String _plus_1 = ("? " + e);
        InputOutput.<String>println(_plus_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return result;
  }
  
  public OldErlangProjectProperties getOldProjectProperties(final IProject project) {
    OldErlangProjectProperties _oldErlangProjectProperties = new OldErlangProjectProperties(project);
    return _oldErlangProjectProperties;
  }
  
  public String debugPrint(final OldErlangProjectProperties props) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Properties {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src = ");
    Collection<IPath> _sourceDirs = props.getSourceDirs();
    String _packList = PathSerializer.packList(_sourceDirs);
    _builder.append(_packList, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("inc = ");
    Collection<IPath> _includeDirs = props.getIncludeDirs();
    String _packList_1 = PathSerializer.packList(_includeDirs);
    _builder.append(_packList_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("out = ");
    Collection<IPath> _outputDirs = props.getOutputDirs();
    String _packList_2 = PathSerializer.packList(_outputDirs);
    _builder.append(_packList_2, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("ver = ");
    RuntimeVersion _runtimeVersion = props.getRuntimeVersion();
    _builder.append(_runtimeVersion, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("xmd = ");
    String _externalModulesFile = props.getExternalModulesFile();
    _builder.append(_externalModulesFile, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("xin = ");
    String _externalIncludesFile = props.getExternalIncludesFile();
    _builder.append(_externalIncludesFile, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public IBuildpathContainer newContainer(final IBuildpathContainer parent, final String name, final ContainerKind kind) {
    BuildpathContainer _buildpathContainer = new BuildpathContainer(parent, name, kind);
    final BuildpathContainer result = _buildpathContainer;
    parent.addChild(result);
    return result;
  }
  
  public IBuildpathFolder newFolder(final IBuildpathContainer parent, final String name, final IPath path, final FolderKind kind) {
    BuildpathFolder _buildpathFolder = new BuildpathFolder(parent, name, null, path, kind);
    final BuildpathFolder result = _buildpathFolder;
    parent.addChild(result);
    return result;
  }
}
