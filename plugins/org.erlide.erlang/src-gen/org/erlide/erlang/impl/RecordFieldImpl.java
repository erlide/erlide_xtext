/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.RecordField;
import org.erlide.erlang.RecordFieldDef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.RecordFieldImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecordFieldImpl extends ExpressionImpl implements RecordField
{
  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected RecordFieldDef value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecordFieldImpl()
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
    return ErlangPackage.Literals.RECORD_FIELD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordFieldDef getValue()
  {
    if (value != null && value.eIsProxy())
    {
      InternalEObject oldValue = (InternalEObject)value;
      value = (RecordFieldDef)eResolveProxy(oldValue);
      if (value != oldValue)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErlangPackage.RECORD_FIELD__VALUE, oldValue, value));
      }
    }
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordFieldDef basicGetValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(RecordFieldDef newValue)
  {
    RecordFieldDef oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.RECORD_FIELD__VALUE, oldValue, value));
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
      case ErlangPackage.RECORD_FIELD__VALUE:
        if (resolve) return getValue();
        return basicGetValue();
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
      case ErlangPackage.RECORD_FIELD__VALUE:
        setValue((RecordFieldDef)newValue);
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
      case ErlangPackage.RECORD_FIELD__VALUE:
        setValue((RecordFieldDef)null);
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
      case ErlangPackage.RECORD_FIELD__VALUE:
        return value != null;
    }
    return super.eIsSet(featureID);
  }

} //RecordFieldImpl
