/**
 * <copyright>
 * </copyright>
 *
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
   * Returns the value of the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference.
   * @see #setRef(Expression)
   * @see org.erlide.erlang.ErlangPackage#getIfdefAttribute_Ref()
   * @model containment="true"
   * @generated
   */
  Expression getRef();

  /**
   * Sets the value of the '{@link org.erlide.erlang.IfdefAttribute#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Expression value);

} // IfdefAttribute
