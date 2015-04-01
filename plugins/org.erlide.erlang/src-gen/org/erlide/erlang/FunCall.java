/**
 */
package org.erlide.erlang;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Fun Call</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.FunCall#getTarget <em>Target</em>}</li>
 * <li>{@link org.erlide.erlang.FunCall#getArgs <em>Args</em>}</li>
 * <li>{@link org.erlide.erlang.FunCall#getArgs2 <em>Args2</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getFunCall()
 * @model
 * @generated
 */
public interface FunCall extends Expression {
    /**
     * Returns the value of the '<em><b>Target</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Target</em>' containment reference.
     * @see #setTarget(Expression)
     * @see org.erlide.erlang.ErlangPackage#getFunCall_Target()
     * @model containment="true"
     * @generated
     */
    Expression getTarget();

    /**
     * Sets the value of the '{@link org.erlide.erlang.FunCall#getTarget
     * <em>Target</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Target</em>' containment reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget(Expression value);

    /**
     * Returns the value of the '<em><b>Args</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Args</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Args</em>' containment reference.
     * @see #setArgs(Expressions)
     * @see org.erlide.erlang.ErlangPackage#getFunCall_Args()
     * @model containment="true"
     * @generated
     */
    Expressions getArgs();

    /**
     * Sets the value of the '{@link org.erlide.erlang.FunCall#getArgs
     * <em>Args</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Args</em>' containment reference.
     * @see #getArgs()
     * @generated
     */
    void setArgs(Expressions value);

    /**
     * Returns the value of the '<em><b>Args2</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Args2</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Args2</em>' containment reference.
     * @see #setArgs2(Expressions)
     * @see org.erlide.erlang.ErlangPackage#getFunCall_Args2()
     * @model containment="true"
     * @generated
     */
    Expressions getArgs2();

    /**
     * Sets the value of the '{@link org.erlide.erlang.FunCall#getArgs2
     * <em>Args2</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Args2</em>' containment reference.
     * @see #getArgs2()
     * @generated
     */
    void setArgs2(Expressions value);

} // FunCall
