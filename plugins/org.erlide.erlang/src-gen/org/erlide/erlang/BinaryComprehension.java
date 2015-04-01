/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Binary Comprehension</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.BinaryComprehension#getRoot <em>Root</em>}</li>
 * <li>{@link org.erlide.erlang.BinaryComprehension#getGenerators <em>Generators
 * </em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getBinaryComprehension()
 * @model
 * @generated
 */
public interface BinaryComprehension extends ErlBinary {
    /**
     * Returns the value of the '<em><b>Root</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Root</em>' containment reference.
     * @see #setRoot(ErlBinary)
     * @see org.erlide.erlang.ErlangPackage#getBinaryComprehension_Root()
     * @model containment="true"
     * @generated
     */
    ErlBinary getRoot();

    /**
     * Sets the value of the '
     * {@link org.erlide.erlang.BinaryComprehension#getRoot <em>Root</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Root</em>' containment reference.
     * @see #getRoot()
     * @generated
     */
    void setRoot(ErlBinary value);

    /**
     * Returns the value of the '<em><b>Generators</b></em>' containment
     * reference list. The list contents are of type
     * {@link org.erlide.erlang.LCExpr}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Generators</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Generators</em>' containment reference
     *         list.
     * @see org.erlide.erlang.ErlangPackage#getBinaryComprehension_Generators()
     * @model containment="true"
     * @generated
     */
    EList<LCExpr> getGenerators();

} // BinaryComprehension
