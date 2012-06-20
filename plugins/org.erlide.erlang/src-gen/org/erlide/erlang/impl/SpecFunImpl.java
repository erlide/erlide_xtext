/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.ReferenceableElement;
import org.erlide.erlang.SpecFun;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spec Fun</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.SpecFunImpl#getModule <em>Module</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.SpecFunImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.SpecFunImpl#getArity <em>Arity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecFunImpl extends MinimalEObjectImpl.Container implements SpecFun
{
  /**
   * The cached value of the '{@link #getModule() <em>Module</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModule()
   * @generated
   * @ordered
   */
  protected ReferenceableElement module;

  /**
   * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction()
   * @generated
   * @ordered
   */
  protected ReferenceableElement function;

  /**
   * The cached value of the '{@link #getArity() <em>Arity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArity()
   * @generated
   * @ordered
   */
  protected ReferenceableElement arity;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpecFunImpl()
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
    return ErlangPackage.Literals.SPEC_FUN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceableElement getModule()
  {
    if (module != null && module.eIsProxy())
    {
      InternalEObject oldModule = (InternalEObject)module;
      module = (ReferenceableElement)eResolveProxy(oldModule);
      if (module != oldModule)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErlangPackage.SPEC_FUN__MODULE, oldModule, module));
      }
    }
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceableElement basicGetModule()
  {
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModule(ReferenceableElement newModule)
  {
    ReferenceableElement oldModule = module;
    module = newModule;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.SPEC_FUN__MODULE, oldModule, module));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceableElement getFunction()
  {
    if (function != null && function.eIsProxy())
    {
      InternalEObject oldFunction = (InternalEObject)function;
      function = (ReferenceableElement)eResolveProxy(oldFunction);
      if (function != oldFunction)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErlangPackage.SPEC_FUN__FUNCTION, oldFunction, function));
      }
    }
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceableElement basicGetFunction()
  {
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunction(ReferenceableElement newFunction)
  {
    ReferenceableElement oldFunction = function;
    function = newFunction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.SPEC_FUN__FUNCTION, oldFunction, function));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceableElement getArity()
  {
    if (arity != null && arity.eIsProxy())
    {
      InternalEObject oldArity = (InternalEObject)arity;
      arity = (ReferenceableElement)eResolveProxy(oldArity);
      if (arity != oldArity)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErlangPackage.SPEC_FUN__ARITY, oldArity, arity));
      }
    }
    return arity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceableElement basicGetArity()
  {
    return arity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArity(ReferenceableElement newArity)
  {
    ReferenceableElement oldArity = arity;
    arity = newArity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.SPEC_FUN__ARITY, oldArity, arity));
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
      case ErlangPackage.SPEC_FUN__MODULE:
        if (resolve) return getModule();
        return basicGetModule();
      case ErlangPackage.SPEC_FUN__FUNCTION:
        if (resolve) return getFunction();
        return basicGetFunction();
      case ErlangPackage.SPEC_FUN__ARITY:
        if (resolve) return getArity();
        return basicGetArity();
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
      case ErlangPackage.SPEC_FUN__MODULE:
        setModule((ReferenceableElement)newValue);
        return;
      case ErlangPackage.SPEC_FUN__FUNCTION:
        setFunction((ReferenceableElement)newValue);
        return;
      case ErlangPackage.SPEC_FUN__ARITY:
        setArity((ReferenceableElement)newValue);
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
      case ErlangPackage.SPEC_FUN__MODULE:
        setModule((ReferenceableElement)null);
        return;
      case ErlangPackage.SPEC_FUN__FUNCTION:
        setFunction((ReferenceableElement)null);
        return;
      case ErlangPackage.SPEC_FUN__ARITY:
        setArity((ReferenceableElement)null);
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
      case ErlangPackage.SPEC_FUN__MODULE:
        return module != null;
      case ErlangPackage.SPEC_FUN__FUNCTION:
        return function != null;
      case ErlangPackage.SPEC_FUN__ARITY:
        return arity != null;
    }
    return super.eIsSet(featureID);
  }

} //SpecFunImpl
