package org.erlide.ui.outline

import org.eclipse.emf.ecore.EObject
import org.eclipse.swt.graphics.Image
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import org.erlide.erlang.ExportAttribute
import org.erlide.erlang.Form
import org.erlide.erlang.FunRef
import org.erlide.erlang.FunctionClause
import org.erlide.erlang.Module
import org.erlide.erlang.ModuleAttribute
import org.erlide.erlang.RecordAttribute
import org.erlide.erlang.DefineAttribute

/**
 * outline structure -- group same type of forms under common parent
 * 
 */
public class ErlangOutlineTreeProvider extends DefaultOutlineTreeProvider {

    def protected boolean _isLeaf(FunctionClause c) {
        true
    }

    def protected boolean _isLeaf(FunRef c) {
        true
    }

    def protected void _createChildren(DocumentRootNode parent,
            Module module) {
        println(parent + " === " + module)

        val AbstractOutlineNode recordsNode = new ErlangOutlineNode(parent,
                null, "Records:", false)
        val AbstractOutlineNode exportsNode = new ErlangOutlineNode(parent,
                null, "Exports:", false)
        val AbstractOutlineNode macrosNode = new ErlangOutlineNode(
                parent, null, "Macros:", false)
                
        for (Form element : module.getForms()) {
        	val theParent = switch element {
        		ModuleAttribute: null 
	            RecordAttribute: recordsNode
	            ExportAttribute: exportsNode
	            DefineAttribute: macrosNode
	            default: parent
            }
            if(theParent!=null)
            	createChildren(theParent, element)
        }
    }

    def protected void _createChildren(ErlangOutlineNode parent,
            ExportAttribute attr) {
        for (EObject element : attr.eContents()) {
            createNode(parent, element)
        }
    }

}

class ErlangOutlineNode extends AbstractOutlineNode {
    new(IOutlineNode parent, Image image, Object text, boolean isLeaf) {
        super(parent, image, text, isLeaf)
    }
}

