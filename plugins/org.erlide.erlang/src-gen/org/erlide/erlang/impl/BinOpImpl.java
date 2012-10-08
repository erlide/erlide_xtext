/**
 * <copyright>
 * </copyright>
 *
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.erlide.erlang.BinOp;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bin Op</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.BinOpImpl#getOpLeft <em>Op Left</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.BinOpImpl#getOp <em>Op</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.BinOpImpl#getOpRight <em>Op Right</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.BinOpImpl#getOpRight2 <em>Op Right2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinOpImpl extends ExpressionImpl implements BinOp
{
  /**
   * The cached value of the '{@link #getOpLeft() <em>Op Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpLeft()
   * @generated
   * @ordered
   */
  protected Expression opLeft;

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
   * The cached value of the '{@link #getOpRight() <em>Op Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpRight()
   * @generated
   * @ordered
   */
  protected Expression opRight;

  /**
   * The cached value of the '{@link #getOpRight2() <em>Op Right2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpRight2()
   * @generated
   * @ordered
   */
  protected Expression opRight2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BinOpImpl()
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
    return ErlangPackage.Literals.BIN_OP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getOpLeft()
  {
    return opLeft;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOpLeft(Expression newOpLeft, NotificationChain msgs)
  {
    Expression oldOpLeft = opLeft;
    opLeft = newOpLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.BIN_OP__OP_LEFT, oldOpLeft, newOpLeft);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpLeft(Expression newOpLeft)
  {
    if (newOpLeft != opLeft)
    {
      NotificationChain msgs = null;
      if (opLeft != null)
        msgs = ((InternalEObject)opLeft).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.BIN_OP__OP_LEFT, null, msgs);
      if (newOpLeft != null)
        msgs = ((InternalEObject)newOpLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.BIN_OP__OP_LEFT, null, msgs);
      msgs = basicSetOpLeft(newOpLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.BIN_OP__OP_LEFT, newOpLeft, newOpLeft));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.BIN_OP__OP, oldOp, op));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getOpRight()
  {
    return opRight;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOpRight(Expression newOpRight, NotificationChain msgs)
  {
    Expression oldOpRight = opRight;
    opRight = newOpRight;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.BIN_OP__OP_RIGHT, oldOpRight, newOpRight);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpRight(Expression newOpRight)
  {
    if (newOpRight != opRight)
    {
      NotificationChain msgs = null;
      if (opRight != null)
        msgs = ((InternalEObject)opRight).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.BIN_OP__OP_RIGHT, null, msgs);
      if (newOpRight != null)
        msgs = ((InternalEObject)newOpRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.BIN_OP__OP_RIGHT, null, msgs);
      msgs = basicSetOpRight(newOpRight, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.BIN_OP__OP_RIGHT, newOpRight, newOpRight));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getOpRight2()
  {
    return opRight2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOpRight2(Expression newOpRight2, NotificationChain msgs)
  {
    Expression oldOpRight2 = opRight2;
    opRight2 = newOpRight2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.BIN_OP__OP_RIGHT2, oldOpRight2, newOpRight2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpRight2(Expression newOpRight2)
  {
    if (newOpRight2 != opRight2)
    {
      NotificationChain msgs = null;
      if (opRight2 != null)
        msgs = ((InternalEObject)opRight2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.BIN_OP__OP_RIGHT2, null, msgs);
      if (newOpRight2 != null)
        msgs = ((InternalEObject)newOpRight2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.BIN_OP__OP_RIGHT2, null, msgs);
      msgs = basicSetOpRight2(newOpRight2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.BIN_OP__OP_RIGHT2, newOpRight2, newOpRight2));
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
      case ErlangPackage.BIN_OP__OP_LEFT:
        return basicSetOpLeft(null, msgs);
      case ErlangPackage.BIN_OP__OP_RIGHT:
        return basicSetOpRight(null, msgs);
      case ErlangPackage.BIN_OP__OP_RIGHT2:
        return basicSetOpRight2(null, msgs);
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
      case ErlangPackage.BIN_OP__OP_LEFT:
        return getOpLeft();
      case ErlangPackage.BIN_OP__OP:
        return getOp();
      case ErlangPackage.BIN_OP__OP_RIGHT:
        return getOpRight();
      case ErlangPackage.BIN_OP__OP_RIGHT2:
        return getOpRight2();
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
      case ErlangPackage.BIN_OP__OP_LEFT:
        setOpLeft((Expression)newValue);
        return;
      case ErlangPackage.BIN_OP__OP:
        setOp((String)newValue);
        return;
      case ErlangPackage.BIN_OP__OP_RIGHT:
        setOpRight((Expression)newValue);
        return;
      case ErlangPackage.BIN_OP__OP_RIGHT2:
        setOpRight2((Expression)newValue);
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
      case ErlangPackage.BIN_OP__OP_LEFT:
        setOpLeft((Expression)null);
        return;
      case ErlangPackage.BIN_OP__OP:
        setOp(OP_EDEFAULT);
        return;
      case ErlangPackage.BIN_OP__OP_RIGHT:
        setOpRight((Expression)null);
        return;
      case ErlangPackage.BIN_OP__OP_RIGHT2:
        setOpRight2((Expression)null);
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
      case ErlangPackage.BIN_OP__OP_LEFT:
        return opLeft != null;
      case ErlangPackage.BIN_OP__OP:
        return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
      case ErlangPackage.BIN_OP__OP_RIGHT:
        return opRight != null;
      case ErlangPackage.BIN_OP__OP_RIGHT2:
        return opRight2 != null;
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

} //BinOpImpl
