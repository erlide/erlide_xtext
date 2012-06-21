/**
 */
package org.erlide.erlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.RecordField#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getRecordField()
 * @model
 * @generated
 */
public interface RecordField extends Expression
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see #setValue(RecordFieldDef)
   * @see org.erlide.erlang.ErlangPackage#getRecordField_Value()
   * @model
   * @generated
   */
  RecordFieldDef getValue();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RecordField#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(RecordFieldDef value);

} // RecordField
