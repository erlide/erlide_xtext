/**
 * <copyright>
 * </copyright>
 *
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.CustomAttribute#getTag <em>Tag</em>}</li>
 *   <li>{@link org.erlide.erlang.CustomAttribute#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getCustomAttribute()
 * @model
 * @generated
 */
public interface CustomAttribute extends Attribute
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
   * @see org.erlide.erlang.ErlangPackage#getCustomAttribute_Tag()
   * @model
   * @generated
   */
  String getTag();

  /**
   * Sets the value of the '{@link org.erlide.erlang.CustomAttribute#getTag <em>Tag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tag</em>' attribute.
   * @see #getTag()
   * @generated
   */
  void setTag(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getCustomAttribute_Value()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getValue();

} // CustomAttribute
