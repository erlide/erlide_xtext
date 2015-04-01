/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Expression</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.Expression#isLine <em>Line</em>}</li>
 * <li>{@link org.erlide.erlang.Expression#getExpr <em>Expr</em>}</li>
 * <li>{@link org.erlide.erlang.Expression#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject {
    /**
     * Returns the value of the '<em><b>Line</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Line</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Line</em>' attribute.
     * @see #setLine(boolean)
     * @see org.erlide.erlang.ErlangPackage#getExpression_Line()
     * @model
     * @generated
     */
    boolean isLine();

    /**
     * Sets the value of the '{@link org.erlide.erlang.Expression#isLine
     * <em>Line</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Line</em>' attribute.
     * @see #isLine()
     * @generated
     */
    void setLine(boolean value);

    /**
     * Returns the value of the '<em><b>Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Expr</em>' containment reference.
     * @see #setExpr(Expression)
     * @see org.erlide.erlang.ErlangPackage#getExpression_Expr()
     * @model containment="true"
     * @generated
     */
    Expression getExpr();

    /**
     * Sets the value of the '{@link org.erlide.erlang.Expression#getExpr
     * <em>Expr</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Expr</em>' containment reference.
     * @see #getExpr()
     * @generated
     */
    void setExpr(Expression value);

    /**
     * Returns the value of the '<em><b>Parts</b></em>' containment reference
     * list. The list contents are of type
     * {@link org.erlide.erlang.StringLiteralPart}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parts</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Parts</em>' containment reference list.
     * @see org.erlide.erlang.ErlangPackage#getExpression_Parts()
     * @model containment="true"
     * @generated
     */
    EList<StringLiteralPart> getParts();

} // Expression
