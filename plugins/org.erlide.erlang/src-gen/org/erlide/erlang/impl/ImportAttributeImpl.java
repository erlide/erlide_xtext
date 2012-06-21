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

import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.FunRef;
import org.erlide.erlang.ImportAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.erlide.erlang.impl.ImportAttributeImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.ImportAttributeImpl#getModule <em>Module</em>}</li>
 *   <li>{@link org.erlide.erlang.impl.ImportAttributeImpl#getFuns <em>Funs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImportAttributeImpl extends AttributeImpl implements ImportAttribute
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
   * The cached value of the '{@link #getModule() <em>Module</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModule()
   * @generated
   * @ordered
   */
  protected Expression module;

  /**
   * The cached value of the '{@link #getFuns() <em>Funs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFuns()
   * @generated
   * @ordered
   */
  protected EList<FunRef> funs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImportAttributeImpl()
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
    return ErlangPackage.Literals.IMPORT_ATTRIBUTE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.IMPORT_ATTRIBUTE__TAG, oldTag, tag));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getModule()
  {
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModule(Expression newModule, NotificationChain msgs)
  {
    Expression oldModule = module;
    module = newModule;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErlangPackage.IMPORT_ATTRIBUTE__MODULE, oldModule, newModule);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModule(Expression newModule)
  {
    if (newModule != module)
    {
      NotificationChain msgs = null;
      if (module != null)
        msgs = ((InternalEObject)module).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.IMPORT_ATTRIBUTE__MODULE, null, msgs);
      if (newModule != null)
        msgs = ((InternalEObject)newModule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErlangPackage.IMPORT_ATTRIBUTE__MODULE, null, msgs);
      msgs = basicSetModule(newModule, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.IMPORT_ATTRIBUTE__MODULE, newModule, newModule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FunRef> getFuns()
  {
    if (funs == null)
    {
      funs = new EObjectContainmentEList<FunRef>(FunRef.class, this, ErlangPackage.IMPORT_ATTRIBUTE__FUNS);
    }
    return funs;
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
      case ErlangPackage.IMPORT_ATTRIBUTE__MODULE:
        return basicSetModule(null, msgs);
      case ErlangPackage.IMPORT_ATTRIBUTE__FUNS:
        return ((InternalEList<?>)getFuns()).basicRemove(otherEnd, msgs);
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
      case ErlangPackage.IMPORT_ATTRIBUTE__TAG:
        return getTag();
      case ErlangPackage.IMPORT_ATTRIBUTE__MODULE:
        return getModule();
      case ErlangPackage.IMPORT_ATTRIBUTE__FUNS:
        return getFuns();
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
      case ErlangPackage.IMPORT_ATTRIBUTE__TAG:
        setTag((String)newValue);
        return;
      case ErlangPackage.IMPORT_ATTRIBUTE__MODULE:
        setModule((Expression)newValue);
        return;
      case ErlangPackage.IMPORT_ATTRIBUTE__FUNS:
        getFuns().clear();
        getFuns().addAll((Collection<? extends FunRef>)newValue);
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
      case ErlangPackage.IMPORT_ATTRIBUTE__TAG:
        setTag(TAG_EDEFAULT);
        return;
      case ErlangPackage.IMPORT_ATTRIBUTE__MODULE:
        setModule((Expression)null);
        return;
      case ErlangPackage.IMPORT_ATTRIBUTE__FUNS:
        getFuns().clear();
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
      case ErlangPackage.IMPORT_ATTRIBUTE__TAG:
        return TAG_EDEFAULT == null ? tag != null : !TAG_EDEFAULT.equals(tag);
      case ErlangPackage.IMPORT_ATTRIBUTE__MODULE:
        return module != null;
      case ErlangPackage.IMPORT_ATTRIBUTE__FUNS:
        return funs != null && !funs.isEmpty();
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

} //ImportAttributeImpl
