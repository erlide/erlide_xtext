package org.erlide.builder;

import com.google.common.base.Objects;
import com.google.inject.Injector;
import java.util.Map;
import javax.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.BuilderPlugin;
import org.erlide.builder.BuildersProvider;
import org.erlide.builder.MakeBuilder;

@SuppressWarnings("all")
public class ErlangBuilder extends IncrementalProjectBuilder {
  public static String BUILDER_ID = "org.erlide.builder.erlangBuilder";
  
  public static String OLD_BUILDER_ID = "org.erlide.core.erlbuilder";
  
  public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem";
  
  @Inject
  private BuilderMarkerUpdater markerUpdater;
  
  @Inject
  private BuildersProvider builderProvider;
  
  @Inject
  private IWorkspace wspace;
  
  public ErlangBuilder() {
    InputOutput.<String>println("CREATED BUILDER 1");
    BuilderPlugin _instance = BuilderPlugin.getInstance();
    Injector _injector = _instance.getInjector();
    _injector.injectMembers(this);
    this.builderProvider.loadBuilders();
  }
  
  public ErlangBuilder(final BuilderMarkerUpdater markerUpdater, final BuildersProvider builderProvider) {
    InputOutput.<String>println("CREATED BUILDER 2");
    this.markerUpdater = markerUpdater;
    this.builderProvider = builderProvider;
    builderProvider.loadBuilders();
  }
  
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor monitor) throws CoreException {
    String _plus = ("INJECT " + this.wspace);
    InputOutput.<String>println(_plus);
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
    this.markerUpdater.clean(_project_1, ErlangBuilder.MARKER_TYPE);
  }
}
