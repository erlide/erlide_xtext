package org.erlide.builder;

import java.util.ArrayList;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.erlide.builder.BuilderExecutor;
import org.erlide.builder.BuilderMarkerUpdater;
import org.erlide.builder.ExternalBuilder;

@SuppressWarnings("all")
public class SgsnBuilder extends ExternalBuilder {
  public final static String ID = "org.erlide.builder.sgsnbuilder";
  
  public SgsnBuilder() {
    super();
    this.setupCommands();
  }
  
  public SgsnBuilder(final IProject project, final BuilderMarkerUpdater markerUpdater, final BuilderExecutor executor) {
    super(project, markerUpdater, executor, null);
    this.setupCommands();
    this.loadConfiguration();
  }
  
  public void setupCommands() {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("rm", "-rf", "do3/erlang/");
    this.setCleanCmdLine(_newArrayList);
    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("make", "beam");
    this.setFullCmdLine(_newArrayList_1);
    ArrayList<String> _newArrayList_2 = CollectionLiterals.<String>newArrayList("make", "-W", "$file");
    this.setSingleCmdLine(_newArrayList_2);
  }
}
