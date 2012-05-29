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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.erlide.erlang.DefineAttribute;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.MacroCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Macro Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.MacroCallImpl#getMacroName <em>Macro Name</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.MacroCallImpl#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MacroCallImpl extends MinimalEObjectImpl.Container implements MacroCall
{
  /**
   * The cached value of the '{@link #getMacroName() <em>Macro Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMacroName()
   * @generated
   * @ordered
   */
  protected DefineAttribute macroName;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MacroCallImpl()
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
    return ErlangPackage.Literals.MACRO_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineAttribute getMacroName()
  {
    if (macroName != null && macroName.eIsProxy())
    {
      InternalEObject oldMacroName = (InternalEObject)macroName;
      macroName = (DefineAttribute)eResolveProxy(oldMacroName);
      if (macroName != oldMacroName)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErlangPackage.MACRO_CALL__MACRO_NAME, oldMacroName, macroName));
      }
    }
    return macroName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineAttribute basicGetMacroName()
  {
    return macroName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMacroName(DefineAttribute newMacroName)
  {
    DefineAttribute oldMacroName = macroName;
    macroName = newMacroName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.MACRO_CALL__MACRO_NAME, oldMacroName, macroName));
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
      args = new EObjectContainmentEList<Expression>(Expression.class, this, ErlangPackage.MACRO_CALL__ARGS);
    }
    return args;
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
      case ErlangPackage.MACRO_CALL__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
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
      case ErlangPackage.MACRO_CALL__MACRO_NAME:
        if (resolve) return getMacroName();
        return basicGetMacroName();
      case ErlangPackage.MACRO_CALL__ARGS:
        return getArgs();
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
      case ErlangPackage.MACRO_CALL__MACRO_NAME:
        setMacroName((DefineAttribute)newValue);
        return;
      case ErlangPackage.MACRO_CALL__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends Expression>)newValue);
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
      case ErlangPackage.MACRO_CALL__MACRO_NAME:
        setMacroName((DefineAttribute)null);
        return;
      case ErlangPackage.MACRO_CALL__ARGS:
        getArgs().clear();
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
      case ErlangPackage.MACRO_CALL__MACRO_NAME:
        return macroName != null;
      case ErlangPackage.MACRO_CALL__ARGS:
        return args != null && !args.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MacroCallImpl
