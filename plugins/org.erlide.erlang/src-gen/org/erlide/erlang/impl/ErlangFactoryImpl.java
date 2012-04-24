/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.erlide.erlang.AbstractDefineAttribute;
import org.erlide.erlang.AbstractElement;
import org.erlide.erlang.AbstractTypeAttribute;
import org.erlide.erlang.AddOp;
import org.erlide.erlang.Atom;
import org.erlide.erlang.Attribute;
import org.erlide.erlang.BinBaseType;
import org.erlide.erlang.BinOp;
import org.erlide.erlang.BinUnitType;
import org.erlide.erlang.Binary;
import org.erlide.erlang.BinaryComprehension;
import org.erlide.erlang.BinaryItem;
import org.erlide.erlang.BinaryType;
import org.erlide.erlang.BitType;
import org.erlide.erlang.BlockExpr;
import org.erlide.erlang.CaseExpr;
import org.erlide.erlang.CatchExpr;
import org.erlide.erlang.Char;
import org.erlide.erlang.CondExpr;
import org.erlide.erlang.ConditionalFormBlock;
import org.erlide.erlang.CrClause;
import org.erlide.erlang.CustomAttribute;
import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.ElseAttribute;
import org.erlide.erlang.EndifAttribute;
import org.erlide.erlang.ErlList;
import org.erlide.erlang.ErlString;
import org.erlide.erlang.ErlangFactory;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Expressions;
import org.erlide.erlang.FieldType;
import org.erlide.erlang.FileAttribute;
import org.erlide.erlang.Form;
import org.erlide.erlang.FunCall;
import org.erlide.erlang.FunExpr;
import org.erlide.erlang.FunType;
import org.erlide.erlang.FunType100;
import org.erlide.erlang.FunTypeList;
import org.erlide.erlang.Function;
import org.erlide.erlang.FunctionClause;
import org.erlide.erlang.Guard;
import org.erlide.erlang.IfClause;
import org.erlide.erlang.IfExpr;
import org.erlide.erlang.IfdefAttribute;
import org.erlide.erlang.IncludeAttribute;
import org.erlide.erlang.LCExpr;
import org.erlide.erlang.LetExpr;
import org.erlide.erlang.List;
import org.erlide.erlang.ListComprehension;
import org.erlide.erlang.ListType;
import org.erlide.erlang.MacroCall;
import org.erlide.erlang.MacroExpr;
import org.erlide.erlang.MacroForm;
import org.erlide.erlang.MatchExpr;
import org.erlide.erlang.Module;
import org.erlide.erlang.ModuleAttribute;
import org.erlide.erlang.MultOp;
import org.erlide.erlang.QueryExpr;
import org.erlide.erlang.ReceiveExpr;
import org.erlide.erlang.RecordAttribute;
import org.erlide.erlang.RecordExpr;
import org.erlide.erlang.RecordField;
import org.erlide.erlang.RecordFieldDef;
import org.erlide.erlang.RecordTuple;
import org.erlide.erlang.RecordType;
import org.erlide.erlang.RefFun;
import org.erlide.erlang.RemoteTarget;
import org.erlide.erlang.RemoteType;
import org.erlide.erlang.SpecAttribute;
import org.erlide.erlang.SpecFun;
import org.erlide.erlang.TopType;
import org.erlide.erlang.TopTypes;
import org.erlide.erlang.TryClause;
import org.erlide.erlang.TryExpr;
import org.erlide.erlang.Tuple;
import org.erlide.erlang.TupleType;
import org.erlide.erlang.Type;
import org.erlide.erlang.Type100;
import org.erlide.erlang.Type200;
import org.erlide.erlang.Type300;
import org.erlide.erlang.Type400;
import org.erlide.erlang.Type500;
import org.erlide.erlang.TypeAttribute;
import org.erlide.erlang.TypeGuard;
import org.erlide.erlang.TypeGuards;
import org.erlide.erlang.TypeSig;
import org.erlide.erlang.TypeSigs;
import org.erlide.erlang.UnaryExpr;
import org.erlide.erlang.UnaryType;
import org.erlide.erlang.UndefAttribute;
import org.erlide.erlang.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ErlangFactoryImpl extends EFactoryImpl implements ErlangFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ErlangFactory init()
  {
    try
    {
      ErlangFactory theErlangFactory = (ErlangFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.erlide.org/Erlang"); 
      if (theErlangFactory != null)
      {
        return theErlangFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ErlangFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlangFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ErlangPackage.MODULE: return createModule();
      case ErlangPackage.FORM: return createForm();
      case ErlangPackage.CONDITIONAL_FORM_BLOCK: return createConditionalFormBlock();
      case ErlangPackage.ABSTRACT_ELEMENT: return createAbstractElement();
      case ErlangPackage.ATTRIBUTE: return createAttribute();
      case ErlangPackage.ABSTRACT_DEFINE_ATTRIBUTE: return createAbstractDefineAttribute();
      case ErlangPackage.DEFINE_ATTRIBUTE: return createDefineAttribute();
      case ErlangPackage.UNDEF_ATTRIBUTE: return createUndefAttribute();
      case ErlangPackage.IFDEF_ATTRIBUTE: return createIfdefAttribute();
      case ErlangPackage.ENDIF_ATTRIBUTE: return createEndifAttribute();
      case ErlangPackage.ELSE_ATTRIBUTE: return createElseAttribute();
      case ErlangPackage.INCLUDE_ATTRIBUTE: return createIncludeAttribute();
      case ErlangPackage.FILE_ATTRIBUTE: return createFileAttribute();
      case ErlangPackage.MODULE_ATTRIBUTE: return createModuleAttribute();
      case ErlangPackage.RECORD_ATTRIBUTE: return createRecordAttribute();
      case ErlangPackage.ABSTRACT_TYPE_ATTRIBUTE: return createAbstractTypeAttribute();
      case ErlangPackage.SPEC_ATTRIBUTE: return createSpecAttribute();
      case ErlangPackage.TYPE_ATTRIBUTE: return createTypeAttribute();
      case ErlangPackage.CUSTOM_ATTRIBUTE: return createCustomAttribute();
      case ErlangPackage.FUNCTION: return createFunction();
      case ErlangPackage.FUNCTION_CLAUSE: return createFunctionClause();
      case ErlangPackage.GUARD: return createGuard();
      case ErlangPackage.EXPRESSIONS: return createExpressions();
      case ErlangPackage.EXPRESSION: return createExpression();
      case ErlangPackage.MACRO_CALL: return createMacroCall();
      case ErlangPackage.RECORD_EXPR: return createRecordExpr();
      case ErlangPackage.QUERY_EXPR: return createQueryExpr();
      case ErlangPackage.COND_EXPR: return createCondExpr();
      case ErlangPackage.LET_EXPR: return createLetExpr();
      case ErlangPackage.RECORD_TUPLE: return createRecordTuple();
      case ErlangPackage.RECORD_FIELD_DEF: return createRecordFieldDef();
      case ErlangPackage.RECORD_FIELD: return createRecordField();
      case ErlangPackage.IF_EXPR: return createIfExpr();
      case ErlangPackage.IF_CLAUSE: return createIfClause();
      case ErlangPackage.CASE_EXPR: return createCaseExpr();
      case ErlangPackage.CR_CLAUSE: return createCrClause();
      case ErlangPackage.RECEIVE_EXPR: return createReceiveExpr();
      case ErlangPackage.FUN_EXPR: return createFunExpr();
      case ErlangPackage.REF_FUN: return createRefFun();
      case ErlangPackage.TRY_EXPR: return createTryExpr();
      case ErlangPackage.TRY_CLAUSE: return createTryClause();
      case ErlangPackage.ERL_LIST: return createErlList();
      case ErlangPackage.LIST_COMPREHENSION: return createListComprehension();
      case ErlangPackage.TUPLE: return createTuple();
      case ErlangPackage.BINARY_COMPREHENSION: return createBinaryComprehension();
      case ErlangPackage.BINARY: return createBinary();
      case ErlangPackage.BINARY_ITEM: return createBinaryItem();
      case ErlangPackage.BIT_TYPE: return createBitType();
      case ErlangPackage.LC_EXPR: return createLCExpr();
      case ErlangPackage.SPEC_FUN: return createSpecFun();
      case ErlangPackage.TYPE_SIGS: return createTypeSigs();
      case ErlangPackage.TYPE_SIG: return createTypeSig();
      case ErlangPackage.FUN_TYPE: return createFunType();
      case ErlangPackage.TOP_TYPES: return createTopTypes();
      case ErlangPackage.TYPE_GUARDS: return createTypeGuards();
      case ErlangPackage.TYPE_GUARD: return createTypeGuard();
      case ErlangPackage.TOP_TYPE: return createTopType();
      case ErlangPackage.TYPE100: return createType100();
      case ErlangPackage.TYPE200: return createType200();
      case ErlangPackage.TYPE300: return createType300();
      case ErlangPackage.TYPE400: return createType400();
      case ErlangPackage.TYPE500: return createType500();
      case ErlangPackage.TYPE: return createType();
      case ErlangPackage.FIELD_TYPE: return createFieldType();
      case ErlangPackage.BINARY_TYPE: return createBinaryType();
      case ErlangPackage.BIN_BASE_TYPE: return createBinBaseType();
      case ErlangPackage.BIN_UNIT_TYPE: return createBinUnitType();
      case ErlangPackage.FUN_TYPE100: return createFunType100();
      case ErlangPackage.MACRO_FORM: return createMacroForm();
      case ErlangPackage.CATCH_EXPR: return createCatchExpr();
      case ErlangPackage.MATCH_EXPR: return createMatchExpr();
      case ErlangPackage.BIN_OP: return createBinOp();
      case ErlangPackage.ADD_OP: return createAddOp();
      case ErlangPackage.MULT_OP: return createMultOp();
      case ErlangPackage.UNARY_EXPR: return createUnaryExpr();
      case ErlangPackage.FUN_CALL: return createFunCall();
      case ErlangPackage.REMOTE_TARGET: return createRemoteTarget();
      case ErlangPackage.BLOCK_EXPR: return createBlockExpr();
      case ErlangPackage.ATOM: return createAtom();
      case ErlangPackage.VARIABLE: return createVariable();
      case ErlangPackage.CHAR: return createChar();
      case ErlangPackage.MACRO_EXPR: return createMacroExpr();
      case ErlangPackage.ERL_STRING: return createErlString();
      case ErlangPackage.INTEGER: return createInteger();
      case ErlangPackage.FLOAT: return createFloat();
      case ErlangPackage.LIST: return createList();
      case ErlangPackage.UNARY_TYPE: return createUnaryType();
      case ErlangPackage.REMOTE_TYPE: return createRemoteType();
      case ErlangPackage.LIST_TYPE: return createListType();
      case ErlangPackage.TUPLE_TYPE: return createTupleType();
      case ErlangPackage.RECORD_TYPE: return createRecordType();
      case ErlangPackage.FUN_TYPE_LIST: return createFunTypeList();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Module createModule()
  {
    ModuleImpl module = new ModuleImpl();
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Form createForm()
  {
    FormImpl form = new FormImpl();
    return form;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalFormBlock createConditionalFormBlock()
  {
    ConditionalFormBlockImpl conditionalFormBlock = new ConditionalFormBlockImpl();
    return conditionalFormBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractElement createAbstractElement()
  {
    AbstractElementImpl abstractElement = new AbstractElementImpl();
    return abstractElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractDefineAttribute createAbstractDefineAttribute()
  {
    AbstractDefineAttributeImpl abstractDefineAttribute = new AbstractDefineAttributeImpl();
    return abstractDefineAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineAttribute createDefineAttribute()
  {
    DefineAttributeImpl defineAttribute = new DefineAttributeImpl();
    return defineAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UndefAttribute createUndefAttribute()
  {
    UndefAttributeImpl undefAttribute = new UndefAttributeImpl();
    return undefAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfdefAttribute createIfdefAttribute()
  {
    IfdefAttributeImpl ifdefAttribute = new IfdefAttributeImpl();
    return ifdefAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EndifAttribute createEndifAttribute()
  {
    EndifAttributeImpl endifAttribute = new EndifAttributeImpl();
    return endifAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElseAttribute createElseAttribute()
  {
    ElseAttributeImpl elseAttribute = new ElseAttributeImpl();
    return elseAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IncludeAttribute createIncludeAttribute()
  {
    IncludeAttributeImpl includeAttribute = new IncludeAttributeImpl();
    return includeAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FileAttribute createFileAttribute()
  {
    FileAttributeImpl fileAttribute = new FileAttributeImpl();
    return fileAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleAttribute createModuleAttribute()
  {
    ModuleAttributeImpl moduleAttribute = new ModuleAttributeImpl();
    return moduleAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordAttribute createRecordAttribute()
  {
    RecordAttributeImpl recordAttribute = new RecordAttributeImpl();
    return recordAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractTypeAttribute createAbstractTypeAttribute()
  {
    AbstractTypeAttributeImpl abstractTypeAttribute = new AbstractTypeAttributeImpl();
    return abstractTypeAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecAttribute createSpecAttribute()
  {
    SpecAttributeImpl specAttribute = new SpecAttributeImpl();
    return specAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeAttribute createTypeAttribute()
  {
    TypeAttributeImpl typeAttribute = new TypeAttributeImpl();
    return typeAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomAttribute createCustomAttribute()
  {
    CustomAttributeImpl customAttribute = new CustomAttributeImpl();
    return customAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionClause createFunctionClause()
  {
    FunctionClauseImpl functionClause = new FunctionClauseImpl();
    return functionClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Guard createGuard()
  {
    GuardImpl guard = new GuardImpl();
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expressions createExpressions()
  {
    ExpressionsImpl expressions = new ExpressionsImpl();
    return expressions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MacroCall createMacroCall()
  {
    MacroCallImpl macroCall = new MacroCallImpl();
    return macroCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordExpr createRecordExpr()
  {
    RecordExprImpl recordExpr = new RecordExprImpl();
    return recordExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryExpr createQueryExpr()
  {
    QueryExprImpl queryExpr = new QueryExprImpl();
    return queryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CondExpr createCondExpr()
  {
    CondExprImpl condExpr = new CondExprImpl();
    return condExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LetExpr createLetExpr()
  {
    LetExprImpl letExpr = new LetExprImpl();
    return letExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordTuple createRecordTuple()
  {
    RecordTupleImpl recordTuple = new RecordTupleImpl();
    return recordTuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordFieldDef createRecordFieldDef()
  {
    RecordFieldDefImpl recordFieldDef = new RecordFieldDefImpl();
    return recordFieldDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordField createRecordField()
  {
    RecordFieldImpl recordField = new RecordFieldImpl();
    return recordField;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfExpr createIfExpr()
  {
    IfExprImpl ifExpr = new IfExprImpl();
    return ifExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfClause createIfClause()
  {
    IfClauseImpl ifClause = new IfClauseImpl();
    return ifClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CaseExpr createCaseExpr()
  {
    CaseExprImpl caseExpr = new CaseExprImpl();
    return caseExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CrClause createCrClause()
  {
    CrClauseImpl crClause = new CrClauseImpl();
    return crClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReceiveExpr createReceiveExpr()
  {
    ReceiveExprImpl receiveExpr = new ReceiveExprImpl();
    return receiveExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunExpr createFunExpr()
  {
    FunExprImpl funExpr = new FunExprImpl();
    return funExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefFun createRefFun()
  {
    RefFunImpl refFun = new RefFunImpl();
    return refFun;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TryExpr createTryExpr()
  {
    TryExprImpl tryExpr = new TryExprImpl();
    return tryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TryClause createTryClause()
  {
    TryClauseImpl tryClause = new TryClauseImpl();
    return tryClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlList createErlList()
  {
    ErlListImpl erlList = new ErlListImpl();
    return erlList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListComprehension createListComprehension()
  {
    ListComprehensionImpl listComprehension = new ListComprehensionImpl();
    return listComprehension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tuple createTuple()
  {
    TupleImpl tuple = new TupleImpl();
    return tuple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryComprehension createBinaryComprehension()
  {
    BinaryComprehensionImpl binaryComprehension = new BinaryComprehensionImpl();
    return binaryComprehension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Binary createBinary()
  {
    BinaryImpl binary = new BinaryImpl();
    return binary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryItem createBinaryItem()
  {
    BinaryItemImpl binaryItem = new BinaryItemImpl();
    return binaryItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitType createBitType()
  {
    BitTypeImpl bitType = new BitTypeImpl();
    return bitType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LCExpr createLCExpr()
  {
    LCExprImpl lcExpr = new LCExprImpl();
    return lcExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecFun createSpecFun()
  {
    SpecFunImpl specFun = new SpecFunImpl();
    return specFun;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSigs createTypeSigs()
  {
    TypeSigsImpl typeSigs = new TypeSigsImpl();
    return typeSigs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSig createTypeSig()
  {
    TypeSigImpl typeSig = new TypeSigImpl();
    return typeSig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunType createFunType()
  {
    FunTypeImpl funType = new FunTypeImpl();
    return funType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TopTypes createTopTypes()
  {
    TopTypesImpl topTypes = new TopTypesImpl();
    return topTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeGuards createTypeGuards()
  {
    TypeGuardsImpl typeGuards = new TypeGuardsImpl();
    return typeGuards;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeGuard createTypeGuard()
  {
    TypeGuardImpl typeGuard = new TypeGuardImpl();
    return typeGuard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TopType createTopType()
  {
    TopTypeImpl topType = new TopTypeImpl();
    return topType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type100 createType100()
  {
    Type100Impl type100 = new Type100Impl();
    return type100;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type200 createType200()
  {
    Type200Impl type200 = new Type200Impl();
    return type200;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type300 createType300()
  {
    Type300Impl type300 = new Type300Impl();
    return type300;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type400 createType400()
  {
    Type400Impl type400 = new Type400Impl();
    return type400;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type500 createType500()
  {
    Type500Impl type500 = new Type500Impl();
    return type500;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FieldType createFieldType()
  {
    FieldTypeImpl fieldType = new FieldTypeImpl();
    return fieldType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryType createBinaryType()
  {
    BinaryTypeImpl binaryType = new BinaryTypeImpl();
    return binaryType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinBaseType createBinBaseType()
  {
    BinBaseTypeImpl binBaseType = new BinBaseTypeImpl();
    return binBaseType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinUnitType createBinUnitType()
  {
    BinUnitTypeImpl binUnitType = new BinUnitTypeImpl();
    return binUnitType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunType100 createFunType100()
  {
    FunType100Impl funType100 = new FunType100Impl();
    return funType100;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MacroForm createMacroForm()
  {
    MacroFormImpl macroForm = new MacroFormImpl();
    return macroForm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CatchExpr createCatchExpr()
  {
    CatchExprImpl catchExpr = new CatchExprImpl();
    return catchExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatchExpr createMatchExpr()
  {
    MatchExprImpl matchExpr = new MatchExprImpl();
    return matchExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinOp createBinOp()
  {
    BinOpImpl binOp = new BinOpImpl();
    return binOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AddOp createAddOp()
  {
    AddOpImpl addOp = new AddOpImpl();
    return addOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultOp createMultOp()
  {
    MultOpImpl multOp = new MultOpImpl();
    return multOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpr createUnaryExpr()
  {
    UnaryExprImpl unaryExpr = new UnaryExprImpl();
    return unaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunCall createFunCall()
  {
    FunCallImpl funCall = new FunCallImpl();
    return funCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RemoteTarget createRemoteTarget()
  {
    RemoteTargetImpl remoteTarget = new RemoteTargetImpl();
    return remoteTarget;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockExpr createBlockExpr()
  {
    BlockExprImpl blockExpr = new BlockExprImpl();
    return blockExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Atom createAtom()
  {
    AtomImpl atom = new AtomImpl();
    return atom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Char createChar()
  {
    CharImpl char_ = new CharImpl();
    return char_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MacroExpr createMacroExpr()
  {
    MacroExprImpl macroExpr = new MacroExprImpl();
    return macroExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlString createErlString()
  {
    ErlStringImpl erlString = new ErlStringImpl();
    return erlString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.erlide.erlang.Integer createInteger()
  {
    IntegerImpl integer = new IntegerImpl();
    return integer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.erlide.erlang.Float createFloat()
  {
    FloatImpl float_ = new FloatImpl();
    return float_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List createList()
  {
    ListImpl list = new ListImpl();
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryType createUnaryType()
  {
    UnaryTypeImpl unaryType = new UnaryTypeImpl();
    return unaryType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RemoteType createRemoteType()
  {
    RemoteTypeImpl remoteType = new RemoteTypeImpl();
    return remoteType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListType createListType()
  {
    ListTypeImpl listType = new ListTypeImpl();
    return listType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleType createTupleType()
  {
    TupleTypeImpl tupleType = new TupleTypeImpl();
    return tupleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordType createRecordType()
  {
    RecordTypeImpl recordType = new RecordTypeImpl();
    return recordType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunTypeList createFunTypeList()
  {
    FunTypeListImpl funTypeList = new FunTypeListImpl();
    return funTypeList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlangPackage getErlangPackage()
  {
    return (ErlangPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ErlangPackage getPackage()
  {
    return ErlangPackage.eINSTANCE;
  }

} //ErlangFactoryImpl