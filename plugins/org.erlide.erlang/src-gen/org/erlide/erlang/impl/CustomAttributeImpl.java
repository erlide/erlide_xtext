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

import org.erlide.erlang.CustomAttribute;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.CustomAttributeImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.CustomAttributeImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomAttributeImpl extends AttributeImpl implements CustomAttribute
{
  /**
   * The default value of the '{@link #getTag() <em>Tag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTag()
   * @generated
   * @ordered
   */
  protected static final String TAG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTag() <em>Tag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTag()
   * @generated
   * @ordered
   */
  protected String tag = TAG_EDEFAULT;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected EList<Expression> value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CustomAttributeImpl()
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
    return ErlangPackage.Literals.CUSTOM_ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTag()
  {
    return tag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTag(String newTag)
  {
    String oldTag = tag;
    tag = newTag;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.CUSTOM_ATTRIBUTE__TAG, oldTag, tag));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getValue()
  {
    if (value == null)
    {
      value = new EObjectContainmentEList<Expression>(Expression.class, this, ErlangPackage.CUSTOM_ATTRIBUTE__VALUE);
    }
    return value;
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
      case ErlangPackage.CUSTOM_ATTRIBUTE__VALUE:
        return ((InternalEList<?>)getValue()).basicRemove(otherEnd, msgs);
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
      case ErlangPackage.CUSTOM_ATTRIBUTE__TAG:
        return getTag();
      case ErlangPackage.CUSTOM_ATTRIBUTE__VALUE:
        return getValue();
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
      case ErlangPackage.CUSTOM_ATTRIBUTE__TAG:
        setTag((String)newValue);
        return;
      case ErlangPackage.CUSTOM_ATTRIBUTE__VALUE:
        getValue().clear();
        getValue().addAll((Collection<? extends Expression>)newValue);
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
      case ErlangPackage.CUSTOM_ATTRIBUTE__TAG:
        setTag(TAG_EDEFAULT);
        return;
      case ErlangPackage.CUSTOM_ATTRIBUTE__VALUE:
        getValue().clear();
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
      case ErlangPackage.CUSTOM_ATTRIBUTE__TAG:
        return TAG_EDEFAULT == null ? tag != null : !TAG_EDEFAULT.equals(tag);
      case ErlangPackage.CUSTOM_ATTRIBUTE__VALUE:
        return value != null && !value.isEmpty();
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
    result.append(" (tag: ");
    result.append(tag);
    result.append(')');
    return result.toString();
  }

} //CustomAttributeImpl
