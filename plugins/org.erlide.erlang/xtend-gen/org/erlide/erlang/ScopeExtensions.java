package org.erlide.erlang;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Module;

@SuppressWarnings("all")
public class ScopeExtensions {
  @Inject
  private IResourceServiceProvider.Registry resourceProviderRegistry;
  
  public IResourceDescription.Manager getIndexProvider(final Resource res) {
    URI _uRI = res.getURI();
    IResourceServiceProvider _resourceServiceProvider = this.resourceProviderRegistry.getResourceServiceProvider(_uRI);
    return _resourceServiceProvider.getResourceDescriptionManager();
  }
  
  public IResourceDescription getDescription(final Module module) {
    IResourceDescription _xblockexpression = null;
    {
      final Resource res = module.eResource();
      IResourceDescription.Manager _indexProvider = this.getIndexProvider(res);
      _xblockexpression = _indexProvider.getResourceDescription(res);
    }
    return _xblockexpression;
  }
  
  public Iterable<IEObjectDescription> getExportedDescriptions(final Module module) {
    IResourceDescription _description = this.getDescription(module);
    return _description.getExportedObjects();
  }
  
  public Iterable<IEObjectDescription> getExportedFunctions(final Module module) {
    IResourceDescription _description = this.getDescription(module);
    return _description.getExportedObjectsByType(ErlangPackage.Literals.FUNCTION);
  }
  
  public Iterable<IEObjectDescription> getExportedMacros(final Module module) {
    IResourceDescription _description = this.getDescription(module);
    return _description.getExportedObjectsByType(ErlangPackage.Literals.DEFINE_ATTRIBUTE);
  }
  
  public Iterable<IEObjectDescription> getExportedRecords(final Module module) {
    IResourceDescription _description = this.getDescription(module);
    return _description.getExportedObjectsByType(ErlangPackage.Literals.RECORD_ATTRIBUTE);
  }
}
