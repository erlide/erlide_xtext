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

import org.erlide.erlang.CrClause;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.TryClause;
import org.erlide.erlang.TryExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Try Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.TryExprImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.TryExprImpl#getOf_clauses <em>Of clauses</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.TryExprImpl#getCatch <em>Catch</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.TryExprImpl#getAfter_body <em>After body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TryExprImpl extends ExpressionImpl implements TryExpr
{
  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected EList<Expression> body;

  /**
   * The cached value of the '{@link #getOf_clauses() <em>Of clauses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOf_clauses()
   * @generated
   * @ordered
   */
  protected EList<CrClause> of_clauses;

  /**
   * The cached value of the '{@link #getCatch() <em>Catch</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCatch()
   * @generated
   * @ordered
   */
  protected EList<TryClause> catch_;

  /**
   * The cached value of the '{@link #getAfter_body() <em>After body</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAfter_body()
   * @generated
   * @ordered
   */
  protected EList<Expression> after_body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TryExprImpl()
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
    return ErlangPackage.Literals.TRY_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getBody()
  {
    if (body == null)
    {
      body = new EObjectContainmentEList<Expression>(Expression.class, this, ErlangPackage.TRY_EXPR__BODY);
    }
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CrClause> getOf_clauses()
  {
    if (of_clauses == null)
    {
      of_clauses = new EObjectContainmentEList<CrClause>(CrClause.class, this, ErlangPackage.TRY_EXPR__OF_CLAUSES);
    }
    return of_clauses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TryClause> getCatch()
  {
    if (catch_ == null)
    {
      catch_ = new EObjectContainmentEList<TryClause>(TryClause.class, this, ErlangPackage.TRY_EXPR__CATCH);
    }
    return catch_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getAfter_body()
  {
    if (after_body == null)
    {
      after_body = new EObjectContainmentEList<Expression>(Expression.class, this, ErlangPackage.TRY_EXPR__AFTER_BODY);
    }
    return after_body;
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
      case ErlangPackage.TRY_EXPR__BODY:
        return ((InternalEList<?>)getBody()).basicRemove(otherEnd, msgs);
      case ErlangPackage.TRY_EXPR__OF_CLAUSES:
        return ((InternalEList<?>)getOf_clauses()).basicRemove(otherEnd, msgs);
      case ErlangPackage.TRY_EXPR__CATCH:
        return ((InternalEList<?>)getCatch()).basicRemove(otherEnd, msgs);
      case ErlangPackage.TRY_EXPR__AFTER_BODY:
        return ((InternalEList<?>)getAfter_body()).basicRemove(otherEnd, msgs);
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
      case ErlangPackage.TRY_EXPR__BODY:
        return getBody();
      case ErlangPackage.TRY_EXPR__OF_CLAUSES:
        return getOf_clauses();
      case ErlangPackage.TRY_EXPR__CATCH:
        return getCatch();
      case ErlangPackage.TRY_EXPR__AFTER_BODY:
        return getAfter_body();
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
      case ErlangPackage.TRY_EXPR__BODY:
        getBody().clear();
        getBody().addAll((Collection<? extends Expression>)newValue);
        return;
      case ErlangPackage.TRY_EXPR__OF_CLAUSES:
        getOf_clauses().clear();
        getOf_clauses().addAll((Collection<? extends CrClause>)newValue);
        return;
      case ErlangPackage.TRY_EXPR__CATCH:
        getCatch().clear();
        getCatch().addAll((Collection<? extends TryClause>)newValue);
        return;
      case ErlangPackage.TRY_EXPR__AFTER_BODY:
        getAfter_body().clear();
        getAfter_body().addAll((Collection<? extends Expression>)newValue);
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
      case ErlangPackage.TRY_EXPR__BODY:
        getBody().clear();
        return;
      case ErlangPackage.TRY_EXPR__OF_CLAUSES:
        getOf_clauses().clear();
        return;
      case ErlangPackage.TRY_EXPR__CATCH:
        getCatch().clear();
        return;
      case ErlangPackage.TRY_EXPR__AFTER_BODY:
        getAfter_body().clear();
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
      case ErlangPackage.TRY_EXPR__BODY:
        return body != null && !body.isEmpty();
      case ErlangPackage.TRY_EXPR__OF_CLAUSES:
        return of_clauses != null && !of_clauses.isEmpty();
      case ErlangPackage.TRY_EXPR__CATCH:
        return catch_ != null && !catch_.isEmpty();
      case ErlangPackage.TRY_EXPR__AFTER_BODY:
        return after_body != null && !after_body.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TryExprImpl
