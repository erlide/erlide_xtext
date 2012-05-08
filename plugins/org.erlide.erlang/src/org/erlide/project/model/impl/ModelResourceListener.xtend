package org.erlide.project.model.impl

import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceChangeListener
import org.eclipse.core.resources.ResourcesPlugin
import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IErlangProject
import org.erlide.project.model.IProjectFragment
import org.erlide.project.model.ICodeFolder
import org.erlide.project.model.ICodeUnit

class ModelResourceListener implements IResourceChangeListener {
    
    IErlangModel model
    
    new(IErlangModel model) {
        this.model = model
        ResourcesPlugin::workspace.addResourceChangeListener(this)
    }

    def dispose() {
        ResourcesPlugin::workspace.removeResourceChangeListener(this)
    }

    override resourceChanged(IResourceChangeEvent event) {
        model.updateModel(event)
    }
    
    def dispatch void updateModel(IErlangModel model, IResourceChangeEvent event) {
        model.projects.forEach [ updateModel(event) ]
    }
    
    def dispatch void updateModel(IErlangProject project, IResourceChangeEvent event) {
         project.sourceFragments.forEach [ updateModel(event) ]
         project.binaryFragments.forEach [ updateModel(event) ]
    }
    
    def dispatch void updateModel(IProjectFragment fragment, IResourceChangeEvent event) {
        fragment.sourceFolders.forEach [ updateModel(event) ]
        fragment.includeFolders.forEach [ updateModel(event) ]
    }
    
    def dispatch void updateModel(ICodeFolder folder, IResourceChangeEvent event) {
        folder.getCodeUnits.forEach [ updateModel(event) ]
    }
    
    def dispatch void updateModel(ICodeUnit unit, IResourceChangeEvent event) {
        
    }
    
    
}