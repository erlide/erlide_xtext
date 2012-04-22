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
import org.erlide.erlang.Expression;
import org.erlide.erlang.LCExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LC Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.LCExprImpl#getO1 <em>O1</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.LCExprImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.LCExprImpl#getO2 <em>O2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LCExprImpl extends MinimalEObjectImpl.Container implements LCExpr
{
  /**
   * The cached value of the '{@link #getO1() <em>O1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getO1()
   * @generated
   * @ordered
   */
  protected Expression o1;

  /**
   * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected static final String OP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected String op = OP_EDEFAULT;

  /**
   * The cached value of the '{@link #getO2() <em>O2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getO2()
   * @generated
   * @ordered
   */
  protected Expression o2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LCExprImpl()
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
    return ErlangPackage.Literals.LC_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getO1()
  {
    return o1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetO1(Expression newO1, NotificationChain msgs)
  {
    Expression oldO1 = o1;
    o1 = newO1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.LC_EXPR__O1, oldO1, newO1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setO1(Expression newO1)
  {
    if (newO1 != o1)
    {
      NotificationChain msgs = null;
      if (o1 != null)
        msgs = ((InternalEObject)o1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.LC_EXPR__O1, null, msgs);
      if (newO1 != null)
        msgs = ((InternalEObject)newO1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.LC_EXPR__O1, null, msgs);
      msgs = basicSetO1(newO1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.LC_EXPR__O1, newO1, newO1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOp()
  {
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOp(String newOp)
  {
    String oldOp = op;
    op = newOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.LC_EXPR__OP, oldOp, op));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getO2()
  {
    return o2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetO2(Expression newO2, NotificationChain msgs)
  {
    Expression oldO2 = o2;
    o2 = newO2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.LC_EXPR__O2, oldO2, newO2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setO2(Expression newO2)
  {
    if (newO2 != o2)
    {
      NotificationChain msgs = null;
      if (o2 != null)
        msgs = ((InternalEObject)o2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.LC_EXPR__O2, null, msgs);
      if (newO2 != null)
        msgs = ((InternalEObject)newO2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.LC_EXPR__O2, null, msgs);
      msgs = basicSetO2(newO2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.LC_EXPR__O2, newO2, newO2));
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
      case ErlangPackage.LC_EXPR__O1:
        return basicSetO1(null, msgs);
      case ErlangPackage.LC_EXPR__O2:
        return basicSetO2(null, msgs);
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
      case ErlangPackage.LC_EXPR__O1:
        return getO1();
      case ErlangPackage.LC_EXPR__OP:
        return getOp();
      case ErlangPackage.LC_EXPR__O2:
        return getO2();
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
      case ErlangPackage.LC_EXPR__O1:
        setO1((Expression)newValue);
        return;
      case ErlangPackage.LC_EXPR__OP:
        setOp((String)newValue);
        return;
      case ErlangPackage.LC_EXPR__O2:
        setO2((Expression)newValue);
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
      case ErlangPackage.LC_EXPR__O1:
        setO1((Expression)null);
        return;
      case ErlangPackage.LC_EXPR__OP:
        setOp(OP_EDEFAULT);
        return;
      case ErlangPackage.LC_EXPR__O2:
        setO2((Expression)null);
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
      case ErlangPackage.LC_EXPR__O1:
        return o1 != null;
      case ErlangPackage.LC_EXPR__OP:
        return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
      case ErlangPackage.LC_EXPR__O2:
        return o2 != null;
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
    result.append(" (op: ");
    result.append(op);
    result.append(')');
    return result.toString();
  }

} //LCExprImpl
