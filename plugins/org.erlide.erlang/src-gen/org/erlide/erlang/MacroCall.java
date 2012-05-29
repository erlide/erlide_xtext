/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Macro Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.MacroCall#getMacroName <em>Macro Name</em>}</li>
 *   <li>{@link org.erlide.erlang.MacroCall#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getMacroCall()
 * @model
 * @generated
 */
public interface MacroCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Macro Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Macro Name</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Macro Name</em>' reference.
   * @see #setMacroName(DefineAttribute)
   * @see org.erlide.erlang.ErlangPackage#getMacroCall_MacroName()
   * @model
   * @generated
   */
  DefineAttribute getMacroName();

  /**
   * Sets the value of the '{@link org.erlide.erlang.MacroCall#getMacroName <em>Macro Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Macro Name</em>' reference.
   * @see #getMacroName()
   * @generated
   */
  void setMacroName(DefineAttribute value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getMacroCall_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArgs();

} // MacroCall
