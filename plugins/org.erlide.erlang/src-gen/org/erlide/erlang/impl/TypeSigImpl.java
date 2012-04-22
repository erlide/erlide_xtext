/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.FunType;
import org.erlide.erlang.TypeGuards;
import org.erlide.erlang.TypeSig;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Sig</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.TypeSigImpl#getDecl <em>Decl</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.TypeSigImpl#getGuards <em>Guards</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeSigImpl extends MinimalEObjectImpl.Container implements TypeSig
{
  /**
   * The cached value of the '{@link #getDecl() <em>Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecl()
   * @generated
   * @ordered
   */
  protected FunType decl;

  /**
   * The cached value of the '{@link #getGuards() <em>Guards</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuards()
   * @generated
   * @ordered
   */
  protected TypeGuards guards;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeSigImpl()
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
    return ErlangPackage.Literals.TYPE_SIG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunType getDecl()
  {
    return decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDecl(FunType newDecl, NotificationChain msgs)
  {
    FunType oldDecl = decl;
    decl = newDecl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.TYPE_SIG__DECL, oldDecl, newDecl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDecl(FunType newDecl)
  {
    if (newDecl != decl)
    {
      NotificationChain msgs = null;
      if (decl != null)
        msgs = ((InternalEObject)decl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.TYPE_SIG__DECL, null, msgs);
      if (newDecl != null)
        msgs = ((InternalEObject)newDecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.TYPE_SIG__DECL, null, msgs);
      msgs = basicSetDecl(newDecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.TYPE_SIG__DECL, newDecl, newDecl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeGuards getGuards()
  {
    return guards;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuards(TypeGuards newGuards, NotificationChain msgs)
  {
    TypeGuards oldGuards = guards;
    guards = newGuards;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.TYPE_SIG__GUARDS, oldGuards, newGuards);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuards(TypeGuards newGuards)
  {
    if (newGuards != guards)
    {
      NotificationChain msgs = null;
      if (guards != null)
        msgs = ((InternalEObject)guards).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.TYPE_SIG__GUARDS, null, msgs);
      if (newGuards != null)
        msgs = ((InternalEObject)newGuards).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.TYPE_SIG__GUARDS, null, msgs);
      msgs = basicSetGuards(newGuards, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.TYPE_SIG__GUARDS, newGuards, newGuards));
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
      case ErlangPackage.TYPE_SIG__DECL:
        return basicSetDecl(null, msgs);
      case ErlangPackage.TYPE_SIG__GUARDS:
        return basicSetGuards(null, msgs);
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
      case ErlangPackage.TYPE_SIG__DECL:
        return getDecl();
      case ErlangPackage.TYPE_SIG__GUARDS:
        return getGuards();
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
      case ErlangPackage.TYPE_SIG__DECL:
        setDecl((FunType)newValue);
        return;
      case ErlangPackage.TYPE_SIG__GUARDS:
        setGuards((TypeGuards)newValue);
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
      case ErlangPackage.TYPE_SIG__DECL:
        setDecl((FunType)null);
        return;
      case ErlangPackage.TYPE_SIG__GUARDS:
        setGuards((TypeGuards)null);
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
      case ErlangPackage.TYPE_SIG__DECL:
        return decl != null;
      case ErlangPackage.TYPE_SIG__GUARDS:
        return guards != null;
    }
    return super.eIsSet(featureID);
  }

} //TypeSigImpl
