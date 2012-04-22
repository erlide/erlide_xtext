/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.SpecAttribute;
import org.erlide.erlang.SpecFun;
import org.erlide.erlang.TypeSigs;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spec Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.SpecAttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.SpecAttributeImpl#getSignatures <em>Signatures</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecAttributeImpl extends AbstractTypeAttributeImpl implements SpecAttribute
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected SpecFun type;

  /**
   * The cached value of the '{@link #getSignatures() <em>Signatures</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignatures()
   * @generated
   * @ordered
   */
  protected TypeSigs signatures;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpecAttributeImpl()
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
    return ErlangPackage.Literals.SPEC_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecFun getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(SpecFun newType, NotificationChain msgs)
  {
    SpecFun oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.SPEC_ATTRIBUTE__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(SpecFun newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.SPEC_ATTRIBUTE__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.SPEC_ATTRIBUTE__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.SPEC_ATTRIBUTE__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeSigs getSignatures()
  {
    return signatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSignatures(TypeSigs newSignatures, NotificationChain msgs)
  {
    TypeSigs oldSignatures = signatures;
    signatures = newSignatures;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES, oldSignatures, newSignatures);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSignatures(TypeSigs newSignatures)
  {
    if (newSignatures != signatures)
    {
      NotificationChain msgs = null;
      if (signatures != null)
        msgs = ((InternalEObject)signatures).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES, null, msgs);
      if (newSignatures != null)
        msgs = ((InternalEObject)newSignatures).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES, null, msgs);
      msgs = basicSetSignatures(newSignatures, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES, newSignatures, newSignatures));
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
      case ErlangPackage.SPEC_ATTRIBUTE__TYPE:
        return basicSetType(null, msgs);
      case ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES:
        return basicSetSignatures(null, msgs);
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
      case ErlangPackage.SPEC_ATTRIBUTE__TYPE:
        return getType();
      case ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES:
        return getSignatures();
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
      case ErlangPackage.SPEC_ATTRIBUTE__TYPE:
        setType((SpecFun)newValue);
        return;
      case ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES:
        setSignatures((TypeSigs)newValue);
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
      case ErlangPackage.SPEC_ATTRIBUTE__TYPE:
        setType((SpecFun)null);
        return;
      case ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES:
        setSignatures((TypeSigs)null);
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
      case ErlangPackage.SPEC_ATTRIBUTE__TYPE:
        return type != null;
      case ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES:
        return signatures != null;
    }
    return super.eIsSet(featureID);
  }

} //SpecAttributeImpl
