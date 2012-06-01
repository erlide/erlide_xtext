/**
 */
package org.erlide.erlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifdef Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.IfdefAttribute#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getIfdefAttribute()
 * @model
 * @generated
 */
public interface IfdefAttribute extends ConditionalAttribute
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(DefineAttribute)
   * @see org.erlide.erlang.ErlangPackage#getIfdefAttribute_Ref()
   * @model
   * @generated
   */
  DefineAttribute getRef();

  /**
   * Sets the value of the '{@link org.erlide.erlang.IfdefAttribute#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(DefineAttribute value);

} // IfdefAttribute
