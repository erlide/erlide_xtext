/**
 */
package org.erlide.erlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Fun</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.RefFun#getModule <em>Module</em>}</li>
 *   <li>{@link org.erlide.erlang.RefFun#getFunction <em>Function</em>}</li>
 *   <li>{@link org.erlide.erlang.RefFun#getArity <em>Arity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getRefFun()
 * @model
 * @generated
 */
public interface RefFun extends FunExpr
{
  /**
   * Returns the value of the '<em><b>Module</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module</em>' containment reference.
   * @see #setModule(Expression)
   * @see org.erlide.erlang.ErlangPackage#getRefFun_Module()
   * @model containment="true"
   * @generated
   */
  Expression getModule();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RefFun#getModule <em>Module</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Module</em>' containment reference.
   * @see #getModule()
   * @generated
   */
  void setModule(Expression value);

  /**
   * Returns the value of the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' containment reference.
   * @see #setFunction(Expression)
   * @see org.erlide.erlang.ErlangPackage#getRefFun_Function()
   * @model containment="true"
   * @generated
   */
  Expression getFunction();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RefFun#getFunction <em>Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' containment reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(Expression value);

  /**
   * Returns the value of the '<em><b>Arity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arity</em>' attribute.
   * @see #setArity(String)
   * @see org.erlide.erlang.ErlangPackage#getRefFun_Arity()
   * @model
   * @generated
   */
  String getArity();

  /**
   * Sets the value of the '{@link org.erlide.erlang.RefFun#getArity <em>Arity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arity</em>' attribute.
   * @see #getArity()
   * @generated
   */
  void setArity(String value);

} // RefFun
