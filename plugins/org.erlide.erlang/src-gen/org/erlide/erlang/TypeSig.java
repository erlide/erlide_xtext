/**
 * <copyright>
 * </copyright>
 *
 */
package org.erlide.erlang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Sig</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.TypeSig#getDecl <em>Decl</em>}</li>
 *   <li>{@link org.erlide.erlang.TypeSig#getGuards <em>Guards</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getTypeSig()
 * @model
 * @generated
 */
public interface TypeSig extends EObject
{
  /**
   * Returns the value of the '<em><b>Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decl</em>' containment reference.
   * @see #setDecl(FunType)
   * @see org.erlide.erlang.ErlangPackage#getTypeSig_Decl()
   * @model containment="true"
   * @generated
   */
  FunType getDecl();

  /**
   * Sets the value of the '{@link org.erlide.erlang.TypeSig#getDecl <em>Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decl</em>' containment reference.
   * @see #getDecl()
   * @generated
   */
  void setDecl(FunType value);

  /**
   * Returns the value of the '<em><b>Guards</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guards</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guards</em>' containment reference.
   * @see #setGuards(TypeGuards)
   * @see org.erlide.erlang.ErlangPackage#getTypeSig_Guards()
   * @model containment="true"
   * @generated
   */
  TypeGuards getGuards();

  /**
   * Sets the value of the '{@link org.erlide.erlang.TypeSig#getGuards <em>Guards</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guards</em>' containment reference.
   * @see #getGuards()
   * @generated
   */
  void setGuards(TypeGuards value);

} // TypeSig
