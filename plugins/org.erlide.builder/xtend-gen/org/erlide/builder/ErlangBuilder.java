package org.erlide.builder;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.BuildersProvider;
import org.erlide.builder.MakeBuilder;

@SuppressWarnings("all")
public class ErlangBuilder extends IncrementalProjectBuilder {
  public static String BUILDER_ID = "org.erlide.builder.erlangBuilder";
  
  public static String OLD_BUILDER_ID = "org.erlide.core.erlbuilder";
  
  public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem";
  
  private BuilderMarkerUpdater markerUpdater;
  
  public ErlangBuilder() {
    this(new Function0<BuilderMarkerUpdater>() {
      public BuilderMarkerUpdater apply() {
        BuilderMarkerUpdater _builderMarkerUpdater = new BuilderMarkerUpdater(ErlangBuilder.MARKER_TYPE);
        return _builderMarkerUpdater;
      }
    }.apply(), new Function0<BuildersProvider>() {
      public BuildersProvider apply() {
        BuildersProvider _buildersProvider = new BuildersProvider();
        return _buildersProvider;
      }
    }.apply());
  }
  
  public ErlangBuilder(final BuilderMarkerUpdater markerUpdater, final BuildersProvider builderProvider) {
    builderProvider.loadBuilders();
    this.markerUpdater = markerUpdater;
  }
  
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor monitor) throws CoreException {
    IProject _project = this.getProject();
    MakeBuilder _makeBuilder = new MakeBuilder(_project, this.markerUpdater);
    final MakeBuilder builder = _makeBuilder;
    boolean _equals = Objects.equal(builder, null);
    if (_equals) {
    } else {
      builder.fullBuild(monitor);
    }
    IProject _project_1 = this.getProject();
    SubProgressMonitor _subProgressMonitor = new SubProgressMonitor(monitor, 10);
    _project_1.refreshLocal(IResource.DEPTH_INFINITE, _subProgressMonitor);
    return null;
  }
  
  protected void clean(final IProgressMonitor monitor) throws CoreException {
    IProject _project = this.getProject();
    MakeBuilder _makeBuilder = new MakeBuilder(_project, this.markerUpdater);
    final MakeBuilder builder = _makeBuilder;
    boolean _equals = Objects.equal(builder, null);
    if (_equals) {
    } else {
      builder.clean(monitor);
    }
    IProject _project_1 = this.getProject();
    this.markerUpdater.clean(_project_1);
  }
}
