/**
 * <copyright>
 * </copyright>
 *
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
import org.erlide.erlang.FunRef;
import org.erlide.erlang.SpecAttribute;
import org.erlide.erlang.TypeSig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spec Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.SpecAttributeImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.SpecAttributeImpl#getSignatures <em>Signatures</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecAttributeImpl extends AbstractTypeAttributeImpl implements SpecAttribute
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected FunRef ref;

  /**
   * The cached value of the '{@link #getSignatures() <em>Signatures</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignatures()
   * @generated
   * @ordered
   */
  protected EList<TypeSig> signatures;

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
  public FunRef getRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRef(FunRef newRef, NotificationChain msgs)
  {
    FunRef oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.SPEC_ATTRIBUTE__REF, oldRef, newRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(FunRef newRef)
  {
    if (newRef != ref)
    {
      NotificationChain msgs = null;
      if (ref != null)
        msgs = ((InternalEObject)ref).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.SPEC_ATTRIBUTE__REF, null, msgs);
      if (newRef != null)
        msgs = ((InternalEObject)newRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.SPEC_ATTRIBUTE__REF, null, msgs);
      msgs = basicSetRef(newRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.SPEC_ATTRIBUTE__REF, newRef, newRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeSig> getSignatures()
  {
    if (signatures == null)
    {
      signatures = new EObjectContainmentEList<TypeSig>(TypeSig.class, this, ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES);
    }
    return signatures;
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
      case ErlangPackage.SPEC_ATTRIBUTE__REF:
        return basicSetRef(null, msgs);
      case ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES:
        return ((InternalEList<?>)getSignatures()).basicRemove(otherEnd, msgs);
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
      case ErlangPackage.SPEC_ATTRIBUTE__REF:
        return getRef();
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
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ErlangPackage.SPEC_ATTRIBUTE__REF:
        setRef((FunRef)newValue);
        return;
      case ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES:
        getSignatures().clear();
        getSignatures().addAll((Collection<? extends TypeSig>)newValue);
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
      case ErlangPackage.SPEC_ATTRIBUTE__REF:
        setRef((FunRef)null);
        return;
      case ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES:
        getSignatures().clear();
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
      case ErlangPackage.SPEC_ATTRIBUTE__REF:
        return ref != null;
      case ErlangPackage.SPEC_ATTRIBUTE__SIGNATURES:
        return signatures != null && !signatures.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SpecAttributeImpl
