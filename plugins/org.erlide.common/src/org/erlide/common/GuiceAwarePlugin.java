package org.erlide.common;

import com.google.inject.Injector;
import com.google.inject.Module;

public interface GuiceAwarePlugin {

    Module getModule();

    Injector getInjector();

}
