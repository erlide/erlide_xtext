/**
 * <copyright>
 * </copyright>
 *
 */
package org.erlide.erlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Undef Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.UndefAttribute#getTag <em>Tag</em>}</li>
 *   <li>{@link org.erlide.erlang.UndefAttribute#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getUndefAttribute()
 * @model
 * @generated
 */
public interface UndefAttribute extends Attribute, AbstractDefineAttribute
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
   * @see org.erlide.erlang.ErlangPackage#getUndefAttribute_Tag()
   * @model
   * @generated
   */
  String getTag();

  /**
   * Sets the value of the '{@link org.erlide.erlang.UndefAttribute#getTag <em>Tag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tag</em>' attribute.
   * @see #getTag()
   * @generated
   */
  void setTag(String value);

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
   * @see org.erlide.erlang.ErlangPackage#getUndefAttribute_Ref()
   * @model containment="true"
   * @generated
   */
  Expression getRef();

  /**
   * Sets the value of the '{@link org.erlide.erlang.UndefAttribute#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Expression value);

} // UndefAttribute
