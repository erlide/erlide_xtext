/**
 */
package org.erlide.erlang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.FunExpr;
import org.erlide.erlang.FunctionClause;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fun Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.FunExprImpl#getClauses <em>Clauses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunExprImpl extends ExpressionImpl implements FunExpr
{
  /**
   * The cached value of the '{@link #getClauses() <em>Clauses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClauses()
   * @generated
   * @ordered
   */
  protected EList<FunctionClause> clauses;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunExprImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ErlangPackage.Literals.FUN_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FunctionClause> getClauses()
  {
    if (clauses == null)
    {
      clauses = new EObjectContainmentEList<FunctionClause>(FunctionClause.class, this, ErlangPackage.FUN_EXPR__CLAUSES);
    }
    return clauses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ErlangPackage.FUN_EXPR__CLAUSES:
        return ((InternalEList<?>)getClauses()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ErlangPackage.FUN_EXPR__CLAUSES:
        return getClauses();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ErlangPackage.FUN_EXPR__CLAUSES:
        getClauses().clear();
        getClauses().addAll((Collection<? extends FunctionClause>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ErlangPackage.FUN_EXPR__CLAUSES:
        getClauses().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ErlangPackage.FUN_EXPR__CLAUSES:
        return clauses != null && !clauses.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FunExprImpl
