/**
 */
package org.erlide.erlang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spec Fun</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.SpecFun#getModule <em>Module</em>}</li>
 *   <li>{@link org.erlide.erlang.SpecFun#getFunction <em>Function</em>}</li>
 *   <li>{@link org.erlide.erlang.SpecFun#getArity <em>Arity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getSpecFun()
 * @model
 * @generated
 */
public interface SpecFun extends EObject
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
   * @see #setModule(AtomVarMacro)
   * @see org.erlide.erlang.ErlangPackage#getSpecFun_Module()
   * @model containment="true"
   * @generated
   */
  AtomVarMacro getModule();

  /**
   * Sets the value of the '{@link org.erlide.erlang.SpecFun#getModule <em>Module</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Module</em>' containment reference.
   * @see #getModule()
   * @generated
   */
  void setModule(AtomVarMacro value);

  /**
   * Returns the value of the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' containment reference.
   * @see #setFunction(AtomVarMacro)
   * @see org.erlide.erlang.ErlangPackage#getSpecFun_Function()
   * @model containment="true"
   * @generated
   */
  AtomVarMacro getFunction();

  /**
   * Sets the value of the '{@link org.erlide.erlang.SpecFun#getFunction <em>Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' containment reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(AtomVarMacro value);

  /**
   * Returns the value of the '<em><b>Arity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arity</em>' containment reference.
   * @see #setArity(IntVarMacro)
   * @see org.erlide.erlang.ErlangPackage#getSpecFun_Arity()
   * @model containment="true"
   * @generated
   */
  IntVarMacro getArity();

  /**
   * Sets the value of the '{@link org.erlide.erlang.SpecFun#getArity <em>Arity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arity</em>' containment reference.
   * @see #getArity()
   * @generated
   */
  void setArity(IntVarMacro value);

} // SpecFun
