/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spec Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.SpecAttribute#getRef <em>Ref</em>}</li>
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
   * Returns the value of the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference.
   * @see #setRef(SpecFun)
   * @see org.erlide.erlang.ErlangPackage#getSpecAttribute_Ref()
   * @model containment="true"
   * @generated
   */
  SpecFun getRef();

  /**
   * Sets the value of the '{@link org.erlide.erlang.SpecAttribute#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(SpecFun value);

  /**
   * Returns the value of the '<em><b>Signatures</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.TypeSig}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signatures</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signatures</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getSpecAttribute_Signatures()
   * @model containment="true"
   * @generated
   */
  EList<TypeSig> getSignatures();

} // SpecAttribute
