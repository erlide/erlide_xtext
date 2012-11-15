/**
 * <copyright>
 * </copyright>
 *
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Comprehension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.ListComprehension#getRoot <em>Root</em>}</li>
 *   <li>{@link org.erlide.erlang.ListComprehension#getGenerators <em>Generators</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getListComprehension()
 * @model
 * @generated
 */
public interface ListComprehension extends ErlList
{
  /**
   * Returns the value of the '<em><b>Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root</em>' containment reference.
   * @see #setRoot(ErlList)
   * @see org.erlide.erlang.ErlangPackage#getListComprehension_Root()
   * @model containment="true"
   * @generated
   */
  ErlList getRoot();

  /**
   * Sets the value of the '{@link org.erlide.erlang.ListComprehension#getRoot <em>Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root</em>' containment reference.
   * @see #getRoot()
   * @generated
   */
  void setRoot(ErlList value);

  /**
   * Returns the value of the '<em><b>Generators</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.LCExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generators</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generators</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getListComprehension_Generators()
   * @model containment="true"
   * @generated
   */
  EList<LCExpr> getGenerators();

} // ListComprehension
