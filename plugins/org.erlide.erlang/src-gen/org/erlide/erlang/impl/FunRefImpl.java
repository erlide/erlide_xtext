/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.FunRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fun Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.FunRefImpl#getModule_ <em>Module </em>}</li>
 *   <li>{@link org.erlide.erlang.impl.FunRefImpl#getFunction_ <em>Function </em>}</li>
 *   <li>{@link org.erlide.erlang.impl.FunRefImpl#getArity_ <em>Arity </em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunRefImpl extends FunExprImpl implements FunRef
{
  /**
   * The cached value of the '{@link #getModule_() <em>Module </em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModule_()
   * @generated
   * @ordered
   */
  protected Expression module_;

  /**
   * The cached value of the '{@link #getFunction_() <em>Function </em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction_()
   * @generated
   * @ordered
   */
  protected Expression function_;

  /**
   * The cached value of the '{@link #getArity_() <em>Arity </em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArity_()
   * @generated
   * @ordered
   */
  protected Expression arity_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunRefImpl()
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
    return ErlangPackage.Literals.FUN_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getModule_()
  {
    return module_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModule_(Expression newModule_, NotificationChain msgs)
  {
    Expression oldModule_ = module_;
    module_ = newModule_;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__MODULE_, oldModule_, newModule_);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModule_(Expression newModule_)
  {
    if (newModule_ != module_)
    {
      NotificationChain msgs = null;
      if (module_ != null)
        msgs = ((InternalEObject)module_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__MODULE_, null, msgs);
      if (newModule_ != null)
        msgs = ((InternalEObject)newModule_).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__MODULE_, null, msgs);
      msgs = basicSetModule_(newModule_, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__MODULE_, newModule_, newModule_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getFunction_()
  {
    return function_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunction_(Expression newFunction_, NotificationChain msgs)
  {
    Expression oldFunction_ = function_;
    function_ = newFunction_;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__FUNCTION_, oldFunction_, newFunction_);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunction_(Expression newFunction_)
  {
    if (newFunction_ != function_)
    {
      NotificationChain msgs = null;
      if (function_ != null)
        msgs = ((InternalEObject)function_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__FUNCTION_, null, msgs);
      if (newFunction_ != null)
        msgs = ((InternalEObject)newFunction_).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__FUNCTION_, null, msgs);
      msgs = basicSetFunction_(newFunction_, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__FUNCTION_, newFunction_, newFunction_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getArity_()
  {
    return arity_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArity_(Expression newArity_, NotificationChain msgs)
  {
    Expression oldArity_ = arity_;
    arity_ = newArity_;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__ARITY_, oldArity_, newArity_);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArity_(Expression newArity_)
  {
    if (newArity_ != arity_)
    {
      NotificationChain msgs = null;
      if (arity_ != null)
        msgs = ((InternalEObject)arity_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__ARITY_, null, msgs);
      if (newArity_ != null)
        msgs = ((InternalEObject)newArity_).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__ARITY_, null, msgs);
      msgs = basicSetArity_(newArity_, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__ARITY_, newArity_, newArity_));
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
      case ErlangPackage.FUN_REF__MODULE_:
        return basicSetModule_(null, msgs);
      case ErlangPackage.FUN_REF__FUNCTION_:
        return basicSetFunction_(null, msgs);
      case ErlangPackage.FUN_REF__ARITY_:
        return basicSetArity_(null, msgs);
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
      case ErlangPackage.FUN_REF__MODULE_:
        return getModule_();
      case ErlangPackage.FUN_REF__FUNCTION_:
        return getFunction_();
      case ErlangPackage.FUN_REF__ARITY_:
        return getArity_();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ErlangPackage.FUN_REF__MODULE_:
        setModule_((Expression)newValue);
        return;
      case ErlangPackage.FUN_REF__FUNCTION_:
        setFunction_((Expression)newValue);
        return;
      case ErlangPackage.FUN_REF__ARITY_:
        setArity_((Expression)newValue);
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
      case ErlangPackage.FUN_REF__MODULE_:
        setModule_((Expression)null);
        return;
      case ErlangPackage.FUN_REF__FUNCTION_:
        setFunction_((Expression)null);
        return;
      case ErlangPackage.FUN_REF__ARITY_:
        setArity_((Expression)null);
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
      case ErlangPackage.FUN_REF__MODULE_:
        return module_ != null;
      case ErlangPackage.FUN_REF__FUNCTION_:
        return function_ != null;
      case ErlangPackage.FUN_REF__ARITY_:
        return arity_ != null;
    }
    return super.eIsSet(featureID);
  }

} //FunRefImpl
