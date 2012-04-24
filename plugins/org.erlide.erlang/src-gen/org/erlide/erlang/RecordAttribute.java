/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.RecordAttribute#getTag <em>Tag</em>}</li>
 *   <li>{@link org.erlide.erlang.RecordAttribute#getName <em>Name</em>}</li>
 *   <li>{@link org.erlide.erlang.RecordAttribute#getFields <em>Fields</em>}</li>
 *   <li>{@link org.erlide.erlang.RecordAttribute#getRecordMacro <em>Record Macro</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getRecordAttribute()
 * @model
 * @generated
 */
public interface RecordAttribute extends Attribute
{
  /**
   * Returns the value of the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tag</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tag</em>' attribute.
   * @see #setTag(String)
   * @see org.erlide.erlang.ErlangPackage#getRecordAttribute_Tag()
   * @model
   * @generated
   */
  String getTag();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RecordAttribute#getTag <em>Tag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tag</em>' attribute.
   * @see #getTag()
   * @generated
   */
  void setTag(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.erlide.erlang.ErlangPackage#getRecordAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RecordAttribute#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.RecordFieldDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getRecordAttribute_Fields()
   * @model containment="true"
   * @generated
   */
  EList<RecordFieldDef> getFields();

  /**
   * Returns the value of the '<em><b>Record Macro</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record Macro</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Record Macro</em>' reference.
   * @see #setRecordMacro(DefineAttribute)
   * @see org.erlide.erlang.ErlangPackage#getRecordAttribute_RecordMacro()
   * @model
   * @generated
   */
  DefineAttribute getRecordMacro();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RecordAttribute#getRecordMacro <em>Record Macro</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Record Macro</em>' reference.
   * @see #getRecordMacro()
   * @generated
   */
  void setRecordMacro(DefineAttribute value);

} // RecordAttribute