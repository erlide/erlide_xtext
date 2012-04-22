/**
 */
package org.erlide.erlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spec Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.SpecAttribute#getType <em>Type</em>}</li>
 *   <li>{@link org.erlide.erlang.SpecAttribute#getSignatures <em>Signatures</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getSpecAttribute()
 * @model
 * @generated
 */
public interface SpecAttribute extends AbstractTypeAttribute
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(SpecFun)
   * @see org.erlide.erlang.ErlangPackage#getSpecAttribute_Type()
   * @model containment="true"
   * @generated
   */
  SpecFun getType();

  /**
   * Sets the value of the '{@link org.erlide.erlang.SpecAttribute#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(SpecFun value);

  /**
   * Returns the value of the '<em><b>Signatures</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signatures</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signatures</em>' containment reference.
   * @see #setSignatures(TypeSigs)
   * @see org.erlide.erlang.ErlangPackage#getSpecAttribute_Signatures()
   * @model containment="true"
   * @generated
   */
  TypeSigs getSignatures();

  /**
   * Sets the value of the '{@link org.erlide.erlang.SpecAttribute#getSignatures <em>Signatures</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signatures</em>' containment reference.
   * @see #getSignatures()
   * @generated
   */
  void setSignatures(TypeSigs value);

} // SpecAttribute
