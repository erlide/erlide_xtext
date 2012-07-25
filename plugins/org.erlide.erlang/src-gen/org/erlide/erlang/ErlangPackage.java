/**
 * <copyright>
 * </copyright>
 *
 */
package org.erlide.erlang;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.erlide.erlang.ErlangFactory
 * @model kind="package"
 * @generated
 */
public interface ErlangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "erlang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.erlide.org/Erlang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "erlang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ErlangPackage eINSTANCE = org.erlide.erlang.impl.ErlangPackageImpl.init();

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.AtomRefTargetImpl <em>Atom Ref Target</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.AtomRefTargetImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getAtomRefTarget()
   * @generated
   */
  int ATOM_REF_TARGET = 1;

  /**
   * The number of structural features of the '<em>Atom Ref Target</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_REF_TARGET_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ModuleImpl <em>Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ModuleImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getModule()
   * @generated
   */
  int MODULE = 0;

  /**
   * The feature id for the '<em><b>Forms</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__FORMS = ATOM_REF_TARGET_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = ATOM_REF_TARGET_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.FormImpl <em>Form</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.FormImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getForm()
   * @generated
   */
  int FORM = 2;

  /**
   * The number of structural features of the '<em>Form</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORM_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ConditionalFormBlockImpl <em>Conditional Form Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ConditionalFormBlockImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getConditionalFormBlock()
   * @generated
   */
  int CONDITIONAL_FORM_BLOCK = 3;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_FORM_BLOCK__CONDITION = FORM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>If Forms</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_FORM_BLOCK__IF_FORMS = FORM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Has Else</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_FORM_BLOCK__HAS_ELSE = FORM_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Else Forms</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_FORM_BLOCK__ELSE_FORMS = FORM_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>End</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_FORM_BLOCK__END = FORM_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Conditional Form Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_FORM_BLOCK_FEATURE_COUNT = FORM_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.AttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 4;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = FORM_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ConditionalAttributeImpl <em>Conditional Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ConditionalAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getConditionalAttribute()
   * @generated
   */
  int CONDITIONAL_ATTRIBUTE = 5;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_ATTRIBUTE__TAG = 0;

  /**
   * The number of structural features of the '<em>Conditional Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_ATTRIBUTE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.AbstractDefineAttributeImpl <em>Abstract Define Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.AbstractDefineAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getAbstractDefineAttribute()
   * @generated
   */
  int ABSTRACT_DEFINE_ATTRIBUTE = 6;

  /**
   * The number of structural features of the '<em>Abstract Define Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DEFINE_ATTRIBUTE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.DefineAttributeImpl <em>Define Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.DefineAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getDefineAttribute()
   * @generated
   */
  int DEFINE_ATTRIBUTE = 7;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_ATTRIBUTE__TAG = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Macro Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_ATTRIBUTE__MACRO_NAME = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_ATTRIBUTE__ARGS = ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_ATTRIBUTE__VALUE = ATTRIBUTE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Define Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.UndefAttributeImpl <em>Undef Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.UndefAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getUndefAttribute()
   * @generated
   */
  int UNDEF_ATTRIBUTE = 8;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNDEF_ATTRIBUTE__TAG = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNDEF_ATTRIBUTE__REF = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Undef Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNDEF_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.IfdefAttributeImpl <em>Ifdef Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.IfdefAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getIfdefAttribute()
   * @generated
   */
  int IFDEF_ATTRIBUTE = 9;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IFDEF_ATTRIBUTE__TAG = CONDITIONAL_ATTRIBUTE__TAG;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IFDEF_ATTRIBUTE__REF = CONDITIONAL_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Ifdef Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IFDEF_ATTRIBUTE_FEATURE_COUNT = CONDITIONAL_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ElseAttributeImpl <em>Else Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ElseAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getElseAttribute()
   * @generated
   */
  int ELSE_ATTRIBUTE = 10;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_ATTRIBUTE__TAG = CONDITIONAL_ATTRIBUTE__TAG;

  /**
   * The number of structural features of the '<em>Else Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_ATTRIBUTE_FEATURE_COUNT = CONDITIONAL_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.EndifAttributeImpl <em>Endif Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.EndifAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getEndifAttribute()
   * @generated
   */
  int ENDIF_ATTRIBUTE = 11;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENDIF_ATTRIBUTE__TAG = CONDITIONAL_ATTRIBUTE__TAG;

  /**
   * The number of structural features of the '<em>Endif Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENDIF_ATTRIBUTE_FEATURE_COUNT = CONDITIONAL_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.AbstractIncludeAttributeImpl <em>Abstract Include Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.AbstractIncludeAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getAbstractIncludeAttribute()
   * @generated
   */
  int ABSTRACT_INCLUDE_ATTRIBUTE = 12;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_INCLUDE_ATTRIBUTE__TAG = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Abstract Include Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_INCLUDE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.IncludeAttributeImpl <em>Include Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.IncludeAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getIncludeAttribute()
   * @generated
   */
  int INCLUDE_ATTRIBUTE = 13;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_ATTRIBUTE__TAG = ABSTRACT_INCLUDE_ATTRIBUTE__TAG;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_ATTRIBUTE__IMPORT_URI = ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI;

  /**
   * The number of structural features of the '<em>Include Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_ATTRIBUTE_FEATURE_COUNT = ABSTRACT_INCLUDE_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.IncludeLibAttributeImpl <em>Include Lib Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.IncludeLibAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getIncludeLibAttribute()
   * @generated
   */
  int INCLUDE_LIB_ATTRIBUTE = 14;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_LIB_ATTRIBUTE__TAG = ABSTRACT_INCLUDE_ATTRIBUTE__TAG;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_LIB_ATTRIBUTE__IMPORT_URI = ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI;

  /**
   * The number of structural features of the '<em>Include Lib Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_LIB_ATTRIBUTE_FEATURE_COUNT = ABSTRACT_INCLUDE_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.FileAttributeImpl <em>File Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.FileAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getFileAttribute()
   * @generated
   */
  int FILE_ATTRIBUTE = 15;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_ATTRIBUTE__TAG = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_ATTRIBUTE__FILE = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_ATTRIBUTE__LINE = ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>File Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ModuleAttributeImpl <em>Module Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ModuleAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getModuleAttribute()
   * @generated
   */
  int MODULE_ATTRIBUTE = 16;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_ATTRIBUTE__TAG = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Module Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_ATTRIBUTE__MODULE_NAME = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Module Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.RecordAttributeImpl <em>Record Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.RecordAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordAttribute()
   * @generated
   */
  int RECORD_ATTRIBUTE = 17;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ATTRIBUTE__TAG = ATOM_REF_TARGET_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ATTRIBUTE__NAME = ATOM_REF_TARGET_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ATTRIBUTE__FIELDS = ATOM_REF_TARGET_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Record Macro</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ATTRIBUTE__RECORD_MACRO = ATOM_REF_TARGET_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Record Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ATTRIBUTE_FEATURE_COUNT = ATOM_REF_TARGET_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.RecordFieldDefImpl <em>Record Field Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.RecordFieldDefImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordFieldDef()
   * @generated
   */
  int RECORD_FIELD_DEF = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_DEF__NAME = ATOM_REF_TARGET_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_DEF__VALUE = ATOM_REF_TARGET_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_DEF__TYPE = ATOM_REF_TARGET_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Record Field Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_DEF_FEATURE_COUNT = ATOM_REF_TARGET_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ExportAttributeImpl <em>Export Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ExportAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getExportAttribute()
   * @generated
   */
  int EXPORT_ATTRIBUTE = 19;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORT_ATTRIBUTE__TAG = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Funs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORT_ATTRIBUTE__FUNS = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Export Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPORT_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ImportAttributeImpl <em>Import Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ImportAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getImportAttribute()
   * @generated
   */
  int IMPORT_ATTRIBUTE = 20;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_ATTRIBUTE__TAG = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Module</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_ATTRIBUTE__MODULE = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Funs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_ATTRIBUTE__FUNS = ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Import Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.CompileAttributeImpl <em>Compile Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.CompileAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getCompileAttribute()
   * @generated
   */
  int COMPILE_ATTRIBUTE = 21;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPILE_ATTRIBUTE__TAG = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Options</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPILE_ATTRIBUTE__OPTIONS = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Compile Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPILE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.AbstractTypeAttributeImpl <em>Abstract Type Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.AbstractTypeAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getAbstractTypeAttribute()
   * @generated
   */
  int ABSTRACT_TYPE_ATTRIBUTE = 22;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TYPE_ATTRIBUTE__TAG = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Type Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TYPE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.SpecAttributeImpl <em>Spec Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.SpecAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getSpecAttribute()
   * @generated
   */
  int SPEC_ATTRIBUTE = 23;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPEC_ATTRIBUTE__TAG = ABSTRACT_TYPE_ATTRIBUTE__TAG;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPEC_ATTRIBUTE__REF = ABSTRACT_TYPE_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Signatures</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPEC_ATTRIBUTE__SIGNATURES = ABSTRACT_TYPE_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Spec Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPEC_ATTRIBUTE_FEATURE_COUNT = ABSTRACT_TYPE_ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.TypeAttributeImpl <em>Type Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.TypeAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getTypeAttribute()
   * @generated
   */
  int TYPE_ATTRIBUTE = 24;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ATTRIBUTE__TAG = ABSTRACT_TYPE_ATTRIBUTE__TAG;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ATTRIBUTE__NAME = ABSTRACT_TYPE_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ATTRIBUTE__ARGS = ABSTRACT_TYPE_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ATTRIBUTE__TYPE = ABSTRACT_TYPE_ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Type Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ATTRIBUTE_FEATURE_COUNT = ABSTRACT_TYPE_ATTRIBUTE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.CustomAttributeImpl <em>Custom Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.CustomAttributeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getCustomAttribute()
   * @generated
   */
  int CUSTOM_ATTRIBUTE = 25;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_ATTRIBUTE__TAG = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_ATTRIBUTE__VALUE = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Custom Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.FunctionImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 26;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__NAME = ATOM_REF_TARGET_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Clauses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__CLAUSES = ATOM_REF_TARGET_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = ATOM_REF_TARGET_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.FunctionClauseImpl <em>Function Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.FunctionClauseImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunctionClause()
   * @generated
   */
  int FUNCTION_CLAUSE = 27;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CLAUSE__REF = 0;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CLAUSE__PARAMS = 1;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CLAUSE__GUARD = 2;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CLAUSE__BODY = 3;

  /**
   * The number of structural features of the '<em>Function Clause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CLAUSE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.GuardImpl <em>Guard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.GuardImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getGuard()
   * @generated
   */
  int GUARD = 28;

  /**
   * The feature id for the '<em><b>Guards</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__GUARDS = 0;

  /**
   * The number of structural features of the '<em>Guard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ExpressionsImpl <em>Expressions</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ExpressionsImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getExpressions()
   * @generated
   */
  int EXPRESSIONS = 29;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSIONS__EXPRS = 0;

  /**
   * The number of structural features of the '<em>Expressions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSIONS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ExpressionImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 30;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__LINE = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPR = 1;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__STRING = 2;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__MORE = 3;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.MacroCallImpl <em>Macro Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.MacroCallImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getMacroCall()
   * @generated
   */
  int MACRO_CALL = 31;

  /**
   * The feature id for the '<em><b>Macro Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_CALL__MACRO_NAME = 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_CALL__ARGS = 1;

  /**
   * The number of structural features of the '<em>Macro Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_CALL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.RecordExprImpl <em>Record Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.RecordExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordExpr()
   * @generated
   */
  int RECORD_EXPR = 32;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__REF = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Record</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__RECORD = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__REC = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Field</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__FIELD = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__TUPLE = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Record Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.QueryExprImpl <em>Query Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.QueryExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getQueryExpr()
   * @generated
   */
  int QUERY_EXPR = 33;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The number of structural features of the '<em>Query Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.CondExprImpl <em>Cond Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.CondExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getCondExpr()
   * @generated
   */
  int COND_EXPR = 34;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The number of structural features of the '<em>Cond Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.LetExprImpl <em>Let Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.LetExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getLetExpr()
   * @generated
   */
  int LET_EXPR = 35;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The number of structural features of the '<em>Let Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.RecordTupleImpl <em>Record Tuple</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.RecordTupleImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordTuple()
   * @generated
   */
  int RECORD_TUPLE = 36;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TUPLE__FIELDS = 0;

  /**
   * The number of structural features of the '<em>Record Tuple</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TUPLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.RecordFieldExprImpl <em>Record Field Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.RecordFieldExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordFieldExpr()
   * @generated
   */
  int RECORD_FIELD_EXPR = 37;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_EXPR__REF = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_EXPR__VALUE = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_EXPR__TYPE = 2;

  /**
   * The number of structural features of the '<em>Record Field Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_EXPR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.StringLiteralPartImpl <em>String Literal Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.StringLiteralPartImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getStringLiteralPart()
   * @generated
   */
  int STRING_LITERAL_PART = 38;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_PART__STRING = 0;

  /**
   * The feature id for the '<em><b>Macro</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_PART__MACRO = 1;

  /**
   * The number of structural features of the '<em>String Literal Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.IfExprImpl <em>If Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.IfExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getIfExpr()
   * @generated
   */
  int IF_EXPR = 39;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Clauses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPR__CLAUSES = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>If Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.IfClauseImpl <em>If Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.IfClauseImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getIfClause()
   * @generated
   */
  int IF_CLAUSE = 40;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CLAUSE__GUARD = 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CLAUSE__BODY = 1;

  /**
   * The number of structural features of the '<em>If Clause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CLAUSE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.CaseExprImpl <em>Case Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.CaseExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getCaseExpr()
   * @generated
   */
  int CASE_EXPR = 41;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Clauses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXPR__CLAUSES = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Case Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.CrClauseImpl <em>Cr Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.CrClauseImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getCrClause()
   * @generated
   */
  int CR_CLAUSE = 42;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CR_CLAUSE__EXPR = 0;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CR_CLAUSE__GUARD = 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CR_CLAUSE__BODY = 2;

  /**
   * The number of structural features of the '<em>Cr Clause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CR_CLAUSE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ReceiveExprImpl <em>Receive Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ReceiveExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getReceiveExpr()
   * @generated
   */
  int RECEIVE_EXPR = 43;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECEIVE_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECEIVE_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECEIVE_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECEIVE_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Clauses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECEIVE_EXPR__CLAUSES = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>After expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECEIVE_EXPR__AFTER_EXPR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>After body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECEIVE_EXPR__AFTER_BODY = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Receive Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECEIVE_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.FunExprImpl <em>Fun Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.FunExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunExpr()
   * @generated
   */
  int FUN_EXPR = 44;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Clauses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_EXPR__CLAUSES = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fun Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.FunRefImpl <em>Fun Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.FunRefImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunRef()
   * @generated
   */
  int FUN_REF = 45;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_REF__LINE = FUN_EXPR__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_REF__EXPR = FUN_EXPR__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_REF__STRING = FUN_EXPR__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_REF__MORE = FUN_EXPR__MORE;

  /**
   * The feature id for the '<em><b>Clauses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_REF__CLAUSES = FUN_EXPR__CLAUSES;

  /**
   * The feature id for the '<em><b>Module</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_REF__MODULE = FUN_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_REF__FUNCTION = FUN_EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Arity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_REF__ARITY = FUN_EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Fun Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_REF_FEATURE_COUNT = FUN_EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.TryExprImpl <em>Try Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.TryExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getTryExpr()
   * @generated
   */
  int TRY_EXPR = 46;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_EXPR__BODY = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Of clauses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_EXPR__OF_CLAUSES = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Catch</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_EXPR__CATCH = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>After body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_EXPR__AFTER_BODY = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Try Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.TryClauseImpl <em>Try Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.TryClauseImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getTryClause()
   * @generated
   */
  int TRY_CLAUSE = 47;

  /**
   * The feature id for the '<em><b>Hdr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_CLAUSE__HDR = 0;

  /**
   * The feature id for the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_CLAUSE__COND = 1;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_CLAUSE__GUARD = 2;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_CLAUSE__BODY = 3;

  /**
   * The number of structural features of the '<em>Try Clause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRY_CLAUSE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ErlListImpl <em>Erl List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ErlListImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlList()
   * @generated
   */
  int ERL_LIST = 48;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_LIST__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_LIST__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_LIST__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_LIST__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_LIST__ELEMENTS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_LIST__TAIL = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Erl List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_LIST_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ListComprehensionImpl <em>List Comprehension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ListComprehensionImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getListComprehension()
   * @generated
   */
  int LIST_COMPREHENSION = 49;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_COMPREHENSION__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_COMPREHENSION__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_COMPREHENSION__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_COMPREHENSION__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_COMPREHENSION__ELEMENT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Generators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_COMPREHENSION__GENERATORS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>List Comprehension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_COMPREHENSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ErlTupleImpl <em>Erl Tuple</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ErlTupleImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlTuple()
   * @generated
   */
  int ERL_TUPLE = 50;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_TUPLE__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_TUPLE__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_TUPLE__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_TUPLE__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_TUPLE__ELEMENTS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Erl Tuple</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_TUPLE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.BinaryComprehensionImpl <em>Binary Comprehension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.BinaryComprehensionImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinaryComprehension()
   * @generated
   */
  int BINARY_COMPREHENSION = 51;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_COMPREHENSION__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_COMPREHENSION__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_COMPREHENSION__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_COMPREHENSION__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Generators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_COMPREHENSION__GENERATORS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Binary Comprehension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_COMPREHENSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ErlBinaryImpl <em>Erl Binary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ErlBinaryImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlBinary()
   * @generated
   */
  int ERL_BINARY = 52;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_BINARY__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_BINARY__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_BINARY__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_BINARY__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_BINARY__ELEMENTS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Erl Binary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_BINARY_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.BinaryItemImpl <em>Binary Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.BinaryItemImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinaryItem()
   * @generated
   */
  int BINARY_ITEM = 53;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_ITEM__EXPR = 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_ITEM__SIZE = 1;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_ITEM__TYPES = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_ITEM__TYPE = 3;

  /**
   * The number of structural features of the '<em>Binary Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_ITEM_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.BitTypeImpl <em>Bit Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.BitTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getBitType()
   * @generated
   */
  int BIT_TYPE = 54;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_TYPE__TYPE_NAME = 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_TYPE__SIZE = 1;

  /**
   * The number of structural features of the '<em>Bit Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIT_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.LCExprImpl <em>LC Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.LCExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getLCExpr()
   * @generated
   */
  int LC_EXPR = 55;

  /**
   * The feature id for the '<em><b>O1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LC_EXPR__O1 = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LC_EXPR__OP = 1;

  /**
   * The feature id for the '<em><b>O2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LC_EXPR__O2 = 2;

  /**
   * The number of structural features of the '<em>LC Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LC_EXPR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.TypeSigImpl <em>Type Sig</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.TypeSigImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getTypeSig()
   * @generated
   */
  int TYPE_SIG = 56;

  /**
   * The feature id for the '<em><b>Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SIG__DECL = 0;

  /**
   * The feature id for the '<em><b>Guards</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SIG__GUARDS = 1;

  /**
   * The number of structural features of the '<em>Type Sig</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SIG_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.Type100Impl <em>Type100</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.Type100Impl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getType100()
   * @generated
   */
  int TYPE100 = 61;

  /**
   * The number of structural features of the '<em>Type100</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE100_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.Type200Impl <em>Type200</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.Type200Impl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getType200()
   * @generated
   */
  int TYPE200 = 62;

  /**
   * The number of structural features of the '<em>Type200</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE200_FEATURE_COUNT = TYPE100_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.Type300Impl <em>Type300</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.Type300Impl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getType300()
   * @generated
   */
  int TYPE300 = 63;

  /**
   * The number of structural features of the '<em>Type300</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE300_FEATURE_COUNT = TYPE200_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.Type400Impl <em>Type400</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.Type400Impl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getType400()
   * @generated
   */
  int TYPE400 = 64;

  /**
   * The number of structural features of the '<em>Type400</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE400_FEATURE_COUNT = TYPE300_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.Type500Impl <em>Type500</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.Type500Impl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getType500()
   * @generated
   */
  int TYPE500 = 65;

  /**
   * The number of structural features of the '<em>Type500</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE500_FEATURE_COUNT = TYPE400_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.TypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getType()
   * @generated
   */
  int TYPE = 66;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__TYPE_NAME = TYPE500_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__VALUE = TYPE500_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = TYPE500_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.FunTypeImpl <em>Fun Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.FunTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunType()
   * @generated
   */
  int FUN_TYPE = 57;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_TYPE__TYPE_NAME = TYPE__TYPE_NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_TYPE__VALUE = TYPE__VALUE;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_TYPE__ARGS = TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_TYPE__RETURN = TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_TYPE__TYPE = TYPE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Fun Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.TypeGuardsImpl <em>Type Guards</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.TypeGuardsImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getTypeGuards()
   * @generated
   */
  int TYPE_GUARDS = 58;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_GUARDS__ITEMS = 0;

  /**
   * The number of structural features of the '<em>Type Guards</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_GUARDS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.TypeGuardImpl <em>Type Guard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.TypeGuardImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getTypeGuard()
   * @generated
   */
  int TYPE_GUARD = 59;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_GUARD__TYPE_NAME = 0;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_GUARD__TYPES = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_GUARD__TYPE = 2;

  /**
   * The number of structural features of the '<em>Type Guard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_GUARD_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.TopTypeImpl <em>Top Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.TopTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getTopType()
   * @generated
   */
  int TOP_TYPE = 60;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_TYPE__TYPE_NAME = TYPE100_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_TYPE__VALUE = TYPE100_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_TYPE__VAR = TYPE100_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_TYPE__TYPE = TYPE100_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_TYPE__LEFT_OPERAND = TYPE100_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_TYPE__OP = TYPE100_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_TYPE__RIGHT_OPERAND = TYPE100_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Top Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOP_TYPE_FEATURE_COUNT = TYPE100_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.FieldTypeImpl <em>Field Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.FieldTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getFieldType()
   * @generated
   */
  int FIELD_TYPE = 67;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__TYPE_NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE__TYPE = 1;

  /**
   * The number of structural features of the '<em>Field Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.BinaryTypeImpl <em>Binary Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.BinaryTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinaryType()
   * @generated
   */
  int BINARY_TYPE = 68;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_TYPE__TYPE_NAME = TYPE__TYPE_NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_TYPE__VALUE = TYPE__VALUE;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_TYPE__TYPE = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Binary Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.BinBaseTypeImpl <em>Bin Base Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.BinBaseTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinBaseType()
   * @generated
   */
  int BIN_BASE_TYPE = 69;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_BASE_TYPE__TYPE_NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_BASE_TYPE__TYPE = 1;

  /**
   * The number of structural features of the '<em>Bin Base Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_BASE_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.BinUnitTypeImpl <em>Bin Unit Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.BinUnitTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinUnitType()
   * @generated
   */
  int BIN_UNIT_TYPE = 70;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_UNIT_TYPE__TYPE_NAME = 0;

  /**
   * The feature id for the '<em><b>M</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_UNIT_TYPE__M = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_UNIT_TYPE__TYPE = 2;

  /**
   * The number of structural features of the '<em>Bin Unit Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_UNIT_TYPE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.FunType100Impl <em>Fun Type100</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.FunType100Impl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunType100()
   * @generated
   */
  int FUN_TYPE100 = 71;

  /**
   * The number of structural features of the '<em>Fun Type100</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_TYPE100_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.MacroFormImpl <em>Macro Form</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.MacroFormImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getMacroForm()
   * @generated
   */
  int MACRO_FORM = 72;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_FORM__CALL = FORM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Macro Form</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_FORM_FEATURE_COUNT = FORM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.CatchExprImpl <em>Catch Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.CatchExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getCatchExpr()
   * @generated
   */
  int CATCH_EXPR = 73;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATCH_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATCH_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATCH_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATCH_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The number of structural features of the '<em>Catch Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATCH_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.MatchExprImpl <em>Match Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.MatchExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getMatchExpr()
   * @generated
   */
  int MATCH_EXPR = 74;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATCH_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATCH_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATCH_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATCH_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Op Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATCH_EXPR__OP_LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATCH_EXPR__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Op Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATCH_EXPR__OP_RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Match Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATCH_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.BinOpImpl <em>Bin Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.BinOpImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinOp()
   * @generated
   */
  int BIN_OP = 75;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Op Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP__OP_LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Op Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP__OP_RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Op Right2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP__OP_RIGHT2 = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Bin Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIN_OP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.AddOpImpl <em>Add Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.AddOpImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getAddOp()
   * @generated
   */
  int ADD_OP = 76;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_OP__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_OP__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_OP__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_OP__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Op Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_OP__OP_LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_OP__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Op Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_OP__OP_RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Add Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_OP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.MultOpImpl <em>Mult Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.MultOpImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getMultOp()
   * @generated
   */
  int MULT_OP = 77;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_OP__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_OP__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_OP__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_OP__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Op Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_OP__OP_LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_OP__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Op Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_OP__OP_RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Mult Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_OP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.UnaryExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getUnaryExpr()
   * @generated
   */
  int UNARY_EXPR = 78;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__OP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.FunCallImpl <em>Fun Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.FunCallImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunCall()
   * @generated
   */
  int FUN_CALL = 79;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_CALL__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_CALL__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_CALL__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_CALL__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_CALL__TARGET = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_CALL__ARGS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Args2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_CALL__ARGS2 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Fun Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.RemoteTargetImpl <em>Remote Target</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.RemoteTargetImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getRemoteTarget()
   * @generated
   */
  int REMOTE_TARGET = 80;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TARGET__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TARGET__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TARGET__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TARGET__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Module</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TARGET__MODULE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TARGET__FUNCTION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Remote Target</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TARGET_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.BlockExprImpl <em>Block Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.BlockExprImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getBlockExpr()
   * @generated
   */
  int BLOCK_EXPR = 81;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_EXPR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_EXPR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_EXPR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_EXPR__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_EXPR__BODY = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Block Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_EXPR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ErlCharImpl <em>Erl Char</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ErlCharImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlChar()
   * @generated
   */
  int ERL_CHAR = 82;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_CHAR__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_CHAR__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_CHAR__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_CHAR__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_CHAR__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Erl Char</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_CHAR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.AtomImpl <em>Atom</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.AtomImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getAtom()
   * @generated
   */
  int ATOM = 83;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Atom</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.MacroImpl <em>Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.MacroImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getMacro()
   * @generated
   */
  int MACRO = 84;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Macro</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.VariableImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 85;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ErlFloatImpl <em>Erl Float</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ErlFloatImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlFloat()
   * @generated
   */
  int ERL_FLOAT = 86;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_FLOAT__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_FLOAT__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_FLOAT__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_FLOAT__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_FLOAT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Erl Float</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_FLOAT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ErlIntegerImpl <em>Erl Integer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ErlIntegerImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlInteger()
   * @generated
   */
  int ERL_INTEGER = 87;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_INTEGER__LINE = EXPRESSION__LINE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_INTEGER__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_INTEGER__STRING = EXPRESSION__STRING;

  /**
   * The feature id for the '<em><b>More</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_INTEGER__MORE = EXPRESSION__MORE;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_INTEGER__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Erl Integer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERL_INTEGER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.UnaryTypeImpl <em>Unary Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.UnaryTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getUnaryType()
   * @generated
   */
  int UNARY_TYPE = 88;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_TYPE__OP = TYPE500_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_TYPE__OPERAND = TYPE500_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_TYPE_FEATURE_COUNT = TYPE500_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.RemoteTypeImpl <em>Remote Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.RemoteTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getRemoteType()
   * @generated
   */
  int REMOTE_TYPE = 89;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TYPE__TYPE_NAME = TYPE__TYPE_NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TYPE__VALUE = TYPE__VALUE;

  /**
   * The feature id for the '<em><b>M</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TYPE__M = TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TYPE__ARGS = TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Remote Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REMOTE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.ListTypeImpl <em>List Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.ListTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getListType()
   * @generated
   */
  int LIST_TYPE = 90;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE__TYPE_NAME = TYPE__TYPE_NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE__VALUE = TYPE__VALUE;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE__TYPE = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>List Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.TupleTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getTupleType()
   * @generated
   */
  int TUPLE_TYPE = 91;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__TYPE_NAME = TYPE__TYPE_NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__VALUE = TYPE__VALUE;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__TYPES = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tuple Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.RecordTypeImpl <em>Record Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.RecordTypeImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordType()
   * @generated
   */
  int RECORD_TYPE = 92;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__TYPE_NAME = TYPE__TYPE_NAME;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__VALUE = TYPE__VALUE;

  /**
   * The feature id for the '<em><b>Rec</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__REC = TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__FIELDS = TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Record Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.erlide.erlang.impl.FunTypeListImpl <em>Fun Type List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.erlide.erlang.impl.FunTypeListImpl
   * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunTypeList()
   * @generated
   */
  int FUN_TYPE_LIST = 93;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_TYPE_LIST__ITEMS = FUN_TYPE100_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_TYPE_LIST__RETURN = FUN_TYPE100_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Fun Type List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_TYPE_LIST_FEATURE_COUNT = FUN_TYPE100_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module</em>'.
   * @see org.erlide.erlang.Module
   * @generated
   */
  EClass getModule();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.Module#getForms <em>Forms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Forms</em>'.
   * @see org.erlide.erlang.Module#getForms()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Forms();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.AtomRefTarget <em>Atom Ref Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atom Ref Target</em>'.
   * @see org.erlide.erlang.AtomRefTarget
   * @generated
   */
  EClass getAtomRefTarget();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Form <em>Form</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Form</em>'.
   * @see org.erlide.erlang.Form
   * @generated
   */
  EClass getForm();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ConditionalFormBlock <em>Conditional Form Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Form Block</em>'.
   * @see org.erlide.erlang.ConditionalFormBlock
   * @generated
   */
  EClass getConditionalFormBlock();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.ConditionalFormBlock#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.erlide.erlang.ConditionalFormBlock#getCondition()
   * @see #getConditionalFormBlock()
   * @generated
   */
  EReference getConditionalFormBlock_Condition();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.ConditionalFormBlock#getIfForms <em>If Forms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>If Forms</em>'.
   * @see org.erlide.erlang.ConditionalFormBlock#getIfForms()
   * @see #getConditionalFormBlock()
   * @generated
   */
  EReference getConditionalFormBlock_IfForms();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.ConditionalFormBlock#isHasElse <em>Has Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Has Else</em>'.
   * @see org.erlide.erlang.ConditionalFormBlock#isHasElse()
   * @see #getConditionalFormBlock()
   * @generated
   */
  EAttribute getConditionalFormBlock_HasElse();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.ConditionalFormBlock#getElseForms <em>Else Forms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Else Forms</em>'.
   * @see org.erlide.erlang.ConditionalFormBlock#getElseForms()
   * @see #getConditionalFormBlock()
   * @generated
   */
  EReference getConditionalFormBlock_ElseForms();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.ConditionalFormBlock#getEnd <em>End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>End</em>'.
   * @see org.erlide.erlang.ConditionalFormBlock#getEnd()
   * @see #getConditionalFormBlock()
   * @generated
   */
  EReference getConditionalFormBlock_End();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see org.erlide.erlang.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ConditionalAttribute <em>Conditional Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Attribute</em>'.
   * @see org.erlide.erlang.ConditionalAttribute
   * @generated
   */
  EClass getConditionalAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.ConditionalAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.ConditionalAttribute#getTag()
   * @see #getConditionalAttribute()
   * @generated
   */
  EAttribute getConditionalAttribute_Tag();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.AbstractDefineAttribute <em>Abstract Define Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Define Attribute</em>'.
   * @see org.erlide.erlang.AbstractDefineAttribute
   * @generated
   */
  EClass getAbstractDefineAttribute();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.DefineAttribute <em>Define Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define Attribute</em>'.
   * @see org.erlide.erlang.DefineAttribute
   * @generated
   */
  EClass getDefineAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.DefineAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.DefineAttribute#getTag()
   * @see #getDefineAttribute()
   * @generated
   */
  EAttribute getDefineAttribute_Tag();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.DefineAttribute#getMacroName <em>Macro Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Macro Name</em>'.
   * @see org.erlide.erlang.DefineAttribute#getMacroName()
   * @see #getDefineAttribute()
   * @generated
   */
  EAttribute getDefineAttribute_MacroName();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.DefineAttribute#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.erlide.erlang.DefineAttribute#getArgs()
   * @see #getDefineAttribute()
   * @generated
   */
  EReference getDefineAttribute_Args();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.DefineAttribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.erlide.erlang.DefineAttribute#getValue()
   * @see #getDefineAttribute()
   * @generated
   */
  EReference getDefineAttribute_Value();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.UndefAttribute <em>Undef Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Undef Attribute</em>'.
   * @see org.erlide.erlang.UndefAttribute
   * @generated
   */
  EClass getUndefAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.UndefAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.UndefAttribute#getTag()
   * @see #getUndefAttribute()
   * @generated
   */
  EAttribute getUndefAttribute_Tag();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.UndefAttribute#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see org.erlide.erlang.UndefAttribute#getRef()
   * @see #getUndefAttribute()
   * @generated
   */
  EReference getUndefAttribute_Ref();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.IfdefAttribute <em>Ifdef Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ifdef Attribute</em>'.
   * @see org.erlide.erlang.IfdefAttribute
   * @generated
   */
  EClass getIfdefAttribute();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.IfdefAttribute#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see org.erlide.erlang.IfdefAttribute#getRef()
   * @see #getIfdefAttribute()
   * @generated
   */
  EReference getIfdefAttribute_Ref();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ElseAttribute <em>Else Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Else Attribute</em>'.
   * @see org.erlide.erlang.ElseAttribute
   * @generated
   */
  EClass getElseAttribute();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.EndifAttribute <em>Endif Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Endif Attribute</em>'.
   * @see org.erlide.erlang.EndifAttribute
   * @generated
   */
  EClass getEndifAttribute();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.AbstractIncludeAttribute <em>Abstract Include Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Include Attribute</em>'.
   * @see org.erlide.erlang.AbstractIncludeAttribute
   * @generated
   */
  EClass getAbstractIncludeAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.AbstractIncludeAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.AbstractIncludeAttribute#getTag()
   * @see #getAbstractIncludeAttribute()
   * @generated
   */
  EAttribute getAbstractIncludeAttribute_Tag();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.AbstractIncludeAttribute#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see org.erlide.erlang.AbstractIncludeAttribute#getImportURI()
   * @see #getAbstractIncludeAttribute()
   * @generated
   */
  EAttribute getAbstractIncludeAttribute_ImportURI();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.IncludeAttribute <em>Include Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include Attribute</em>'.
   * @see org.erlide.erlang.IncludeAttribute
   * @generated
   */
  EClass getIncludeAttribute();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.IncludeLibAttribute <em>Include Lib Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include Lib Attribute</em>'.
   * @see org.erlide.erlang.IncludeLibAttribute
   * @generated
   */
  EClass getIncludeLibAttribute();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.FileAttribute <em>File Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>File Attribute</em>'.
   * @see org.erlide.erlang.FileAttribute
   * @generated
   */
  EClass getFileAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.FileAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.FileAttribute#getTag()
   * @see #getFileAttribute()
   * @generated
   */
  EAttribute getFileAttribute_Tag();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.FileAttribute#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see org.erlide.erlang.FileAttribute#getFile()
   * @see #getFileAttribute()
   * @generated
   */
  EAttribute getFileAttribute_File();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.FileAttribute#getLine <em>Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Line</em>'.
   * @see org.erlide.erlang.FileAttribute#getLine()
   * @see #getFileAttribute()
   * @generated
   */
  EAttribute getFileAttribute_Line();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ModuleAttribute <em>Module Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module Attribute</em>'.
   * @see org.erlide.erlang.ModuleAttribute
   * @generated
   */
  EClass getModuleAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.ModuleAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.ModuleAttribute#getTag()
   * @see #getModuleAttribute()
   * @generated
   */
  EAttribute getModuleAttribute_Tag();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.ModuleAttribute#getModuleName <em>Module Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Module Name</em>'.
   * @see org.erlide.erlang.ModuleAttribute#getModuleName()
   * @see #getModuleAttribute()
   * @generated
   */
  EAttribute getModuleAttribute_ModuleName();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.RecordAttribute <em>Record Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Attribute</em>'.
   * @see org.erlide.erlang.RecordAttribute
   * @generated
   */
  EClass getRecordAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.RecordAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.RecordAttribute#getTag()
   * @see #getRecordAttribute()
   * @generated
   */
  EAttribute getRecordAttribute_Tag();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.RecordAttribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.erlide.erlang.RecordAttribute#getName()
   * @see #getRecordAttribute()
   * @generated
   */
  EAttribute getRecordAttribute_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.RecordAttribute#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.erlide.erlang.RecordAttribute#getFields()
   * @see #getRecordAttribute()
   * @generated
   */
  EReference getRecordAttribute_Fields();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RecordAttribute#getRecordMacro <em>Record Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Record Macro</em>'.
   * @see org.erlide.erlang.RecordAttribute#getRecordMacro()
   * @see #getRecordAttribute()
   * @generated
   */
  EReference getRecordAttribute_RecordMacro();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.RecordFieldDef <em>Record Field Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Field Def</em>'.
   * @see org.erlide.erlang.RecordFieldDef
   * @generated
   */
  EClass getRecordFieldDef();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.RecordFieldDef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.erlide.erlang.RecordFieldDef#getName()
   * @see #getRecordFieldDef()
   * @generated
   */
  EAttribute getRecordFieldDef_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RecordFieldDef#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.erlide.erlang.RecordFieldDef#getValue()
   * @see #getRecordFieldDef()
   * @generated
   */
  EReference getRecordFieldDef_Value();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RecordFieldDef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.erlide.erlang.RecordFieldDef#getType()
   * @see #getRecordFieldDef()
   * @generated
   */
  EReference getRecordFieldDef_Type();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ExportAttribute <em>Export Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Export Attribute</em>'.
   * @see org.erlide.erlang.ExportAttribute
   * @generated
   */
  EClass getExportAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.ExportAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.ExportAttribute#getTag()
   * @see #getExportAttribute()
   * @generated
   */
  EAttribute getExportAttribute_Tag();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.ExportAttribute#getFuns <em>Funs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Funs</em>'.
   * @see org.erlide.erlang.ExportAttribute#getFuns()
   * @see #getExportAttribute()
   * @generated
   */
  EReference getExportAttribute_Funs();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ImportAttribute <em>Import Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import Attribute</em>'.
   * @see org.erlide.erlang.ImportAttribute
   * @generated
   */
  EClass getImportAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.ImportAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.ImportAttribute#getTag()
   * @see #getImportAttribute()
   * @generated
   */
  EAttribute getImportAttribute_Tag();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.ImportAttribute#getModule <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Module</em>'.
   * @see org.erlide.erlang.ImportAttribute#getModule()
   * @see #getImportAttribute()
   * @generated
   */
  EReference getImportAttribute_Module();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.ImportAttribute#getFuns <em>Funs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Funs</em>'.
   * @see org.erlide.erlang.ImportAttribute#getFuns()
   * @see #getImportAttribute()
   * @generated
   */
  EReference getImportAttribute_Funs();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.CompileAttribute <em>Compile Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compile Attribute</em>'.
   * @see org.erlide.erlang.CompileAttribute
   * @generated
   */
  EClass getCompileAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.CompileAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.CompileAttribute#getTag()
   * @see #getCompileAttribute()
   * @generated
   */
  EAttribute getCompileAttribute_Tag();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.CompileAttribute#getOptions <em>Options</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Options</em>'.
   * @see org.erlide.erlang.CompileAttribute#getOptions()
   * @see #getCompileAttribute()
   * @generated
   */
  EReference getCompileAttribute_Options();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.AbstractTypeAttribute <em>Abstract Type Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Type Attribute</em>'.
   * @see org.erlide.erlang.AbstractTypeAttribute
   * @generated
   */
  EClass getAbstractTypeAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.AbstractTypeAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.AbstractTypeAttribute#getTag()
   * @see #getAbstractTypeAttribute()
   * @generated
   */
  EAttribute getAbstractTypeAttribute_Tag();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.SpecAttribute <em>Spec Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Spec Attribute</em>'.
   * @see org.erlide.erlang.SpecAttribute
   * @generated
   */
  EClass getSpecAttribute();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.SpecAttribute#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see org.erlide.erlang.SpecAttribute#getRef()
   * @see #getSpecAttribute()
   * @generated
   */
  EReference getSpecAttribute_Ref();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.SpecAttribute#getSignatures <em>Signatures</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Signatures</em>'.
   * @see org.erlide.erlang.SpecAttribute#getSignatures()
   * @see #getSpecAttribute()
   * @generated
   */
  EReference getSpecAttribute_Signatures();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.TypeAttribute <em>Type Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Attribute</em>'.
   * @see org.erlide.erlang.TypeAttribute
   * @generated
   */
  EClass getTypeAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.TypeAttribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.erlide.erlang.TypeAttribute#getName()
   * @see #getTypeAttribute()
   * @generated
   */
  EAttribute getTypeAttribute_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.TypeAttribute#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.erlide.erlang.TypeAttribute#getArgs()
   * @see #getTypeAttribute()
   * @generated
   */
  EReference getTypeAttribute_Args();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TypeAttribute#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.erlide.erlang.TypeAttribute#getType()
   * @see #getTypeAttribute()
   * @generated
   */
  EReference getTypeAttribute_Type();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.CustomAttribute <em>Custom Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Custom Attribute</em>'.
   * @see org.erlide.erlang.CustomAttribute
   * @generated
   */
  EClass getCustomAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.CustomAttribute#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.erlide.erlang.CustomAttribute#getTag()
   * @see #getCustomAttribute()
   * @generated
   */
  EAttribute getCustomAttribute_Tag();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.CustomAttribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Value</em>'.
   * @see org.erlide.erlang.CustomAttribute#getValue()
   * @see #getCustomAttribute()
   * @generated
   */
  EReference getCustomAttribute_Value();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see org.erlide.erlang.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.Function#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.erlide.erlang.Function#getName()
   * @see #getFunction()
   * @generated
   */
  EAttribute getFunction_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.Function#getClauses <em>Clauses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Clauses</em>'.
   * @see org.erlide.erlang.Function#getClauses()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Clauses();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.FunctionClause <em>Function Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Clause</em>'.
   * @see org.erlide.erlang.FunctionClause
   * @generated
   */
  EClass getFunctionClause();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.FunctionClause#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.erlide.erlang.FunctionClause#getRef()
   * @see #getFunctionClause()
   * @generated
   */
  EAttribute getFunctionClause_Ref();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunctionClause#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Params</em>'.
   * @see org.erlide.erlang.FunctionClause#getParams()
   * @see #getFunctionClause()
   * @generated
   */
  EReference getFunctionClause_Params();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunctionClause#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.erlide.erlang.FunctionClause#getGuard()
   * @see #getFunctionClause()
   * @generated
   */
  EReference getFunctionClause_Guard();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunctionClause#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.erlide.erlang.FunctionClause#getBody()
   * @see #getFunctionClause()
   * @generated
   */
  EReference getFunctionClause_Body();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard</em>'.
   * @see org.erlide.erlang.Guard
   * @generated
   */
  EClass getGuard();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.Guard#getGuards <em>Guards</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Guards</em>'.
   * @see org.erlide.erlang.Guard#getGuards()
   * @see #getGuard()
   * @generated
   */
  EReference getGuard_Guards();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Expressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expressions</em>'.
   * @see org.erlide.erlang.Expressions
   * @generated
   */
  EClass getExpressions();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.Expressions#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exprs</em>'.
   * @see org.erlide.erlang.Expressions#getExprs()
   * @see #getExpressions()
   * @generated
   */
  EReference getExpressions_Exprs();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.erlide.erlang.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.Expression#isLine <em>Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Line</em>'.
   * @see org.erlide.erlang.Expression#isLine()
   * @see #getExpression()
   * @generated
   */
  EAttribute getExpression_Line();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.Expression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.erlide.erlang.Expression#getExpr()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Expr();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.Expression#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see org.erlide.erlang.Expression#getString()
   * @see #getExpression()
   * @generated
   */
  EAttribute getExpression_String();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.Expression#getMore <em>More</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More</em>'.
   * @see org.erlide.erlang.Expression#getMore()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_More();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.MacroCall <em>Macro Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Macro Call</em>'.
   * @see org.erlide.erlang.MacroCall
   * @generated
   */
  EClass getMacroCall();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.MacroCall#getMacroName <em>Macro Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Macro Name</em>'.
   * @see org.erlide.erlang.MacroCall#getMacroName()
   * @see #getMacroCall()
   * @generated
   */
  EReference getMacroCall_MacroName();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.MacroCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Args</em>'.
   * @see org.erlide.erlang.MacroCall#getArgs()
   * @see #getMacroCall()
   * @generated
   */
  EReference getMacroCall_Args();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.RecordExpr <em>Record Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Expr</em>'.
   * @see org.erlide.erlang.RecordExpr
   * @generated
   */
  EClass getRecordExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RecordExpr#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see org.erlide.erlang.RecordExpr#getRef()
   * @see #getRecordExpr()
   * @generated
   */
  EReference getRecordExpr_Ref();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RecordExpr#getRecord <em>Record</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Record</em>'.
   * @see org.erlide.erlang.RecordExpr#getRecord()
   * @see #getRecordExpr()
   * @generated
   */
  EReference getRecordExpr_Record();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RecordExpr#getRec <em>Rec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rec</em>'.
   * @see org.erlide.erlang.RecordExpr#getRec()
   * @see #getRecordExpr()
   * @generated
   */
  EReference getRecordExpr_Rec();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RecordExpr#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Field</em>'.
   * @see org.erlide.erlang.RecordExpr#getField()
   * @see #getRecordExpr()
   * @generated
   */
  EReference getRecordExpr_Field();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RecordExpr#getTuple <em>Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tuple</em>'.
   * @see org.erlide.erlang.RecordExpr#getTuple()
   * @see #getRecordExpr()
   * @generated
   */
  EReference getRecordExpr_Tuple();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.QueryExpr <em>Query Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query Expr</em>'.
   * @see org.erlide.erlang.QueryExpr
   * @generated
   */
  EClass getQueryExpr();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.CondExpr <em>Cond Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cond Expr</em>'.
   * @see org.erlide.erlang.CondExpr
   * @generated
   */
  EClass getCondExpr();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.LetExpr <em>Let Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Let Expr</em>'.
   * @see org.erlide.erlang.LetExpr
   * @generated
   */
  EClass getLetExpr();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.RecordTuple <em>Record Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Tuple</em>'.
   * @see org.erlide.erlang.RecordTuple
   * @generated
   */
  EClass getRecordTuple();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.RecordTuple#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.erlide.erlang.RecordTuple#getFields()
   * @see #getRecordTuple()
   * @generated
   */
  EReference getRecordTuple_Fields();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.RecordFieldExpr <em>Record Field Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Field Expr</em>'.
   * @see org.erlide.erlang.RecordFieldExpr
   * @generated
   */
  EClass getRecordFieldExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RecordFieldExpr#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see org.erlide.erlang.RecordFieldExpr#getRef()
   * @see #getRecordFieldExpr()
   * @generated
   */
  EReference getRecordFieldExpr_Ref();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RecordFieldExpr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.erlide.erlang.RecordFieldExpr#getValue()
   * @see #getRecordFieldExpr()
   * @generated
   */
  EReference getRecordFieldExpr_Value();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RecordFieldExpr#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.erlide.erlang.RecordFieldExpr#getType()
   * @see #getRecordFieldExpr()
   * @generated
   */
  EReference getRecordFieldExpr_Type();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.StringLiteralPart <em>String Literal Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal Part</em>'.
   * @see org.erlide.erlang.StringLiteralPart
   * @generated
   */
  EClass getStringLiteralPart();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.StringLiteralPart#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see org.erlide.erlang.StringLiteralPart#getString()
   * @see #getStringLiteralPart()
   * @generated
   */
  EAttribute getStringLiteralPart_String();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.StringLiteralPart#getMacro <em>Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Macro</em>'.
   * @see org.erlide.erlang.StringLiteralPart#getMacro()
   * @see #getStringLiteralPart()
   * @generated
   */
  EReference getStringLiteralPart_Macro();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.IfExpr <em>If Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Expr</em>'.
   * @see org.erlide.erlang.IfExpr
   * @generated
   */
  EClass getIfExpr();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.IfExpr#getClauses <em>Clauses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Clauses</em>'.
   * @see org.erlide.erlang.IfExpr#getClauses()
   * @see #getIfExpr()
   * @generated
   */
  EReference getIfExpr_Clauses();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.IfClause <em>If Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Clause</em>'.
   * @see org.erlide.erlang.IfClause
   * @generated
   */
  EClass getIfClause();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.IfClause#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.erlide.erlang.IfClause#getGuard()
   * @see #getIfClause()
   * @generated
   */
  EReference getIfClause_Guard();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.IfClause#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.erlide.erlang.IfClause#getBody()
   * @see #getIfClause()
   * @generated
   */
  EReference getIfClause_Body();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.CaseExpr <em>Case Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Case Expr</em>'.
   * @see org.erlide.erlang.CaseExpr
   * @generated
   */
  EClass getCaseExpr();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.CaseExpr#getClauses <em>Clauses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Clauses</em>'.
   * @see org.erlide.erlang.CaseExpr#getClauses()
   * @see #getCaseExpr()
   * @generated
   */
  EReference getCaseExpr_Clauses();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.CrClause <em>Cr Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cr Clause</em>'.
   * @see org.erlide.erlang.CrClause
   * @generated
   */
  EClass getCrClause();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.CrClause#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.erlide.erlang.CrClause#getExpr()
   * @see #getCrClause()
   * @generated
   */
  EReference getCrClause_Expr();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.CrClause#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.erlide.erlang.CrClause#getGuard()
   * @see #getCrClause()
   * @generated
   */
  EReference getCrClause_Guard();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.CrClause#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.erlide.erlang.CrClause#getBody()
   * @see #getCrClause()
   * @generated
   */
  EReference getCrClause_Body();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ReceiveExpr <em>Receive Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Receive Expr</em>'.
   * @see org.erlide.erlang.ReceiveExpr
   * @generated
   */
  EClass getReceiveExpr();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.ReceiveExpr#getClauses <em>Clauses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Clauses</em>'.
   * @see org.erlide.erlang.ReceiveExpr#getClauses()
   * @see #getReceiveExpr()
   * @generated
   */
  EReference getReceiveExpr_Clauses();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.ReceiveExpr#getAfter_expr <em>After expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>After expr</em>'.
   * @see org.erlide.erlang.ReceiveExpr#getAfter_expr()
   * @see #getReceiveExpr()
   * @generated
   */
  EReference getReceiveExpr_After_expr();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.ReceiveExpr#getAfter_body <em>After body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>After body</em>'.
   * @see org.erlide.erlang.ReceiveExpr#getAfter_body()
   * @see #getReceiveExpr()
   * @generated
   */
  EReference getReceiveExpr_After_body();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.FunExpr <em>Fun Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fun Expr</em>'.
   * @see org.erlide.erlang.FunExpr
   * @generated
   */
  EClass getFunExpr();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.FunExpr#getClauses <em>Clauses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Clauses</em>'.
   * @see org.erlide.erlang.FunExpr#getClauses()
   * @see #getFunExpr()
   * @generated
   */
  EReference getFunExpr_Clauses();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.FunRef <em>Fun Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fun Ref</em>'.
   * @see org.erlide.erlang.FunRef
   * @generated
   */
  EClass getFunRef();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunRef#getModule <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Module</em>'.
   * @see org.erlide.erlang.FunRef#getModule()
   * @see #getFunRef()
   * @generated
   */
  EReference getFunRef_Module();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunRef#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function</em>'.
   * @see org.erlide.erlang.FunRef#getFunction()
   * @see #getFunRef()
   * @generated
   */
  EReference getFunRef_Function();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunRef#getArity <em>Arity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arity</em>'.
   * @see org.erlide.erlang.FunRef#getArity()
   * @see #getFunRef()
   * @generated
   */
  EReference getFunRef_Arity();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.TryExpr <em>Try Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Try Expr</em>'.
   * @see org.erlide.erlang.TryExpr
   * @generated
   */
  EClass getTryExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TryExpr#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.erlide.erlang.TryExpr#getBody()
   * @see #getTryExpr()
   * @generated
   */
  EReference getTryExpr_Body();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.TryExpr#getOf_clauses <em>Of clauses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Of clauses</em>'.
   * @see org.erlide.erlang.TryExpr#getOf_clauses()
   * @see #getTryExpr()
   * @generated
   */
  EReference getTryExpr_Of_clauses();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.TryExpr#getCatch <em>Catch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Catch</em>'.
   * @see org.erlide.erlang.TryExpr#getCatch()
   * @see #getTryExpr()
   * @generated
   */
  EReference getTryExpr_Catch();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TryExpr#getAfter_body <em>After body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>After body</em>'.
   * @see org.erlide.erlang.TryExpr#getAfter_body()
   * @see #getTryExpr()
   * @generated
   */
  EReference getTryExpr_After_body();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.TryClause <em>Try Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Try Clause</em>'.
   * @see org.erlide.erlang.TryClause
   * @generated
   */
  EClass getTryClause();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.TryClause#getHdr <em>Hdr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Hdr</em>'.
   * @see org.erlide.erlang.TryClause#getHdr()
   * @see #getTryClause()
   * @generated
   */
  EAttribute getTryClause_Hdr();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TryClause#getCond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond</em>'.
   * @see org.erlide.erlang.TryClause#getCond()
   * @see #getTryClause()
   * @generated
   */
  EReference getTryClause_Cond();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TryClause#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.erlide.erlang.TryClause#getGuard()
   * @see #getTryClause()
   * @generated
   */
  EReference getTryClause_Guard();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TryClause#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.erlide.erlang.TryClause#getBody()
   * @see #getTryClause()
   * @generated
   */
  EReference getTryClause_Body();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ErlList <em>Erl List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Erl List</em>'.
   * @see org.erlide.erlang.ErlList
   * @generated
   */
  EClass getErlList();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.ErlList#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.erlide.erlang.ErlList#getElements()
   * @see #getErlList()
   * @generated
   */
  EReference getErlList_Elements();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.ErlList#getTail <em>Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tail</em>'.
   * @see org.erlide.erlang.ErlList#getTail()
   * @see #getErlList()
   * @generated
   */
  EReference getErlList_Tail();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ListComprehension <em>List Comprehension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Comprehension</em>'.
   * @see org.erlide.erlang.ListComprehension
   * @generated
   */
  EClass getListComprehension();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.ListComprehension#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.erlide.erlang.ListComprehension#getElement()
   * @see #getListComprehension()
   * @generated
   */
  EReference getListComprehension_Element();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.ListComprehension#getGenerators <em>Generators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generators</em>'.
   * @see org.erlide.erlang.ListComprehension#getGenerators()
   * @see #getListComprehension()
   * @generated
   */
  EReference getListComprehension_Generators();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ErlTuple <em>Erl Tuple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Erl Tuple</em>'.
   * @see org.erlide.erlang.ErlTuple
   * @generated
   */
  EClass getErlTuple();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.ErlTuple#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.erlide.erlang.ErlTuple#getElements()
   * @see #getErlTuple()
   * @generated
   */
  EReference getErlTuple_Elements();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.BinaryComprehension <em>Binary Comprehension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Comprehension</em>'.
   * @see org.erlide.erlang.BinaryComprehension
   * @generated
   */
  EClass getBinaryComprehension();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.BinaryComprehension#getGenerators <em>Generators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generators</em>'.
   * @see org.erlide.erlang.BinaryComprehension#getGenerators()
   * @see #getBinaryComprehension()
   * @generated
   */
  EReference getBinaryComprehension_Generators();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ErlBinary <em>Erl Binary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Erl Binary</em>'.
   * @see org.erlide.erlang.ErlBinary
   * @generated
   */
  EClass getErlBinary();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.ErlBinary#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.erlide.erlang.ErlBinary#getElements()
   * @see #getErlBinary()
   * @generated
   */
  EReference getErlBinary_Elements();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.BinaryItem <em>Binary Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Item</em>'.
   * @see org.erlide.erlang.BinaryItem
   * @generated
   */
  EClass getBinaryItem();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.BinaryItem#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.erlide.erlang.BinaryItem#getExpr()
   * @see #getBinaryItem()
   * @generated
   */
  EReference getBinaryItem_Expr();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.BinaryItem#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Size</em>'.
   * @see org.erlide.erlang.BinaryItem#getSize()
   * @see #getBinaryItem()
   * @generated
   */
  EReference getBinaryItem_Size();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.BinaryItem#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see org.erlide.erlang.BinaryItem#getTypes()
   * @see #getBinaryItem()
   * @generated
   */
  EReference getBinaryItem_Types();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.BinaryItem#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type</em>'.
   * @see org.erlide.erlang.BinaryItem#getType()
   * @see #getBinaryItem()
   * @generated
   */
  EReference getBinaryItem_Type();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.BitType <em>Bit Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bit Type</em>'.
   * @see org.erlide.erlang.BitType
   * @generated
   */
  EClass getBitType();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.BitType#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Name</em>'.
   * @see org.erlide.erlang.BitType#getTypeName()
   * @see #getBitType()
   * @generated
   */
  EAttribute getBitType_TypeName();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.BitType#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Size</em>'.
   * @see org.erlide.erlang.BitType#getSize()
   * @see #getBitType()
   * @generated
   */
  EAttribute getBitType_Size();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.LCExpr <em>LC Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LC Expr</em>'.
   * @see org.erlide.erlang.LCExpr
   * @generated
   */
  EClass getLCExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.LCExpr#getO1 <em>O1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>O1</em>'.
   * @see org.erlide.erlang.LCExpr#getO1()
   * @see #getLCExpr()
   * @generated
   */
  EReference getLCExpr_O1();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.LCExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.erlide.erlang.LCExpr#getOp()
   * @see #getLCExpr()
   * @generated
   */
  EAttribute getLCExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.LCExpr#getO2 <em>O2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>O2</em>'.
   * @see org.erlide.erlang.LCExpr#getO2()
   * @see #getLCExpr()
   * @generated
   */
  EReference getLCExpr_O2();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.TypeSig <em>Type Sig</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Sig</em>'.
   * @see org.erlide.erlang.TypeSig
   * @generated
   */
  EClass getTypeSig();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TypeSig#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Decl</em>'.
   * @see org.erlide.erlang.TypeSig#getDecl()
   * @see #getTypeSig()
   * @generated
   */
  EReference getTypeSig_Decl();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TypeSig#getGuards <em>Guards</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guards</em>'.
   * @see org.erlide.erlang.TypeSig#getGuards()
   * @see #getTypeSig()
   * @generated
   */
  EReference getTypeSig_Guards();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.FunType <em>Fun Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fun Type</em>'.
   * @see org.erlide.erlang.FunType
   * @generated
   */
  EClass getFunType();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.FunType#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.erlide.erlang.FunType#getArgs()
   * @see #getFunType()
   * @generated
   */
  EReference getFunType_Args();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunType#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return</em>'.
   * @see org.erlide.erlang.FunType#getReturn()
   * @see #getFunType()
   * @generated
   */
  EReference getFunType_Return();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.erlide.erlang.FunType#getType()
   * @see #getFunType()
   * @generated
   */
  EReference getFunType_Type();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.TypeGuards <em>Type Guards</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Guards</em>'.
   * @see org.erlide.erlang.TypeGuards
   * @generated
   */
  EClass getTypeGuards();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.TypeGuards#getItems <em>Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Items</em>'.
   * @see org.erlide.erlang.TypeGuards#getItems()
   * @see #getTypeGuards()
   * @generated
   */
  EReference getTypeGuards_Items();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.TypeGuard <em>Type Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Guard</em>'.
   * @see org.erlide.erlang.TypeGuard
   * @generated
   */
  EClass getTypeGuard();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.TypeGuard#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Name</em>'.
   * @see org.erlide.erlang.TypeGuard#getTypeName()
   * @see #getTypeGuard()
   * @generated
   */
  EAttribute getTypeGuard_TypeName();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.TypeGuard#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see org.erlide.erlang.TypeGuard#getTypes()
   * @see #getTypeGuard()
   * @generated
   */
  EReference getTypeGuard_Types();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TypeGuard#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.erlide.erlang.TypeGuard#getType()
   * @see #getTypeGuard()
   * @generated
   */
  EReference getTypeGuard_Type();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.TopType <em>Top Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Top Type</em>'.
   * @see org.erlide.erlang.TopType
   * @generated
   */
  EClass getTopType();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.TopType#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see org.erlide.erlang.TopType#getVar()
   * @see #getTopType()
   * @generated
   */
  EAttribute getTopType_Var();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TopType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.erlide.erlang.TopType#getType()
   * @see #getTopType()
   * @generated
   */
  EReference getTopType_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TopType#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.erlide.erlang.TopType#getLeftOperand()
   * @see #getTopType()
   * @generated
   */
  EReference getTopType_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.TopType#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.erlide.erlang.TopType#getOp()
   * @see #getTopType()
   * @generated
   */
  EAttribute getTopType_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.TopType#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.erlide.erlang.TopType#getRightOperand()
   * @see #getTopType()
   * @generated
   */
  EReference getTopType_RightOperand();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Type100 <em>Type100</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type100</em>'.
   * @see org.erlide.erlang.Type100
   * @generated
   */
  EClass getType100();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Type200 <em>Type200</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type200</em>'.
   * @see org.erlide.erlang.Type200
   * @generated
   */
  EClass getType200();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Type300 <em>Type300</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type300</em>'.
   * @see org.erlide.erlang.Type300
   * @generated
   */
  EClass getType300();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Type400 <em>Type400</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type400</em>'.
   * @see org.erlide.erlang.Type400
   * @generated
   */
  EClass getType400();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Type500 <em>Type500</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type500</em>'.
   * @see org.erlide.erlang.Type500
   * @generated
   */
  EClass getType500();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.erlide.erlang.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.Type#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Name</em>'.
   * @see org.erlide.erlang.Type#getTypeName()
   * @see #getType()
   * @generated
   */
  EAttribute getType_TypeName();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.Type#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.erlide.erlang.Type#getValue()
   * @see #getType()
   * @generated
   */
  EAttribute getType_Value();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.FieldType <em>Field Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Type</em>'.
   * @see org.erlide.erlang.FieldType
   * @generated
   */
  EClass getFieldType();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.FieldType#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Name</em>'.
   * @see org.erlide.erlang.FieldType#getTypeName()
   * @see #getFieldType()
   * @generated
   */
  EAttribute getFieldType_TypeName();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FieldType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.erlide.erlang.FieldType#getType()
   * @see #getFieldType()
   * @generated
   */
  EReference getFieldType_Type();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.BinaryType <em>Binary Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Type</em>'.
   * @see org.erlide.erlang.BinaryType
   * @generated
   */
  EClass getBinaryType();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.BinaryType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type</em>'.
   * @see org.erlide.erlang.BinaryType#getType()
   * @see #getBinaryType()
   * @generated
   */
  EReference getBinaryType_Type();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.BinBaseType <em>Bin Base Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bin Base Type</em>'.
   * @see org.erlide.erlang.BinBaseType
   * @generated
   */
  EClass getBinBaseType();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.BinBaseType#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Name</em>'.
   * @see org.erlide.erlang.BinBaseType#getTypeName()
   * @see #getBinBaseType()
   * @generated
   */
  EAttribute getBinBaseType_TypeName();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.BinBaseType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.erlide.erlang.BinBaseType#getType()
   * @see #getBinBaseType()
   * @generated
   */
  EReference getBinBaseType_Type();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.BinUnitType <em>Bin Unit Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bin Unit Type</em>'.
   * @see org.erlide.erlang.BinUnitType
   * @generated
   */
  EClass getBinUnitType();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.BinUnitType#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Name</em>'.
   * @see org.erlide.erlang.BinUnitType#getTypeName()
   * @see #getBinUnitType()
   * @generated
   */
  EAttribute getBinUnitType_TypeName();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.BinUnitType#getM <em>M</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>M</em>'.
   * @see org.erlide.erlang.BinUnitType#getM()
   * @see #getBinUnitType()
   * @generated
   */
  EAttribute getBinUnitType_M();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.BinUnitType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.erlide.erlang.BinUnitType#getType()
   * @see #getBinUnitType()
   * @generated
   */
  EReference getBinUnitType_Type();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.FunType100 <em>Fun Type100</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fun Type100</em>'.
   * @see org.erlide.erlang.FunType100
   * @generated
   */
  EClass getFunType100();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.MacroForm <em>Macro Form</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Macro Form</em>'.
   * @see org.erlide.erlang.MacroForm
   * @generated
   */
  EClass getMacroForm();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.MacroForm#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see org.erlide.erlang.MacroForm#getCall()
   * @see #getMacroForm()
   * @generated
   */
  EReference getMacroForm_Call();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.CatchExpr <em>Catch Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Catch Expr</em>'.
   * @see org.erlide.erlang.CatchExpr
   * @generated
   */
  EClass getCatchExpr();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.MatchExpr <em>Match Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Match Expr</em>'.
   * @see org.erlide.erlang.MatchExpr
   * @generated
   */
  EClass getMatchExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.MatchExpr#getOpLeft <em>Op Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op Left</em>'.
   * @see org.erlide.erlang.MatchExpr#getOpLeft()
   * @see #getMatchExpr()
   * @generated
   */
  EReference getMatchExpr_OpLeft();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.MatchExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.erlide.erlang.MatchExpr#getOp()
   * @see #getMatchExpr()
   * @generated
   */
  EAttribute getMatchExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.MatchExpr#getOpRight <em>Op Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op Right</em>'.
   * @see org.erlide.erlang.MatchExpr#getOpRight()
   * @see #getMatchExpr()
   * @generated
   */
  EReference getMatchExpr_OpRight();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.BinOp <em>Bin Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bin Op</em>'.
   * @see org.erlide.erlang.BinOp
   * @generated
   */
  EClass getBinOp();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.BinOp#getOpLeft <em>Op Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op Left</em>'.
   * @see org.erlide.erlang.BinOp#getOpLeft()
   * @see #getBinOp()
   * @generated
   */
  EReference getBinOp_OpLeft();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.BinOp#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.erlide.erlang.BinOp#getOp()
   * @see #getBinOp()
   * @generated
   */
  EAttribute getBinOp_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.BinOp#getOpRight <em>Op Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op Right</em>'.
   * @see org.erlide.erlang.BinOp#getOpRight()
   * @see #getBinOp()
   * @generated
   */
  EReference getBinOp_OpRight();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.BinOp#getOpRight2 <em>Op Right2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op Right2</em>'.
   * @see org.erlide.erlang.BinOp#getOpRight2()
   * @see #getBinOp()
   * @generated
   */
  EReference getBinOp_OpRight2();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.AddOp <em>Add Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Add Op</em>'.
   * @see org.erlide.erlang.AddOp
   * @generated
   */
  EClass getAddOp();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.AddOp#getOpLeft <em>Op Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op Left</em>'.
   * @see org.erlide.erlang.AddOp#getOpLeft()
   * @see #getAddOp()
   * @generated
   */
  EReference getAddOp_OpLeft();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.AddOp#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.erlide.erlang.AddOp#getOp()
   * @see #getAddOp()
   * @generated
   */
  EAttribute getAddOp_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.AddOp#getOpRight <em>Op Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op Right</em>'.
   * @see org.erlide.erlang.AddOp#getOpRight()
   * @see #getAddOp()
   * @generated
   */
  EReference getAddOp_OpRight();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.MultOp <em>Mult Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mult Op</em>'.
   * @see org.erlide.erlang.MultOp
   * @generated
   */
  EClass getMultOp();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.MultOp#getOpLeft <em>Op Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op Left</em>'.
   * @see org.erlide.erlang.MultOp#getOpLeft()
   * @see #getMultOp()
   * @generated
   */
  EReference getMultOp_OpLeft();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.MultOp#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.erlide.erlang.MultOp#getOp()
   * @see #getMultOp()
   * @generated
   */
  EAttribute getMultOp_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.MultOp#getOpRight <em>Op Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op Right</em>'.
   * @see org.erlide.erlang.MultOp#getOpRight()
   * @see #getMultOp()
   * @generated
   */
  EReference getMultOp_OpRight();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expr</em>'.
   * @see org.erlide.erlang.UnaryExpr
   * @generated
   */
  EClass getUnaryExpr();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.UnaryExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.erlide.erlang.UnaryExpr#getOp()
   * @see #getUnaryExpr()
   * @generated
   */
  EAttribute getUnaryExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.UnaryExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.erlide.erlang.UnaryExpr#getOperand()
   * @see #getUnaryExpr()
   * @generated
   */
  EReference getUnaryExpr_Operand();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.FunCall <em>Fun Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fun Call</em>'.
   * @see org.erlide.erlang.FunCall
   * @generated
   */
  EClass getFunCall();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunCall#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see org.erlide.erlang.FunCall#getTarget()
   * @see #getFunCall()
   * @generated
   */
  EReference getFunCall_Target();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Args</em>'.
   * @see org.erlide.erlang.FunCall#getArgs()
   * @see #getFunCall()
   * @generated
   */
  EReference getFunCall_Args();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunCall#getArgs2 <em>Args2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Args2</em>'.
   * @see org.erlide.erlang.FunCall#getArgs2()
   * @see #getFunCall()
   * @generated
   */
  EReference getFunCall_Args2();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.RemoteTarget <em>Remote Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Remote Target</em>'.
   * @see org.erlide.erlang.RemoteTarget
   * @generated
   */
  EClass getRemoteTarget();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RemoteTarget#getModule <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Module</em>'.
   * @see org.erlide.erlang.RemoteTarget#getModule()
   * @see #getRemoteTarget()
   * @generated
   */
  EReference getRemoteTarget_Module();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RemoteTarget#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function</em>'.
   * @see org.erlide.erlang.RemoteTarget#getFunction()
   * @see #getRemoteTarget()
   * @generated
   */
  EReference getRemoteTarget_Function();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.BlockExpr <em>Block Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block Expr</em>'.
   * @see org.erlide.erlang.BlockExpr
   * @generated
   */
  EClass getBlockExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.BlockExpr#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.erlide.erlang.BlockExpr#getBody()
   * @see #getBlockExpr()
   * @generated
   */
  EReference getBlockExpr_Body();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ErlChar <em>Erl Char</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Erl Char</em>'.
   * @see org.erlide.erlang.ErlChar
   * @generated
   */
  EClass getErlChar();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.ErlChar#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.erlide.erlang.ErlChar#getValue()
   * @see #getErlChar()
   * @generated
   */
  EAttribute getErlChar_Value();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Atom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atom</em>'.
   * @see org.erlide.erlang.Atom
   * @generated
   */
  EClass getAtom();

  /**
   * Returns the meta object for the reference '{@link org.erlide.erlang.Atom#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.erlide.erlang.Atom#getValue()
   * @see #getAtom()
   * @generated
   */
  EReference getAtom_Value();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Macro <em>Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Macro</em>'.
   * @see org.erlide.erlang.Macro
   * @generated
   */
  EClass getMacro();

  /**
   * Returns the meta object for the reference '{@link org.erlide.erlang.Macro#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.erlide.erlang.Macro#getValue()
   * @see #getMacro()
   * @generated
   */
  EReference getMacro_Value();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see org.erlide.erlang.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the reference '{@link org.erlide.erlang.Variable#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.erlide.erlang.Variable#getValue()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Value();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ErlFloat <em>Erl Float</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Erl Float</em>'.
   * @see org.erlide.erlang.ErlFloat
   * @generated
   */
  EClass getErlFloat();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.ErlFloat#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.erlide.erlang.ErlFloat#getValue()
   * @see #getErlFloat()
   * @generated
   */
  EAttribute getErlFloat_Value();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ErlInteger <em>Erl Integer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Erl Integer</em>'.
   * @see org.erlide.erlang.ErlInteger
   * @generated
   */
  EClass getErlInteger();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.ErlInteger#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.erlide.erlang.ErlInteger#getValue()
   * @see #getErlInteger()
   * @generated
   */
  EAttribute getErlInteger_Value();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.UnaryType <em>Unary Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Type</em>'.
   * @see org.erlide.erlang.UnaryType
   * @generated
   */
  EClass getUnaryType();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.UnaryType#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.erlide.erlang.UnaryType#getOp()
   * @see #getUnaryType()
   * @generated
   */
  EAttribute getUnaryType_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.UnaryType#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.erlide.erlang.UnaryType#getOperand()
   * @see #getUnaryType()
   * @generated
   */
  EReference getUnaryType_Operand();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.RemoteType <em>Remote Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Remote Type</em>'.
   * @see org.erlide.erlang.RemoteType
   * @generated
   */
  EClass getRemoteType();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.RemoteType#getM <em>M</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>M</em>'.
   * @see org.erlide.erlang.RemoteType#getM()
   * @see #getRemoteType()
   * @generated
   */
  EReference getRemoteType_M();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.RemoteType#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.erlide.erlang.RemoteType#getArgs()
   * @see #getRemoteType()
   * @generated
   */
  EReference getRemoteType_Args();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.ListType <em>List Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Type</em>'.
   * @see org.erlide.erlang.ListType
   * @generated
   */
  EClass getListType();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.ListType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.erlide.erlang.ListType#getType()
   * @see #getListType()
   * @generated
   */
  EReference getListType_Type();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.TupleType <em>Tuple Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Type</em>'.
   * @see org.erlide.erlang.TupleType
   * @generated
   */
  EClass getTupleType();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.TupleType#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see org.erlide.erlang.TupleType#getTypes()
   * @see #getTupleType()
   * @generated
   */
  EReference getTupleType_Types();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.RecordType <em>Record Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Type</em>'.
   * @see org.erlide.erlang.RecordType
   * @generated
   */
  EClass getRecordType();

  /**
   * Returns the meta object for the attribute '{@link org.erlide.erlang.RecordType#getRec <em>Rec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rec</em>'.
   * @see org.erlide.erlang.RecordType#getRec()
   * @see #getRecordType()
   * @generated
   */
  EAttribute getRecordType_Rec();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.RecordType#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.erlide.erlang.RecordType#getFields()
   * @see #getRecordType()
   * @generated
   */
  EReference getRecordType_Fields();

  /**
   * Returns the meta object for class '{@link org.erlide.erlang.FunTypeList <em>Fun Type List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fun Type List</em>'.
   * @see org.erlide.erlang.FunTypeList
   * @generated
   */
  EClass getFunTypeList();

  /**
   * Returns the meta object for the containment reference list '{@link org.erlide.erlang.FunTypeList#getItems <em>Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Items</em>'.
   * @see org.erlide.erlang.FunTypeList#getItems()
   * @see #getFunTypeList()
   * @generated
   */
  EReference getFunTypeList_Items();

  /**
   * Returns the meta object for the containment reference '{@link org.erlide.erlang.FunTypeList#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return</em>'.
   * @see org.erlide.erlang.FunTypeList#getReturn()
   * @see #getFunTypeList()
   * @generated
   */
  EReference getFunTypeList_Return();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ErlangFactory getErlangFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ModuleImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getModule()
     * @generated
     */
    EClass MODULE = eINSTANCE.getModule();

    /**
     * The meta object literal for the '<em><b>Forms</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__FORMS = eINSTANCE.getModule_Forms();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.AtomRefTargetImpl <em>Atom Ref Target</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.AtomRefTargetImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getAtomRefTarget()
     * @generated
     */
    EClass ATOM_REF_TARGET = eINSTANCE.getAtomRefTarget();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.FormImpl <em>Form</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.FormImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getForm()
     * @generated
     */
    EClass FORM = eINSTANCE.getForm();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ConditionalFormBlockImpl <em>Conditional Form Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ConditionalFormBlockImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getConditionalFormBlock()
     * @generated
     */
    EClass CONDITIONAL_FORM_BLOCK = eINSTANCE.getConditionalFormBlock();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_FORM_BLOCK__CONDITION = eINSTANCE.getConditionalFormBlock_Condition();

    /**
     * The meta object literal for the '<em><b>If Forms</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_FORM_BLOCK__IF_FORMS = eINSTANCE.getConditionalFormBlock_IfForms();

    /**
     * The meta object literal for the '<em><b>Has Else</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONDITIONAL_FORM_BLOCK__HAS_ELSE = eINSTANCE.getConditionalFormBlock_HasElse();

    /**
     * The meta object literal for the '<em><b>Else Forms</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_FORM_BLOCK__ELSE_FORMS = eINSTANCE.getConditionalFormBlock_ElseForms();

    /**
     * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_FORM_BLOCK__END = eINSTANCE.getConditionalFormBlock_End();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.AttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ConditionalAttributeImpl <em>Conditional Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ConditionalAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getConditionalAttribute()
     * @generated
     */
    EClass CONDITIONAL_ATTRIBUTE = eINSTANCE.getConditionalAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONDITIONAL_ATTRIBUTE__TAG = eINSTANCE.getConditionalAttribute_Tag();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.AbstractDefineAttributeImpl <em>Abstract Define Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.AbstractDefineAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getAbstractDefineAttribute()
     * @generated
     */
    EClass ABSTRACT_DEFINE_ATTRIBUTE = eINSTANCE.getAbstractDefineAttribute();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.DefineAttributeImpl <em>Define Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.DefineAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getDefineAttribute()
     * @generated
     */
    EClass DEFINE_ATTRIBUTE = eINSTANCE.getDefineAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINE_ATTRIBUTE__TAG = eINSTANCE.getDefineAttribute_Tag();

    /**
     * The meta object literal for the '<em><b>Macro Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINE_ATTRIBUTE__MACRO_NAME = eINSTANCE.getDefineAttribute_MacroName();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINE_ATTRIBUTE__ARGS = eINSTANCE.getDefineAttribute_Args();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINE_ATTRIBUTE__VALUE = eINSTANCE.getDefineAttribute_Value();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.UndefAttributeImpl <em>Undef Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.UndefAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getUndefAttribute()
     * @generated
     */
    EClass UNDEF_ATTRIBUTE = eINSTANCE.getUndefAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNDEF_ATTRIBUTE__TAG = eINSTANCE.getUndefAttribute_Tag();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNDEF_ATTRIBUTE__REF = eINSTANCE.getUndefAttribute_Ref();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.IfdefAttributeImpl <em>Ifdef Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.IfdefAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getIfdefAttribute()
     * @generated
     */
    EClass IFDEF_ATTRIBUTE = eINSTANCE.getIfdefAttribute();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IFDEF_ATTRIBUTE__REF = eINSTANCE.getIfdefAttribute_Ref();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ElseAttributeImpl <em>Else Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ElseAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getElseAttribute()
     * @generated
     */
    EClass ELSE_ATTRIBUTE = eINSTANCE.getElseAttribute();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.EndifAttributeImpl <em>Endif Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.EndifAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getEndifAttribute()
     * @generated
     */
    EClass ENDIF_ATTRIBUTE = eINSTANCE.getEndifAttribute();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.AbstractIncludeAttributeImpl <em>Abstract Include Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.AbstractIncludeAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getAbstractIncludeAttribute()
     * @generated
     */
    EClass ABSTRACT_INCLUDE_ATTRIBUTE = eINSTANCE.getAbstractIncludeAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_INCLUDE_ATTRIBUTE__TAG = eINSTANCE.getAbstractIncludeAttribute_Tag();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_INCLUDE_ATTRIBUTE__IMPORT_URI = eINSTANCE.getAbstractIncludeAttribute_ImportURI();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.IncludeAttributeImpl <em>Include Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.IncludeAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getIncludeAttribute()
     * @generated
     */
    EClass INCLUDE_ATTRIBUTE = eINSTANCE.getIncludeAttribute();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.IncludeLibAttributeImpl <em>Include Lib Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.IncludeLibAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getIncludeLibAttribute()
     * @generated
     */
    EClass INCLUDE_LIB_ATTRIBUTE = eINSTANCE.getIncludeLibAttribute();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.FileAttributeImpl <em>File Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.FileAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getFileAttribute()
     * @generated
     */
    EClass FILE_ATTRIBUTE = eINSTANCE.getFileAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FILE_ATTRIBUTE__TAG = eINSTANCE.getFileAttribute_Tag();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FILE_ATTRIBUTE__FILE = eINSTANCE.getFileAttribute_File();

    /**
     * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FILE_ATTRIBUTE__LINE = eINSTANCE.getFileAttribute_Line();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ModuleAttributeImpl <em>Module Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ModuleAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getModuleAttribute()
     * @generated
     */
    EClass MODULE_ATTRIBUTE = eINSTANCE.getModuleAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE_ATTRIBUTE__TAG = eINSTANCE.getModuleAttribute_Tag();

    /**
     * The meta object literal for the '<em><b>Module Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE_ATTRIBUTE__MODULE_NAME = eINSTANCE.getModuleAttribute_ModuleName();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.RecordAttributeImpl <em>Record Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.RecordAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordAttribute()
     * @generated
     */
    EClass RECORD_ATTRIBUTE = eINSTANCE.getRecordAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD_ATTRIBUTE__TAG = eINSTANCE.getRecordAttribute_Tag();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD_ATTRIBUTE__NAME = eINSTANCE.getRecordAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_ATTRIBUTE__FIELDS = eINSTANCE.getRecordAttribute_Fields();

    /**
     * The meta object literal for the '<em><b>Record Macro</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_ATTRIBUTE__RECORD_MACRO = eINSTANCE.getRecordAttribute_RecordMacro();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.RecordFieldDefImpl <em>Record Field Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.RecordFieldDefImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordFieldDef()
     * @generated
     */
    EClass RECORD_FIELD_DEF = eINSTANCE.getRecordFieldDef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD_FIELD_DEF__NAME = eINSTANCE.getRecordFieldDef_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD_DEF__VALUE = eINSTANCE.getRecordFieldDef_Value();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD_DEF__TYPE = eINSTANCE.getRecordFieldDef_Type();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ExportAttributeImpl <em>Export Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ExportAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getExportAttribute()
     * @generated
     */
    EClass EXPORT_ATTRIBUTE = eINSTANCE.getExportAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPORT_ATTRIBUTE__TAG = eINSTANCE.getExportAttribute_Tag();

    /**
     * The meta object literal for the '<em><b>Funs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPORT_ATTRIBUTE__FUNS = eINSTANCE.getExportAttribute_Funs();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ImportAttributeImpl <em>Import Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ImportAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getImportAttribute()
     * @generated
     */
    EClass IMPORT_ATTRIBUTE = eINSTANCE.getImportAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT_ATTRIBUTE__TAG = eINSTANCE.getImportAttribute_Tag();

    /**
     * The meta object literal for the '<em><b>Module</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT_ATTRIBUTE__MODULE = eINSTANCE.getImportAttribute_Module();

    /**
     * The meta object literal for the '<em><b>Funs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT_ATTRIBUTE__FUNS = eINSTANCE.getImportAttribute_Funs();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.CompileAttributeImpl <em>Compile Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.CompileAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getCompileAttribute()
     * @generated
     */
    EClass COMPILE_ATTRIBUTE = eINSTANCE.getCompileAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPILE_ATTRIBUTE__TAG = eINSTANCE.getCompileAttribute_Tag();

    /**
     * The meta object literal for the '<em><b>Options</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPILE_ATTRIBUTE__OPTIONS = eINSTANCE.getCompileAttribute_Options();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.AbstractTypeAttributeImpl <em>Abstract Type Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.AbstractTypeAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getAbstractTypeAttribute()
     * @generated
     */
    EClass ABSTRACT_TYPE_ATTRIBUTE = eINSTANCE.getAbstractTypeAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_TYPE_ATTRIBUTE__TAG = eINSTANCE.getAbstractTypeAttribute_Tag();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.SpecAttributeImpl <em>Spec Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.SpecAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getSpecAttribute()
     * @generated
     */
    EClass SPEC_ATTRIBUTE = eINSTANCE.getSpecAttribute();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPEC_ATTRIBUTE__REF = eINSTANCE.getSpecAttribute_Ref();

    /**
     * The meta object literal for the '<em><b>Signatures</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPEC_ATTRIBUTE__SIGNATURES = eINSTANCE.getSpecAttribute_Signatures();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.TypeAttributeImpl <em>Type Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.TypeAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getTypeAttribute()
     * @generated
     */
    EClass TYPE_ATTRIBUTE = eINSTANCE.getTypeAttribute();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_ATTRIBUTE__NAME = eINSTANCE.getTypeAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_ATTRIBUTE__ARGS = eINSTANCE.getTypeAttribute_Args();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_ATTRIBUTE__TYPE = eINSTANCE.getTypeAttribute_Type();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.CustomAttributeImpl <em>Custom Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.CustomAttributeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getCustomAttribute()
     * @generated
     */
    EClass CUSTOM_ATTRIBUTE = eINSTANCE.getCustomAttribute();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CUSTOM_ATTRIBUTE__TAG = eINSTANCE.getCustomAttribute_Tag();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CUSTOM_ATTRIBUTE__VALUE = eINSTANCE.getCustomAttribute_Value();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.FunctionImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

    /**
     * The meta object literal for the '<em><b>Clauses</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__CLAUSES = eINSTANCE.getFunction_Clauses();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.FunctionClauseImpl <em>Function Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.FunctionClauseImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunctionClause()
     * @generated
     */
    EClass FUNCTION_CLAUSE = eINSTANCE.getFunctionClause();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_CLAUSE__REF = eINSTANCE.getFunctionClause_Ref();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_CLAUSE__PARAMS = eINSTANCE.getFunctionClause_Params();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_CLAUSE__GUARD = eINSTANCE.getFunctionClause_Guard();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_CLAUSE__BODY = eINSTANCE.getFunctionClause_Body();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.GuardImpl <em>Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.GuardImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getGuard()
     * @generated
     */
    EClass GUARD = eINSTANCE.getGuard();

    /**
     * The meta object literal for the '<em><b>Guards</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD__GUARDS = eINSTANCE.getGuard_Guards();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ExpressionsImpl <em>Expressions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ExpressionsImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getExpressions()
     * @generated
     */
    EClass EXPRESSIONS = eINSTANCE.getExpressions();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSIONS__EXPRS = eINSTANCE.getExpressions_Exprs();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ExpressionImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION__LINE = eINSTANCE.getExpression_Line();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXPR = eINSTANCE.getExpression_Expr();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION__STRING = eINSTANCE.getExpression_String();

    /**
     * The meta object literal for the '<em><b>More</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__MORE = eINSTANCE.getExpression_More();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.MacroCallImpl <em>Macro Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.MacroCallImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getMacroCall()
     * @generated
     */
    EClass MACRO_CALL = eINSTANCE.getMacroCall();

    /**
     * The meta object literal for the '<em><b>Macro Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_CALL__MACRO_NAME = eINSTANCE.getMacroCall_MacroName();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_CALL__ARGS = eINSTANCE.getMacroCall_Args();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.RecordExprImpl <em>Record Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.RecordExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordExpr()
     * @generated
     */
    EClass RECORD_EXPR = eINSTANCE.getRecordExpr();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_EXPR__REF = eINSTANCE.getRecordExpr_Ref();

    /**
     * The meta object literal for the '<em><b>Record</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_EXPR__RECORD = eINSTANCE.getRecordExpr_Record();

    /**
     * The meta object literal for the '<em><b>Rec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_EXPR__REC = eINSTANCE.getRecordExpr_Rec();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_EXPR__FIELD = eINSTANCE.getRecordExpr_Field();

    /**
     * The meta object literal for the '<em><b>Tuple</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_EXPR__TUPLE = eINSTANCE.getRecordExpr_Tuple();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.QueryExprImpl <em>Query Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.QueryExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getQueryExpr()
     * @generated
     */
    EClass QUERY_EXPR = eINSTANCE.getQueryExpr();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.CondExprImpl <em>Cond Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.CondExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getCondExpr()
     * @generated
     */
    EClass COND_EXPR = eINSTANCE.getCondExpr();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.LetExprImpl <em>Let Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.LetExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getLetExpr()
     * @generated
     */
    EClass LET_EXPR = eINSTANCE.getLetExpr();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.RecordTupleImpl <em>Record Tuple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.RecordTupleImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordTuple()
     * @generated
     */
    EClass RECORD_TUPLE = eINSTANCE.getRecordTuple();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_TUPLE__FIELDS = eINSTANCE.getRecordTuple_Fields();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.RecordFieldExprImpl <em>Record Field Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.RecordFieldExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordFieldExpr()
     * @generated
     */
    EClass RECORD_FIELD_EXPR = eINSTANCE.getRecordFieldExpr();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD_EXPR__REF = eINSTANCE.getRecordFieldExpr_Ref();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD_EXPR__VALUE = eINSTANCE.getRecordFieldExpr_Value();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD_EXPR__TYPE = eINSTANCE.getRecordFieldExpr_Type();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.StringLiteralPartImpl <em>String Literal Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.StringLiteralPartImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getStringLiteralPart()
     * @generated
     */
    EClass STRING_LITERAL_PART = eINSTANCE.getStringLiteralPart();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL_PART__STRING = eINSTANCE.getStringLiteralPart_String();

    /**
     * The meta object literal for the '<em><b>Macro</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_LITERAL_PART__MACRO = eINSTANCE.getStringLiteralPart_Macro();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.IfExprImpl <em>If Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.IfExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getIfExpr()
     * @generated
     */
    EClass IF_EXPR = eINSTANCE.getIfExpr();

    /**
     * The meta object literal for the '<em><b>Clauses</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_EXPR__CLAUSES = eINSTANCE.getIfExpr_Clauses();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.IfClauseImpl <em>If Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.IfClauseImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getIfClause()
     * @generated
     */
    EClass IF_CLAUSE = eINSTANCE.getIfClause();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_CLAUSE__GUARD = eINSTANCE.getIfClause_Guard();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_CLAUSE__BODY = eINSTANCE.getIfClause_Body();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.CaseExprImpl <em>Case Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.CaseExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getCaseExpr()
     * @generated
     */
    EClass CASE_EXPR = eINSTANCE.getCaseExpr();

    /**
     * The meta object literal for the '<em><b>Clauses</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_EXPR__CLAUSES = eINSTANCE.getCaseExpr_Clauses();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.CrClauseImpl <em>Cr Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.CrClauseImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getCrClause()
     * @generated
     */
    EClass CR_CLAUSE = eINSTANCE.getCrClause();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CR_CLAUSE__EXPR = eINSTANCE.getCrClause_Expr();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CR_CLAUSE__GUARD = eINSTANCE.getCrClause_Guard();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CR_CLAUSE__BODY = eINSTANCE.getCrClause_Body();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ReceiveExprImpl <em>Receive Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ReceiveExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getReceiveExpr()
     * @generated
     */
    EClass RECEIVE_EXPR = eINSTANCE.getReceiveExpr();

    /**
     * The meta object literal for the '<em><b>Clauses</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECEIVE_EXPR__CLAUSES = eINSTANCE.getReceiveExpr_Clauses();

    /**
     * The meta object literal for the '<em><b>After expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECEIVE_EXPR__AFTER_EXPR = eINSTANCE.getReceiveExpr_After_expr();

    /**
     * The meta object literal for the '<em><b>After body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECEIVE_EXPR__AFTER_BODY = eINSTANCE.getReceiveExpr_After_body();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.FunExprImpl <em>Fun Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.FunExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunExpr()
     * @generated
     */
    EClass FUN_EXPR = eINSTANCE.getFunExpr();

    /**
     * The meta object literal for the '<em><b>Clauses</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_EXPR__CLAUSES = eINSTANCE.getFunExpr_Clauses();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.FunRefImpl <em>Fun Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.FunRefImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunRef()
     * @generated
     */
    EClass FUN_REF = eINSTANCE.getFunRef();

    /**
     * The meta object literal for the '<em><b>Module</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_REF__MODULE = eINSTANCE.getFunRef_Module();

    /**
     * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_REF__FUNCTION = eINSTANCE.getFunRef_Function();

    /**
     * The meta object literal for the '<em><b>Arity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_REF__ARITY = eINSTANCE.getFunRef_Arity();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.TryExprImpl <em>Try Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.TryExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getTryExpr()
     * @generated
     */
    EClass TRY_EXPR = eINSTANCE.getTryExpr();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_EXPR__BODY = eINSTANCE.getTryExpr_Body();

    /**
     * The meta object literal for the '<em><b>Of clauses</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_EXPR__OF_CLAUSES = eINSTANCE.getTryExpr_Of_clauses();

    /**
     * The meta object literal for the '<em><b>Catch</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_EXPR__CATCH = eINSTANCE.getTryExpr_Catch();

    /**
     * The meta object literal for the '<em><b>After body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_EXPR__AFTER_BODY = eINSTANCE.getTryExpr_After_body();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.TryClauseImpl <em>Try Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.TryClauseImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getTryClause()
     * @generated
     */
    EClass TRY_CLAUSE = eINSTANCE.getTryClause();

    /**
     * The meta object literal for the '<em><b>Hdr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRY_CLAUSE__HDR = eINSTANCE.getTryClause_Hdr();

    /**
     * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_CLAUSE__COND = eINSTANCE.getTryClause_Cond();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_CLAUSE__GUARD = eINSTANCE.getTryClause_Guard();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRY_CLAUSE__BODY = eINSTANCE.getTryClause_Body();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ErlListImpl <em>Erl List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ErlListImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlList()
     * @generated
     */
    EClass ERL_LIST = eINSTANCE.getErlList();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERL_LIST__ELEMENTS = eINSTANCE.getErlList_Elements();

    /**
     * The meta object literal for the '<em><b>Tail</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERL_LIST__TAIL = eINSTANCE.getErlList_Tail();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ListComprehensionImpl <em>List Comprehension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ListComprehensionImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getListComprehension()
     * @generated
     */
    EClass LIST_COMPREHENSION = eINSTANCE.getListComprehension();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_COMPREHENSION__ELEMENT = eINSTANCE.getListComprehension_Element();

    /**
     * The meta object literal for the '<em><b>Generators</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_COMPREHENSION__GENERATORS = eINSTANCE.getListComprehension_Generators();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ErlTupleImpl <em>Erl Tuple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ErlTupleImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlTuple()
     * @generated
     */
    EClass ERL_TUPLE = eINSTANCE.getErlTuple();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERL_TUPLE__ELEMENTS = eINSTANCE.getErlTuple_Elements();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.BinaryComprehensionImpl <em>Binary Comprehension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.BinaryComprehensionImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinaryComprehension()
     * @generated
     */
    EClass BINARY_COMPREHENSION = eINSTANCE.getBinaryComprehension();

    /**
     * The meta object literal for the '<em><b>Generators</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_COMPREHENSION__GENERATORS = eINSTANCE.getBinaryComprehension_Generators();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ErlBinaryImpl <em>Erl Binary</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ErlBinaryImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlBinary()
     * @generated
     */
    EClass ERL_BINARY = eINSTANCE.getErlBinary();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERL_BINARY__ELEMENTS = eINSTANCE.getErlBinary_Elements();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.BinaryItemImpl <em>Binary Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.BinaryItemImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinaryItem()
     * @generated
     */
    EClass BINARY_ITEM = eINSTANCE.getBinaryItem();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_ITEM__EXPR = eINSTANCE.getBinaryItem_Expr();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_ITEM__SIZE = eINSTANCE.getBinaryItem_Size();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_ITEM__TYPES = eINSTANCE.getBinaryItem_Types();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_ITEM__TYPE = eINSTANCE.getBinaryItem_Type();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.BitTypeImpl <em>Bit Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.BitTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getBitType()
     * @generated
     */
    EClass BIT_TYPE = eINSTANCE.getBitType();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIT_TYPE__TYPE_NAME = eINSTANCE.getBitType_TypeName();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIT_TYPE__SIZE = eINSTANCE.getBitType_Size();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.LCExprImpl <em>LC Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.LCExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getLCExpr()
     * @generated
     */
    EClass LC_EXPR = eINSTANCE.getLCExpr();

    /**
     * The meta object literal for the '<em><b>O1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LC_EXPR__O1 = eINSTANCE.getLCExpr_O1();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LC_EXPR__OP = eINSTANCE.getLCExpr_Op();

    /**
     * The meta object literal for the '<em><b>O2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LC_EXPR__O2 = eINSTANCE.getLCExpr_O2();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.TypeSigImpl <em>Type Sig</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.TypeSigImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getTypeSig()
     * @generated
     */
    EClass TYPE_SIG = eINSTANCE.getTypeSig();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_SIG__DECL = eINSTANCE.getTypeSig_Decl();

    /**
     * The meta object literal for the '<em><b>Guards</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_SIG__GUARDS = eINSTANCE.getTypeSig_Guards();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.FunTypeImpl <em>Fun Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.FunTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunType()
     * @generated
     */
    EClass FUN_TYPE = eINSTANCE.getFunType();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_TYPE__ARGS = eINSTANCE.getFunType_Args();

    /**
     * The meta object literal for the '<em><b>Return</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_TYPE__RETURN = eINSTANCE.getFunType_Return();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_TYPE__TYPE = eINSTANCE.getFunType_Type();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.TypeGuardsImpl <em>Type Guards</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.TypeGuardsImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getTypeGuards()
     * @generated
     */
    EClass TYPE_GUARDS = eINSTANCE.getTypeGuards();

    /**
     * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_GUARDS__ITEMS = eINSTANCE.getTypeGuards_Items();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.TypeGuardImpl <em>Type Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.TypeGuardImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getTypeGuard()
     * @generated
     */
    EClass TYPE_GUARD = eINSTANCE.getTypeGuard();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_GUARD__TYPE_NAME = eINSTANCE.getTypeGuard_TypeName();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_GUARD__TYPES = eINSTANCE.getTypeGuard_Types();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_GUARD__TYPE = eINSTANCE.getTypeGuard_Type();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.TopTypeImpl <em>Top Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.TopTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getTopType()
     * @generated
     */
    EClass TOP_TYPE = eINSTANCE.getTopType();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TOP_TYPE__VAR = eINSTANCE.getTopType_Var();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TOP_TYPE__TYPE = eINSTANCE.getTopType_Type();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TOP_TYPE__LEFT_OPERAND = eINSTANCE.getTopType_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TOP_TYPE__OP = eINSTANCE.getTopType_Op();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TOP_TYPE__RIGHT_OPERAND = eINSTANCE.getTopType_RightOperand();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.Type100Impl <em>Type100</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.Type100Impl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getType100()
     * @generated
     */
    EClass TYPE100 = eINSTANCE.getType100();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.Type200Impl <em>Type200</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.Type200Impl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getType200()
     * @generated
     */
    EClass TYPE200 = eINSTANCE.getType200();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.Type300Impl <em>Type300</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.Type300Impl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getType300()
     * @generated
     */
    EClass TYPE300 = eINSTANCE.getType300();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.Type400Impl <em>Type400</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.Type400Impl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getType400()
     * @generated
     */
    EClass TYPE400 = eINSTANCE.getType400();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.Type500Impl <em>Type500</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.Type500Impl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getType500()
     * @generated
     */
    EClass TYPE500 = eINSTANCE.getType500();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.TypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__TYPE_NAME = eINSTANCE.getType_TypeName();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__VALUE = eINSTANCE.getType_Value();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.FieldTypeImpl <em>Field Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.FieldTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getFieldType()
     * @generated
     */
    EClass FIELD_TYPE = eINSTANCE.getFieldType();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_TYPE__TYPE_NAME = eINSTANCE.getFieldType_TypeName();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_TYPE__TYPE = eINSTANCE.getFieldType_Type();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.BinaryTypeImpl <em>Binary Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.BinaryTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinaryType()
     * @generated
     */
    EClass BINARY_TYPE = eINSTANCE.getBinaryType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_TYPE__TYPE = eINSTANCE.getBinaryType_Type();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.BinBaseTypeImpl <em>Bin Base Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.BinBaseTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinBaseType()
     * @generated
     */
    EClass BIN_BASE_TYPE = eINSTANCE.getBinBaseType();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIN_BASE_TYPE__TYPE_NAME = eINSTANCE.getBinBaseType_TypeName();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BIN_BASE_TYPE__TYPE = eINSTANCE.getBinBaseType_Type();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.BinUnitTypeImpl <em>Bin Unit Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.BinUnitTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinUnitType()
     * @generated
     */
    EClass BIN_UNIT_TYPE = eINSTANCE.getBinUnitType();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIN_UNIT_TYPE__TYPE_NAME = eINSTANCE.getBinUnitType_TypeName();

    /**
     * The meta object literal for the '<em><b>M</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIN_UNIT_TYPE__M = eINSTANCE.getBinUnitType_M();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BIN_UNIT_TYPE__TYPE = eINSTANCE.getBinUnitType_Type();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.FunType100Impl <em>Fun Type100</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.FunType100Impl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunType100()
     * @generated
     */
    EClass FUN_TYPE100 = eINSTANCE.getFunType100();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.MacroFormImpl <em>Macro Form</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.MacroFormImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getMacroForm()
     * @generated
     */
    EClass MACRO_FORM = eINSTANCE.getMacroForm();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_FORM__CALL = eINSTANCE.getMacroForm_Call();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.CatchExprImpl <em>Catch Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.CatchExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getCatchExpr()
     * @generated
     */
    EClass CATCH_EXPR = eINSTANCE.getCatchExpr();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.MatchExprImpl <em>Match Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.MatchExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getMatchExpr()
     * @generated
     */
    EClass MATCH_EXPR = eINSTANCE.getMatchExpr();

    /**
     * The meta object literal for the '<em><b>Op Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATCH_EXPR__OP_LEFT = eINSTANCE.getMatchExpr_OpLeft();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MATCH_EXPR__OP = eINSTANCE.getMatchExpr_Op();

    /**
     * The meta object literal for the '<em><b>Op Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATCH_EXPR__OP_RIGHT = eINSTANCE.getMatchExpr_OpRight();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.BinOpImpl <em>Bin Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.BinOpImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getBinOp()
     * @generated
     */
    EClass BIN_OP = eINSTANCE.getBinOp();

    /**
     * The meta object literal for the '<em><b>Op Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BIN_OP__OP_LEFT = eINSTANCE.getBinOp_OpLeft();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIN_OP__OP = eINSTANCE.getBinOp_Op();

    /**
     * The meta object literal for the '<em><b>Op Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BIN_OP__OP_RIGHT = eINSTANCE.getBinOp_OpRight();

    /**
     * The meta object literal for the '<em><b>Op Right2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BIN_OP__OP_RIGHT2 = eINSTANCE.getBinOp_OpRight2();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.AddOpImpl <em>Add Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.AddOpImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getAddOp()
     * @generated
     */
    EClass ADD_OP = eINSTANCE.getAddOp();

    /**
     * The meta object literal for the '<em><b>Op Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD_OP__OP_LEFT = eINSTANCE.getAddOp_OpLeft();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADD_OP__OP = eINSTANCE.getAddOp_Op();

    /**
     * The meta object literal for the '<em><b>Op Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD_OP__OP_RIGHT = eINSTANCE.getAddOp_OpRight();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.MultOpImpl <em>Mult Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.MultOpImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getMultOp()
     * @generated
     */
    EClass MULT_OP = eINSTANCE.getMultOp();

    /**
     * The meta object literal for the '<em><b>Op Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULT_OP__OP_LEFT = eINSTANCE.getMultOp_OpLeft();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULT_OP__OP = eINSTANCE.getMultOp_Op();

    /**
     * The meta object literal for the '<em><b>Op Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULT_OP__OP_RIGHT = eINSTANCE.getMultOp_OpRight();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.UnaryExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getUnaryExpr()
     * @generated
     */
    EClass UNARY_EXPR = eINSTANCE.getUnaryExpr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPR__OP = eINSTANCE.getUnaryExpr_Op();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPR__OPERAND = eINSTANCE.getUnaryExpr_Operand();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.FunCallImpl <em>Fun Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.FunCallImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunCall()
     * @generated
     */
    EClass FUN_CALL = eINSTANCE.getFunCall();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_CALL__TARGET = eINSTANCE.getFunCall_Target();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_CALL__ARGS = eINSTANCE.getFunCall_Args();

    /**
     * The meta object literal for the '<em><b>Args2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_CALL__ARGS2 = eINSTANCE.getFunCall_Args2();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.RemoteTargetImpl <em>Remote Target</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.RemoteTargetImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getRemoteTarget()
     * @generated
     */
    EClass REMOTE_TARGET = eINSTANCE.getRemoteTarget();

    /**
     * The meta object literal for the '<em><b>Module</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REMOTE_TARGET__MODULE = eINSTANCE.getRemoteTarget_Module();

    /**
     * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REMOTE_TARGET__FUNCTION = eINSTANCE.getRemoteTarget_Function();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.BlockExprImpl <em>Block Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.BlockExprImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getBlockExpr()
     * @generated
     */
    EClass BLOCK_EXPR = eINSTANCE.getBlockExpr();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK_EXPR__BODY = eINSTANCE.getBlockExpr_Body();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ErlCharImpl <em>Erl Char</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ErlCharImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlChar()
     * @generated
     */
    EClass ERL_CHAR = eINSTANCE.getErlChar();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERL_CHAR__VALUE = eINSTANCE.getErlChar_Value();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.AtomImpl <em>Atom</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.AtomImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getAtom()
     * @generated
     */
    EClass ATOM = eINSTANCE.getAtom();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOM__VALUE = eINSTANCE.getAtom_Value();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.MacroImpl <em>Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.MacroImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getMacro()
     * @generated
     */
    EClass MACRO = eINSTANCE.getMacro();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO__VALUE = eINSTANCE.getMacro_Value();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.VariableImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__VALUE = eINSTANCE.getVariable_Value();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ErlFloatImpl <em>Erl Float</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ErlFloatImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlFloat()
     * @generated
     */
    EClass ERL_FLOAT = eINSTANCE.getErlFloat();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERL_FLOAT__VALUE = eINSTANCE.getErlFloat_Value();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ErlIntegerImpl <em>Erl Integer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ErlIntegerImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getErlInteger()
     * @generated
     */
    EClass ERL_INTEGER = eINSTANCE.getErlInteger();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERL_INTEGER__VALUE = eINSTANCE.getErlInteger_Value();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.UnaryTypeImpl <em>Unary Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.UnaryTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getUnaryType()
     * @generated
     */
    EClass UNARY_TYPE = eINSTANCE.getUnaryType();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_TYPE__OP = eINSTANCE.getUnaryType_Op();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_TYPE__OPERAND = eINSTANCE.getUnaryType_Operand();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.RemoteTypeImpl <em>Remote Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.RemoteTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getRemoteType()
     * @generated
     */
    EClass REMOTE_TYPE = eINSTANCE.getRemoteType();

    /**
     * The meta object literal for the '<em><b>M</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REMOTE_TYPE__M = eINSTANCE.getRemoteType_M();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REMOTE_TYPE__ARGS = eINSTANCE.getRemoteType_Args();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.ListTypeImpl <em>List Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.ListTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getListType()
     * @generated
     */
    EClass LIST_TYPE = eINSTANCE.getListType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_TYPE__TYPE = eINSTANCE.getListType_Type();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.TupleTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getTupleType()
     * @generated
     */
    EClass TUPLE_TYPE = eINSTANCE.getTupleType();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_TYPE__TYPES = eINSTANCE.getTupleType_Types();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.RecordTypeImpl <em>Record Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.RecordTypeImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getRecordType()
     * @generated
     */
    EClass RECORD_TYPE = eINSTANCE.getRecordType();

    /**
     * The meta object literal for the '<em><b>Rec</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD_TYPE__REC = eINSTANCE.getRecordType_Rec();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_TYPE__FIELDS = eINSTANCE.getRecordType_Fields();

    /**
     * The meta object literal for the '{@link org.erlide.erlang.impl.FunTypeListImpl <em>Fun Type List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.erlide.erlang.impl.FunTypeListImpl
     * @see org.erlide.erlang.impl.ErlangPackageImpl#getFunTypeList()
     * @generated
     */
    EClass FUN_TYPE_LIST = eINSTANCE.getFunTypeList();

    /**
     * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_TYPE_LIST__ITEMS = eINSTANCE.getFunTypeList_Items();

    /**
     * The meta object literal for the '<em><b>Return</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_TYPE_LIST__RETURN = eINSTANCE.getFunTypeList_Return();

  }

} //ErlangPackage
