package org.erlide.ui.labeling;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.erlide.erlang.Attribute;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Expressions;
import org.erlide.erlang.Form;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.Function;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.ModelExtensions;
import org.erlide.erlang.Module;
import org.erlide.erlang.ModuleAttribute;

/**
 * Provides labels for a EObjects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
@SuppressWarnings("all")
public class ErlangLabelProvider extends DefaultEObjectLabelProvider {
  @Inject
  private ModelExtensions _modelExtensions;
  
  @Inject
  public ErlangLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public String text(final Module ele) {
    EList<Form> _forms = ele.getForms();
    final Form first = _forms.get(0);
    String _xifexpression = null;
    if ((first instanceof ModuleAttribute)) {
      String _moduleName = ((ModuleAttribute) first).getModuleName();
      _xifexpression = _moduleName;
    } else {
      String _string = first.toString();
      String _plus = (_string + "?");
      _xifexpression = _plus;
    }
    final String name = _xifexpression;
    return ("module " + name);
  }
  
  public String text(final Attribute ele) {
    final String tag = ele.getTag();
    String _plus = ("-" + tag);
    return (_plus + " -- ");
  }
  
  public String text(final Function ele) {
    boolean _or = false;
    EList<FunctionClause> _clauses = ele.getClauses();
    boolean _equals = Objects.equal(_clauses, null);
    if (_equals) {
      _or = true;
    } else {
      EList<FunctionClause> _clauses_1 = ele.getClauses();
      int _size = _clauses_1.size();
      boolean _equals_1 = (_size == 0);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      return "???";
    }
    EList<FunctionClause> _clauses_2 = ele.getClauses();
    FunctionClause _head = IterableExtensions.<FunctionClause>head(_clauses_2);
    Expressions _params = _head.getParams();
    final EList<Expression> params = _params.getExprs();
    String _name = ele.getName();
    String _plus = (_name + "/");
    Object _xifexpression = null;
    boolean _equals_2 = Objects.equal(params, null);
    if (_equals_2) {
      _xifexpression = "0";
    } else {
      int _size_1 = params.size();
      _xifexpression = _size_1;
    }
    return (_plus + ((Comparable<Object>)_xifexpression));
  }
  
  public String text(final FunctionClause ele) {
    Expressions _params = ele.getParams();
    EList<Expression> _exprs = _params.getExprs();
    String _listText = this.getListText(_exprs);
    String _plus = ("(" + _listText);
    return (_plus + ")");
  }
  
  public String text(final FunRef c) {
    return this._modelExtensions.getSourceText(c);
  }
  
  public String text(final EObject element) {
    String _sourceText = this._modelExtensions.getSourceText(element);
    String _plus = ("\u00A7 " + _sourceText);
    String _plus_1 = (_plus + " -- ");
    Class<? extends Object> _class = element.getClass();
    String _name = _class.getName();
    return (_plus_1 + _name);
  }
  
  public String image(final Attribute ele) {
    return "MyModel.gif";
  }
  
  public String getListText(final EList<Expression> list) {
    final Function1<Expression,String> _function = new Function1<Expression,String>() {
        public String apply(final Expression it) {
          String _sourceText = ErlangLabelProvider.this._modelExtensions.getSourceText(it);
          return _sourceText;
        }
      };
    List<String> _map = ListExtensions.<Expression, String>map(list, _function);
    return IterableExtensions.join(_map, ", ");
  }
}
