/**
 * <copyright>
 * </copyright>
 *
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
public interface RecordAttribute extends AtomRefTarget, Attribute
{
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
   * Returns the value of the '<em><b>Record Macro</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record Macro</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Record Macro</em>' containment reference.
   * @see #setRecordMacro(MacroCall)
   * @see org.erlide.erlang.ErlangPackage#getRecordAttribute_RecordMacro()
   * @model containment="true"
   * @generated
   */
  MacroCall getRecordMacro();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RecordAttribute#getRecordMacro <em>Record Macro</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Record Macro</em>' containment reference.
   * @see #getRecordMacro()
   * @generated
   */
  void setRecordMacro(MacroCall value);

} // RecordAttribute
