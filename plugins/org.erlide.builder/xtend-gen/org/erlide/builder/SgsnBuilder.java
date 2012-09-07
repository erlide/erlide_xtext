package org.erlide.builder;

import java.util.ArrayList;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.ExternalBuilder;
import org.erlide.builder.ProjectBuilderExtensions;

@SuppressWarnings("all")
public class SgsnBuilder extends ExternalBuilder {
  public SgsnBuilder() {
    super();
    this.setupCommands();
  }
  
  public SgsnBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater) {
    super(project, markerUpdater);
    this.setupConfig(project);
    this.setupCommands();
  }
  
  public SgsnBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater, final BuilderExecutor executor) {
    super(project, markerUpdater, executor);
    this.setupConfig(project);
    this.setupCommands();
  }
  
  public void setupCommands() {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("rm", "-rf", "do3/erlang/");
    this.setCleanCmdLine(_newArrayList);
    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("make", "beam");
    this.setFullCmdLine(_newArrayList_1);
    ArrayList<String> _newArrayList_2 = CollectionLiterals.<String>newArrayList("make", "-W", "$file");
    this.setSingleCmdLine(_newArrayList_2);
  }
  
  public String setupConfig(final IProject project) {
    String _xifexpression = null;
    IPath _location = project.getLocation();
    String _portableString = _location.toPortableString();
    boolean _startsWith = _portableString.startsWith("/vobs/gsn");
    if (_startsWith) {
      String _xblockexpression = null;
      {
        IResource _linkedContent = ProjectBuilderExtensions.getLinkedContent(project);
        IPath _location_1 = _linkedContent==null?(IPath)null:_linkedContent.getLocation();
        this.setWorkingDir(_location_1);
        IPath _workingDir = this.getWorkingDir();
        String _plus = ("WD=" + _workingDir);
        String _println = InputOutput.<String>println(_plus);
        _xblockexpression = (_println);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
}
