/**
 */
package org.erlide.erlang.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.erlide.erlang.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.erlide.erlang.ErlangPackage
 * @generated
 */
public class ErlangSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ErlangPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlangSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ErlangPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ErlangPackage.MODULE:
      {
        Module module = (Module)theEObject;
        T result = caseModule(module);
        if (result == null) result = caseAtomRefTarget(module);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ATOM_REF_TARGET:
      {
        AtomRefTarget atomRefTarget = (AtomRefTarget)theEObject;
        T result = caseAtomRefTarget(atomRefTarget);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.FORM:
      {
        Form form = (Form)theEObject;
        T result = caseForm(form);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.CONDITIONAL_FORM_BLOCK:
      {
        ConditionalFormBlock conditionalFormBlock = (ConditionalFormBlock)theEObject;
        T result = caseConditionalFormBlock(conditionalFormBlock);
        if (result == null) result = caseForm(conditionalFormBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = caseForm(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.CONDITIONAL_ATTRIBUTE:
      {
        ConditionalAttribute conditionalAttribute = (ConditionalAttribute)theEObject;
        T result = caseConditionalAttribute(conditionalAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ABSTRACT_DEFINE_ATTRIBUTE:
      {
        AbstractDefineAttribute abstractDefineAttribute = (AbstractDefineAttribute)theEObject;
        T result = caseAbstractDefineAttribute(abstractDefineAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.DEFINE_ATTRIBUTE:
      {
        DefineAttribute defineAttribute = (DefineAttribute)theEObject;
        T result = caseDefineAttribute(defineAttribute);
        if (result == null) result = caseAttribute(defineAttribute);
        if (result == null) result = caseAbstractDefineAttribute(defineAttribute);
        if (result == null) result = caseForm(defineAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.UNDEF_ATTRIBUTE:
      {
        UndefAttribute undefAttribute = (UndefAttribute)theEObject;
        T result = caseUndefAttribute(undefAttribute);
        if (result == null) result = caseAttribute(undefAttribute);
        if (result == null) result = caseAbstractDefineAttribute(undefAttribute);
        if (result == null) result = caseForm(undefAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.IFDEF_ATTRIBUTE:
      {
        IfdefAttribute ifdefAttribute = (IfdefAttribute)theEObject;
        T result = caseIfdefAttribute(ifdefAttribute);
        if (result == null) result = caseConditionalAttribute(ifdefAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ELSE_ATTRIBUTE:
      {
        ElseAttribute elseAttribute = (ElseAttribute)theEObject;
        T result = caseElseAttribute(elseAttribute);
        if (result == null) result = caseConditionalAttribute(elseAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ENDIF_ATTRIBUTE:
      {
        EndifAttribute endifAttribute = (EndifAttribute)theEObject;
        T result = caseEndifAttribute(endifAttribute);
        if (result == null) result = caseConditionalAttribute(endifAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ABSTRACT_INCLUDE_ATTRIBUTE:
      {
        AbstractIncludeAttribute abstractIncludeAttribute = (AbstractIncludeAttribute)theEObject;
        T result = caseAbstractIncludeAttribute(abstractIncludeAttribute);
        if (result == null) result = caseAttribute(abstractIncludeAttribute);
        if (result == null) result = caseForm(abstractIncludeAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.INCLUDE_ATTRIBUTE:
      {
        IncludeAttribute includeAttribute = (IncludeAttribute)theEObject;
        T result = caseIncludeAttribute(includeAttribute);
        if (result == null) result = caseAbstractIncludeAttribute(includeAttribute);
        if (result == null) result = caseAttribute(includeAttribute);
        if (result == null) result = caseForm(includeAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.INCLUDE_LIB_ATTRIBUTE:
      {
        IncludeLibAttribute includeLibAttribute = (IncludeLibAttribute)theEObject;
        T result = caseIncludeLibAttribute(includeLibAttribute);
        if (result == null) result = caseAbstractIncludeAttribute(includeLibAttribute);
        if (result == null) result = caseAttribute(includeLibAttribute);
        if (result == null) result = caseForm(includeLibAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.FILE_ATTRIBUTE:
      {
        FileAttribute fileAttribute = (FileAttribute)theEObject;
        T result = caseFileAttribute(fileAttribute);
        if (result == null) result = caseAttribute(fileAttribute);
        if (result == null) result = caseForm(fileAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.MODULE_ATTRIBUTE:
      {
        ModuleAttribute moduleAttribute = (ModuleAttribute)theEObject;
        T result = caseModuleAttribute(moduleAttribute);
        if (result == null) result = caseAttribute(moduleAttribute);
        if (result == null) result = caseForm(moduleAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.RECORD_ATTRIBUTE:
      {
        RecordAttribute recordAttribute = (RecordAttribute)theEObject;
        T result = caseRecordAttribute(recordAttribute);
        if (result == null) result = caseAttribute(recordAttribute);
        if (result == null) result = caseForm(recordAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.RECORD_FIELD_DEF:
      {
        RecordFieldDef recordFieldDef = (RecordFieldDef)theEObject;
        T result = caseRecordFieldDef(recordFieldDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.EXPORT_ATTRIBUTE:
      {
        ExportAttribute exportAttribute = (ExportAttribute)theEObject;
        T result = caseExportAttribute(exportAttribute);
        if (result == null) result = caseAttribute(exportAttribute);
        if (result == null) result = caseForm(exportAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.IMPORT_ATTRIBUTE:
      {
        ImportAttribute importAttribute = (ImportAttribute)theEObject;
        T result = caseImportAttribute(importAttribute);
        if (result == null) result = caseAttribute(importAttribute);
        if (result == null) result = caseForm(importAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.COMPILE_ATTRIBUTE:
      {
        CompileAttribute compileAttribute = (CompileAttribute)theEObject;
        T result = caseCompileAttribute(compileAttribute);
        if (result == null) result = caseAttribute(compileAttribute);
        if (result == null) result = caseForm(compileAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ABSTRACT_TYPE_ATTRIBUTE:
      {
        AbstractTypeAttribute abstractTypeAttribute = (AbstractTypeAttribute)theEObject;
        T result = caseAbstractTypeAttribute(abstractTypeAttribute);
        if (result == null) result = caseAttribute(abstractTypeAttribute);
        if (result == null) result = caseForm(abstractTypeAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.SPEC_ATTRIBUTE:
      {
        SpecAttribute specAttribute = (SpecAttribute)theEObject;
        T result = caseSpecAttribute(specAttribute);
        if (result == null) result = caseAbstractTypeAttribute(specAttribute);
        if (result == null) result = caseAttribute(specAttribute);
        if (result == null) result = caseForm(specAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TYPE_ATTRIBUTE:
      {
        TypeAttribute typeAttribute = (TypeAttribute)theEObject;
        T result = caseTypeAttribute(typeAttribute);
        if (result == null) result = caseAbstractTypeAttribute(typeAttribute);
        if (result == null) result = caseAttribute(typeAttribute);
        if (result == null) result = caseForm(typeAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.CUSTOM_ATTRIBUTE:
      {
        CustomAttribute customAttribute = (CustomAttribute)theEObject;
        T result = caseCustomAttribute(customAttribute);
        if (result == null) result = caseAttribute(customAttribute);
        if (result == null) result = caseForm(customAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.FUNCTION:
      {
        Function function = (Function)theEObject;
        T result = caseFunction(function);
        if (result == null) result = caseAtomRefTarget(function);
        if (result == null) result = caseForm(function);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.FUNCTION_CLAUSE:
      {
        FunctionClause functionClause = (FunctionClause)theEObject;
        T result = caseFunctionClause(functionClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.GUARD:
      {
        Guard guard = (Guard)theEObject;
        T result = caseGuard(guard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.EXPRESSIONS:
      {
        Expressions expressions = (Expressions)theEObject;
        T result = caseExpressions(expressions);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseAtomVarMacro(expression);
        if (result == null) result = caseRecordVarMacro(expression);
        if (result == null) result = caseAtomVar(expression);
        if (result == null) result = caseAtomMacro(expression);
        if (result == null) result = caseIntVarMacro(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.MACRO_CALL:
      {
        MacroCall macroCall = (MacroCall)theEObject;
        T result = caseMacroCall(macroCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.RECORD_EXPR:
      {
        RecordExpr recordExpr = (RecordExpr)theEObject;
        T result = caseRecordExpr(recordExpr);
        if (result == null) result = caseExpression(recordExpr);
        if (result == null) result = caseAtomVarMacro(recordExpr);
        if (result == null) result = caseRecordVarMacro(recordExpr);
        if (result == null) result = caseAtomVar(recordExpr);
        if (result == null) result = caseAtomMacro(recordExpr);
        if (result == null) result = caseIntVarMacro(recordExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.QUERY_EXPR:
      {
        QueryExpr queryExpr = (QueryExpr)theEObject;
        T result = caseQueryExpr(queryExpr);
        if (result == null) result = caseExpression(queryExpr);
        if (result == null) result = caseAtomVarMacro(queryExpr);
        if (result == null) result = caseRecordVarMacro(queryExpr);
        if (result == null) result = caseAtomVar(queryExpr);
        if (result == null) result = caseAtomMacro(queryExpr);
        if (result == null) result = caseIntVarMacro(queryExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.COND_EXPR:
      {
        CondExpr condExpr = (CondExpr)theEObject;
        T result = caseCondExpr(condExpr);
        if (result == null) result = caseExpression(condExpr);
        if (result == null) result = caseAtomVarMacro(condExpr);
        if (result == null) result = caseRecordVarMacro(condExpr);
        if (result == null) result = caseAtomVar(condExpr);
        if (result == null) result = caseAtomMacro(condExpr);
        if (result == null) result = caseIntVarMacro(condExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.LET_EXPR:
      {
        LetExpr letExpr = (LetExpr)theEObject;
        T result = caseLetExpr(letExpr);
        if (result == null) result = caseExpression(letExpr);
        if (result == null) result = caseAtomVarMacro(letExpr);
        if (result == null) result = caseRecordVarMacro(letExpr);
        if (result == null) result = caseAtomVar(letExpr);
        if (result == null) result = caseAtomMacro(letExpr);
        if (result == null) result = caseIntVarMacro(letExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.RECORD_TUPLE:
      {
        RecordTuple recordTuple = (RecordTuple)theEObject;
        T result = caseRecordTuple(recordTuple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.RECORD_FIELD_EXPR:
      {
        RecordFieldExpr recordFieldExpr = (RecordFieldExpr)theEObject;
        T result = caseRecordFieldExpr(recordFieldExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.STRING_LITERAL_PART:
      {
        StringLiteralPart stringLiteralPart = (StringLiteralPart)theEObject;
        T result = caseStringLiteralPart(stringLiteralPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.IF_EXPR:
      {
        IfExpr ifExpr = (IfExpr)theEObject;
        T result = caseIfExpr(ifExpr);
        if (result == null) result = caseExpression(ifExpr);
        if (result == null) result = caseAtomVarMacro(ifExpr);
        if (result == null) result = caseRecordVarMacro(ifExpr);
        if (result == null) result = caseAtomVar(ifExpr);
        if (result == null) result = caseAtomMacro(ifExpr);
        if (result == null) result = caseIntVarMacro(ifExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.IF_CLAUSE:
      {
        IfClause ifClause = (IfClause)theEObject;
        T result = caseIfClause(ifClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.CASE_EXPR:
      {
        CaseExpr caseExpr = (CaseExpr)theEObject;
        T result = caseCaseExpr(caseExpr);
        if (result == null) result = caseExpression(caseExpr);
        if (result == null) result = caseAtomVarMacro(caseExpr);
        if (result == null) result = caseRecordVarMacro(caseExpr);
        if (result == null) result = caseAtomVar(caseExpr);
        if (result == null) result = caseAtomMacro(caseExpr);
        if (result == null) result = caseIntVarMacro(caseExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.CR_CLAUSE:
      {
        CrClause crClause = (CrClause)theEObject;
        T result = caseCrClause(crClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.RECEIVE_EXPR:
      {
        ReceiveExpr receiveExpr = (ReceiveExpr)theEObject;
        T result = caseReceiveExpr(receiveExpr);
        if (result == null) result = caseExpression(receiveExpr);
        if (result == null) result = caseAtomVarMacro(receiveExpr);
        if (result == null) result = caseRecordVarMacro(receiveExpr);
        if (result == null) result = caseAtomVar(receiveExpr);
        if (result == null) result = caseAtomMacro(receiveExpr);
        if (result == null) result = caseIntVarMacro(receiveExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.FUN_EXPR:
      {
        FunExpr funExpr = (FunExpr)theEObject;
        T result = caseFunExpr(funExpr);
        if (result == null) result = caseExpression(funExpr);
        if (result == null) result = caseAtomVarMacro(funExpr);
        if (result == null) result = caseRecordVarMacro(funExpr);
        if (result == null) result = caseAtomVar(funExpr);
        if (result == null) result = caseAtomMacro(funExpr);
        if (result == null) result = caseIntVarMacro(funExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.FUN_REF:
      {
        FunRef funRef = (FunRef)theEObject;
        T result = caseFunRef(funRef);
        if (result == null) result = caseFunExpr(funRef);
        if (result == null) result = caseExpression(funRef);
        if (result == null) result = caseAtomVarMacro(funRef);
        if (result == null) result = caseRecordVarMacro(funRef);
        if (result == null) result = caseAtomVar(funRef);
        if (result == null) result = caseAtomMacro(funRef);
        if (result == null) result = caseIntVarMacro(funRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TRY_EXPR:
      {
        TryExpr tryExpr = (TryExpr)theEObject;
        T result = caseTryExpr(tryExpr);
        if (result == null) result = caseExpression(tryExpr);
        if (result == null) result = caseAtomVarMacro(tryExpr);
        if (result == null) result = caseRecordVarMacro(tryExpr);
        if (result == null) result = caseAtomVar(tryExpr);
        if (result == null) result = caseAtomMacro(tryExpr);
        if (result == null) result = caseIntVarMacro(tryExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TRY_CLAUSE:
      {
        TryClause tryClause = (TryClause)theEObject;
        T result = caseTryClause(tryClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ERL_LIST:
      {
        ErlList erlList = (ErlList)theEObject;
        T result = caseErlList(erlList);
        if (result == null) result = caseExpression(erlList);
        if (result == null) result = caseAtomVarMacro(erlList);
        if (result == null) result = caseRecordVarMacro(erlList);
        if (result == null) result = caseAtomVar(erlList);
        if (result == null) result = caseAtomMacro(erlList);
        if (result == null) result = caseIntVarMacro(erlList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.LIST_COMPREHENSION:
      {
        ListComprehension listComprehension = (ListComprehension)theEObject;
        T result = caseListComprehension(listComprehension);
        if (result == null) result = caseExpression(listComprehension);
        if (result == null) result = caseAtomVarMacro(listComprehension);
        if (result == null) result = caseRecordVarMacro(listComprehension);
        if (result == null) result = caseAtomVar(listComprehension);
        if (result == null) result = caseAtomMacro(listComprehension);
        if (result == null) result = caseIntVarMacro(listComprehension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ERL_TUPLE:
      {
        ErlTuple erlTuple = (ErlTuple)theEObject;
        T result = caseErlTuple(erlTuple);
        if (result == null) result = caseExpression(erlTuple);
        if (result == null) result = caseAtomVarMacro(erlTuple);
        if (result == null) result = caseRecordVarMacro(erlTuple);
        if (result == null) result = caseAtomVar(erlTuple);
        if (result == null) result = caseAtomMacro(erlTuple);
        if (result == null) result = caseIntVarMacro(erlTuple);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.BINARY_COMPREHENSION:
      {
        BinaryComprehension binaryComprehension = (BinaryComprehension)theEObject;
        T result = caseBinaryComprehension(binaryComprehension);
        if (result == null) result = caseExpression(binaryComprehension);
        if (result == null) result = caseAtomVarMacro(binaryComprehension);
        if (result == null) result = caseRecordVarMacro(binaryComprehension);
        if (result == null) result = caseAtomVar(binaryComprehension);
        if (result == null) result = caseAtomMacro(binaryComprehension);
        if (result == null) result = caseIntVarMacro(binaryComprehension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ERL_BINARY:
      {
        ErlBinary erlBinary = (ErlBinary)theEObject;
        T result = caseErlBinary(erlBinary);
        if (result == null) result = caseExpression(erlBinary);
        if (result == null) result = caseAtomVarMacro(erlBinary);
        if (result == null) result = caseRecordVarMacro(erlBinary);
        if (result == null) result = caseAtomVar(erlBinary);
        if (result == null) result = caseAtomMacro(erlBinary);
        if (result == null) result = caseIntVarMacro(erlBinary);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.BINARY_ITEM:
      {
        BinaryItem binaryItem = (BinaryItem)theEObject;
        T result = caseBinaryItem(binaryItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.BIT_TYPE:
      {
        BitType bitType = (BitType)theEObject;
        T result = caseBitType(bitType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.LC_EXPR:
      {
        LCExpr lcExpr = (LCExpr)theEObject;
        T result = caseLCExpr(lcExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ATOM_VAR_MACRO:
      {
        AtomVarMacro atomVarMacro = (AtomVarMacro)theEObject;
        T result = caseAtomVarMacro(atomVarMacro);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.RECORD_VAR_MACRO:
      {
        RecordVarMacro recordVarMacro = (RecordVarMacro)theEObject;
        T result = caseRecordVarMacro(recordVarMacro);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ATOM_VAR:
      {
        AtomVar atomVar = (AtomVar)theEObject;
        T result = caseAtomVar(atomVar);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ATOM_MACRO:
      {
        AtomMacro atomMacro = (AtomMacro)theEObject;
        T result = caseAtomMacro(atomMacro);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.INT_VAR_MACRO:
      {
        IntVarMacro intVarMacro = (IntVarMacro)theEObject;
        T result = caseIntVarMacro(intVarMacro);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.SPEC_FUN:
      {
        SpecFun specFun = (SpecFun)theEObject;
        T result = caseSpecFun(specFun);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TYPE_SIG:
      {
        TypeSig typeSig = (TypeSig)theEObject;
        T result = caseTypeSig(typeSig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.FUN_TYPE:
      {
        FunType funType = (FunType)theEObject;
        T result = caseFunType(funType);
        if (result == null) result = caseType(funType);
        if (result == null) result = caseType500(funType);
        if (result == null) result = caseType400(funType);
        if (result == null) result = caseType300(funType);
        if (result == null) result = caseType200(funType);
        if (result == null) result = caseType100(funType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TYPE_GUARDS:
      {
        TypeGuards typeGuards = (TypeGuards)theEObject;
        T result = caseTypeGuards(typeGuards);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TYPE_GUARD:
      {
        TypeGuard typeGuard = (TypeGuard)theEObject;
        T result = caseTypeGuard(typeGuard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TOP_TYPE:
      {
        TopType topType = (TopType)theEObject;
        T result = caseTopType(topType);
        if (result == null) result = caseType(topType);
        if (result == null) result = caseType100(topType);
        if (result == null) result = caseType200(topType);
        if (result == null) result = caseType300(topType);
        if (result == null) result = caseType500(topType);
        if (result == null) result = caseType400(topType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TYPE100:
      {
        Type100 type100 = (Type100)theEObject;
        T result = caseType100(type100);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TYPE200:
      {
        Type200 type200 = (Type200)theEObject;
        T result = caseType200(type200);
        if (result == null) result = caseType100(type200);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TYPE300:
      {
        Type300 type300 = (Type300)theEObject;
        T result = caseType300(type300);
        if (result == null) result = caseType200(type300);
        if (result == null) result = caseType100(type300);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TYPE400:
      {
        Type400 type400 = (Type400)theEObject;
        T result = caseType400(type400);
        if (result == null) result = caseType300(type400);
        if (result == null) result = caseType200(type400);
        if (result == null) result = caseType100(type400);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TYPE500:
      {
        Type500 type500 = (Type500)theEObject;
        T result = caseType500(type500);
        if (result == null) result = caseType400(type500);
        if (result == null) result = caseType300(type500);
        if (result == null) result = caseType200(type500);
        if (result == null) result = caseType100(type500);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TYPE:
      {
        Type type = (Type)theEObject;
        T result = caseType(type);
        if (result == null) result = caseType500(type);
        if (result == null) result = caseType400(type);
        if (result == null) result = caseType300(type);
        if (result == null) result = caseType200(type);
        if (result == null) result = caseType100(type);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.FIELD_TYPE:
      {
        FieldType fieldType = (FieldType)theEObject;
        T result = caseFieldType(fieldType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.BINARY_TYPE:
      {
        BinaryType binaryType = (BinaryType)theEObject;
        T result = caseBinaryType(binaryType);
        if (result == null) result = caseType(binaryType);
        if (result == null) result = caseType500(binaryType);
        if (result == null) result = caseType400(binaryType);
        if (result == null) result = caseType300(binaryType);
        if (result == null) result = caseType200(binaryType);
        if (result == null) result = caseType100(binaryType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.BIN_BASE_TYPE:
      {
        BinBaseType binBaseType = (BinBaseType)theEObject;
        T result = caseBinBaseType(binBaseType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.BIN_UNIT_TYPE:
      {
        BinUnitType binUnitType = (BinUnitType)theEObject;
        T result = caseBinUnitType(binUnitType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.FUN_TYPE100:
      {
        FunType100 funType100 = (FunType100)theEObject;
        T result = caseFunType100(funType100);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.MACRO_FORM:
      {
        MacroForm macroForm = (MacroForm)theEObject;
        T result = caseMacroForm(macroForm);
        if (result == null) result = caseForm(macroForm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.CATCH_EXPR:
      {
        CatchExpr catchExpr = (CatchExpr)theEObject;
        T result = caseCatchExpr(catchExpr);
        if (result == null) result = caseExpression(catchExpr);
        if (result == null) result = caseAtomVarMacro(catchExpr);
        if (result == null) result = caseRecordVarMacro(catchExpr);
        if (result == null) result = caseAtomVar(catchExpr);
        if (result == null) result = caseAtomMacro(catchExpr);
        if (result == null) result = caseIntVarMacro(catchExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.MATCH_EXPR:
      {
        MatchExpr matchExpr = (MatchExpr)theEObject;
        T result = caseMatchExpr(matchExpr);
        if (result == null) result = caseExpression(matchExpr);
        if (result == null) result = caseAtomVarMacro(matchExpr);
        if (result == null) result = caseRecordVarMacro(matchExpr);
        if (result == null) result = caseAtomVar(matchExpr);
        if (result == null) result = caseAtomMacro(matchExpr);
        if (result == null) result = caseIntVarMacro(matchExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.BIN_OP:
      {
        BinOp binOp = (BinOp)theEObject;
        T result = caseBinOp(binOp);
        if (result == null) result = caseExpression(binOp);
        if (result == null) result = caseAtomVarMacro(binOp);
        if (result == null) result = caseRecordVarMacro(binOp);
        if (result == null) result = caseAtomVar(binOp);
        if (result == null) result = caseAtomMacro(binOp);
        if (result == null) result = caseIntVarMacro(binOp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ADD_OP:
      {
        AddOp addOp = (AddOp)theEObject;
        T result = caseAddOp(addOp);
        if (result == null) result = caseExpression(addOp);
        if (result == null) result = caseAtomVarMacro(addOp);
        if (result == null) result = caseRecordVarMacro(addOp);
        if (result == null) result = caseAtomVar(addOp);
        if (result == null) result = caseAtomMacro(addOp);
        if (result == null) result = caseIntVarMacro(addOp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.MULT_OP:
      {
        MultOp multOp = (MultOp)theEObject;
        T result = caseMultOp(multOp);
        if (result == null) result = caseExpression(multOp);
        if (result == null) result = caseAtomVarMacro(multOp);
        if (result == null) result = caseRecordVarMacro(multOp);
        if (result == null) result = caseAtomVar(multOp);
        if (result == null) result = caseAtomMacro(multOp);
        if (result == null) result = caseIntVarMacro(multOp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.UNARY_EXPR:
      {
        UnaryExpr unaryExpr = (UnaryExpr)theEObject;
        T result = caseUnaryExpr(unaryExpr);
        if (result == null) result = caseExpression(unaryExpr);
        if (result == null) result = caseAtomVarMacro(unaryExpr);
        if (result == null) result = caseRecordVarMacro(unaryExpr);
        if (result == null) result = caseAtomVar(unaryExpr);
        if (result == null) result = caseAtomMacro(unaryExpr);
        if (result == null) result = caseIntVarMacro(unaryExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.FUN_CALL:
      {
        FunCall funCall = (FunCall)theEObject;
        T result = caseFunCall(funCall);
        if (result == null) result = caseExpression(funCall);
        if (result == null) result = caseAtomVarMacro(funCall);
        if (result == null) result = caseRecordVarMacro(funCall);
        if (result == null) result = caseAtomVar(funCall);
        if (result == null) result = caseAtomMacro(funCall);
        if (result == null) result = caseIntVarMacro(funCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.REMOTE_TARGET:
      {
        RemoteTarget remoteTarget = (RemoteTarget)theEObject;
        T result = caseRemoteTarget(remoteTarget);
        if (result == null) result = caseExpression(remoteTarget);
        if (result == null) result = caseAtomVarMacro(remoteTarget);
        if (result == null) result = caseRecordVarMacro(remoteTarget);
        if (result == null) result = caseAtomVar(remoteTarget);
        if (result == null) result = caseAtomMacro(remoteTarget);
        if (result == null) result = caseIntVarMacro(remoteTarget);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.BLOCK_EXPR:
      {
        BlockExpr blockExpr = (BlockExpr)theEObject;
        T result = caseBlockExpr(blockExpr);
        if (result == null) result = caseExpression(blockExpr);
        if (result == null) result = caseAtomVarMacro(blockExpr);
        if (result == null) result = caseRecordVarMacro(blockExpr);
        if (result == null) result = caseAtomVar(blockExpr);
        if (result == null) result = caseAtomMacro(blockExpr);
        if (result == null) result = caseIntVarMacro(blockExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ERL_CHAR:
      {
        ErlChar erlChar = (ErlChar)theEObject;
        T result = caseErlChar(erlChar);
        if (result == null) result = caseExpression(erlChar);
        if (result == null) result = caseAtomVarMacro(erlChar);
        if (result == null) result = caseRecordVarMacro(erlChar);
        if (result == null) result = caseAtomVar(erlChar);
        if (result == null) result = caseAtomMacro(erlChar);
        if (result == null) result = caseIntVarMacro(erlChar);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ATOM:
      {
        Atom atom = (Atom)theEObject;
        T result = caseAtom(atom);
        if (result == null) result = caseExpression(atom);
        if (result == null) result = caseAtomVarMacro(atom);
        if (result == null) result = caseRecordVarMacro(atom);
        if (result == null) result = caseAtomVar(atom);
        if (result == null) result = caseAtomMacro(atom);
        if (result == null) result = caseIntVarMacro(atom);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.RECORD_NAME:
      {
        RecordName recordName = (RecordName)theEObject;
        T result = caseRecordName(recordName);
        if (result == null) result = caseExpression(recordName);
        if (result == null) result = caseAtomVarMacro(recordName);
        if (result == null) result = caseRecordVarMacro(recordName);
        if (result == null) result = caseAtomVar(recordName);
        if (result == null) result = caseAtomMacro(recordName);
        if (result == null) result = caseIntVarMacro(recordName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.RECORD_FIELD:
      {
        RecordField recordField = (RecordField)theEObject;
        T result = caseRecordField(recordField);
        if (result == null) result = caseExpression(recordField);
        if (result == null) result = caseAtomVarMacro(recordField);
        if (result == null) result = caseRecordVarMacro(recordField);
        if (result == null) result = caseAtomVar(recordField);
        if (result == null) result = caseAtomMacro(recordField);
        if (result == null) result = caseIntVarMacro(recordField);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.MACRO:
      {
        Macro macro = (Macro)theEObject;
        T result = caseMacro(macro);
        if (result == null) result = caseExpression(macro);
        if (result == null) result = caseAtomVarMacro(macro);
        if (result == null) result = caseRecordVarMacro(macro);
        if (result == null) result = caseAtomVar(macro);
        if (result == null) result = caseAtomMacro(macro);
        if (result == null) result = caseIntVarMacro(macro);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.VARIABLE:
      {
        Variable variable = (Variable)theEObject;
        T result = caseVariable(variable);
        if (result == null) result = caseExpression(variable);
        if (result == null) result = caseAtomVarMacro(variable);
        if (result == null) result = caseRecordVarMacro(variable);
        if (result == null) result = caseAtomVar(variable);
        if (result == null) result = caseAtomMacro(variable);
        if (result == null) result = caseIntVarMacro(variable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ERL_FLOAT:
      {
        ErlFloat erlFloat = (ErlFloat)theEObject;
        T result = caseErlFloat(erlFloat);
        if (result == null) result = caseExpression(erlFloat);
        if (result == null) result = caseAtomVarMacro(erlFloat);
        if (result == null) result = caseRecordVarMacro(erlFloat);
        if (result == null) result = caseAtomVar(erlFloat);
        if (result == null) result = caseAtomMacro(erlFloat);
        if (result == null) result = caseIntVarMacro(erlFloat);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.ERL_INTEGER:
      {
        ErlInteger erlInteger = (ErlInteger)theEObject;
        T result = caseErlInteger(erlInteger);
        if (result == null) result = caseExpression(erlInteger);
        if (result == null) result = caseAtomVarMacro(erlInteger);
        if (result == null) result = caseRecordVarMacro(erlInteger);
        if (result == null) result = caseAtomVar(erlInteger);
        if (result == null) result = caseAtomMacro(erlInteger);
        if (result == null) result = caseIntVarMacro(erlInteger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.UNARY_TYPE:
      {
        UnaryType unaryType = (UnaryType)theEObject;
        T result = caseUnaryType(unaryType);
        if (result == null) result = caseType500(unaryType);
        if (result == null) result = caseType400(unaryType);
        if (result == null) result = caseType300(unaryType);
        if (result == null) result = caseType200(unaryType);
        if (result == null) result = caseType100(unaryType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.REMOTE_TYPE:
      {
        RemoteType remoteType = (RemoteType)theEObject;
        T result = caseRemoteType(remoteType);
        if (result == null) result = caseType(remoteType);
        if (result == null) result = caseType500(remoteType);
        if (result == null) result = caseType400(remoteType);
        if (result == null) result = caseType300(remoteType);
        if (result == null) result = caseType200(remoteType);
        if (result == null) result = caseType100(remoteType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.LIST_TYPE:
      {
        ListType listType = (ListType)theEObject;
        T result = caseListType(listType);
        if (result == null) result = caseType(listType);
        if (result == null) result = caseType500(listType);
        if (result == null) result = caseType400(listType);
        if (result == null) result = caseType300(listType);
        if (result == null) result = caseType200(listType);
        if (result == null) result = caseType100(listType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.TUPLE_TYPE:
      {
        TupleType tupleType = (TupleType)theEObject;
        T result = caseTupleType(tupleType);
        if (result == null) result = caseType(tupleType);
        if (result == null) result = caseType500(tupleType);
        if (result == null) result = caseType400(tupleType);
        if (result == null) result = caseType300(tupleType);
        if (result == null) result = caseType200(tupleType);
        if (result == null) result = caseType100(tupleType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.RECORD_TYPE:
      {
        RecordType recordType = (RecordType)theEObject;
        T result = caseRecordType(recordType);
        if (result == null) result = caseType(recordType);
        if (result == null) result = caseType500(recordType);
        if (result == null) result = caseType400(recordType);
        if (result == null) result = caseType300(recordType);
        if (result == null) result = caseType200(recordType);
        if (result == null) result = caseType100(recordType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErlangPackage.FUN_TYPE_LIST:
      {
        FunTypeList funTypeList = (FunTypeList)theEObject;
        T result = caseFunTypeList(funTypeList);
        if (result == null) result = caseFunType100(funTypeList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModule(Module object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atom Ref Target</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atom Ref Target</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtomRefTarget(AtomRefTarget object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Form</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Form</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForm(Form object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Form Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Form Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalFormBlock(ConditionalFormBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalAttribute(ConditionalAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Define Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Define Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractDefineAttribute(AbstractDefineAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Define Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Define Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefineAttribute(DefineAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Undef Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Undef Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUndefAttribute(UndefAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ifdef Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ifdef Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfdefAttribute(IfdefAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Else Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Else Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElseAttribute(ElseAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Endif Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Endif Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEndifAttribute(EndifAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Include Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Include Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractIncludeAttribute(AbstractIncludeAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Include Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Include Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIncludeAttribute(IncludeAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Include Lib Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Include Lib Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIncludeLibAttribute(IncludeLibAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>File Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>File Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFileAttribute(FileAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModuleAttribute(ModuleAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordAttribute(RecordAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Field Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Field Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordFieldDef(RecordFieldDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Export Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Export Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExportAttribute(ExportAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImportAttribute(ImportAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Compile Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Compile Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompileAttribute(CompileAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Type Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Type Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractTypeAttribute(AbstractTypeAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Spec Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Spec Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecAttribute(SpecAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeAttribute(TypeAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Custom Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Custom Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCustomAttribute(CustomAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunction(Function object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionClause(FunctionClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Guard</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Guard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGuard(Guard object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expressions</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expressions</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressions(Expressions object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Macro Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Macro Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMacroCall(MacroCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordExpr(RecordExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQueryExpr(QueryExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cond Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cond Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCondExpr(CondExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Let Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Let Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLetExpr(LetExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Tuple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Tuple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordTuple(RecordTuple object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Field Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Field Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordFieldExpr(RecordFieldExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLiteralPart(StringLiteralPart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfExpr(IfExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfClause(IfClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Case Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Case Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCaseExpr(CaseExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cr Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cr Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCrClause(CrClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Receive Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Receive Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReceiveExpr(ReceiveExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fun Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fun Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunExpr(FunExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fun Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fun Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunRef(FunRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Try Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Try Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTryExpr(TryExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Try Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Try Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTryClause(TryClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Erl List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Erl List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErlList(ErlList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Comprehension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Comprehension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListComprehension(ListComprehension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Erl Tuple</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Erl Tuple</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErlTuple(ErlTuple object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Comprehension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Comprehension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryComprehension(BinaryComprehension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Erl Binary</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Erl Binary</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErlBinary(ErlBinary object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryItem(BinaryItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bit Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bit Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBitType(BitType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LC Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LC Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLCExpr(LCExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atom Var Macro</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atom Var Macro</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtomVarMacro(AtomVarMacro object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Var Macro</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Var Macro</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordVarMacro(RecordVarMacro object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atom Var</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atom Var</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtomVar(AtomVar object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atom Macro</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atom Macro</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtomMacro(AtomMacro object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Var Macro</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Var Macro</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntVarMacro(IntVarMacro object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Spec Fun</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Spec Fun</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecFun(SpecFun object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Sig</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Sig</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeSig(TypeSig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fun Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fun Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunType(FunType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Guards</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Guards</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeGuards(TypeGuards object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Guard</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Guard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeGuard(TypeGuard object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Top Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Top Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTopType(TopType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type100</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type100</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType100(Type100 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type200</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type200</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType200(Type200 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type300</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type300</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType300(Type300 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type400</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type400</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType400(Type400 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type500</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type500</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType500(Type500 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Field Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Field Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFieldType(FieldType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryType(BinaryType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bin Base Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bin Base Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinBaseType(BinBaseType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bin Unit Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bin Unit Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinUnitType(BinUnitType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fun Type100</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fun Type100</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunType100(FunType100 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Macro Form</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Macro Form</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMacroForm(MacroForm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Catch Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Catch Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCatchExpr(CatchExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Match Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Match Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMatchExpr(MatchExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bin Op</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bin Op</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinOp(BinOp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Add Op</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Add Op</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAddOp(AddOp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mult Op</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mult Op</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultOp(MultOp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryExpr(UnaryExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fun Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fun Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunCall(FunCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Remote Target</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Remote Target</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRemoteTarget(RemoteTarget object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlockExpr(BlockExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Erl Char</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Erl Char</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErlChar(ErlChar object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atom</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atom</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtom(Atom object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordName(RecordName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Field</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Field</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordField(RecordField object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Macro</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Macro</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMacro(Macro object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariable(Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Erl Float</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Erl Float</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErlFloat(ErlFloat object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Erl Integer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Erl Integer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErlInteger(ErlInteger object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryType(UnaryType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Remote Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Remote Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRemoteType(RemoteType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListType(ListType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleType(TupleType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordType(RecordType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fun Type List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fun Type List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunTypeList(FunTypeList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ErlangSwitch
