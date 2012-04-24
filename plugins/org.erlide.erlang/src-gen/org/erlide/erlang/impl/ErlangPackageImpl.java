/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ErlangPackageImpl extends EPackageImpl implements ErlangPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalFormBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractDefineAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defineAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass undefAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifdefAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass endifAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elseAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass includeAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fileAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractTypeAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass customAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass guardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass macroCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass condExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass letExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordTupleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordFieldDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordFieldEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass caseExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass crClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass receiveExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass funExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refFunEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tryExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tryClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass erlListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listComprehensionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binaryComprehensionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binaryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binaryItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lcExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specFunEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeSigsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeSigEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass funTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass topTypesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeGuardsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeGuardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass topTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass type100EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass type200EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass type300EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass type400EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass type500EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fieldTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binaryTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binBaseTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binUnitTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass funType100EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass macroFormEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass catchExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass matchExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binOpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass addOpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multOpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass funCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass remoteTargetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass charEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass macroExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass erlStringEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floatEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass remoteTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass funTypeListEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.erlide.erlang.ErlangPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ErlangPackageImpl()
  {
    super(eNS_URI, ErlangFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ErlangPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ErlangPackage init()
  {
    if (isInited) return (ErlangPackage)EPackage.Registry.INSTANCE.getEPackage(ErlangPackage.eNS_URI);

    // Obtain or create and register package
    ErlangPackageImpl theErlangPackage = (ErlangPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ErlangPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ErlangPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theErlangPackage.createPackageContents();

    // Initialize created meta-data
    theErlangPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theErlangPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ErlangPackage.eNS_URI, theErlangPackage);
    return theErlangPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModule()
  {
    return moduleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Forms()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForm()
  {
    return formEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalFormBlock()
  {
    return conditionalFormBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalFormBlock_Condition()
  {
    return (EReference)conditionalFormBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalFormBlock_IfForms()
  {
    return (EReference)conditionalFormBlockEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConditionalFormBlock_HasElse()
  {
    return (EAttribute)conditionalFormBlockEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalFormBlock_ElseForms()
  {
    return (EReference)conditionalFormBlockEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalFormBlock_End()
  {
    return (EReference)conditionalFormBlockEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractElement()
  {
    return abstractElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractDefineAttribute()
  {
    return abstractDefineAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefineAttribute()
  {
    return defineAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefineAttribute_Tag()
  {
    return (EAttribute)defineAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefineAttribute_Name()
  {
    return (EAttribute)defineAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefineAttribute_Args()
  {
    return (EReference)defineAttributeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefineAttribute_Value()
  {
    return (EReference)defineAttributeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUndefAttribute()
  {
    return undefAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUndefAttribute_Tag()
  {
    return (EAttribute)undefAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUndefAttribute_Name()
  {
    return (EReference)undefAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfdefAttribute()
  {
    return ifdefAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIfdefAttribute_Tag()
  {
    return (EAttribute)ifdefAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfdefAttribute_Ref()
  {
    return (EReference)ifdefAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEndifAttribute()
  {
    return endifAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEndifAttribute_Tag()
  {
    return (EAttribute)endifAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElseAttribute()
  {
    return elseAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getElseAttribute_Tag()
  {
    return (EAttribute)elseAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIncludeAttribute()
  {
    return includeAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIncludeAttribute_Tag()
  {
    return (EAttribute)includeAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIncludeAttribute_Value()
  {
    return (EReference)includeAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFileAttribute()
  {
    return fileAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFileAttribute_Tag()
  {
    return (EAttribute)fileAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFileAttribute_File()
  {
    return (EAttribute)fileAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFileAttribute_Line()
  {
    return (EAttribute)fileAttributeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModuleAttribute()
  {
    return moduleAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModuleAttribute_Tag()
  {
    return (EAttribute)moduleAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModuleAttribute_Name()
  {
    return (EAttribute)moduleAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordAttribute()
  {
    return recordAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordAttribute_Tag()
  {
    return (EAttribute)recordAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordAttribute_Name()
  {
    return (EAttribute)recordAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordAttribute_Fields()
  {
    return (EReference)recordAttributeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordAttribute_RecordMacro()
  {
    return (EReference)recordAttributeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractTypeAttribute()
  {
    return abstractTypeAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractTypeAttribute_Tag()
  {
    return (EAttribute)abstractTypeAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecAttribute()
  {
    return specAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecAttribute_Type()
  {
    return (EReference)specAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecAttribute_Signatures()
  {
    return (EReference)specAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeAttribute()
  {
    return typeAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeAttribute_Name()
  {
    return (EAttribute)typeAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeAttribute_Args()
  {
    return (EReference)typeAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeAttribute_Type()
  {
    return (EReference)typeAttributeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCustomAttribute()
  {
    return customAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCustomAttribute_Tag()
  {
    return (EAttribute)customAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCustomAttribute_Value()
  {
    return (EReference)customAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunction()
  {
    return functionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunction_Name()
  {
    return (EAttribute)functionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunction_Clauses()
  {
    return (EReference)functionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionClause()
  {
    return functionClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionClause_Ref()
  {
    return (EAttribute)functionClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionClause_Params()
  {
    return (EReference)functionClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionClause_Guard()
  {
    return (EReference)functionClauseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionClause_Body()
  {
    return (EReference)functionClauseEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGuard()
  {
    return guardEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGuard_Guards()
  {
    return (EReference)guardEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressions()
  {
    return expressionsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressions_Exprs()
  {
    return (EReference)expressionsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpression_Line()
  {
    return (EAttribute)expressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Expr()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMacroCall()
  {
    return macroCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMacroCall_Name()
  {
    return (EReference)macroCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMacroCall_Args()
  {
    return (EReference)macroCallEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordExpr()
  {
    return recordExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordExpr_Ref()
  {
    return (EReference)recordExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordExpr_Record()
  {
    return (EReference)recordExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordExpr_Rec()
  {
    return (EReference)recordExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordExpr_Field()
  {
    return (EReference)recordExprEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordExpr_Tuple()
  {
    return (EReference)recordExprEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryExpr()
  {
    return queryExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCondExpr()
  {
    return condExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLetExpr()
  {
    return letExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordTuple()
  {
    return recordTupleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordTuple_Fields()
  {
    return (EReference)recordTupleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordFieldDef()
  {
    return recordFieldDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordFieldDef_Name()
  {
    return (EAttribute)recordFieldDefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordFieldDef_Value()
  {
    return (EReference)recordFieldDefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordFieldDef_Type()
  {
    return (EReference)recordFieldDefEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordField()
  {
    return recordFieldEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordField_Ref()
  {
    return (EReference)recordFieldEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordField_Value()
  {
    return (EReference)recordFieldEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordField_Type()
  {
    return (EReference)recordFieldEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfExpr()
  {
    return ifExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfExpr_Clauses()
  {
    return (EReference)ifExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfClause()
  {
    return ifClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfClause_Guard()
  {
    return (EReference)ifClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfClause_Body()
  {
    return (EReference)ifClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCaseExpr()
  {
    return caseExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCaseExpr_Clauses()
  {
    return (EReference)caseExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCrClause()
  {
    return crClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCrClause_Expr()
  {
    return (EReference)crClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCrClause_Guard()
  {
    return (EReference)crClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCrClause_Body()
  {
    return (EReference)crClauseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReceiveExpr()
  {
    return receiveExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReceiveExpr_Clauses()
  {
    return (EReference)receiveExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReceiveExpr_After_expr()
  {
    return (EReference)receiveExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReceiveExpr_After_body()
  {
    return (EReference)receiveExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunExpr()
  {
    return funExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunExpr_Clauses()
  {
    return (EReference)funExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefFun()
  {
    return refFunEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefFun_Module()
  {
    return (EReference)refFunEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefFun_Function()
  {
    return (EReference)refFunEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRefFun_Arity()
  {
    return (EAttribute)refFunEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTryExpr()
  {
    return tryExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTryExpr_Body()
  {
    return (EReference)tryExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTryExpr_Of_clauses()
  {
    return (EReference)tryExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTryExpr_Catch()
  {
    return (EReference)tryExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTryExpr_After_body()
  {
    return (EReference)tryExprEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTryClause()
  {
    return tryClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTryClause_Hdr()
  {
    return (EAttribute)tryClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTryClause_Cond()
  {
    return (EReference)tryClauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTryClause_Guard()
  {
    return (EReference)tryClauseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTryClause_Body()
  {
    return (EReference)tryClauseEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErlList()
  {
    return erlListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErlList_Elements()
  {
    return (EReference)erlListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErlList_Tail()
  {
    return (EReference)erlListEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getListComprehension()
  {
    return listComprehensionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListComprehension_Element()
  {
    return (EReference)listComprehensionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListComprehension_Generators()
  {
    return (EReference)listComprehensionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTuple()
  {
    return tupleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTuple_Elements()
  {
    return (EReference)tupleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinaryComprehension()
  {
    return binaryComprehensionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryComprehension_Generators()
  {
    return (EReference)binaryComprehensionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinary()
  {
    return binaryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinary_Elements()
  {
    return (EReference)binaryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinaryItem()
  {
    return binaryItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryItem_Expr()
  {
    return (EReference)binaryItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryItem_Size()
  {
    return (EReference)binaryItemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryItem_Types()
  {
    return (EReference)binaryItemEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryItem_Type()
  {
    return (EReference)binaryItemEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitType()
  {
    return bitTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBitType_Name()
  {
    return (EAttribute)bitTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBitType_Size()
  {
    return (EAttribute)bitTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLCExpr()
  {
    return lcExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLCExpr_O1()
  {
    return (EReference)lcExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLCExpr_Op()
  {
    return (EAttribute)lcExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLCExpr_O2()
  {
    return (EReference)lcExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecFun()
  {
    return specFunEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecFun_M()
  {
    return (EAttribute)specFunEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecFun_F()
  {
    return (EAttribute)specFunEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecFun_A()
  {
    return (EAttribute)specFunEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeSigs()
  {
    return typeSigsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeSigs_Items()
  {
    return (EReference)typeSigsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeSig()
  {
    return typeSigEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeSig_Decl()
  {
    return (EReference)typeSigEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeSig_Guards()
  {
    return (EReference)typeSigEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunType()
  {
    return funTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunType_Args()
  {
    return (EReference)funTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunType_Return()
  {
    return (EReference)funTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunType_Type()
  {
    return (EReference)funTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTopTypes()
  {
    return topTypesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTopTypes_Items()
  {
    return (EReference)topTypesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeGuards()
  {
    return typeGuardsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeGuards_Items()
  {
    return (EReference)typeGuardsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeGuard()
  {
    return typeGuardEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeGuard_Name()
  {
    return (EAttribute)typeGuardEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeGuard_Types()
  {
    return (EReference)typeGuardEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeGuard_Type()
  {
    return (EReference)typeGuardEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTopType()
  {
    return topTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTopType_Var()
  {
    return (EAttribute)topTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTopType_Type()
  {
    return (EReference)topTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTopType_LeftOperand()
  {
    return (EReference)topTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTopType_Op()
  {
    return (EAttribute)topTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTopType_RightOperand()
  {
    return (EReference)topTypeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType100()
  {
    return type100EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType200()
  {
    return type200EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType300()
  {
    return type300EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType400()
  {
    return type400EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType500()
  {
    return type500EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getType_Name()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getType_Value()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFieldType()
  {
    return fieldTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFieldType_Name()
  {
    return (EAttribute)fieldTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldType_Type()
  {
    return (EReference)fieldTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinaryType()
  {
    return binaryTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryType_Type()
  {
    return (EReference)binaryTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinBaseType()
  {
    return binBaseTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBinBaseType_Name()
  {
    return (EAttribute)binBaseTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinBaseType_Type()
  {
    return (EReference)binBaseTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinUnitType()
  {
    return binUnitTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBinUnitType_Name()
  {
    return (EAttribute)binUnitTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBinUnitType_M()
  {
    return (EAttribute)binUnitTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinUnitType_Type()
  {
    return (EReference)binUnitTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunType100()
  {
    return funType100EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMacroForm()
  {
    return macroFormEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMacroForm_Name()
  {
    return (EAttribute)macroFormEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCatchExpr()
  {
    return catchExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMatchExpr()
  {
    return matchExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatchExpr_OpLeft()
  {
    return (EReference)matchExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMatchExpr_Op()
  {
    return (EAttribute)matchExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatchExpr_OpRight()
  {
    return (EReference)matchExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinOp()
  {
    return binOpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinOp_OpLeft()
  {
    return (EReference)binOpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBinOp_Op()
  {
    return (EAttribute)binOpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinOp_OpRight()
  {
    return (EReference)binOpEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinOp_OpRight2()
  {
    return (EReference)binOpEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAddOp()
  {
    return addOpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAddOp_OpLeft()
  {
    return (EReference)addOpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAddOp_Op()
  {
    return (EAttribute)addOpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAddOp_OpRight()
  {
    return (EReference)addOpEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultOp()
  {
    return multOpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultOp_OpLeft()
  {
    return (EReference)multOpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultOp_Op()
  {
    return (EAttribute)multOpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultOp_OpRight()
  {
    return (EReference)multOpEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryExpr()
  {
    return unaryExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpr_Op()
  {
    return (EAttribute)unaryExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryExpr_Operand()
  {
    return (EReference)unaryExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunCall()
  {
    return funCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunCall_Target()
  {
    return (EReference)funCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunCall_Args()
  {
    return (EReference)funCallEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRemoteTarget()
  {
    return remoteTargetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRemoteTarget_Module()
  {
    return (EReference)remoteTargetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRemoteTarget_Function()
  {
    return (EReference)remoteTargetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlockExpr()
  {
    return blockExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlockExpr_Body()
  {
    return (EReference)blockExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtom()
  {
    return atomEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAtom_Value()
  {
    return (EReference)atomEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariable()
  {
    return variableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariable_Value()
  {
    return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChar()
  {
    return charEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChar_Value()
  {
    return (EAttribute)charEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMacroExpr()
  {
    return macroExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMacroExpr_Value()
  {
    return (EReference)macroExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErlString()
  {
    return erlStringEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErlString_Value()
  {
    return (EAttribute)erlStringEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInteger()
  {
    return integerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInteger_Value()
  {
    return (EAttribute)integerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFloat()
  {
    return floatEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFloat_Value()
  {
    return (EAttribute)floatEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getList()
  {
    return listEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryType()
  {
    return unaryTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryType_Op()
  {
    return (EAttribute)unaryTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryType_Operand()
  {
    return (EReference)unaryTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRemoteType()
  {
    return remoteTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRemoteType_M()
  {
    return (EReference)remoteTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRemoteType_Args()
  {
    return (EReference)remoteTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getListType()
  {
    return listTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListType_Type()
  {
    return (EReference)listTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTupleType()
  {
    return tupleTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleType_Types()
  {
    return (EReference)tupleTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordType()
  {
    return recordTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordType_Rec()
  {
    return (EAttribute)recordTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordType_Fields()
  {
    return (EReference)recordTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunTypeList()
  {
    return funTypeListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunTypeList_Items()
  {
    return (EReference)funTypeListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunTypeList_Return()
  {
    return (EReference)funTypeListEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlangFactory getErlangFactory()
  {
    return (ErlangFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    moduleEClass = createEClass(MODULE);
    createEReference(moduleEClass, MODULE__FORMS);

    formEClass = createEClass(FORM);

    conditionalFormBlockEClass = createEClass(CONDITIONAL_FORM_BLOCK);
    createEReference(conditionalFormBlockEClass, CONDITIONAL_FORM_BLOCK__CONDITION);
    createEReference(conditionalFormBlockEClass, CONDITIONAL_FORM_BLOCK__IF_FORMS);
    createEAttribute(conditionalFormBlockEClass, CONDITIONAL_FORM_BLOCK__HAS_ELSE);
    createEReference(conditionalFormBlockEClass, CONDITIONAL_FORM_BLOCK__ELSE_FORMS);
    createEReference(conditionalFormBlockEClass, CONDITIONAL_FORM_BLOCK__END);

    abstractElementEClass = createEClass(ABSTRACT_ELEMENT);

    attributeEClass = createEClass(ATTRIBUTE);

    abstractDefineAttributeEClass = createEClass(ABSTRACT_DEFINE_ATTRIBUTE);

    defineAttributeEClass = createEClass(DEFINE_ATTRIBUTE);
    createEAttribute(defineAttributeEClass, DEFINE_ATTRIBUTE__TAG);
    createEAttribute(defineAttributeEClass, DEFINE_ATTRIBUTE__NAME);
    createEReference(defineAttributeEClass, DEFINE_ATTRIBUTE__ARGS);
    createEReference(defineAttributeEClass, DEFINE_ATTRIBUTE__VALUE);

    undefAttributeEClass = createEClass(UNDEF_ATTRIBUTE);
    createEAttribute(undefAttributeEClass, UNDEF_ATTRIBUTE__TAG);
    createEReference(undefAttributeEClass, UNDEF_ATTRIBUTE__NAME);

    ifdefAttributeEClass = createEClass(IFDEF_ATTRIBUTE);
    createEAttribute(ifdefAttributeEClass, IFDEF_ATTRIBUTE__TAG);
    createEReference(ifdefAttributeEClass, IFDEF_ATTRIBUTE__REF);

    endifAttributeEClass = createEClass(ENDIF_ATTRIBUTE);
    createEAttribute(endifAttributeEClass, ENDIF_ATTRIBUTE__TAG);

    elseAttributeEClass = createEClass(ELSE_ATTRIBUTE);
    createEAttribute(elseAttributeEClass, ELSE_ATTRIBUTE__TAG);

    includeAttributeEClass = createEClass(INCLUDE_ATTRIBUTE);
    createEAttribute(includeAttributeEClass, INCLUDE_ATTRIBUTE__TAG);
    createEReference(includeAttributeEClass, INCLUDE_ATTRIBUTE__VALUE);

    fileAttributeEClass = createEClass(FILE_ATTRIBUTE);
    createEAttribute(fileAttributeEClass, FILE_ATTRIBUTE__TAG);
    createEAttribute(fileAttributeEClass, FILE_ATTRIBUTE__FILE);
    createEAttribute(fileAttributeEClass, FILE_ATTRIBUTE__LINE);

    moduleAttributeEClass = createEClass(MODULE_ATTRIBUTE);
    createEAttribute(moduleAttributeEClass, MODULE_ATTRIBUTE__TAG);
    createEAttribute(moduleAttributeEClass, MODULE_ATTRIBUTE__NAME);

    recordAttributeEClass = createEClass(RECORD_ATTRIBUTE);
    createEAttribute(recordAttributeEClass, RECORD_ATTRIBUTE__TAG);
    createEAttribute(recordAttributeEClass, RECORD_ATTRIBUTE__NAME);
    createEReference(recordAttributeEClass, RECORD_ATTRIBUTE__FIELDS);
    createEReference(recordAttributeEClass, RECORD_ATTRIBUTE__RECORD_MACRO);

    abstractTypeAttributeEClass = createEClass(ABSTRACT_TYPE_ATTRIBUTE);
    createEAttribute(abstractTypeAttributeEClass, ABSTRACT_TYPE_ATTRIBUTE__TAG);

    specAttributeEClass = createEClass(SPEC_ATTRIBUTE);
    createEReference(specAttributeEClass, SPEC_ATTRIBUTE__TYPE);
    createEReference(specAttributeEClass, SPEC_ATTRIBUTE__SIGNATURES);

    typeAttributeEClass = createEClass(TYPE_ATTRIBUTE);
    createEAttribute(typeAttributeEClass, TYPE_ATTRIBUTE__NAME);
    createEReference(typeAttributeEClass, TYPE_ATTRIBUTE__ARGS);
    createEReference(typeAttributeEClass, TYPE_ATTRIBUTE__TYPE);

    customAttributeEClass = createEClass(CUSTOM_ATTRIBUTE);
    createEAttribute(customAttributeEClass, CUSTOM_ATTRIBUTE__TAG);
    createEReference(customAttributeEClass, CUSTOM_ATTRIBUTE__VALUE);

    functionEClass = createEClass(FUNCTION);
    createEAttribute(functionEClass, FUNCTION__NAME);
    createEReference(functionEClass, FUNCTION__CLAUSES);

    functionClauseEClass = createEClass(FUNCTION_CLAUSE);
    createEAttribute(functionClauseEClass, FUNCTION_CLAUSE__REF);
    createEReference(functionClauseEClass, FUNCTION_CLAUSE__PARAMS);
    createEReference(functionClauseEClass, FUNCTION_CLAUSE__GUARD);
    createEReference(functionClauseEClass, FUNCTION_CLAUSE__BODY);

    guardEClass = createEClass(GUARD);
    createEReference(guardEClass, GUARD__GUARDS);

    expressionsEClass = createEClass(EXPRESSIONS);
    createEReference(expressionsEClass, EXPRESSIONS__EXPRS);

    expressionEClass = createEClass(EXPRESSION);
    createEAttribute(expressionEClass, EXPRESSION__LINE);
    createEReference(expressionEClass, EXPRESSION__EXPR);

    macroCallEClass = createEClass(MACRO_CALL);
    createEReference(macroCallEClass, MACRO_CALL__NAME);
    createEReference(macroCallEClass, MACRO_CALL__ARGS);

    recordExprEClass = createEClass(RECORD_EXPR);
    createEReference(recordExprEClass, RECORD_EXPR__REF);
    createEReference(recordExprEClass, RECORD_EXPR__RECORD);
    createEReference(recordExprEClass, RECORD_EXPR__REC);
    createEReference(recordExprEClass, RECORD_EXPR__FIELD);
    createEReference(recordExprEClass, RECORD_EXPR__TUPLE);

    queryExprEClass = createEClass(QUERY_EXPR);

    condExprEClass = createEClass(COND_EXPR);

    letExprEClass = createEClass(LET_EXPR);

    recordTupleEClass = createEClass(RECORD_TUPLE);
    createEReference(recordTupleEClass, RECORD_TUPLE__FIELDS);

    recordFieldDefEClass = createEClass(RECORD_FIELD_DEF);
    createEAttribute(recordFieldDefEClass, RECORD_FIELD_DEF__NAME);
    createEReference(recordFieldDefEClass, RECORD_FIELD_DEF__VALUE);
    createEReference(recordFieldDefEClass, RECORD_FIELD_DEF__TYPE);

    recordFieldEClass = createEClass(RECORD_FIELD);
    createEReference(recordFieldEClass, RECORD_FIELD__REF);
    createEReference(recordFieldEClass, RECORD_FIELD__VALUE);
    createEReference(recordFieldEClass, RECORD_FIELD__TYPE);

    ifExprEClass = createEClass(IF_EXPR);
    createEReference(ifExprEClass, IF_EXPR__CLAUSES);

    ifClauseEClass = createEClass(IF_CLAUSE);
    createEReference(ifClauseEClass, IF_CLAUSE__GUARD);
    createEReference(ifClauseEClass, IF_CLAUSE__BODY);

    caseExprEClass = createEClass(CASE_EXPR);
    createEReference(caseExprEClass, CASE_EXPR__CLAUSES);

    crClauseEClass = createEClass(CR_CLAUSE);
    createEReference(crClauseEClass, CR_CLAUSE__EXPR);
    createEReference(crClauseEClass, CR_CLAUSE__GUARD);
    createEReference(crClauseEClass, CR_CLAUSE__BODY);

    receiveExprEClass = createEClass(RECEIVE_EXPR);
    createEReference(receiveExprEClass, RECEIVE_EXPR__CLAUSES);
    createEReference(receiveExprEClass, RECEIVE_EXPR__AFTER_EXPR);
    createEReference(receiveExprEClass, RECEIVE_EXPR__AFTER_BODY);

    funExprEClass = createEClass(FUN_EXPR);
    createEReference(funExprEClass, FUN_EXPR__CLAUSES);

    refFunEClass = createEClass(REF_FUN);
    createEReference(refFunEClass, REF_FUN__MODULE);
    createEReference(refFunEClass, REF_FUN__FUNCTION);
    createEAttribute(refFunEClass, REF_FUN__ARITY);

    tryExprEClass = createEClass(TRY_EXPR);
    createEReference(tryExprEClass, TRY_EXPR__BODY);
    createEReference(tryExprEClass, TRY_EXPR__OF_CLAUSES);
    createEReference(tryExprEClass, TRY_EXPR__CATCH);
    createEReference(tryExprEClass, TRY_EXPR__AFTER_BODY);

    tryClauseEClass = createEClass(TRY_CLAUSE);
    createEAttribute(tryClauseEClass, TRY_CLAUSE__HDR);
    createEReference(tryClauseEClass, TRY_CLAUSE__COND);
    createEReference(tryClauseEClass, TRY_CLAUSE__GUARD);
    createEReference(tryClauseEClass, TRY_CLAUSE__BODY);

    erlListEClass = createEClass(ERL_LIST);
    createEReference(erlListEClass, ERL_LIST__ELEMENTS);
    createEReference(erlListEClass, ERL_LIST__TAIL);

    listComprehensionEClass = createEClass(LIST_COMPREHENSION);
    createEReference(listComprehensionEClass, LIST_COMPREHENSION__ELEMENT);
    createEReference(listComprehensionEClass, LIST_COMPREHENSION__GENERATORS);

    tupleEClass = createEClass(TUPLE);
    createEReference(tupleEClass, TUPLE__ELEMENTS);

    binaryComprehensionEClass = createEClass(BINARY_COMPREHENSION);
    createEReference(binaryComprehensionEClass, BINARY_COMPREHENSION__GENERATORS);

    binaryEClass = createEClass(BINARY);
    createEReference(binaryEClass, BINARY__ELEMENTS);

    binaryItemEClass = createEClass(BINARY_ITEM);
    createEReference(binaryItemEClass, BINARY_ITEM__EXPR);
    createEReference(binaryItemEClass, BINARY_ITEM__SIZE);
    createEReference(binaryItemEClass, BINARY_ITEM__TYPES);
    createEReference(binaryItemEClass, BINARY_ITEM__TYPE);

    bitTypeEClass = createEClass(BIT_TYPE);
    createEAttribute(bitTypeEClass, BIT_TYPE__NAME);
    createEAttribute(bitTypeEClass, BIT_TYPE__SIZE);

    lcExprEClass = createEClass(LC_EXPR);
    createEReference(lcExprEClass, LC_EXPR__O1);
    createEAttribute(lcExprEClass, LC_EXPR__OP);
    createEReference(lcExprEClass, LC_EXPR__O2);

    specFunEClass = createEClass(SPEC_FUN);
    createEAttribute(specFunEClass, SPEC_FUN__M);
    createEAttribute(specFunEClass, SPEC_FUN__F);
    createEAttribute(specFunEClass, SPEC_FUN__A);

    typeSigsEClass = createEClass(TYPE_SIGS);
    createEReference(typeSigsEClass, TYPE_SIGS__ITEMS);

    typeSigEClass = createEClass(TYPE_SIG);
    createEReference(typeSigEClass, TYPE_SIG__DECL);
    createEReference(typeSigEClass, TYPE_SIG__GUARDS);

    funTypeEClass = createEClass(FUN_TYPE);
    createEReference(funTypeEClass, FUN_TYPE__ARGS);
    createEReference(funTypeEClass, FUN_TYPE__RETURN);
    createEReference(funTypeEClass, FUN_TYPE__TYPE);

    topTypesEClass = createEClass(TOP_TYPES);
    createEReference(topTypesEClass, TOP_TYPES__ITEMS);

    typeGuardsEClass = createEClass(TYPE_GUARDS);
    createEReference(typeGuardsEClass, TYPE_GUARDS__ITEMS);

    typeGuardEClass = createEClass(TYPE_GUARD);
    createEAttribute(typeGuardEClass, TYPE_GUARD__NAME);
    createEReference(typeGuardEClass, TYPE_GUARD__TYPES);
    createEReference(typeGuardEClass, TYPE_GUARD__TYPE);

    topTypeEClass = createEClass(TOP_TYPE);
    createEAttribute(topTypeEClass, TOP_TYPE__VAR);
    createEReference(topTypeEClass, TOP_TYPE__TYPE);
    createEReference(topTypeEClass, TOP_TYPE__LEFT_OPERAND);
    createEAttribute(topTypeEClass, TOP_TYPE__OP);
    createEReference(topTypeEClass, TOP_TYPE__RIGHT_OPERAND);

    type100EClass = createEClass(TYPE100);

    type200EClass = createEClass(TYPE200);

    type300EClass = createEClass(TYPE300);

    type400EClass = createEClass(TYPE400);

    type500EClass = createEClass(TYPE500);

    typeEClass = createEClass(TYPE);
    createEAttribute(typeEClass, TYPE__NAME);
    createEAttribute(typeEClass, TYPE__VALUE);

    fieldTypeEClass = createEClass(FIELD_TYPE);
    createEAttribute(fieldTypeEClass, FIELD_TYPE__NAME);
    createEReference(fieldTypeEClass, FIELD_TYPE__TYPE);

    binaryTypeEClass = createEClass(BINARY_TYPE);
    createEReference(binaryTypeEClass, BINARY_TYPE__TYPE);

    binBaseTypeEClass = createEClass(BIN_BASE_TYPE);
    createEAttribute(binBaseTypeEClass, BIN_BASE_TYPE__NAME);
    createEReference(binBaseTypeEClass, BIN_BASE_TYPE__TYPE);

    binUnitTypeEClass = createEClass(BIN_UNIT_TYPE);
    createEAttribute(binUnitTypeEClass, BIN_UNIT_TYPE__NAME);
    createEAttribute(binUnitTypeEClass, BIN_UNIT_TYPE__M);
    createEReference(binUnitTypeEClass, BIN_UNIT_TYPE__TYPE);

    funType100EClass = createEClass(FUN_TYPE100);

    macroFormEClass = createEClass(MACRO_FORM);
    createEAttribute(macroFormEClass, MACRO_FORM__NAME);

    catchExprEClass = createEClass(CATCH_EXPR);

    matchExprEClass = createEClass(MATCH_EXPR);
    createEReference(matchExprEClass, MATCH_EXPR__OP_LEFT);
    createEAttribute(matchExprEClass, MATCH_EXPR__OP);
    createEReference(matchExprEClass, MATCH_EXPR__OP_RIGHT);

    binOpEClass = createEClass(BIN_OP);
    createEReference(binOpEClass, BIN_OP__OP_LEFT);
    createEAttribute(binOpEClass, BIN_OP__OP);
    createEReference(binOpEClass, BIN_OP__OP_RIGHT);
    createEReference(binOpEClass, BIN_OP__OP_RIGHT2);

    addOpEClass = createEClass(ADD_OP);
    createEReference(addOpEClass, ADD_OP__OP_LEFT);
    createEAttribute(addOpEClass, ADD_OP__OP);
    createEReference(addOpEClass, ADD_OP__OP_RIGHT);

    multOpEClass = createEClass(MULT_OP);
    createEReference(multOpEClass, MULT_OP__OP_LEFT);
    createEAttribute(multOpEClass, MULT_OP__OP);
    createEReference(multOpEClass, MULT_OP__OP_RIGHT);

    unaryExprEClass = createEClass(UNARY_EXPR);
    createEAttribute(unaryExprEClass, UNARY_EXPR__OP);
    createEReference(unaryExprEClass, UNARY_EXPR__OPERAND);

    funCallEClass = createEClass(FUN_CALL);
    createEReference(funCallEClass, FUN_CALL__TARGET);
    createEReference(funCallEClass, FUN_CALL__ARGS);

    remoteTargetEClass = createEClass(REMOTE_TARGET);
    createEReference(remoteTargetEClass, REMOTE_TARGET__MODULE);
    createEReference(remoteTargetEClass, REMOTE_TARGET__FUNCTION);

    blockExprEClass = createEClass(BLOCK_EXPR);
    createEReference(blockExprEClass, BLOCK_EXPR__BODY);

    atomEClass = createEClass(ATOM);
    createEReference(atomEClass, ATOM__VALUE);

    variableEClass = createEClass(VARIABLE);
    createEAttribute(variableEClass, VARIABLE__VALUE);

    charEClass = createEClass(CHAR);
    createEAttribute(charEClass, CHAR__VALUE);

    macroExprEClass = createEClass(MACRO_EXPR);
    createEReference(macroExprEClass, MACRO_EXPR__VALUE);

    erlStringEClass = createEClass(ERL_STRING);
    createEAttribute(erlStringEClass, ERL_STRING__VALUE);

    integerEClass = createEClass(INTEGER);
    createEAttribute(integerEClass, INTEGER__VALUE);

    floatEClass = createEClass(FLOAT);
    createEAttribute(floatEClass, FLOAT__VALUE);

    listEClass = createEClass(LIST);

    unaryTypeEClass = createEClass(UNARY_TYPE);
    createEAttribute(unaryTypeEClass, UNARY_TYPE__OP);
    createEReference(unaryTypeEClass, UNARY_TYPE__OPERAND);

    remoteTypeEClass = createEClass(REMOTE_TYPE);
    createEReference(remoteTypeEClass, REMOTE_TYPE__M);
    createEReference(remoteTypeEClass, REMOTE_TYPE__ARGS);

    listTypeEClass = createEClass(LIST_TYPE);
    createEReference(listTypeEClass, LIST_TYPE__TYPE);

    tupleTypeEClass = createEClass(TUPLE_TYPE);
    createEReference(tupleTypeEClass, TUPLE_TYPE__TYPES);

    recordTypeEClass = createEClass(RECORD_TYPE);
    createEAttribute(recordTypeEClass, RECORD_TYPE__REC);
    createEReference(recordTypeEClass, RECORD_TYPE__FIELDS);

    funTypeListEClass = createEClass(FUN_TYPE_LIST);
    createEReference(funTypeListEClass, FUN_TYPE_LIST__ITEMS);
    createEReference(funTypeListEClass, FUN_TYPE_LIST__RETURN);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    moduleEClass.getESuperTypes().add(this.getAbstractElement());
    formEClass.getESuperTypes().add(this.getAbstractElement());
    conditionalFormBlockEClass.getESuperTypes().add(this.getForm());
    attributeEClass.getESuperTypes().add(this.getForm());
    defineAttributeEClass.getESuperTypes().add(this.getAttribute());
    defineAttributeEClass.getESuperTypes().add(this.getAbstractDefineAttribute());
    undefAttributeEClass.getESuperTypes().add(this.getAttribute());
    undefAttributeEClass.getESuperTypes().add(this.getAbstractDefineAttribute());
    includeAttributeEClass.getESuperTypes().add(this.getAttribute());
    fileAttributeEClass.getESuperTypes().add(this.getAttribute());
    moduleAttributeEClass.getESuperTypes().add(this.getAttribute());
    recordAttributeEClass.getESuperTypes().add(this.getAttribute());
    abstractTypeAttributeEClass.getESuperTypes().add(this.getAttribute());
    specAttributeEClass.getESuperTypes().add(this.getAbstractTypeAttribute());
    typeAttributeEClass.getESuperTypes().add(this.getAbstractTypeAttribute());
    customAttributeEClass.getESuperTypes().add(this.getAttribute());
    functionEClass.getESuperTypes().add(this.getForm());
    macroCallEClass.getESuperTypes().add(this.getExpression());
    recordExprEClass.getESuperTypes().add(this.getExpression());
    queryExprEClass.getESuperTypes().add(this.getExpression());
    condExprEClass.getESuperTypes().add(this.getExpression());
    letExprEClass.getESuperTypes().add(this.getExpression());
    ifExprEClass.getESuperTypes().add(this.getExpression());
    caseExprEClass.getESuperTypes().add(this.getExpression());
    receiveExprEClass.getESuperTypes().add(this.getExpression());
    funExprEClass.getESuperTypes().add(this.getExpression());
    refFunEClass.getESuperTypes().add(this.getFunExpr());
    tryExprEClass.getESuperTypes().add(this.getExpression());
    erlListEClass.getESuperTypes().add(this.getExpression());
    listComprehensionEClass.getESuperTypes().add(this.getExpression());
    tupleEClass.getESuperTypes().add(this.getExpression());
    binaryComprehensionEClass.getESuperTypes().add(this.getExpression());
    binaryEClass.getESuperTypes().add(this.getExpression());
    funTypeEClass.getESuperTypes().add(this.getType());
    topTypeEClass.getESuperTypes().add(this.getType100());
    topTypeEClass.getESuperTypes().add(this.getType200());
    topTypeEClass.getESuperTypes().add(this.getType300());
    topTypeEClass.getESuperTypes().add(this.getType400());
    topTypeEClass.getESuperTypes().add(this.getType());
    type200EClass.getESuperTypes().add(this.getType100());
    type300EClass.getESuperTypes().add(this.getType200());
    type400EClass.getESuperTypes().add(this.getType300());
    type500EClass.getESuperTypes().add(this.getType400());
    typeEClass.getESuperTypes().add(this.getType500());
    binaryTypeEClass.getESuperTypes().add(this.getType());
    macroFormEClass.getESuperTypes().add(this.getForm());
    catchExprEClass.getESuperTypes().add(this.getExpression());
    matchExprEClass.getESuperTypes().add(this.getExpression());
    binOpEClass.getESuperTypes().add(this.getExpression());
    addOpEClass.getESuperTypes().add(this.getExpression());
    multOpEClass.getESuperTypes().add(this.getExpression());
    unaryExprEClass.getESuperTypes().add(this.getExpression());
    funCallEClass.getESuperTypes().add(this.getExpression());
    remoteTargetEClass.getESuperTypes().add(this.getExpression());
    blockExprEClass.getESuperTypes().add(this.getExpression());
    atomEClass.getESuperTypes().add(this.getExpression());
    variableEClass.getESuperTypes().add(this.getExpression());
    charEClass.getESuperTypes().add(this.getExpression());
    macroExprEClass.getESuperTypes().add(this.getExpression());
    erlStringEClass.getESuperTypes().add(this.getExpression());
    integerEClass.getESuperTypes().add(this.getExpression());
    floatEClass.getESuperTypes().add(this.getExpression());
    listEClass.getESuperTypes().add(this.getErlList());
    unaryTypeEClass.getESuperTypes().add(this.getType500());
    remoteTypeEClass.getESuperTypes().add(this.getType());
    listTypeEClass.getESuperTypes().add(this.getType());
    tupleTypeEClass.getESuperTypes().add(this.getType());
    recordTypeEClass.getESuperTypes().add(this.getType());
    funTypeListEClass.getESuperTypes().add(this.getFunType100());

    // Initialize classes and features; add operations and parameters
    initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModule_Forms(), this.getForm(), null, "forms", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formEClass, Form.class, "Form", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(conditionalFormBlockEClass, ConditionalFormBlock.class, "ConditionalFormBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalFormBlock_Condition(), this.getIfdefAttribute(), null, "condition", null, 0, 1, ConditionalFormBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalFormBlock_IfForms(), this.getForm(), null, "ifForms", null, 0, -1, ConditionalFormBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConditionalFormBlock_HasElse(), ecorePackage.getEBoolean(), "hasElse", null, 0, 1, ConditionalFormBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalFormBlock_ElseForms(), this.getForm(), null, "elseForms", null, 0, -1, ConditionalFormBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalFormBlock_End(), this.getEndifAttribute(), null, "end", null, 0, 1, ConditionalFormBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractElementEClass, AbstractElement.class, "AbstractElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractDefineAttributeEClass, AbstractDefineAttribute.class, "AbstractDefineAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(defineAttributeEClass, DefineAttribute.class, "DefineAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDefineAttribute_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, DefineAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDefineAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, DefineAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDefineAttribute_Args(), this.getExpression(), null, "args", null, 0, -1, DefineAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDefineAttribute_Value(), this.getGuard(), null, "value", null, 0, 1, DefineAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(undefAttributeEClass, UndefAttribute.class, "UndefAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUndefAttribute_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, UndefAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUndefAttribute_Name(), this.getDefineAttribute(), null, "name", null, 0, 1, UndefAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifdefAttributeEClass, IfdefAttribute.class, "IfdefAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIfdefAttribute_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, IfdefAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfdefAttribute_Ref(), this.getDefineAttribute(), null, "ref", null, 0, 1, IfdefAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(endifAttributeEClass, EndifAttribute.class, "EndifAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEndifAttribute_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, EndifAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elseAttributeEClass, ElseAttribute.class, "ElseAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getElseAttribute_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, ElseAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(includeAttributeEClass, IncludeAttribute.class, "IncludeAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIncludeAttribute_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, IncludeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIncludeAttribute_Value(), this.getModule(), null, "value", null, 0, 1, IncludeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fileAttributeEClass, FileAttribute.class, "FileAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFileAttribute_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, FileAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFileAttribute_File(), ecorePackage.getEString(), "file", null, 0, 1, FileAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFileAttribute_Line(), ecorePackage.getEString(), "line", null, 0, 1, FileAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleAttributeEClass, ModuleAttribute.class, "ModuleAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModuleAttribute_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, ModuleAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModuleAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModuleAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordAttributeEClass, RecordAttribute.class, "RecordAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRecordAttribute_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, RecordAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRecordAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, RecordAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordAttribute_Fields(), this.getRecordFieldDef(), null, "fields", null, 0, -1, RecordAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordAttribute_RecordMacro(), this.getDefineAttribute(), null, "recordMacro", null, 0, 1, RecordAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractTypeAttributeEClass, AbstractTypeAttribute.class, "AbstractTypeAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractTypeAttribute_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, AbstractTypeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(specAttributeEClass, SpecAttribute.class, "SpecAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSpecAttribute_Type(), this.getSpecFun(), null, "type", null, 0, 1, SpecAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpecAttribute_Signatures(), this.getTypeSigs(), null, "signatures", null, 0, 1, SpecAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeAttributeEClass, TypeAttribute.class, "TypeAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeAttribute_Args(), this.getExpression(), null, "args", null, 0, -1, TypeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeAttribute_Type(), this.getTopType(), null, "type", null, 0, 1, TypeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(customAttributeEClass, CustomAttribute.class, "CustomAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCustomAttribute_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, CustomAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCustomAttribute_Value(), this.getExpression(), null, "value", null, 0, -1, CustomAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunction_Clauses(), this.getFunctionClause(), null, "clauses", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionClauseEClass, FunctionClause.class, "FunctionClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFunctionClause_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, FunctionClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionClause_Params(), this.getExpression(), null, "params", null, 0, -1, FunctionClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionClause_Guard(), this.getGuard(), null, "guard", null, 0, 1, FunctionClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionClause_Body(), this.getExpression(), null, "body", null, 0, -1, FunctionClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(guardEClass, Guard.class, "Guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGuard_Guards(), this.getExpressions(), null, "guards", null, 0, -1, Guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionsEClass, Expressions.class, "Expressions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressions_Exprs(), this.getExpression(), null, "exprs", null, 0, -1, Expressions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExpression_Line(), ecorePackage.getEBoolean(), "line", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Expr(), this.getExpression(), null, "expr", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macroCallEClass, MacroCall.class, "MacroCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMacroCall_Name(), this.getDefineAttribute(), null, "name", null, 0, 1, MacroCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMacroCall_Args(), this.getExpression(), null, "args", null, 0, -1, MacroCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordExprEClass, RecordExpr.class, "RecordExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecordExpr_Ref(), this.getExpression(), null, "ref", null, 0, 1, RecordExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordExpr_Record(), this.getRecordExpr(), null, "record", null, 0, 1, RecordExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordExpr_Rec(), this.getRecordAttribute(), null, "rec", null, 0, 1, RecordExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordExpr_Field(), this.getRecordFieldDef(), null, "field", null, 0, 1, RecordExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordExpr_Tuple(), this.getRecordTuple(), null, "tuple", null, 0, 1, RecordExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(queryExprEClass, QueryExpr.class, "QueryExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(condExprEClass, CondExpr.class, "CondExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(letExprEClass, LetExpr.class, "LetExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(recordTupleEClass, RecordTuple.class, "RecordTuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecordTuple_Fields(), this.getRecordField(), null, "fields", null, 0, -1, RecordTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordFieldDefEClass, RecordFieldDef.class, "RecordFieldDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRecordFieldDef_Name(), ecorePackage.getEString(), "name", null, 0, 1, RecordFieldDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordFieldDef_Value(), this.getExpression(), null, "value", null, 0, 1, RecordFieldDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordFieldDef_Type(), this.getTopType(), null, "type", null, 0, 1, RecordFieldDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordFieldEClass, RecordField.class, "RecordField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecordField_Ref(), this.getRecordFieldDef(), null, "ref", null, 0, 1, RecordField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordField_Value(), this.getExpression(), null, "value", null, 0, 1, RecordField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordField_Type(), this.getTopType(), null, "type", null, 0, 1, RecordField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifExprEClass, IfExpr.class, "IfExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfExpr_Clauses(), this.getIfClause(), null, "clauses", null, 0, -1, IfExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifClauseEClass, IfClause.class, "IfClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfClause_Guard(), this.getGuard(), null, "guard", null, 0, 1, IfClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfClause_Body(), this.getExpression(), null, "body", null, 0, -1, IfClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(caseExprEClass, CaseExpr.class, "CaseExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCaseExpr_Clauses(), this.getCrClause(), null, "clauses", null, 0, -1, CaseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(crClauseEClass, CrClause.class, "CrClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCrClause_Expr(), this.getExpression(), null, "expr", null, 0, 1, CrClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCrClause_Guard(), this.getGuard(), null, "guard", null, 0, 1, CrClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCrClause_Body(), this.getExpression(), null, "body", null, 0, -1, CrClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(receiveExprEClass, ReceiveExpr.class, "ReceiveExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReceiveExpr_Clauses(), this.getCrClause(), null, "clauses", null, 0, -1, ReceiveExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReceiveExpr_After_expr(), this.getExpression(), null, "after_expr", null, 0, 1, ReceiveExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReceiveExpr_After_body(), this.getExpression(), null, "after_body", null, 0, -1, ReceiveExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(funExprEClass, FunExpr.class, "FunExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunExpr_Clauses(), this.getFunctionClause(), null, "clauses", null, 0, -1, FunExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refFunEClass, RefFun.class, "RefFun", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefFun_Module(), this.getExpression(), null, "module", null, 0, 1, RefFun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRefFun_Function(), this.getExpression(), null, "function", null, 0, 1, RefFun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRefFun_Arity(), ecorePackage.getEString(), "arity", null, 0, 1, RefFun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tryExprEClass, TryExpr.class, "TryExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTryExpr_Body(), this.getExpression(), null, "body", null, 0, -1, TryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTryExpr_Of_clauses(), this.getCrClause(), null, "of_clauses", null, 0, -1, TryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTryExpr_Catch(), this.getTryClause(), null, "catch", null, 0, -1, TryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTryExpr_After_body(), this.getExpression(), null, "after_body", null, 0, -1, TryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tryClauseEClass, TryClause.class, "TryClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTryClause_Hdr(), ecorePackage.getEString(), "hdr", null, 0, 1, TryClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTryClause_Cond(), this.getExpression(), null, "cond", null, 0, 1, TryClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTryClause_Guard(), this.getGuard(), null, "guard", null, 0, 1, TryClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTryClause_Body(), this.getExpression(), null, "body", null, 0, -1, TryClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(erlListEClass, ErlList.class, "ErlList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErlList_Elements(), this.getExpression(), null, "elements", null, 0, -1, ErlList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErlList_Tail(), this.getExpression(), null, "tail", null, 0, 1, ErlList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listComprehensionEClass, ListComprehension.class, "ListComprehension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getListComprehension_Element(), this.getExpression(), null, "element", null, 0, 1, ListComprehension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getListComprehension_Generators(), this.getLCExpr(), null, "generators", null, 0, -1, ListComprehension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleEClass, Tuple.class, "Tuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTuple_Elements(), this.getExpression(), null, "elements", null, 0, -1, Tuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(binaryComprehensionEClass, BinaryComprehension.class, "BinaryComprehension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinaryComprehension_Generators(), this.getLCExpr(), null, "generators", null, 0, -1, BinaryComprehension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(binaryEClass, Binary.class, "Binary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinary_Elements(), this.getBinaryItem(), null, "elements", null, 0, -1, Binary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(binaryItemEClass, BinaryItem.class, "BinaryItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinaryItem_Expr(), this.getExpression(), null, "expr", null, 0, 1, BinaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinaryItem_Size(), this.getExpression(), null, "size", null, 0, 1, BinaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinaryItem_Types(), this.getBitType(), null, "types", null, 0, -1, BinaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinaryItem_Type(), this.getBitType(), null, "type", null, 0, -1, BinaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitTypeEClass, BitType.class, "BitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBitType_Name(), ecorePackage.getEString(), "name", null, 0, 1, BitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBitType_Size(), ecorePackage.getEString(), "size", null, 0, 1, BitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lcExprEClass, LCExpr.class, "LCExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLCExpr_O1(), this.getExpression(), null, "o1", null, 0, 1, LCExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLCExpr_Op(), ecorePackage.getEString(), "op", null, 0, 1, LCExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLCExpr_O2(), this.getExpression(), null, "o2", null, 0, 1, LCExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(specFunEClass, SpecFun.class, "SpecFun", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSpecFun_M(), ecorePackage.getEString(), "m", null, 0, 1, SpecFun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSpecFun_F(), ecorePackage.getEString(), "f", null, 0, 1, SpecFun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSpecFun_A(), ecorePackage.getEString(), "a", null, 0, 1, SpecFun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeSigsEClass, TypeSigs.class, "TypeSigs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeSigs_Items(), this.getTypeSig(), null, "items", null, 0, -1, TypeSigs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeSigEClass, TypeSig.class, "TypeSig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeSig_Decl(), this.getFunType(), null, "decl", null, 0, 1, TypeSig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeSig_Guards(), this.getTypeGuards(), null, "guards", null, 0, 1, TypeSig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(funTypeEClass, FunType.class, "FunType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunType_Args(), this.getTopTypes(), null, "args", null, 0, 1, FunType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunType_Return(), this.getTopType(), null, "return", null, 0, 1, FunType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunType_Type(), this.getFunType100(), null, "type", null, 0, 1, FunType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(topTypesEClass, TopTypes.class, "TopTypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTopTypes_Items(), this.getTopType(), null, "items", null, 0, -1, TopTypes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeGuardsEClass, TypeGuards.class, "TypeGuards", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeGuards_Items(), this.getTypeGuard(), null, "items", null, 0, -1, TypeGuards.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeGuardEClass, TypeGuard.class, "TypeGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeGuard_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeGuard_Types(), this.getTopTypes(), null, "types", null, 0, 1, TypeGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeGuard_Type(), this.getTopType(), null, "type", null, 0, 1, TypeGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(topTypeEClass, TopType.class, "TopType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTopType_Var(), ecorePackage.getEString(), "var", null, 0, 1, TopType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTopType_Type(), this.getType100(), null, "type", null, 0, 1, TopType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTopType_LeftOperand(), this.getType200(), null, "leftOperand", null, 0, 1, TopType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTopType_Op(), ecorePackage.getEString(), "op", null, 0, 1, TopType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTopType_RightOperand(), this.getType200(), null, "rightOperand", null, 0, 1, TopType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(type100EClass, Type100.class, "Type100", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(type200EClass, Type200.class, "Type200", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(type300EClass, Type300.class, "Type300", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(type400EClass, Type400.class, "Type400", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(type500EClass, Type500.class, "Type500", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getType_Name(), ecorePackage.getEString(), "name", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_Value(), ecorePackage.getEString(), "value", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fieldTypeEClass, FieldType.class, "FieldType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFieldType_Name(), ecorePackage.getEString(), "name", null, 0, 1, FieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFieldType_Type(), this.getTopType(), null, "type", null, 0, 1, FieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(binaryTypeEClass, BinaryType.class, "BinaryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinaryType_Type(), ecorePackage.getEObject(), null, "type", null, 0, -1, BinaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(binBaseTypeEClass, BinBaseType.class, "BinBaseType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBinBaseType_Name(), ecorePackage.getEString(), "name", null, 0, 1, BinBaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinBaseType_Type(), this.getType(), null, "type", null, 0, 1, BinBaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(binUnitTypeEClass, BinUnitType.class, "BinUnitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBinUnitType_Name(), ecorePackage.getEString(), "name", null, 0, 1, BinUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBinUnitType_M(), ecorePackage.getEString(), "m", null, 0, 1, BinUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinUnitType_Type(), this.getType(), null, "type", null, 0, 1, BinUnitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(funType100EClass, FunType100.class, "FunType100", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(macroFormEClass, MacroForm.class, "MacroForm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMacroForm_Name(), ecorePackage.getEString(), "name", null, 0, 1, MacroForm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(catchExprEClass, CatchExpr.class, "CatchExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(matchExprEClass, MatchExpr.class, "MatchExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMatchExpr_OpLeft(), this.getExpression(), null, "opLeft", null, 0, 1, MatchExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMatchExpr_Op(), ecorePackage.getEString(), "op", null, 0, 1, MatchExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMatchExpr_OpRight(), this.getExpression(), null, "opRight", null, 0, 1, MatchExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(binOpEClass, BinOp.class, "BinOp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinOp_OpLeft(), this.getExpression(), null, "opLeft", null, 0, 1, BinOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBinOp_Op(), ecorePackage.getEString(), "op", null, 0, 1, BinOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinOp_OpRight(), this.getExpression(), null, "opRight", null, 0, 1, BinOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinOp_OpRight2(), this.getExpression(), null, "opRight2", null, 0, 1, BinOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(addOpEClass, AddOp.class, "AddOp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAddOp_OpLeft(), this.getExpression(), null, "opLeft", null, 0, 1, AddOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAddOp_Op(), ecorePackage.getEString(), "op", null, 0, 1, AddOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAddOp_OpRight(), this.getExpression(), null, "opRight", null, 0, 1, AddOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multOpEClass, MultOp.class, "MultOp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultOp_OpLeft(), this.getExpression(), null, "opLeft", null, 0, 1, MultOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultOp_Op(), ecorePackage.getEString(), "op", null, 0, 1, MultOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMultOp_OpRight(), this.getExpression(), null, "opRight", null, 0, 1, MultOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryExprEClass, UnaryExpr.class, "UnaryExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnaryExpr_Op(), ecorePackage.getEString(), "op", null, 0, 1, UnaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnaryExpr_Operand(), this.getExpression(), null, "operand", null, 0, 1, UnaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(funCallEClass, FunCall.class, "FunCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunCall_Target(), this.getExpression(), null, "target", null, 0, 1, FunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunCall_Args(), this.getExpression(), null, "args", null, 0, -1, FunCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(remoteTargetEClass, RemoteTarget.class, "RemoteTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRemoteTarget_Module(), this.getExpression(), null, "module", null, 0, 1, RemoteTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRemoteTarget_Function(), this.getExpression(), null, "function", null, 0, 1, RemoteTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(blockExprEClass, BlockExpr.class, "BlockExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBlockExpr_Body(), this.getExpression(), null, "body", null, 0, -1, BlockExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomEClass, Atom.class, "Atom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAtom_Value(), this.getAbstractElement(), null, "value", null, 0, 1, Atom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariable_Value(), ecorePackage.getEString(), "value", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(charEClass, Char.class, "Char", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getChar_Value(), ecorePackage.getEString(), "value", null, 0, 1, Char.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(macroExprEClass, MacroExpr.class, "MacroExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMacroExpr_Value(), this.getDefineAttribute(), null, "value", null, 0, 1, MacroExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(erlStringEClass, ErlString.class, "ErlString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErlString_Value(), ecorePackage.getEString(), "value", null, 0, 1, ErlString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integerEClass, org.erlide.erlang.Integer.class, "Integer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInteger_Value(), ecorePackage.getEString(), "value", null, 0, 1, org.erlide.erlang.Integer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(floatEClass, org.erlide.erlang.Float.class, "Float", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFloat_Value(), ecorePackage.getEString(), "value", null, 0, 1, org.erlide.erlang.Float.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listEClass, List.class, "List", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unaryTypeEClass, UnaryType.class, "UnaryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnaryType_Op(), ecorePackage.getEString(), "op", null, 0, 1, UnaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnaryType_Operand(), this.getType(), null, "operand", null, 0, 1, UnaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(remoteTypeEClass, RemoteType.class, "RemoteType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRemoteType_M(), this.getModule(), null, "m", null, 0, 1, RemoteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRemoteType_Args(), this.getTopTypes(), null, "args", null, 0, 1, RemoteType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listTypeEClass, ListType.class, "ListType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getListType_Type(), this.getTopType(), null, "type", null, 0, 1, ListType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleTypeEClass, TupleType.class, "TupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTupleType_Types(), this.getTopTypes(), null, "types", null, 0, 1, TupleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordTypeEClass, RecordType.class, "RecordType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRecordType_Rec(), ecorePackage.getEString(), "rec", null, 0, 1, RecordType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordType_Fields(), this.getFieldType(), null, "fields", null, 0, -1, RecordType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(funTypeListEClass, FunTypeList.class, "FunTypeList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunTypeList_Items(), this.getTopTypes(), null, "items", null, 0, 1, FunTypeList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunTypeList_Return(), this.getTopType(), null, "return", null, 0, 1, FunTypeList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ErlangPackageImpl