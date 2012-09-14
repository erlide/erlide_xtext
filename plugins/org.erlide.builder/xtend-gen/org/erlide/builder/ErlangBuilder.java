package org.erlide.builder;

import com.google.common.base.Objects;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.erlide.builder.BuilderPlugin;
import org.erlide.builder.BuilderProgressMonitorWrapper;
import org.erlide.builder.BuildersProvider;
import org.erlide.builder.IErlangBuilder;
import org.erlide.builder.SgsnBuilder;
import org.erlide.builder.markers.BuilderMarkerUpdater;
import org.erlide.builder.markers.RemoveMarkersEvent;
import org.erlide.builder.progress.BuilderProgressUpdater;
import org.erlide.common.NatureConstants;
import org.erlide.common.util.ErlLogger;

@SuppressWarnings("all")
public class ErlangBuilder extends IncrementalProjectBuilder {
  public static String BUILDER_ID = "org.erlide.builder.erlangBuilder";
  
  public static String OLD_BUILDER_ID = "org.erlide.core.erlbuilder";
  
  public static String MARKER_TYPE = "org.erlide.builder.erlangBuildProblem";
  
  @Inject
  private BuilderMarkerUpdater markerUpdater;
  
  @Inject
  private BuilderProgressUpdater progressUpdater;
  
  @Inject
  private BuildersProvider builderProvider;
  
  @Inject
  private ErlLogger log;
  
  @Inject
  @Named(value = "erlangBuilder")
  private EventBus builderEventBus;
  
  public ErlangBuilder() {
    BuilderPlugin _instance = BuilderPlugin.getInstance();
    Injector _injector = _instance.getInjector();
    _injector.injectMembers(this);
    this.builderEventBus.register(this);
  }
  
  public ErlangBuilder(final BuilderMarkerUpdater markerUpdater, final BuilderProgressUpdater progressUpdater, final BuildersProvider builderProvider, final EventBus eventBus) {
    this.markerUpdater = markerUpdater;
    this.progressUpdater = progressUpdater;
    this.builderProvider = builderProvider;
    this.builderEventBus = eventBus;
    this.builderEventBus.register(this);
  }
  
  protected IProject[] build(final int kind, final Map<String,String> args, final IProgressMonitor _monitor) throws CoreException {
    final long startTime = System.currentTimeMillis();
    IProject _project = this.getProject();
    this.cleanXtextMarkers(_project);
    try {
      IProgressMonitor _xifexpression = null;
      boolean _notEquals = (!Objects.equal(_monitor, null));
      if (_notEquals) {
        BuilderProgressMonitorWrapper _xblockexpression = null;
        {
          IProject _project_1 = this.getProject();
          String _name = _project_1.getName();
          String _plus = (" building" + _name);
          final String taskName = (_plus + ": ");
          BuilderProgressMonitorWrapper _builderProgressMonitorWrapper = new BuilderProgressMonitorWrapper(_monitor, taskName);
          _xblockexpression = (_builderProgressMonitorWrapper);
        }
        _xifexpression = _xblockexpression;
      } else {
        _xifexpression = _monitor;
      }
      final IProgressMonitor monitor = _xifexpression;
      final SubMonitor progress = SubMonitor.convert(monitor, 1);
      IProject _project_1 = this.getProject();
      final IErlangBuilder builder = this.getProjectBuilder(_project_1);
      boolean _equals = Objects.equal(builder, null);
      if (_equals) {
        IProject _project_2 = this.getProject();
        String _plus = ("Project " + _project_2);
        String _plus_1 = (_plus + " has no Erlang builder");
        this.log.warn(_plus_1);
      } else {
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(kind,IncrementalProjectBuilder.FULL_BUILD)) {
            _matched=true;
            SubMonitor _newChild = progress.newChild(1);
            builder.fullBuild(_newChild);
          }
        }
        if (!_matched) {
          IProject _project_3 = this.getProject();
          IResourceDelta _delta = this.getDelta(_project_3);
          SubMonitor _newChild_1 = progress.newChild(1);
          builder.incrementalBuild(_delta, _newChild_1);
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        this.log.error(e);
        throw e;
      } else if (_t instanceof OperationCanceledException) {
        final OperationCanceledException e_1 = (OperationCanceledException)_t;
        this.forgetLastBuiltState();
        throw e_1;
      } else if (_t instanceof Exception) {
        final Exception e_2 = (Exception)_t;
        this.log.error(e_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      boolean _notEquals_1 = (!Objects.equal(_monitor, null));
      if (_notEquals_1) {
        _monitor.done();
      }
      IProject _project_4 = this.getProject();
      String _name = _project_4.getName();
      String _plus_2 = ("Build " + _name);
      String _plus_3 = (_plus_2 + " in ");
      long _currentTimeMillis = System.currentTimeMillis();
      long _minus = (_currentTimeMillis - startTime);
      String _plus_4 = (_plus_3 + Long.valueOf(_minus));
      String _plus_5 = (_plus_4 + " ms");
      this.log.info(_plus_5);
    }
    IProject _project_5 = this.getProject();
    return _project_5.getReferencedProjects();
  }
  
  protected void clean(final IProgressMonitor monitor) throws CoreException {
    final SubMonitor progress = SubMonitor.convert(monitor, 10);
    IProject _project = this.getProject();
    this.cleanXtextMarkers(_project);
    progress.worked(2);
    try {
      IProject _project_1 = this.getProject();
      final IErlangBuilder builder = this.getProjectBuilder(_project_1);
      boolean _equals = Objects.equal(builder, null);
      if (_equals) {
      } else {
        SubMonitor _newChild = progress.newChild(8);
        builder.clean(_newChild);
      }
      IProject _project_2 = this.getProject();
      RemoveMarkersEvent _removeMarkersEvent = new RemoveMarkersEvent(_project_2, ErlangBuilder.MARKER_TYPE);
      this.builderEventBus.post(_removeMarkersEvent);
    } finally {
      boolean _notEquals = (!Objects.equal(monitor, null));
      if (_notEquals) {
        monitor.done();
      }
    }
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
  
  @Subscribe
  public void noBuilderHandler(final DeadEvent dead) {
    IProject _project = this.getProject();
    String _name = _project.getName();
    this.log.warn("No builder configured for project %s", _name);
  }
}
