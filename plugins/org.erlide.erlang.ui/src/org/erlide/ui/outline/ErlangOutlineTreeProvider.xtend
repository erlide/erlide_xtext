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
import org.erlide.erlang.ErlangPackage

/**
 * outline structure -- group same type of forms under common parent
 * 
 */
public class ErlangOutlineTreeProvider extends DefaultOutlineTreeProvider {

    def dispatch boolean isLeaf(FunctionClause c) {
        true
    }

    def dispatch boolean isLeaf(FunRef c) {
        true
    }

    def dispatch void createChildren(DocumentRootNode parent, Module module) {
        val recordsNode = new ErlangOutlineNode(parent, null, "Records:", false)
        val exportsNode = new ErlangOutlineNode(parent, null, "Exports:", false)
        val macrosNode = new ErlangOutlineNode(parent, null, "Macros:", false)
                
        for (Form element : module.getForms()) {
        	val theParent = switch element {
        		ModuleAttribute: null 
	            RecordAttribute: recordsNode
	            ExportAttribute: exportsNode
	            DefineAttribute: macrosNode
	            default: parent
            }
            if(theParent!=null) {
            	createChildren(theParent, element)
           	}
        }
    }

    def dispatch void createChildren(ErlangOutlineNode parent, ExportAttribute attr) {
        for (EObject element : attr.eContents()) {
            createNode(parent, element)
        }
    }
    def dispatch void createChildren(ErlangOutlineNode parent, DefineAttribute attr) {
    	val name = createEStructuralFeatureNode(parent, attr, ErlangPackage$Literals::DEFINE_ATTRIBUTE__MACRO_NAME, null, attr.macroName, true)
        for (EObject element : attr.eContents()) {
            createNode(name, element)
        }
    }
    def dispatch void createChildren(ErlangOutlineNode parent, RecordAttribute attr) {
    	val name = createEStructuralFeatureNode(parent, attr, ErlangPackage$Literals::RECORD_ATTRIBUTE__NAME, null, attr.name, true)
        for (EObject element : attr.eContents()) {
            createNode(name, element)
        }
    }
}

class ErlangOutlineNode extends AbstractOutlineNode {
    new(IOutlineNode parent, Image image, Object text, boolean isLeaf) {
        super(parent, image, text, isLeaf)
    }
}

