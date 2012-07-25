/**
 * <copyright>
 * </copyright>
 *
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Erl Binary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.ErlBinary#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getErlBinary()
 * @model
 * @generated
 */
public interface ErlBinary extends Expression
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.BinaryItem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getErlBinary_Elements()
   * @model containment="true"
   * @generated
   */
  EList<BinaryItem> getElements();

} // ErlBinary
