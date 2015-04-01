/**
 */
package org.erlide.erlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Case Expr</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.CaseExpr#getClauses <em>Clauses</em>}</li>
 * </ul>
 *
 * @see org.erlide.erlang.ErlangPackage#getCaseExpr()
 * @model
 * @generated
 */
public interface CaseExpr extends Expression {
    /**
     * Returns the value of the '<em><b>Clauses</b></em>' containment reference
     * list. The list contents are of type {@link org.erlide.erlang.CrClause}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Clauses</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Clauses</em>' containment reference list.
     * @see org.erlide.erlang.ErlangPackage#getCaseExpr_Clauses()
     * @model containment="true"
     * @generated
     */
    EList<CrClause> getClauses();

} // CaseExpr
