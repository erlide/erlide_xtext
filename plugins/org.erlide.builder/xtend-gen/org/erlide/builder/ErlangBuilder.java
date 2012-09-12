package org.erlide.builder;

import com.google.common.base.Objects;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.BuilderPlugin;
import org.erlide.builder.BuildersProvider;
import org.erlide.builder.IErlangBuilder;
import org.erlide.builder.SgsnBuilder;
import org.erlide.common.NatureConstants;

@SuppressWarnings("all")
public class ErlangBuilder extends IncrementalProjectBuilder {
  public static String BUILDER_ID = "org.erlide.builder.erlangBuilder";
  
  public static String OLD_BUILDER_ID = "org.erlide.core.erlbuilder";
  
  public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem";
  
  @Inject
  private BuilderMarkerUpdater markerUpdater;
  
  @Inject
  private BuildersProvider builderProvider;
  
  public ErlangBuilder() {
    BuilderPlugin _instance = BuilderPlugin.getInstance();
    Injector _injector = _instance.getInjector();
    _injector.injectMembers(this);
  }
  
  public ErlangBuilder(final BuilderMarkerUpdater markerUpdater, final BuildersProvider builderProvider) {
    this.markerUpdater = markerUpdater;
    this.builderProvider = builderProvider;
  }
  
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor monitor) throws CoreException {
    IProject _project = this.getProject();
    this.cleanXtextMarkers(_project);
    IProject _project_1 = this.getProject();
    final IErlangBuilder builder = this.getProjectBuilder(_project_1);
    boolean _equals = Objects.equal(builder, null);
    if (_equals) {
    } else {
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(kind,IncrementalProjectBuilder.FULL_BUILD)) {
          _matched=true;
          builder.fullBuild(monitor);
        }
      }
      if (!_matched) {
        IProject _project_2 = this.getProject();
        IResourceDelta _delta = this.getDelta(_project_2);
        builder.incrementalBuild(_delta, monitor);
      }
    }
    IProject _project_3 = this.getProject();
    SubProgressMonitor _subProgressMonitor = new SubProgressMonitor(monitor, 10);
    _project_3.refreshLocal(IResource.DEPTH_INFINITE, _subProgressMonitor);
    return null;
  }
  
  protected void clean(final IProgressMonitor monitor) throws CoreException {
    IProject _project = this.getProject();
    this.cleanXtextMarkers(_project);
    IProject _project_1 = this.getProject();
    final IErlangBuilder builder = this.getProjectBuilder(_project_1);
    boolean _equals = Objects.equal(builder, null);
    if (_equals) {
    } else {
      builder.clean(monitor);
    }
    IProject _project_2 = this.getProject();
    this.markerUpdater.clean(_project_2, ErlangBuilder.MARKER_TYPE);
  }
  
  public IErlangBuilder getProjectBuilder(final IProject project) {
    IErlangBuilder _xblockexpression = null;
    {
      final String bId = SgsnBuilder.ID;
      final IErlangBuilder builder = this.builderProvider.get(bId);
      builder.setProject(project);
      builder.loadConfiguration();
      _xblockexpression = (builder);
    }
    return _xblockexpression;
  }
  
  private void cleanXtextMarkers(final IProject project) {
    try {
      boolean _hasNature = project.hasNature(NatureConstants.OLD_NATURE_ID);
      if (_hasNature) {
        ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("erlang.check.fast", 
          "erlang.check.normal", 
          "erlang.check.expensive");
        final Procedure1<String> _function = new Procedure1<String>() {
            public void apply(final String it) {
              try {
                String _plus = ("org.erlide.erlang.ui." + it);
                project.deleteMarkers(_plus, true, IResource.DEPTH_INFINITE);
              } catch (Exception _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
        IterableExtensions.<String>forEach(_newArrayList, _function);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
