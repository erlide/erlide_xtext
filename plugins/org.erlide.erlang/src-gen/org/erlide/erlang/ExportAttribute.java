/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Export Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.erlide.erlang.ExportAttribute#getTag <em>Tag</em>}</li>
 *   <li>{@link org.erlide.erlang.ExportAttribute#getFuns <em>Funs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.erlide.erlang.ErlangPackage#getExportAttribute()
 * @model
 * @generated
 */
public interface ExportAttribute extends Attribute
{
  /**
   * Returns the value of the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tag</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tag</em>' attribute.
   * @see #setTag(String)
   * @see org.erlide.erlang.ErlangPackage#getExportAttribute_Tag()
   * @model
   * @generated
   */
  String getTag();

  /**
   * Sets the value of the '{@link org.erlide.erlang.ExportAttribute#getTag <em>Tag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tag</em>' attribute.
   * @see #getTag()
   * @generated
   */
  void setTag(String value);

  /**
   * Returns the value of the '<em><b>Funs</b></em>' containment reference list.
   * The list contents are of type {@link org.erlide.erlang.FunRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Funs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Funs</em>' containment reference list.
   * @see org.erlide.erlang.ErlangPackage#getExportAttribute_Funs()
   * @model containment="true"
   * @generated
   */
  EList<FunRef> getFuns();

} // ExportAttribute
