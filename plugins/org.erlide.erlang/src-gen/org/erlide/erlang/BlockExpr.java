/**
 */
package org.erlide.erlang;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Block Expr</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.BlockExpr#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getBlockExpr()
 * @model
 * @generated
 */
public interface BlockExpr extends Expression {
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
     * @see org.erlide.erlang.ErlangPackage#getBlockExpr_Body()
     * @model containment="true"
     * @generated
     */
    Expressions getBody();

    /**
     * Sets the value of the '{@link org.erlide.erlang.BlockExpr#getBody
     * <em>Body</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Body</em>' containment reference.
     * @see #getBody()
     * @generated
     */
    void setBody(Expressions value);

} // BlockExpr
