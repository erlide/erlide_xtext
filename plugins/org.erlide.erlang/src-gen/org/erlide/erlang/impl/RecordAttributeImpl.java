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
import org.erlide.erlang.MacroCall;
import org.erlide.erlang.RecordAttribute;
import org.erlide.erlang.RecordFieldDef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.RecordAttributeImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.RecordAttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.RecordAttributeImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.RecordAttributeImpl#getRecordMacro <em>Record Macro</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecordAttributeImpl extends AtomRefTargetImpl implements RecordAttribute
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
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFields()
   * @generated
   * @ordered
   */
  protected EList<RecordFieldDef> fields;

  /**
   * The cached value of the '{@link #getRecordMacro() <em>Record Macro</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordMacro()
   * @generated
   * @ordered
   */
  protected MacroCall recordMacro;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecordAttributeImpl()
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
    return ErlangPackage.Literals.RECORD_ATTRIBUTE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.RECORD_ATTRIBUTE__TAG, oldTag, tag));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.RECORD_ATTRIBUTE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RecordFieldDef> getFields()
  {
    if (fields == null)
    {
      fields = new EObjectContainmentEList<RecordFieldDef>(RecordFieldDef.class, this, ErlangPackage.RECORD_ATTRIBUTE__FIELDS);
    }
    return fields;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MacroCall getRecordMacro()
  {
    return recordMacro;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRecordMacro(MacroCall newRecordMacro, NotificationChain msgs)
  {
    MacroCall oldRecordMacro = recordMacro;
    recordMacro = newRecordMacro;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.RECORD_ATTRIBUTE__RECORD_MACRO, oldRecordMacro, newRecordMacro);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRecordMacro(MacroCall newRecordMacro)
  {
    if (newRecordMacro != recordMacro)
    {
      NotificationChain msgs = null;
      if (recordMacro != null)
        msgs = ((InternalEObject)recordMacro).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.RECORD_ATTRIBUTE__RECORD_MACRO, null, msgs);
      if (newRecordMacro != null)
        msgs = ((InternalEObject)newRecordMacro).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.RECORD_ATTRIBUTE__RECORD_MACRO, null, msgs);
      msgs = basicSetRecordMacro(newRecordMacro, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.RECORD_ATTRIBUTE__RECORD_MACRO, newRecordMacro, newRecordMacro));
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
      case ErlangPackage.RECORD_ATTRIBUTE__FIELDS:
        return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
      case ErlangPackage.RECORD_ATTRIBUTE__RECORD_MACRO:
        return basicSetRecordMacro(null, msgs);
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
      case ErlangPackage.RECORD_ATTRIBUTE__TAG:
        return getTag();
      case ErlangPackage.RECORD_ATTRIBUTE__NAME:
        return getName();
      case ErlangPackage.RECORD_ATTRIBUTE__FIELDS:
        return getFields();
      case ErlangPackage.RECORD_ATTRIBUTE__RECORD_MACRO:
        return getRecordMacro();
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
      case ErlangPackage.RECORD_ATTRIBUTE__TAG:
        setTag((String)newValue);
        return;
      case ErlangPackage.RECORD_ATTRIBUTE__NAME:
        setName((String)newValue);
        return;
      case ErlangPackage.RECORD_ATTRIBUTE__FIELDS:
        getFields().clear();
        getFields().addAll((Collection<? extends RecordFieldDef>)newValue);
        return;
      case ErlangPackage.RECORD_ATTRIBUTE__RECORD_MACRO:
        setRecordMacro((MacroCall)newValue);
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
      case ErlangPackage.RECORD_ATTRIBUTE__TAG:
        setTag(TAG_EDEFAULT);
        return;
      case ErlangPackage.RECORD_ATTRIBUTE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ErlangPackage.RECORD_ATTRIBUTE__FIELDS:
        getFields().clear();
        return;
      case ErlangPackage.RECORD_ATTRIBUTE__RECORD_MACRO:
        setRecordMacro((MacroCall)null);
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
      case ErlangPackage.RECORD_ATTRIBUTE__TAG:
        return TAG_EDEFAULT == null ? tag != null : !TAG_EDEFAULT.equals(tag);
      case ErlangPackage.RECORD_ATTRIBUTE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ErlangPackage.RECORD_ATTRIBUTE__FIELDS:
        return fields != null && !fields.isEmpty();
      case ErlangPackage.RECORD_ATTRIBUTE__RECORD_MACRO:
        return recordMacro != null;
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
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //RecordAttributeImpl
