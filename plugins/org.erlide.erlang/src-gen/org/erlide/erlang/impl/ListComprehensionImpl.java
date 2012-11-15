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

import org.erlide.erlang.ErlList;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.LCExpr;
import org.erlide.erlang.ListComprehension;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Comprehension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.ListComprehensionImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.ListComprehensionImpl#getGenerators <em>Generators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ListComprehensionImpl extends ErlListImpl implements ListComprehension
{
  /**
   * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoot()
   * @generated
   * @ordered
   */
  protected ErlList root;

  /**
   * The cached value of the '{@link #getGenerators() <em>Generators</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerators()
   * @generated
   * @ordered
   */
  protected EList<LCExpr> generators;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ListComprehensionImpl()
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
    return ErlangPackage.Literals.LIST_COMPREHENSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErlList getRoot()
  {
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRoot(ErlList newRoot, NotificationChain msgs)
  {
    ErlList oldRoot = root;
    root = newRoot;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.LIST_COMPREHENSION__ROOT, oldRoot, newRoot);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoot(ErlList newRoot)
  {
    if (newRoot != root)
    {
      NotificationChain msgs = null;
      if (root != null)
        msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.LIST_COMPREHENSION__ROOT, null, msgs);
      if (newRoot != null)
        msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.LIST_COMPREHENSION__ROOT, null, msgs);
      msgs = basicSetRoot(newRoot, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.LIST_COMPREHENSION__ROOT, newRoot, newRoot));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LCExpr> getGenerators()
  {
    if (generators == null)
    {
      generators = new EObjectContainmentEList<LCExpr>(LCExpr.class, this, ErlangPackage.LIST_COMPREHENSION__GENERATORS);
    }
    return generators;
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
      case ErlangPackage.LIST_COMPREHENSION__ROOT:
        return basicSetRoot(null, msgs);
      case ErlangPackage.LIST_COMPREHENSION__GENERATORS:
        return ((InternalEList<?>)getGenerators()).basicRemove(otherEnd, msgs);
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
      case ErlangPackage.LIST_COMPREHENSION__ROOT:
        return getRoot();
      case ErlangPackage.LIST_COMPREHENSION__GENERATORS:
        return getGenerators();
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
      case ErlangPackage.LIST_COMPREHENSION__ROOT:
        setRoot((ErlList)newValue);
        return;
      case ErlangPackage.LIST_COMPREHENSION__GENERATORS:
        getGenerators().clear();
        getGenerators().addAll((Collection<? extends LCExpr>)newValue);
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
      case ErlangPackage.LIST_COMPREHENSION__ROOT:
        setRoot((ErlList)null);
        return;
      case ErlangPackage.LIST_COMPREHENSION__GENERATORS:
        getGenerators().clear();
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
      case ErlangPackage.LIST_COMPREHENSION__ROOT:
        return root != null;
      case ErlangPackage.LIST_COMPREHENSION__GENERATORS:
        return generators != null && !generators.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ListComprehensionImpl
