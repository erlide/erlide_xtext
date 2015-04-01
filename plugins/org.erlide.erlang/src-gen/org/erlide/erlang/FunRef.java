/**
 */
package org.erlide.erlang;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Fun Ref</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.FunRef#getModule <em>Module</em>}</li>
 * <li>{@link org.erlide.erlang.FunRef#getFunction <em>Function</em>}</li>
 * <li>{@link org.erlide.erlang.FunRef#getArity <em>Arity</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getFunRef()
 * @model
 * @generated
 */
public interface FunRef extends FunExpr {
    /**
     * Returns the value of the '<em><b>Module</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Module</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Module</em>' containment reference.
     * @see #setModule(Expression)
     * @see org.erlide.erlang.ErlangPackage#getFunRef_Module()
     * @model containment="true"
     * @generated
     */
    Expression getModule();

    /**
     * Sets the value of the '{@link org.erlide.erlang.FunRef#getModule
     * <em>Module</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Module</em>' containment reference.
     * @see #getModule()
     * @generated
     */
    void setModule(Expression value);

    /**
     * Returns the value of the '<em><b>Function</b></em>' containment
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Function</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Function</em>' containment reference.
     * @see #setFunction(Expression)
     * @see org.erlide.erlang.ErlangPackage#getFunRef_Function()
     * @model containment="true"
     * @generated
     */
    Expression getFunction();

    /**
     * Sets the value of the '{@link org.erlide.erlang.FunRef#getFunction
     * <em>Function</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Function</em>' containment
     *            reference.
     * @see #getFunction()
     * @generated
     */
    void setFunction(Expression value);

    /**
     * Returns the value of the '<em><b>Arity</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Arity</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Arity</em>' containment reference.
     * @see #setArity(Expression)
     * @see org.erlide.erlang.ErlangPackage#getFunRef_Arity()
     * @model containment="true"
     * @generated
     */
    Expression getArity();

    /**
     * Sets the value of the '{@link org.erlide.erlang.FunRef#getArity
     * <em>Arity</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Arity</em>' containment reference.
     * @see #getArity()
     * @generated
     */
    void setArity(Expression value);

} // FunRef
