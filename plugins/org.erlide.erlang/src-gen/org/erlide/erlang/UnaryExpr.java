/**
 */
package org.erlide.erlang;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Unary Expr</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.UnaryExpr#getOp <em>Op</em>}</li>
 * <li>{@link org.erlide.erlang.UnaryExpr#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getUnaryExpr()
 * @model
 * @generated
 */
public interface UnaryExpr extends Expression {
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
     * @see org.erlide.erlang.ErlangPackage#getUnaryExpr_Op()
     * @model
     * @generated
     */
    String getOp();

    /**
     * Sets the value of the '{@link org.erlide.erlang.UnaryExpr#getOp
     * <em>Op</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Op</em>' attribute.
     * @see #getOp()
     * @generated
     */
    void setOp(String value);

    /**
     * Returns the value of the '<em><b>Operand</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operand</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Operand</em>' containment reference.
     * @see #setOperand(Expression)
     * @see org.erlide.erlang.ErlangPackage#getUnaryExpr_Operand()
     * @model containment="true"
     * @generated
     */
    Expression getOperand();

    /**
     * Sets the value of the '{@link org.erlide.erlang.UnaryExpr#getOperand
     * <em>Operand</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Operand</em>' containment reference.
     * @see #getOperand()
     * @generated
     */
    void setOperand(Expression value);

} // UnaryExpr
