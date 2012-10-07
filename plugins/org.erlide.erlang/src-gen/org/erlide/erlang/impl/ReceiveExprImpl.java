/**
 */
package org.erlide.erlang.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.erlide.erlang.CrClause;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.Expressions;
import org.erlide.erlang.ReceiveExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Receive Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.ReceiveExprImpl#getClauses <em>Clauses</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.ReceiveExprImpl#getAfter_expr <em>After expr</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.ReceiveExprImpl#getAfter_body <em>After body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReceiveExprImpl extends ExpressionImpl implements ReceiveExpr
{
  /**
   * The cached value of the '{@link #getClauses() <em>Clauses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClauses()
   * @generated
   * @ordered
   */
  protected EList<CrClause> clauses;

  /**
   * The cached value of the '{@link #getAfter_expr() <em>After expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAfter_expr()
   * @generated
   * @ordered
   */
  protected Expression after_expr;

  /**
   * The cached value of the '{@link #getAfter_body() <em>After body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAfter_body()
   * @generated
   * @ordered
   */
  protected Expressions after_body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReceiveExprImpl()
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
    return ErlangPackage.Literals.RECEIVE_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CrClause> getClauses()
  {
    if (clauses == null)
    {
      clauses = new EObjectContainmentEList<CrClause>(CrClause.class, this, ErlangPackage.RECEIVE_EXPR__CLAUSES);
    }
    return clauses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getAfter_expr()
  {
    return after_expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAfter_expr(Expression newAfter_expr, NotificationChain msgs)
  {
    Expression oldAfter_expr = after_expr;
    after_expr = newAfter_expr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.RECEIVE_EXPR__AFTER_EXPR, oldAfter_expr, newAfter_expr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAfter_expr(Expression newAfter_expr)
  {
    if (newAfter_expr != after_expr)
    {
      NotificationChain msgs = null;
      if (after_expr != null)
        msgs = ((InternalEObject)after_expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.RECEIVE_EXPR__AFTER_EXPR, null, msgs);
      if (newAfter_expr != null)
        msgs = ((InternalEObject)newAfter_expr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.RECEIVE_EXPR__AFTER_EXPR, null, msgs);
      msgs = basicSetAfter_expr(newAfter_expr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.RECEIVE_EXPR__AFTER_EXPR, newAfter_expr, newAfter_expr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expressions getAfter_body()
  {
    return after_body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAfter_body(Expressions newAfter_body, NotificationChain msgs)
  {
    Expressions oldAfter_body = after_body;
    after_body = newAfter_body;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.RECEIVE_EXPR__AFTER_BODY, oldAfter_body, newAfter_body);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAfter_body(Expressions newAfter_body)
  {
    if (newAfter_body != after_body)
    {
      NotificationChain msgs = null;
      if (after_body != null)
        msgs = ((InternalEObject)after_body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.RECEIVE_EXPR__AFTER_BODY, null, msgs);
      if (newAfter_body != null)
        msgs = ((InternalEObject)newAfter_body).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.RECEIVE_EXPR__AFTER_BODY, null, msgs);
      msgs = basicSetAfter_body(newAfter_body, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.RECEIVE_EXPR__AFTER_BODY, newAfter_body, newAfter_body));
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
      case ErlangPackage.RECEIVE_EXPR__CLAUSES:
        return ((InternalEList<?>)getClauses()).basicRemove(otherEnd, msgs);
      case ErlangPackage.RECEIVE_EXPR__AFTER_EXPR:
        return basicSetAfter_expr(null, msgs);
      case ErlangPackage.RECEIVE_EXPR__AFTER_BODY:
        return basicSetAfter_body(null, msgs);
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
      case ErlangPackage.RECEIVE_EXPR__CLAUSES:
        return getClauses();
      case ErlangPackage.RECEIVE_EXPR__AFTER_EXPR:
        return getAfter_expr();
      case ErlangPackage.RECEIVE_EXPR__AFTER_BODY:
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
      case ErlangPackage.RECEIVE_EXPR__CLAUSES:
        getClauses().clear();
        getClauses().addAll((Collection<? extends CrClause>)newValue);
        return;
      case ErlangPackage.RECEIVE_EXPR__AFTER_EXPR:
        setAfter_expr((Expression)newValue);
        return;
      case ErlangPackage.RECEIVE_EXPR__AFTER_BODY:
        setAfter_body((Expressions)newValue);
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
      case ErlangPackage.RECEIVE_EXPR__CLAUSES:
        getClauses().clear();
        return;
      case ErlangPackage.RECEIVE_EXPR__AFTER_EXPR:
        setAfter_expr((Expression)null);
        return;
      case ErlangPackage.RECEIVE_EXPR__AFTER_BODY:
        setAfter_body((Expressions)null);
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
      case ErlangPackage.RECEIVE_EXPR__CLAUSES:
        return clauses != null && !clauses.isEmpty();
      case ErlangPackage.RECEIVE_EXPR__AFTER_EXPR:
        return after_expr != null;
      case ErlangPackage.RECEIVE_EXPR__AFTER_BODY:
        return after_body != null;
    }
    return super.eIsSet(featureID);
  }

} //ReceiveExprImpl
