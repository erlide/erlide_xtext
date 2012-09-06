package org.erlide.builder;

import java.util.ArrayList;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.ExternalBuilder;

@SuppressWarnings("all")
public class MakeBuilder extends ExternalBuilder {
  public MakeBuilder() {
    super();
  }
  
  public MakeBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater) {
    super(project, markerUpdater);
  }
  
  public MakeBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater, final BuilderExecutor executor) {
    super(project, markerUpdater, executor);
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("make", "clean");
    this.setCleanCmdLine(_newArrayList);
    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("make", "beam");
    this.setFullCmdLine(_newArrayList_1);
    ArrayList<String> _newArrayList_2 = CollectionLiterals.<String>newArrayList("make", "-W", "$file");
    this.setSingleCmdLine(_newArrayList_2);
  }
}
