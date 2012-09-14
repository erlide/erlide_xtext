package org.erlide.builder.progress;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.erlide.builder.progress.ProgressEvent;
import org.erlide.common.util.ErlLogger;

@SuppressWarnings("all")
public class BuilderProgressUpdater {
  private EventBus builderEventBus;
  
  @Inject
  private ErlLogger log;
  
  @Inject
  public BuilderProgressUpdater(@Named(value = "erlangBuilder") final EventBus builderEventBus) {
    this.builderEventBus = builderEventBus;
    builderEventBus.register(this);
  }
  
  @Subscribe
  public void handleProgressEvent(final ProgressEvent event) {
    String _plus = ("PROGRESS " + event);
    this.log.debug(_plus);
  }
}
