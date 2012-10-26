package org.erlide.erlang;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.erlide.erlang.ErlangPackage.Literals;
import org.erlide.erlang.Module;

@SuppressWarnings("all")
public class ScopeExtensions {
  @Inject
  private Registry resourceProviderRegistry;
  
  public Manager getIndexProvider(final Resource res) {
    URI _uRI = res.getURI();
    IResourceServiceProvider _resourceServiceProvider = this.resourceProviderRegistry.getResourceServiceProvider(_uRI);
    Manager _resourceDescriptionManager = _resourceServiceProvider.getResourceDescriptionManager();
    return _resourceDescriptionManager;
  }
  
  public IResourceDescription getDescription(final Module module) {
    IResourceDescription _xblockexpression = null;
    {
      final Resource res = module.eResource();
      Manager _indexProvider = this.getIndexProvider(res);
      IResourceDescription _resourceDescription = _indexProvider.getResourceDescription(res);
      _xblockexpression = (_resourceDescription);
    }
    return _xblockexpression;
  }
  
  public Iterable<IEObjectDescription> getExportedDescriptions(final Module module) {
    IResourceDescription _description = this.getDescription(module);
    Iterable<IEObjectDescription> _exportedObjects = _description.getExportedObjects();
    return _exportedObjects;
  }
  
  public Iterable<IEObjectDescription> getExportedFunctions(final Module module) {
    IResourceDescription _description = this.getDescription(module);
    Iterable<IEObjectDescription> _exportedObjectsByType = _description.getExportedObjectsByType(Literals.FUNCTION);
    return _exportedObjectsByType;
  }
  
  public Iterable<IEObjectDescription> getExportedMacros(final Module module) {
    IResourceDescription _description = this.getDescription(module);
    Iterable<IEObjectDescription> _exportedObjectsByType = _description.getExportedObjectsByType(Literals.DEFINE_ATTRIBUTE);
    return _exportedObjectsByType;
  }
  
  public Iterable<IEObjectDescription> getExportedRecords(final Module module) {
    IResourceDescription _description = this.getDescription(module);
    Iterable<IEObjectDescription> _exportedObjectsByType = _description.getExportedObjectsByType(Literals.RECORD_ATTRIBUTE);
    return _exportedObjectsByType;
  }
}
