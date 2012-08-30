package org.erlide.project.model.impl

import java.util.Collection
import java.util.Collections
import java.util.List
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceChangeListener
import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.resources.ResourcesPlugin
import org.erlide.project.model.ICodeUnit
import org.erlide.project.model.IErlangModel
import org.erlide.project.model.IErlangModelElement
import org.erlide.project.model.IErlangProject

import static extension org.eclipse.xtext.xbase.lib.IntegerExtensions.*

public class ErlangProject extends ErlangModelElement implements IErlangProject, IResourceChangeListener {

    IErlangModel model
    List<ICodeUnit> units
    IProject workspaceProject
    boolean closed

    new(IErlangModel model, IProject project) {
        super()
        this.model = model
        units = newArrayList()
        workspaceProject = project
    	ResourcesPlugin::workspace.addResourceChangeListener(this)
        if(project.open) open()
     }

    def List<IProject> getReferencedProjects() {
    	open()
        return workspaceProject.referencedProjects
    }

    override Collection<ICodeUnit> getUnits() {
    	open()
        return Collections::unmodifiableCollection(units)
    }

    override IProject getWorkspaceProject() {
        return workspaceProject
    }

    override String toString() {
        val StringBuffer result = new StringBuffer(super.toString())
        result.append(" (workspaceProject: ")
        result.append(workspaceProject)
        result.append(')')
        return result.toString()
    }

    override String getName() {
        return workspaceProject.getName()
    }

    override IErlangModelElement getParent() {
        return model
    }

    override getResource() {
        return workspaceProject
    }
    
    def private open() {
    	println("OPEN "+this)
    	closed = false
    }
    
    def private close() {
    	println("CLOSE "+this)
    	closed = true
    }
    
	override resourceChanged(IResourceChangeEvent event) {
		if(event.type != IResourceChangeEvent::POST_CHANGE) {
			return
		}
		event.delta.accept [ delta |
			if (delta.resource == project) {
				println("CHANGE IN PROJECT "+project+ " "+delta.flags)
				switch delta.flags {
					case match(delta.flags, IResourceDelta::OPEN): {
						if(closed) open()
						else close()
					}
					case match(delta.flags, IResourceDelta::DESCRIPTION):{
						// rescan?
					}
					case match(delta.flags, IResourceDelta::REMOVED):{
						ResourcesPlugin::workspace.removeResourceChangeListener(this)
					}
				}
			} 
			// TODO check for children at this level too, or do we do it locally in lower level elements?
			return true
		]
	}
	
	def private boolean match(int v, int flag) {
		bitwiseAnd(v, flag) != 0
	}
	
} // ErlangProject
