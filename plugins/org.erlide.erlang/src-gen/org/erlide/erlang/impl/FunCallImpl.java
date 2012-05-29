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

import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.FunCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fun Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.FunCallImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.FunCallImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.FunCallImpl#getArgs2 <em>Args2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunCallImpl extends ExpressionImpl implements FunCall
{
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Expression target;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<Expression> args;

  /**
   * The cached value of the '{@link #getArgs2() <em>Args2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs2()
   * @generated
   * @ordered
   */
  protected EList<Expression> args2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunCallImpl()
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
    return ErlangPackage.Literals.FUN_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(Expression newTarget, NotificationChain msgs)
  {
    Expression oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_CALL__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(Expression newTarget)
  {
    if (newTarget != target)
    {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_CALL__TARGET, null, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_CALL__TARGET, null, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_CALL__TARGET, newTarget, newTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<Expression>(Expression.class, this, ErlangPackage.FUN_CALL__ARGS);
    }
    return args;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getArgs2()
  {
    if (args2 == null)
    {
      args2 = new EObjectContainmentEList<Expression>(Expression.class, this, ErlangPackage.FUN_CALL__ARGS2);
    }
    return args2;
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
      case ErlangPackage.FUN_CALL__TARGET:
        return basicSetTarget(null, msgs);
      case ErlangPackage.FUN_CALL__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
      case ErlangPackage.FUN_CALL__ARGS2:
        return ((InternalEList<?>)getArgs2()).basicRemove(otherEnd, msgs);
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
      case ErlangPackage.FUN_CALL__TARGET:
        return getTarget();
      case ErlangPackage.FUN_CALL__ARGS:
        return getArgs();
      case ErlangPackage.FUN_CALL__ARGS2:
        return getArgs2();
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
      case ErlangPackage.FUN_CALL__TARGET:
        setTarget((Expression)newValue);
        return;
      case ErlangPackage.FUN_CALL__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends Expression>)newValue);
        return;
      case ErlangPackage.FUN_CALL__ARGS2:
        getArgs2().clear();
        getArgs2().addAll((Collection<? extends Expression>)newValue);
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
      case ErlangPackage.FUN_CALL__TARGET:
        setTarget((Expression)null);
        return;
      case ErlangPackage.FUN_CALL__ARGS:
        getArgs().clear();
        return;
      case ErlangPackage.FUN_CALL__ARGS2:
        getArgs2().clear();
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
      case ErlangPackage.FUN_CALL__TARGET:
        return target != null;
      case ErlangPackage.FUN_CALL__ARGS:
        return args != null && !args.isEmpty();
      case ErlangPackage.FUN_CALL__ARGS2:
        return args2 != null && !args2.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FunCallImpl
