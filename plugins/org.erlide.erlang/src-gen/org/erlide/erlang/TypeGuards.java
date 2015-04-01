/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Type Guards</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.TypeGuards#getItems <em>Items</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getTypeGuards()
 * @model
 * @generated
 */
public interface TypeGuards extends EObject {
    /**
     * Returns the value of the '<em><b>Items</b></em>' containment reference
     * list. The list contents are of type {@link org.erlide.erlang.TypeGuard}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Items</em>' containment reference list.
     * @see org.erlide.erlang.ErlangPackage#getTypeGuards_Items()
     * @model containment="true"
     * @generated
     */
    EList<TypeGuard> getItems();

} // TypeGuards
