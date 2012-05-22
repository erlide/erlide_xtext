package org.erlide.erlang;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.erlide.erlang.Attribute;
import org.erlide.erlang.CompilerOptionsAttribute;
import org.erlide.erlang.CustomAttribute;
import org.erlide.erlang.ExportAttribute;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Form;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.FunType;
import org.erlide.erlang.Function;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.ImportAttribute;
import org.erlide.erlang.Module;
import org.erlide.erlang.ModuleAttribute;
import org.erlide.erlang.SpecAttribute;
import org.erlide.erlang.SpecFun;
import org.erlide.erlang.TopType;
import org.erlide.erlang.TypeSig;

@SuppressWarnings("all")
public class ModelExtensions {
  public static String getName(final Module module) {
    String _xblockexpression = null;
    {
      EList<Form> _forms = module.getForms();
      final Form attr = IterableExtensions.<Form>head(_forms);
      String _xifexpression = null;
      if ((attr instanceof ModuleAttribute)) {
        String _name = ((ModuleAttribute) attr).getName();
        _xifexpression = _name;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public static boolean isHeader(final Module module) {
    String _name = ModelExtensions.getName(module);
    boolean _equals = Objects.equal(_name, null);
    return _equals;
  }
  
  public static Collection<Attribute> getAttributes(final Module module) {
    EList<EObject> _eContents = module.eContents();
    Iterable<Attribute> _filter = Iterables.<Attribute>filter(_eContents, Attribute.class);
    List<Attribute> _list = IterableExtensions.<Attribute>toList(_filter);
    return _list;
  }
  
  public static Collection<CustomAttribute> getCustomAttributesWithTag(final Module module, final String mytag) {
    EList<EObject> _eContents = module.eContents();
    Iterable<CustomAttribute> _filter = Iterables.<CustomAttribute>filter(_eContents, CustomAttribute.class);
    final Function1<CustomAttribute,Boolean> _function = new Function1<CustomAttribute,Boolean>() {
        public Boolean apply(final CustomAttribute it) {
          String _tag = it.getTag();
          boolean _equals = Objects.equal(_tag, mytag);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<CustomAttribute> _filter_1 = IterableExtensions.<CustomAttribute>filter(_filter, _function);
    List<CustomAttribute> _list = IterableExtensions.<CustomAttribute>toList(_filter_1);
    return _list;
  }
  
  public static Collection<ExportAttribute> getExportAttributes(final Module module) {
    Collection<ExportAttribute> _attributes = ModelExtensions.<ExportAttribute>getAttributes(module, ExportAttribute.class);
    return _attributes;
  }
  
  public static Collection<ImportAttribute> getImportAttributes(final Module module) {
    Collection<ImportAttribute> _attributes = ModelExtensions.<ImportAttribute>getAttributes(module, ImportAttribute.class);
    return _attributes;
  }
  
  public static Collection<SpecAttribute> getSpecs(final Module module) {
    Collection<SpecAttribute> _attributes = ModelExtensions.<SpecAttribute>getAttributes(module, SpecAttribute.class);
    return _attributes;
  }
  
  private static <T extends Object> Collection<T> getAttributes(final Module module, final Class<T> type) {
    EList<EObject> _eContents = module.eContents();
    Iterable<T> _filter = Iterables.<T>filter(_eContents, type);
    List<T> _list = IterableExtensions.<T>toList(_filter);
    return _list;
  }
  
  public static boolean exportsFunction(final Module module, final Function function) {
    Collection<Function> _exportedFunctions = ModelExtensions.getExportedFunctions(module);
    boolean _contains = _exportedFunctions.contains(function);
    return _contains;
  }
  
  public static boolean exports(final Module module, final FunRef function) {
    Collection<Function> _exportedFunctions = ModelExtensions.getExportedFunctions(module);
    boolean _contains = _exportedFunctions.contains(function);
    return _contains;
  }
  
  public static Collection<Function> getExportedFunctions(final Module module) {
    List<Function> _xblockexpression = null;
    {
      final Collection<FunRef> exportAttributes = ModelExtensions.getExportedFunRefs(module);
      final Function1<FunRef,Function> _function = new Function1<FunRef,Function>() {
          public Function apply(final FunRef it) {
            Function _function = ModelExtensions.getFunction(module, it);
            return _function;
          }
        };
      Iterable<Function> _map = IterableExtensions.<FunRef, Function>map(exportAttributes, _function);
      List<Function> _list = IterableExtensions.<Function>toList(_map);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public static Collection<FunRef> getExportedFunRefs(final Module module) {
    List<FunRef> _xblockexpression = null;
    {
      final Collection<ExportAttribute> exportAttributes = ModelExtensions.getExportAttributes(module);
      final Function1<ExportAttribute,EList<FunRef>> _function = new Function1<ExportAttribute,EList<FunRef>>() {
          public EList<FunRef> apply(final ExportAttribute it) {
            EList<FunRef> _funs = it.getFuns();
            return _funs;
          }
        };
      Iterable<EList<FunRef>> _map = IterableExtensions.<ExportAttribute, EList<FunRef>>map(exportAttributes, _function);
      Iterable<FunRef> _concat = Iterables.<FunRef>concat(_map);
      List<FunRef> _list = IterableExtensions.<FunRef>toList(_concat);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public static Function getFunction(final Module module, final String fname, final int farity) {
    EList<EObject> _eContents = module.eContents();
    Iterable<Function> _filter = Iterables.<Function>filter(_eContents, Function.class);
    final Function1<Function,Boolean> _function = new Function1<Function,Boolean>() {
        public Boolean apply(final Function it) {
          boolean _and = false;
          String _name = it.getName();
          boolean _equals = Objects.equal(_name, fname);
          if (!_equals) {
            _and = false;
          } else {
            int _arity = ModelExtensions.getArity(it);
            boolean _equals_1 = (_arity == farity);
            _and = (_equals && _equals_1);
          }
          return Boolean.valueOf(_and);
        }
      };
    Function _findFirst = IterableExtensions.<Function>findFirst(_filter, _function);
    return _findFirst;
  }
  
  public static Function getFunction(final Module module, final FunRef ref) {
    String _function = ref.getFunction();
    String _arity = ref.getArity();
    int _parseInt = Integer.parseInt(_arity);
    Function _function_1 = ModelExtensions.getFunction(module, _function, _parseInt);
    return _function_1;
  }
  
  public static Function getFunction(final Module module, final SpecFun ref) {
    String _function = ref.getFunction();
    String _arity = ref.getArity();
    int _parseInt = Integer.parseInt(_arity);
    Function _function_1 = ModelExtensions.getFunction(module, _function, _parseInt);
    return _function_1;
  }
  
  public static Collection<CompilerOptionsAttribute> getCompilerOptions(final Module module) {
    Collection<CompilerOptionsAttribute> _attributes = ModelExtensions.<CompilerOptionsAttribute>getAttributes(module, CompilerOptionsAttribute.class);
    return _attributes;
  }
  
  public static SpecAttribute getSpec(final Module module, final String fname, final int farity) {
    SpecAttribute _xblockexpression = null;
    {
      final Collection<SpecAttribute> specs = ModelExtensions.getSpecs(module);
      final Function1<SpecAttribute,Boolean> _function = new Function1<SpecAttribute,Boolean>() {
          public Boolean apply(final SpecAttribute it) {
            boolean _and = false;
            SpecFun _ref = it.getRef();
            String _function = _ref.getFunction();
            boolean _equals = Objects.equal(_function, fname);
            if (!_equals) {
              _and = false;
            } else {
              int _specArity = ModelExtensions.getSpecArity(it);
              boolean _equals_1 = (_specArity == farity);
              _and = (_equals && _equals_1);
            }
            return Boolean.valueOf(_and);
          }
        };
      SpecAttribute _findFirst = IterableExtensions.<SpecAttribute>findFirst(specs, _function);
      _xblockexpression = (_findFirst);
    }
    return _xblockexpression;
  }
  
  public static int getArity(final Function fun) {
    EList<FunctionClause> _clauses = fun.getClauses();
    FunctionClause _head = IterableExtensions.<FunctionClause>head(_clauses);
    EList<Expression> _params = _head.getParams();
    int _size = _params.size();
    return _size;
  }
  
  public static boolean isExported(final Function function) {
    Module _module = ModelExtensions.getModule(function);
    boolean _exportsFunction = ModelExtensions.exportsFunction(_module, function);
    return _exportsFunction;
  }
  
  public static SpecAttribute getSpec(final Function function) {
    SpecAttribute _xblockexpression = null;
    {
      final Module module = ModelExtensions.getModule(function);
      final Collection<SpecAttribute> specs = ModelExtensions.getSpecs(module);
      final Function1<SpecAttribute,Boolean> _function = new Function1<SpecAttribute,Boolean>() {
          public Boolean apply(final SpecAttribute it) {
            boolean _and = false;
            SpecFun _ref = it.getRef();
            String _function = _ref.getFunction();
            String _name = function.getName();
            boolean _equals = Objects.equal(_function, _name);
            if (!_equals) {
              _and = false;
            } else {
              int _specArity = ModelExtensions.getSpecArity(it);
              int _arity = ModelExtensions.getArity(function);
              boolean _equals_1 = (_specArity == _arity);
              _and = (_equals && _equals_1);
            }
            return Boolean.valueOf(_and);
          }
        };
      SpecAttribute _findFirst = IterableExtensions.<SpecAttribute>findFirst(specs, _function);
      _xblockexpression = (_findFirst);
    }
    return _xblockexpression;
  }
  
  protected static Module _getModule(final Module element) {
    return element;
  }
  
  protected static Module _getModule(final EObject element) {
    Module _xblockexpression = null;
    {
      final EObject parent = element.eContainer();
      Module _module = ModelExtensions.getModule(parent);
      _xblockexpression = (_module);
    }
    return _xblockexpression;
  }
  
  public static String getSourceName(final EObject atom) {
    String _xblockexpression = null;
    {
      ICompositeNode _node = NodeModelUtils.getNode(atom);
      final Iterable<ILeafNode> nodes = _node.getLeafNodes();
      final Function1<ILeafNode,Boolean> _function = new Function1<ILeafNode,Boolean>() {
          public Boolean apply(final ILeafNode it) {
            boolean _isHidden = it.isHidden();
            boolean _not = (!_isHidden);
            return Boolean.valueOf(_not);
          }
        };
      Iterable<ILeafNode> _filter = IterableExtensions.<ILeafNode>filter(nodes, _function);
      ILeafNode _head = IterableExtensions.<ILeafNode>head(_filter);
      String _text = _head.getText();
      _xblockexpression = (_text);
    }
    return _xblockexpression;
  }
  
  public static int getSpecArity(final SpecAttribute spec) {
    int _xifexpression = (int) 0;
    SpecFun _ref = spec.getRef();
    String _arity = _ref.getArity();
    boolean _notEquals = (!Objects.equal(_arity, null));
    if (_notEquals) {
      SpecFun _ref_1 = spec.getRef();
      String _arity_1 = _ref_1.getArity();
      int _parseInt = Integer.parseInt(_arity_1);
      _xifexpression = _parseInt;
    } else {
      EList<TypeSig> _signatures = spec.getSignatures();
      TypeSig _head = IterableExtensions.<TypeSig>head(_signatures);
      FunType _decl = _head.getDecl();
      EList<TopType> _args = _decl.getArgs();
      int _size = _args.size();
      _xifexpression = _size;
    }
    return _xifexpression;
  }
  
  public static Module getModule(final EObject element) {
    if (element instanceof Module) {
      return _getModule((Module)element);
    } else if (element != null) {
      return _getModule(element);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
  }
}
