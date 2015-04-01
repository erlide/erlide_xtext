/**
 */
package org.erlide.erlang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>If Clause</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.IfClause#getGuard <em>Guard</em>}</li>
 * <li>{@link org.erlide.erlang.IfClause#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getIfClause()
 * @model
 * @generated
 */
public interface IfClause extends EObject {
    /**
     * Returns the value of the '<em><b>Guard</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Guard</em>' containment reference.
     * @see #setGuard(Guard)
     * @see org.erlide.erlang.ErlangPackage#getIfClause_Guard()
     * @model containment="true"
     * @generated
     */
    Guard getGuard();

    /**
     * Sets the value of the '{@link org.erlide.erlang.IfClause#getGuard
     * <em>Guard</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Guard</em>' containment reference.
     * @see #getGuard()
     * @generated
     */
    void setGuard(Guard value);

    /**
     * Returns the value of the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Body</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Body</em>' containment reference.
     * @see #setBody(Expressions)
     * @see org.erlide.erlang.ErlangPackage#getIfClause_Body()
     * @model containment="true"
     * @generated
     */
    Expressions getBody();

    /**
     * Sets the value of the '{@link org.erlide.erlang.IfClause#getBody
     * <em>Body</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Body</em>' containment reference.
     * @see #getBody()
     * @generated
     */
    void setBody(Expressions value);

} // IfClause
