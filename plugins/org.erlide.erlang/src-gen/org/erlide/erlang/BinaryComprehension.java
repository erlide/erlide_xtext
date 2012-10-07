/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Comprehension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.BinaryComprehension#getGenerators <em>Generators</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getBinaryComprehension()
 * @model
 * @generated
 */
public interface BinaryComprehension extends Expression
{
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
   * @see org.erlide.erlang.ErlangPackage#getBinaryComprehension_Generators()
   * @model containment="true"
   * @generated
   */
  EList<LCExpr> getGenerators();

} // BinaryComprehension
