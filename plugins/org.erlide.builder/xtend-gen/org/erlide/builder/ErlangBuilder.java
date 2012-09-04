package org.erlide.builder;

import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.IErlangBuilder;
import org.erlide.builder.resourcecompiler.ErlCompiler;

@SuppressWarnings("all")
public class ErlangBuilder extends IncrementalProjectBuilder {
  public static String BUILDER_ID = "org.erlide.builder.erlangBuilder";
  
  public static String OLD_BUILDER_ID = "org.erlide.core.erlbuilder";
  
  public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem";
  
  private Map<String,IErlangBuilder> builders;
  
  private BuilderMarkerUpdater markerUpdater;
  
  public ErlangBuilder() {
    this(new Function0<BuilderMarkerUpdater>() {
      public BuilderMarkerUpdater apply() {
        BuilderMarkerUpdater _builderMarkerUpdater = new BuilderMarkerUpdater(ErlangBuilder.MARKER_TYPE);
        return _builderMarkerUpdater;
      }
    }.apply());
  }
  
  public ErlangBuilder(final BuilderMarkerUpdater markerUpdater) {
    HashMap<String,IErlangBuilder> _newHashMap = CollectionLiterals.<String, IErlangBuilder>newHashMap();
    this.builders = _newHashMap;
    this.loadBuilders();
    this.markerUpdater = markerUpdater;
  }
  
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor monitor) throws CoreException {
    IProject _project = this.getProject();
    final IErlangBuilder compiler = this.builders.get(_project);
    boolean _equals = Objects.equal(compiler, null);
    if (_equals) {
    } else {
    }
    IProject _project_1 = this.getProject();
    SubProgressMonitor _subProgressMonitor = new SubProgressMonitor(monitor, 10);
    _project_1.refreshLocal(IResource.DEPTH_INFINITE, _subProgressMonitor);
    return null;
  }
  
  protected void clean(final IProgressMonitor monitor) throws CoreException {
    IProject _project = this.getProject();
    String _builderId = this.getBuilderId(_project);
    final IErlangBuilder builder = this.builders.get(_builderId);
    boolean _equals = Objects.equal(builder, null);
    if (_equals) {
    } else {
      builder.clean(monitor);
    }
    IProject _project_1 = this.getProject();
    this.markerUpdater.clean(_project_1);
  }
  
  private String getBuilderId(final IProject project) {
    return ErlCompiler.COMPILER_ID;
  }
  
  private void loadBuilders() {
    final IExtensionRegistry reg = Platform.getExtensionRegistry();
    final IConfigurationElement[] elements = reg.getConfigurationElementsFor("org.erlide.builder.builders");
    for (final IConfigurationElement element : elements) {
      try {
        Object _createExecutableExtension = element.createExecutableExtension("class");
        final IErlangBuilder builder = ((IErlangBuilder) _createExecutableExtension);
        IProject _project = this.getProject();
        builder.setProject(_project);
        IProject _project_1 = this.getProject();
        String _builderId = this.getBuilderId(_project_1);
        this.builders.put(_builderId, builder);
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException e = (CoreException)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
}
