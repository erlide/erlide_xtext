/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.RecordType#getRec <em>Rec</em>}</li>
 *   <li>{@link org.erlide.erlang.RecordType#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getRecordType()
 * @model
 * @generated
 */
public interface RecordType extends Type
{
  /**
   * Returns the value of the '<em><b>Rec</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rec</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rec</em>' attribute.
   * @see #setRec(String)
   * @see org.erlide.erlang.ErlangPackage#getRecordType_Rec()
   * @model
   * @generated
   */
  String getRec();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RecordType#getRec <em>Rec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rec</em>' attribute.
   * @see #getRec()
   * @generated
   */
  void setRec(String value);

  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.FieldType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getRecordType_Fields()
   * @model containment="true"
   * @generated
   */
  EList<FieldType> getFields();

} // RecordType
