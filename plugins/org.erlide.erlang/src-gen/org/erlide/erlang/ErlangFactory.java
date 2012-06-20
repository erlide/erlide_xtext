/**
 */
package org.erlide.erlang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.erlide.erlang.ErlangPackage
 * @generated
 */
public interface ErlangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ErlangFactory eINSTANCE = org.erlide.erlang.impl.ErlangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module</em>'.
   * @generated
   */
  Module createModule();

  /**
   * Returns a new object of class '<em>Referenceable Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Referenceable Element</em>'.
   * @generated
   */
  ReferenceableElement createReferenceableElement();

  /**
   * Returns a new object of class '<em>Form</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Form</em>'.
   * @generated
   */
  Form createForm();

  /**
   * Returns a new object of class '<em>Conditional Form Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Form Block</em>'.
   * @generated
   */
  ConditionalFormBlock createConditionalFormBlock();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Conditional Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Attribute</em>'.
   * @generated
   */
  ConditionalAttribute createConditionalAttribute();

  /**
   * Returns a new object of class '<em>Abstract Define Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Define Attribute</em>'.
   * @generated
   */
  AbstractDefineAttribute createAbstractDefineAttribute();

  /**
   * Returns a new object of class '<em>Define Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Define Attribute</em>'.
   * @generated
   */
  DefineAttribute createDefineAttribute();

  /**
   * Returns a new object of class '<em>Undef Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Undef Attribute</em>'.
   * @generated
   */
  UndefAttribute createUndefAttribute();

  /**
   * Returns a new object of class '<em>Ifdef Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ifdef Attribute</em>'.
   * @generated
   */
  IfdefAttribute createIfdefAttribute();

  /**
   * Returns a new object of class '<em>Else Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Else Attribute</em>'.
   * @generated
   */
  ElseAttribute createElseAttribute();

  /**
   * Returns a new object of class '<em>Endif Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Endif Attribute</em>'.
   * @generated
   */
  EndifAttribute createEndifAttribute();

  /**
   * Returns a new object of class '<em>Abstract Include Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Include Attribute</em>'.
   * @generated
   */
  AbstractIncludeAttribute createAbstractIncludeAttribute();

  /**
   * Returns a new object of class '<em>Include Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Include Attribute</em>'.
   * @generated
   */
  IncludeAttribute createIncludeAttribute();

  /**
   * Returns a new object of class '<em>Include Lib Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Include Lib Attribute</em>'.
   * @generated
   */
  IncludeLibAttribute createIncludeLibAttribute();

  /**
   * Returns a new object of class '<em>File Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>File Attribute</em>'.
   * @generated
   */
  FileAttribute createFileAttribute();

  /**
   * Returns a new object of class '<em>Module Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module Attribute</em>'.
   * @generated
   */
  ModuleAttribute createModuleAttribute();

  /**
   * Returns a new object of class '<em>Record Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Attribute</em>'.
   * @generated
   */
  RecordAttribute createRecordAttribute();

  /**
   * Returns a new object of class '<em>Export Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Export Attribute</em>'.
   * @generated
   */
  ExportAttribute createExportAttribute();

  /**
   * Returns a new object of class '<em>Import Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import Attribute</em>'.
   * @generated
   */
  ImportAttribute createImportAttribute();

  /**
   * Returns a new object of class '<em>Compile Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compile Attribute</em>'.
   * @generated
   */
  CompileAttribute createCompileAttribute();

  /**
   * Returns a new object of class '<em>Abstract Type Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Type Attribute</em>'.
   * @generated
   */
  AbstractTypeAttribute createAbstractTypeAttribute();

  /**
   * Returns a new object of class '<em>Spec Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Spec Attribute</em>'.
   * @generated
   */
  SpecAttribute createSpecAttribute();

  /**
   * Returns a new object of class '<em>Type Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Attribute</em>'.
   * @generated
   */
  TypeAttribute createTypeAttribute();

  /**
   * Returns a new object of class '<em>Custom Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Custom Attribute</em>'.
   * @generated
   */
  CustomAttribute createCustomAttribute();

  /**
   * Returns a new object of class '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function</em>'.
   * @generated
   */
  Function createFunction();

  /**
   * Returns a new object of class '<em>Function Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Clause</em>'.
   * @generated
   */
  FunctionClause createFunctionClause();

  /**
   * Returns a new object of class '<em>Guard</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guard</em>'.
   * @generated
   */
  Guard createGuard();

  /**
   * Returns a new object of class '<em>Expressions</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expressions</em>'.
   * @generated
   */
  Expressions createExpressions();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Macro Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Macro Call</em>'.
   * @generated
   */
  MacroCall createMacroCall();

  /**
   * Returns a new object of class '<em>Record Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Expr</em>'.
   * @generated
   */
  RecordExpr createRecordExpr();

  /**
   * Returns a new object of class '<em>Query Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query Expr</em>'.
   * @generated
   */
  QueryExpr createQueryExpr();

  /**
   * Returns a new object of class '<em>Cond Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cond Expr</em>'.
   * @generated
   */
  CondExpr createCondExpr();

  /**
   * Returns a new object of class '<em>Let Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Let Expr</em>'.
   * @generated
   */
  LetExpr createLetExpr();

  /**
   * Returns a new object of class '<em>Record Tuple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Tuple</em>'.
   * @generated
   */
  RecordTuple createRecordTuple();

  /**
   * Returns a new object of class '<em>Record Field Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Field Def</em>'.
   * @generated
   */
  RecordFieldDef createRecordFieldDef();

  /**
   * Returns a new object of class '<em>Record Field</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Field</em>'.
   * @generated
   */
  RecordField createRecordField();

  /**
   * Returns a new object of class '<em>If Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Expr</em>'.
   * @generated
   */
  IfExpr createIfExpr();

  /**
   * Returns a new object of class '<em>If Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Clause</em>'.
   * @generated
   */
  IfClause createIfClause();

  /**
   * Returns a new object of class '<em>Case Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Case Expr</em>'.
   * @generated
   */
  CaseExpr createCaseExpr();

  /**
   * Returns a new object of class '<em>Cr Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cr Clause</em>'.
   * @generated
   */
  CrClause createCrClause();

  /**
   * Returns a new object of class '<em>Receive Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Receive Expr</em>'.
   * @generated
   */
  ReceiveExpr createReceiveExpr();

  /**
   * Returns a new object of class '<em>Fun Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fun Expr</em>'.
   * @generated
   */
  FunExpr createFunExpr();

  /**
   * Returns a new object of class '<em>Fun Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fun Ref</em>'.
   * @generated
   */
  FunRef createFunRef();

  /**
   * Returns a new object of class '<em>Try Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Try Expr</em>'.
   * @generated
   */
  TryExpr createTryExpr();

  /**
   * Returns a new object of class '<em>Try Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Try Clause</em>'.
   * @generated
   */
  TryClause createTryClause();

  /**
   * Returns a new object of class '<em>Erl List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Erl List</em>'.
   * @generated
   */
  ErlList createErlList();

  /**
   * Returns a new object of class '<em>List Comprehension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Comprehension</em>'.
   * @generated
   */
  ListComprehension createListComprehension();

  /**
   * Returns a new object of class '<em>Erl Tuple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Erl Tuple</em>'.
   * @generated
   */
  ErlTuple createErlTuple();

  /**
   * Returns a new object of class '<em>Binary Comprehension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Comprehension</em>'.
   * @generated
   */
  BinaryComprehension createBinaryComprehension();

  /**
   * Returns a new object of class '<em>Erl Binary</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Erl Binary</em>'.
   * @generated
   */
  ErlBinary createErlBinary();

  /**
   * Returns a new object of class '<em>Binary Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Item</em>'.
   * @generated
   */
  BinaryItem createBinaryItem();

  /**
   * Returns a new object of class '<em>Bit Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bit Type</em>'.
   * @generated
   */
  BitType createBitType();

  /**
   * Returns a new object of class '<em>LC Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LC Expr</em>'.
   * @generated
   */
  LCExpr createLCExpr();

  /**
   * Returns a new object of class '<em>Spec Fun</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Spec Fun</em>'.
   * @generated
   */
  SpecFun createSpecFun();

  /**
   * Returns a new object of class '<em>Type Sig</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Sig</em>'.
   * @generated
   */
  TypeSig createTypeSig();

  /**
   * Returns a new object of class '<em>Fun Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fun Type</em>'.
   * @generated
   */
  FunType createFunType();

  /**
   * Returns a new object of class '<em>Type Guards</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Guards</em>'.
   * @generated
   */
  TypeGuards createTypeGuards();

  /**
   * Returns a new object of class '<em>Type Guard</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Guard</em>'.
   * @generated
   */
  TypeGuard createTypeGuard();

  /**
   * Returns a new object of class '<em>Top Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Top Type</em>'.
   * @generated
   */
  TopType createTopType();

  /**
   * Returns a new object of class '<em>Type100</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type100</em>'.
   * @generated
   */
  Type100 createType100();

  /**
   * Returns a new object of class '<em>Type200</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type200</em>'.
   * @generated
   */
  Type200 createType200();

  /**
   * Returns a new object of class '<em>Type300</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type300</em>'.
   * @generated
   */
  Type300 createType300();

  /**
   * Returns a new object of class '<em>Type400</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type400</em>'.
   * @generated
   */
  Type400 createType400();

  /**
   * Returns a new object of class '<em>Type500</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type500</em>'.
   * @generated
   */
  Type500 createType500();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  Type createType();

  /**
   * Returns a new object of class '<em>Field Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Field Type</em>'.
   * @generated
   */
  FieldType createFieldType();

  /**
   * Returns a new object of class '<em>Binary Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Type</em>'.
   * @generated
   */
  BinaryType createBinaryType();

  /**
   * Returns a new object of class '<em>Bin Base Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bin Base Type</em>'.
   * @generated
   */
  BinBaseType createBinBaseType();

  /**
   * Returns a new object of class '<em>Bin Unit Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bin Unit Type</em>'.
   * @generated
   */
  BinUnitType createBinUnitType();

  /**
   * Returns a new object of class '<em>Fun Type100</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fun Type100</em>'.
   * @generated
   */
  FunType100 createFunType100();

  /**
   * Returns a new object of class '<em>Macro Form</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Macro Form</em>'.
   * @generated
   */
  MacroForm createMacroForm();

  /**
   * Returns a new object of class '<em>Catch Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Catch Expr</em>'.
   * @generated
   */
  CatchExpr createCatchExpr();

  /**
   * Returns a new object of class '<em>Match Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Match Expr</em>'.
   * @generated
   */
  MatchExpr createMatchExpr();

  /**
   * Returns a new object of class '<em>Bin Op</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bin Op</em>'.
   * @generated
   */
  BinOp createBinOp();

  /**
   * Returns a new object of class '<em>Add Op</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Add Op</em>'.
   * @generated
   */
  AddOp createAddOp();

  /**
   * Returns a new object of class '<em>Mult Op</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mult Op</em>'.
   * @generated
   */
  MultOp createMultOp();

  /**
   * Returns a new object of class '<em>Unary Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Expr</em>'.
   * @generated
   */
  UnaryExpr createUnaryExpr();

  /**
   * Returns a new object of class '<em>Fun Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fun Call</em>'.
   * @generated
   */
  FunCall createFunCall();

  /**
   * Returns a new object of class '<em>Remote Target</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Remote Target</em>'.
   * @generated
   */
  RemoteTarget createRemoteTarget();

  /**
   * Returns a new object of class '<em>Block Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block Expr</em>'.
   * @generated
   */
  BlockExpr createBlockExpr();

  /**
   * Returns a new object of class '<em>Atom</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atom</em>'.
   * @generated
   */
  Atom createAtom();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>Erl Char</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Erl Char</em>'.
   * @generated
   */
  ErlChar createErlChar();

  /**
   * Returns a new object of class '<em>Macro Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Macro Expr</em>'.
   * @generated
   */
  MacroExpr createMacroExpr();

  /**
   * Returns a new object of class '<em>Erl String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Erl String</em>'.
   * @generated
   */
  ErlString createErlString();

  /**
   * Returns a new object of class '<em>Erl Integer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Erl Integer</em>'.
   * @generated
   */
  ErlInteger createErlInteger();

  /**
   * Returns a new object of class '<em>Erl Float</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Erl Float</em>'.
   * @generated
   */
  ErlFloat createErlFloat();

  /**
   * Returns a new object of class '<em>Unary Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Type</em>'.
   * @generated
   */
  UnaryType createUnaryType();

  /**
   * Returns a new object of class '<em>Remote Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Remote Type</em>'.
   * @generated
   */
  RemoteType createRemoteType();

  /**
   * Returns a new object of class '<em>List Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Type</em>'.
   * @generated
   */
  ListType createListType();

  /**
   * Returns a new object of class '<em>Tuple Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Type</em>'.
   * @generated
   */
  TupleType createTupleType();

  /**
   * Returns a new object of class '<em>Record Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Type</em>'.
   * @generated
   */
  RecordType createRecordType();

  /**
   * Returns a new object of class '<em>Fun Type List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fun Type List</em>'.
   * @generated
   */
  FunTypeList createFunTypeList();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ErlangPackage getErlangPackage();

} //ErlangFactory
