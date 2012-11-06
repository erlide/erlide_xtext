package org.erlide.ui.labeling

import com.google.inject.Inject
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.jface.viewers.StyledString$Styler
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Color
import org.eclipse.swt.graphics.Font
import org.eclipse.swt.widgets.Display
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.erlide.erlang.Attribute
import org.erlide.erlang.CustomAttribute
import org.erlide.erlang.DefineAttribute
import org.erlide.erlang.Expression
import org.erlide.erlang.FunRef
import org.erlide.erlang.Function
import org.erlide.erlang.FunctionClause
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.Module
import org.erlide.erlang.RecordAttribute

/**
 * Provides labels for a EObjects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ErlangLabelProvider extends DefaultEObjectLabelProvider {

    val Styler grayStyler = createStyler(null, Display::current.getSystemColor(SWT::COLOR_GRAY))

	@Inject
	extension ModelExtensions

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
	}

    def Object text(Module module) {
        val StyledString s = new StyledString
        s.append("module ", grayStyler)
        s.append(module.name)
        return s
    }
    
    def Object text(DefineAttribute attribute) {
        val StyledString s = new StyledString
        s.append(attribute.tag, grayStyler)
        s.append(" ")
        s.append(attribute.macroName)
        return s
    }
    
    def Object text(RecordAttribute attribute) {
        val StyledString s = new StyledString
        s.append(attribute.tag, grayStyler)
        s.append(" ")
        s.append(attribute.name)
        return s
    }
    
    def Object text(CustomAttribute attribute) {
        val StyledString s = new StyledString
        s.append(attribute.tag, grayStyler)
        s.append(" ")
        s.append(attribute.value.toString)
        return s
    }
    
    def Object text(Function function) {
		if (function.getClauses() == null || function.getClauses().size() == 0) {
			return "???"
		}
        val StyledString s = new StyledString
        s.append("function", grayStyler)
        s.append(" ")
        s.append(function.name)
		val EList<Expression> params = function.clauses.head.params.exprs
		s.append("/" + (if(params == null) "0" else params.size()))
        return s
    }
    
    def Object text(FunctionClause clause) {
        val StyledString s = new StyledString
        val args = clause.params.toString
        s.append(args) //.substring(1, args.length-1))
        return s
    }
    
	 def String text(Attribute ele) {
	 	val tag = ele.tag
	 	return "-" + tag + " -- "
	 }

	def String text(FunRef c) {
        return c.sourceText
    }

	def String text(EObject element) {
		// just a way to see unwanted elements
		return "§ " + element.sourceText + " -- "+element.^class.name
	}

	def String getListText(EList<Expression> list) {
		return list.map[sourceText].join(", ")
	}

    def String image(FunctionClause clause) {
        null
    }
    
    def String image(EObject element) {
        "full/obj16/skip.gif"
    }
    
	def String image(Attribute ele) {
		return "MyModel.gif"
	}

    def String image(Function function) {
    	if(function.isExported)
        	"full/obj16/methpub_obj.gif"
        else
        	"full/obj16/methpri_obj.gif"
    }
    
    def private static Styler createStyler(Font font, Color color) {
        new ErlideStyler(font, color)
    }



}
