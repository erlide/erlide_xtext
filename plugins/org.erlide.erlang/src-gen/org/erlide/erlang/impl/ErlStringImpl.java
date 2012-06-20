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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.erlide.erlang.ErlString;
import org.erlide.erlang.ErlStringPart;
import org.erlide.erlang.ErlangPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Erl String</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.ErlStringImpl#getString <em>String</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.ErlStringImpl#getMore <em>More</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErlStringImpl extends ExpressionImpl implements ErlString
{
  /**
   * The default value of the '{@link #getString() <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected static final String STRING_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getString() <em>String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getString()
   * @generated
   * @ordered
   */
  protected String string = STRING_EDEFAULT;

  /**
   * The cached value of the '{@link #getMore() <em>More</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMore()
   * @generated
   * @ordered
   */
  protected EList<ErlStringPart> more;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErlStringImpl()
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
    return ErlangPackage.Literals.ERL_STRING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getString()
  {
    return string;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setString(String newString)
  {
    String oldString = string;
    string = newString;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.ERL_STRING__STRING, oldString, string));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErlStringPart> getMore()
  {
    if (more == null)
    {
      more = new EObjectContainmentEList<ErlStringPart>(ErlStringPart.class, this, ErlangPackage.ERL_STRING__MORE);
    }
    return more;
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
      case ErlangPackage.ERL_STRING__MORE:
        return ((InternalEList<?>)getMore()).basicRemove(otherEnd, msgs);
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
      case ErlangPackage.ERL_STRING__STRING:
        return getString();
      case ErlangPackage.ERL_STRING__MORE:
        return getMore();
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
      case ErlangPackage.ERL_STRING__STRING:
        setString((String)newValue);
        return;
      case ErlangPackage.ERL_STRING__MORE:
        getMore().clear();
        getMore().addAll((Collection<? extends ErlStringPart>)newValue);
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
      case ErlangPackage.ERL_STRING__STRING:
        setString(STRING_EDEFAULT);
        return;
      case ErlangPackage.ERL_STRING__MORE:
        getMore().clear();
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
      case ErlangPackage.ERL_STRING__STRING:
        return STRING_EDEFAULT == null ? string != null : !STRING_EDEFAULT.equals(string);
      case ErlangPackage.ERL_STRING__MORE:
        return more != null && !more.isEmpty();
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
    result.append(" (string: ");
    result.append(string);
    result.append(')');
    return result.toString();
  }

} //ErlStringImpl
