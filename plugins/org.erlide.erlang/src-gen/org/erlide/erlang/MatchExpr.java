/**
 */
package org.erlide.erlang;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Match Expr</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.MatchExpr#getOpLeft <em>Op Left</em>}</li>
 * <li>{@link org.erlide.erlang.MatchExpr#getOp <em>Op</em>}</li>
 * <li>{@link org.erlide.erlang.MatchExpr#getOpRight <em>Op Right</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getMatchExpr()
 * @model
 * @generated
 */
public interface MatchExpr extends Expression {
    /**
     * Returns the value of the '<em><b>Op Left</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Op Left</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Op Left</em>' containment reference.
     * @see #setOpLeft(Expression)
     * @see org.erlide.erlang.ErlangPackage#getMatchExpr_OpLeft()
     * @model containment="true"
     * @generated
     */
    Expression getOpLeft();

    /**
     * Sets the value of the '{@link org.erlide.erlang.MatchExpr#getOpLeft
     * <em>Op Left</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Op Left</em>' containment reference.
     * @see #getOpLeft()
     * @generated
     */
    void setOpLeft(Expression value);

    /**
     * Returns the value of the '<em><b>Op</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Op</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Op</em>' attribute.
     * @see #setOp(String)
     * @see org.erlide.erlang.ErlangPackage#getMatchExpr_Op()
     * @model
     * @generated
     */
    String getOp();

    /**
     * Sets the value of the '{@link org.erlide.erlang.MatchExpr#getOp
     * <em>Op</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Op</em>' attribute.
     * @see #getOp()
     * @generated
     */
    void setOp(String value);

    /**
     * Returns the value of the '<em><b>Op Right</b></em>' containment
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Op Right</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Op Right</em>' containment reference.
     * @see #setOpRight(Expression)
     * @see org.erlide.erlang.ErlangPackage#getMatchExpr_OpRight()
     * @model containment="true"
     * @generated
     */
    Expression getOpRight();

    /**
     * Sets the value of the '{@link org.erlide.erlang.MatchExpr#getOpRight
     * <em>Op Right</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Op Right</em>' containment
     *            reference.
     * @see #getOpRight()
     * @generated
     */
    void setOpRight(Expression value);

} // MatchExpr
