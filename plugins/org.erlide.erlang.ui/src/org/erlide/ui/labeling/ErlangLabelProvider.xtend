package org.erlide.ui.labeling

import com.google.inject.Inject
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.erlide.erlang.Attribute
import org.erlide.erlang.Expression
import org.erlide.erlang.Form
import org.erlide.erlang.Function
import org.erlide.erlang.FunctionClause
import org.erlide.erlang.ModelExtensions
import org.erlide.erlang.Module
import org.erlide.erlang.ModuleAttribute
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.erlide.erlang.FunRef

/**
 * Provides labels for a EObjects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ErlangLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	extension ModelExtensions

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
	}

	def String text(Module ele) {
		val Form first = ele.getForms().get(0)
		val String name = if(first instanceof ModuleAttribute)  (first as ModuleAttribute).getModuleName() else first.toString() + "?"
		return "module " + name
	}

	 def String text(Attribute ele) {
	 	val tag = ele.tag
	 	return "-" + tag + " -- "
	 }

	def String text(Function ele) {
		if (ele.getClauses() == null || ele.getClauses().size() == 0) {
			return "???"
		}
		val EList<Expression> params = ele.clauses.head.params.exprs
		return ele.getName() + "/" + (if(params == null) "0" else params.size())
	}

	def String text(FunctionClause ele) {
		return "(" + getListText(ele.params.exprs) + ")"
	}

	def String text(FunRef c) {
        return c.sourceText
    }

	def String text(EObject element) {
		// just a way to see unwanted elements
		return "§ " + element.sourceText + " -- "+element.^class.name
	}

	def String image(Attribute ele) {
		return "MyModel.gif"
	}

	def String getListText(EList<Expression> list) {
		return list.map[sourceText].join(", ")
	}

}
