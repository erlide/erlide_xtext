/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.erlide.erlang.AtomVarMacro;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.IntVarMacro;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fun Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.FunRefImpl#getModule <em>Module</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.FunRefImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.FunRefImpl#getArity <em>Arity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunRefImpl extends FunExprImpl implements FunRef
{
  /**
   * The cached value of the '{@link #getModule() <em>Module</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModule()
   * @generated
   * @ordered
   */
  protected AtomVarMacro module;

  /**
   * The cached value of the '{@link #getFunction() <em>Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction()
   * @generated
   * @ordered
   */
  protected AtomVarMacro function;

  /**
   * The cached value of the '{@link #getArity() <em>Arity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArity()
   * @generated
   * @ordered
   */
  protected IntVarMacro arity;

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
  public AtomVarMacro getModule()
  {
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModule(AtomVarMacro newModule, NotificationChain msgs)
  {
    AtomVarMacro oldModule = module;
    module = newModule;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__MODULE, oldModule, newModule);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModule(AtomVarMacro newModule)
  {
    if (newModule != module)
    {
      NotificationChain msgs = null;
      if (module != null)
        msgs = ((InternalEObject)module).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__MODULE, null, msgs);
      if (newModule != null)
        msgs = ((InternalEObject)newModule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__MODULE, null, msgs);
      msgs = basicSetModule(newModule, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__MODULE, newModule, newModule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomVarMacro getFunction()
  {
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunction(AtomVarMacro newFunction, NotificationChain msgs)
  {
    AtomVarMacro oldFunction = function;
    function = newFunction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__FUNCTION, oldFunction, newFunction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunction(AtomVarMacro newFunction)
  {
    if (newFunction != function)
    {
      NotificationChain msgs = null;
      if (function != null)
        msgs = ((InternalEObject)function).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__FUNCTION, null, msgs);
      if (newFunction != null)
        msgs = ((InternalEObject)newFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__FUNCTION, null, msgs);
      msgs = basicSetFunction(newFunction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__FUNCTION, newFunction, newFunction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntVarMacro getArity()
  {
    return arity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArity(IntVarMacro newArity, NotificationChain msgs)
  {
    IntVarMacro oldArity = arity;
    arity = newArity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__ARITY, oldArity, newArity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArity(IntVarMacro newArity)
  {
    if (newArity != arity)
    {
      NotificationChain msgs = null;
      if (arity != null)
        msgs = ((InternalEObject)arity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__ARITY, null, msgs);
      if (newArity != null)
        msgs = ((InternalEObject)newArity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.FUN_REF__ARITY, null, msgs);
      msgs = basicSetArity(newArity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__ARITY, newArity, newArity));
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
      case ErlangPackage.FUN_REF__MODULE:
        return basicSetModule(null, msgs);
      case ErlangPackage.FUN_REF__FUNCTION:
        return basicSetFunction(null, msgs);
      case ErlangPackage.FUN_REF__ARITY:
        return basicSetArity(null, msgs);
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
      case ErlangPackage.FUN_REF__MODULE:
        return getModule();
      case ErlangPackage.FUN_REF__FUNCTION:
        return getFunction();
      case ErlangPackage.FUN_REF__ARITY:
        return getArity();
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
      case ErlangPackage.FUN_REF__MODULE:
        setModule((AtomVarMacro)newValue);
        return;
      case ErlangPackage.FUN_REF__FUNCTION:
        setFunction((AtomVarMacro)newValue);
        return;
      case ErlangPackage.FUN_REF__ARITY:
        setArity((IntVarMacro)newValue);
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
      case ErlangPackage.FUN_REF__MODULE:
        setModule((AtomVarMacro)null);
        return;
      case ErlangPackage.FUN_REF__FUNCTION:
        setFunction((AtomVarMacro)null);
        return;
      case ErlangPackage.FUN_REF__ARITY:
        setArity((IntVarMacro)null);
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
      case ErlangPackage.FUN_REF__MODULE:
        return module != null;
      case ErlangPackage.FUN_REF__FUNCTION:
        return function != null;
      case ErlangPackage.FUN_REF__ARITY:
        return arity != null;
    }
    return super.eIsSet(featureID);
  }

} //FunRefImpl
