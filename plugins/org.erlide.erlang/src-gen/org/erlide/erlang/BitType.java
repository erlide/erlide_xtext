/**
 * <copyright>
 * </copyright>
 *
 */
package org.erlide.erlang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bit Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.BitType#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.erlide.erlang.BitType#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getBitType()
 * @model
 * @generated
 */
public interface BitType extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' attribute.
   * @see #setTypeName(String)
   * @see org.erlide.erlang.ErlangPackage#getBitType_TypeName()
   * @model
   * @generated
   */
  String getTypeName();

  /**
   * Sets the value of the '{@link org.erlide.erlang.BitType#getTypeName <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' attribute.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(String value);

  /**
   * Returns the value of the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' attribute.
   * @see #setSize(String)
   * @see org.erlide.erlang.ErlangPackage#getBitType_Size()
   * @model
   * @generated
   */
  String getSize();

  /**
   * Sets the value of the '{@link org.erlide.erlang.BitType#getSize <em>Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' attribute.
   * @see #getSize()
   * @generated
   */
  void setSize(String value);

} // BitType
