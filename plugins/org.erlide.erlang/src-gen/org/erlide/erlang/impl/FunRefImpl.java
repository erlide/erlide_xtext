/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.FunRef;

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
   * The default value of the '{@link #getModule() <em>Module</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModule()
   * @generated
   * @ordered
   */
  protected static final String MODULE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getModule() <em>Module</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModule()
   * @generated
   * @ordered
   */
  protected String module = MODULE_EDEFAULT;

  /**
   * The default value of the '{@link #getFunction() <em>Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction()
   * @generated
   * @ordered
   */
  protected static final String FUNCTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFunction() <em>Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction()
   * @generated
   * @ordered
   */
  protected String function = FUNCTION_EDEFAULT;

  /**
   * The default value of the '{@link #getArity() <em>Arity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArity()
   * @generated
   * @ordered
   */
  protected static final String ARITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getArity() <em>Arity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArity()
   * @generated
   * @ordered
   */
  protected String arity = ARITY_EDEFAULT;

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
  public String getModule()
  {
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModule(String newModule)
  {
    String oldModule = module;
    module = newModule;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__MODULE, oldModule, module));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFunction()
  {
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunction(String newFunction)
  {
    String oldFunction = function;
    function = newFunction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__FUNCTION, oldFunction, function));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getArity()
  {
    return arity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArity(String newArity)
  {
    String oldArity = arity;
    arity = newArity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.FUN_REF__ARITY, oldArity, arity));
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
        setModule((String)newValue);
        return;
      case ErlangPackage.FUN_REF__FUNCTION:
        setFunction((String)newValue);
        return;
      case ErlangPackage.FUN_REF__ARITY:
        setArity((String)newValue);
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
        setModule(MODULE_EDEFAULT);
        return;
      case ErlangPackage.FUN_REF__FUNCTION:
        setFunction(FUNCTION_EDEFAULT);
        return;
      case ErlangPackage.FUN_REF__ARITY:
        setArity(ARITY_EDEFAULT);
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
        return MODULE_EDEFAULT == null ? module != null : !MODULE_EDEFAULT.equals(module);
      case ErlangPackage.FUN_REF__FUNCTION:
        return FUNCTION_EDEFAULT == null ? function != null : !FUNCTION_EDEFAULT.equals(function);
      case ErlangPackage.FUN_REF__ARITY:
        return ARITY_EDEFAULT == null ? arity != null : !ARITY_EDEFAULT.equals(arity);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (module: ");
    result.append(module);
    result.append(", function: ");
    result.append(function);
    result.append(", arity: ");
    result.append(arity);
    result.append(')');
    return result.toString();
  }

} //FunRefImpl
