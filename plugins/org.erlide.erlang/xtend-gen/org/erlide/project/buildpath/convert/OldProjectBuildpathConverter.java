package org.erlide.project.buildpath.convert;

import com.ericsson.otp.erlang.RuntimeVersion;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
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
import org.erlide.project.buildpath.BuildpathApp;
import org.erlide.project.buildpath.BuildpathEntry;
import org.erlide.project.buildpath.BuildpathFolder;
import org.erlide.project.buildpath.BuildpathLibrary;
import org.erlide.project.buildpath.FolderKind;
import org.erlide.project.buildpath.convert.OldErlangProjectProperties;
import org.erlide.project.buildpath.convert.PathExpander;

@SuppressWarnings("all")
public class OldProjectBuildpathConverter {
  /**
   * Old-style projects will be converted to a buildpath consisting of the
   * following containers:
   * <ul>
   * <li>the project proper, with folders for all source & include paths</li>
   * <li>the OTP library</li>
   * <li>referenced projects</li>
   * </ul>
   * 
   * If "external modules" has references to modules not in any referenced
   * project, they will be lost. We could scan and compare to the projects, in
   * order to extract the real external libraries, but at the moment it feels
   * too much work for too little benefit.
   * 
   * Project must have an old Erlang nature.
   */
  public BuildpathEntry convert(final IProject project) {
    try {
      BuildpathEntry _xblockexpression = null;
      {
        PathExpander _pathExpander = new PathExpander();
        Path _path = new Path(".settings/modules.erlidex");
        HashMap<String, String> _newHashMap = CollectionLiterals.<String, String>newHashMap();
        final Collection<IPath> externals = _pathExpander.expandFile(_path, _newHashMap);
        OldErlangProjectProperties _oldProjectProperties = this.getOldProjectProperties(project);
        String _name = project.getName();
        IProject[] _referencedProjects = project.getReferencedProjects();
        final Function1<IProject, String> _function = new Function1<IProject, String>() {
          @Override
          public String apply(final IProject it) {
            return it.getName();
          }
        };
        List<String> _map = ListExtensions.<IProject, String>map(((List<IProject>)Conversions.doWrapArray(_referencedProjects)), _function);
        _xblockexpression = this.convert(_oldProjectProperties, _name, _map, externals);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public BuildpathEntry convert(final OldErlangProjectProperties properties, final String name, final Collection<String> refProjects, final Collection<IPath> externals) {
    String _debugPrint = this.debugPrint(properties);
    String _plus = ("CONVERTING " + _debugPrint);
    InputOutput.<String>println(_plus);
    final BuildpathLibrary result = new BuildpathLibrary(null, "root");
    final BuildpathApp crt = this.newApp(result);
    Collection<IPath> _sourceDirs = properties.getSourceDirs();
    final Consumer<IPath> _function = new Consumer<IPath>() {
      @Override
      public void accept(final IPath it) {
        OldProjectBuildpathConverter.this.newFolder(crt, it, FolderKind.SOURCE);
      }
    };
    _sourceDirs.forEach(_function);
    Collection<IPath> _includeDirs = properties.getIncludeDirs();
    final Consumer<IPath> _function_1 = new Consumer<IPath>() {
      @Override
      public void accept(final IPath it) {
        OldProjectBuildpathConverter.this.newFolder(crt, it, FolderKind.INCLUDE);
      }
    };
    _includeDirs.forEach(_function_1);
    Collection<IPath> _outputDirs = properties.getOutputDirs();
    final Consumer<IPath> _function_2 = new Consumer<IPath>() {
      @Override
      public void accept(final IPath it) {
        OldProjectBuildpathConverter.this.newFolder(crt, it, FolderKind.EBIN);
      }
    };
    _outputDirs.forEach(_function_2);
    RuntimeVersion _runtimeVersion = properties.getRuntimeVersion();
    String _string = _runtimeVersion.toString();
    final BuildpathLibrary otp = this.newLibrary(result, _string);
    final Consumer<String> _function_3 = new Consumer<String>() {
      @Override
      public void accept(final String it) {
        OldProjectBuildpathConverter.this.newLibrary(result, it);
      }
    };
    refProjects.forEach(_function_3);
    try {
      final Function1<IPath, String> _function_4 = new Function1<IPath, String>() {
        @Override
        public String apply(final IPath it) {
          String[] _segments = it.segments();
          return IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_segments)));
        }
      };
      Iterable<String> _map = IterableExtensions.<IPath, String>map(externals, _function_4);
      final Set<String> roots = IterableExtensions.<String>toSet(_map);
      for (final String root : roots) {
        this.newLibrary(result, root);
      }
    } catch (final Throwable _t) {
      if (_t instanceof FileNotFoundException) {
        final FileNotFoundException e = (FileNotFoundException)_t;
        InputOutput.<String>println(("? " + e));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return result;
  }
  
  public OldErlangProjectProperties getOldProjectProperties(final IProject project) {
    return new OldErlangProjectProperties(project);
  }
  
  public String debugPrint(final OldErlangProjectProperties props) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Properties {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("src = �PathSerializer::packList(props.sourceDirs)�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("inc = �PathSerializer::packList(props.includeDirs)�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("out = �PathSerializer::packList(props.outputDirs)�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ver = �props.runtimeVersion�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmd = �props.externalModulesFile�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xin = �props.externalIncludesFile�");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public BuildpathLibrary newLibrary(final BuildpathLibrary parent, final String name) {
    final BuildpathLibrary result = new BuildpathLibrary(parent, name);
    parent.addChild(result);
    return result;
  }
  
  public BuildpathApp newApp(final BuildpathLibrary parent) {
    final BuildpathApp result = new BuildpathApp(parent);
    parent.addChild(result);
    return result;
  }
  
  public BuildpathFolder newFolder(final BuildpathApp parent, final IPath path, final FolderKind kind) {
    final BuildpathFolder result = new BuildpathFolder(parent, null, path, kind);
    parent.addFolder(result);
    return result;
  }
}
