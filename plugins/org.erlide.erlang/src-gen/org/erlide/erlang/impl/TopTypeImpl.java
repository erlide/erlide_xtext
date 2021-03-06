/**
 */
package org.erlide.erlang.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.erlide.erlang.ErlangPackage;
import org.erlide.erlang.Expression;
import org.erlide.erlang.TopType;
import org.erlide.erlang.Type;
import org.erlide.erlang.Type100;
import org.erlide.erlang.Type200;
import org.erlide.erlang.Type300;
import org.erlide.erlang.Type400;
import org.erlide.erlang.Type500;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Top Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.TopTypeImpl#getTypeName <em>Type Name</em>}
 * </li>
 * <li>{@link org.erlide.erlang.impl.TopTypeImpl#getValue <em>Value</em>}</li>
 * <li>{@link org.erlide.erlang.impl.TopTypeImpl#getVar <em>Var</em>}</li>
 * <li>{@link org.erlide.erlang.impl.TopTypeImpl#getType <em>Type</em>}</li>
 * <li>{@link org.erlide.erlang.impl.TopTypeImpl#getLeftOperand <em>Left Operand
 * </em>}</li>
 * <li>{@link org.erlide.erlang.impl.TopTypeImpl#getOp <em>Op</em>}</li>
 * <li>{@link org.erlide.erlang.impl.TopTypeImpl#getRightOperand <em>Right
 * Operand</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TopTypeImpl extends Type100Impl implements TopType {
    /**
     * The cached value of the '{@link #getTypeName() <em>Type Name</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTypeName()
     * @generated
     * @ordered
     */
    protected Expression typeName;

    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #getVar() <em>Var</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVar()
     * @generated
     * @ordered
     */
    protected static final String VAR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVar() <em>Var</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVar()
     * @generated
     * @ordered
     */
    protected String var = VAR_EDEFAULT;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected Type100 type;

    /**
     * The cached value of the '{@link #getLeftOperand() <em>Left Operand</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLeftOperand()
     * @generated
     * @ordered
     */
    protected Type200 leftOperand;

    /**
     * The default value of the '{@link #getOp() <em>Op</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOp()
     * @generated
     * @ordered
     */
    protected static final String OP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOp() <em>Op</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOp()
     * @generated
     * @ordered
     */
    protected String op = OP_EDEFAULT;

    /**
     * The cached value of the '{@link #getRightOperand()
     * <em>Right Operand</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getRightOperand()
     * @generated
     * @ordered
     */
    protected Type200 rightOperand;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TopTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.TOP_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getTypeName() {
        return typeName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetTypeName(final Expression newTypeName,
            NotificationChain msgs) {
        final Expression oldTypeName = typeName;
        typeName = newTypeName;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.TOP_TYPE__TYPE_NAME,
                    oldTypeName, newTypeName);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTypeName(final Expression newTypeName) {
        if (newTypeName != typeName) {
            NotificationChain msgs = null;
            if (typeName != null) {
                msgs = ((InternalEObject) typeName)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.TOP_TYPE__TYPE_NAME, null, msgs);
            }
            if (newTypeName != null) {
                msgs = ((InternalEObject) newTypeName)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.TOP_TYPE__TYPE_NAME, null, msgs);
            }
            msgs = basicSetTypeName(newTypeName, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.TOP_TYPE__TYPE_NAME, newTypeName, newTypeName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setValue(final String newValue) {
        final String oldValue = value;
        value = newValue;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.TOP_TYPE__VALUE, oldValue, value));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getVar() {
        return var;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setVar(final String newVar) {
        final String oldVar = var;
        var = newVar;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.TOP_TYPE__VAR, oldVar, var));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Type100 getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetType(final Type100 newType,
            NotificationChain msgs) {
        final Type100 oldType = type;
        type = newType;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.TOP_TYPE__TYPE, oldType,
                    newType);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setType(final Type100 newType) {
        if (newType != type) {
            NotificationChain msgs = null;
            if (type != null) {
                msgs = ((InternalEObject) type).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.TOP_TYPE__TYPE,
                        null, msgs);
            }
            if (newType != null) {
                msgs = ((InternalEObject) newType).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - ErlangPackage.TOP_TYPE__TYPE,
                        null, msgs);
            }
            msgs = basicSetType(newType, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.TOP_TYPE__TYPE, newType, newType));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Type200 getLeftOperand() {
        return leftOperand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetLeftOperand(final Type200 newLeftOperand,
            NotificationChain msgs) {
        final Type200 oldLeftOperand = leftOperand;
        leftOperand = newLeftOperand;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.TOP_TYPE__LEFT_OPERAND,
                    oldLeftOperand, newLeftOperand);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLeftOperand(final Type200 newLeftOperand) {
        if (newLeftOperand != leftOperand) {
            NotificationChain msgs = null;
            if (leftOperand != null) {
                msgs = ((InternalEObject) leftOperand).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.TOP_TYPE__LEFT_OPERAND, null,
                        msgs);
            }
            if (newLeftOperand != null) {
                msgs = ((InternalEObject) newLeftOperand).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.TOP_TYPE__LEFT_OPERAND, null,
                        msgs);
            }
            msgs = basicSetLeftOperand(newLeftOperand, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.TOP_TYPE__LEFT_OPERAND, newLeftOperand,
                    newLeftOperand));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getOp() {
        return op;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOp(final String newOp) {
        final String oldOp = op;
        op = newOp;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.TOP_TYPE__OP, oldOp, op));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Type200 getRightOperand() {
        return rightOperand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRightOperand(
            final Type200 newRightOperand, NotificationChain msgs) {
        final Type200 oldRightOperand = rightOperand;
        rightOperand = newRightOperand;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.TOP_TYPE__RIGHT_OPERAND,
                    oldRightOperand, newRightOperand);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRightOperand(final Type200 newRightOperand) {
        if (newRightOperand != rightOperand) {
            NotificationChain msgs = null;
            if (rightOperand != null) {
                msgs = ((InternalEObject) rightOperand).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.TOP_TYPE__RIGHT_OPERAND, null,
                        msgs);
            }
            if (newRightOperand != null) {
                msgs = ((InternalEObject) newRightOperand).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.TOP_TYPE__RIGHT_OPERAND, null,
                        msgs);
            }
            msgs = basicSetRightOperand(newRightOperand, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.TOP_TYPE__RIGHT_OPERAND, newRightOperand,
                    newRightOperand));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd,
            final int featureID, final NotificationChain msgs) {
        switch (featureID) {
        case ErlangPackage.TOP_TYPE__TYPE_NAME:
            return basicSetTypeName(null, msgs);
        case ErlangPackage.TOP_TYPE__TYPE:
            return basicSetType(null, msgs);
        case ErlangPackage.TOP_TYPE__LEFT_OPERAND:
            return basicSetLeftOperand(null, msgs);
        case ErlangPackage.TOP_TYPE__RIGHT_OPERAND:
            return basicSetRightOperand(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve,
            final boolean coreType) {
        switch (featureID) {
        case ErlangPackage.TOP_TYPE__TYPE_NAME:
            return getTypeName();
        case ErlangPackage.TOP_TYPE__VALUE:
            return getValue();
        case ErlangPackage.TOP_TYPE__VAR:
            return getVar();
        case ErlangPackage.TOP_TYPE__TYPE:
            return getType();
        case ErlangPackage.TOP_TYPE__LEFT_OPERAND:
            return getLeftOperand();
        case ErlangPackage.TOP_TYPE__OP:
            return getOp();
        case ErlangPackage.TOP_TYPE__RIGHT_OPERAND:
            return getRightOperand();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ErlangPackage.TOP_TYPE__TYPE_NAME:
            setTypeName((Expression) newValue);
            return;
        case ErlangPackage.TOP_TYPE__VALUE:
            setValue((String) newValue);
            return;
        case ErlangPackage.TOP_TYPE__VAR:
            setVar((String) newValue);
            return;
        case ErlangPackage.TOP_TYPE__TYPE:
            setType((Type100) newValue);
            return;
        case ErlangPackage.TOP_TYPE__LEFT_OPERAND:
            setLeftOperand((Type200) newValue);
            return;
        case ErlangPackage.TOP_TYPE__OP:
            setOp((String) newValue);
            return;
        case ErlangPackage.TOP_TYPE__RIGHT_OPERAND:
            setRightOperand((Type200) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case ErlangPackage.TOP_TYPE__TYPE_NAME:
            setTypeName((Expression) null);
            return;
        case ErlangPackage.TOP_TYPE__VALUE:
            setValue(VALUE_EDEFAULT);
            return;
        case ErlangPackage.TOP_TYPE__VAR:
            setVar(VAR_EDEFAULT);
            return;
        case ErlangPackage.TOP_TYPE__TYPE:
            setType((Type100) null);
            return;
        case ErlangPackage.TOP_TYPE__LEFT_OPERAND:
            setLeftOperand((Type200) null);
            return;
        case ErlangPackage.TOP_TYPE__OP:
            setOp(OP_EDEFAULT);
            return;
        case ErlangPackage.TOP_TYPE__RIGHT_OPERAND:
            setRightOperand((Type200) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case ErlangPackage.TOP_TYPE__TYPE_NAME:
            return typeName != null;
        case ErlangPackage.TOP_TYPE__VALUE:
            return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT
                    .equals(value);
        case ErlangPackage.TOP_TYPE__VAR:
            return VAR_EDEFAULT == null ? var != null : !VAR_EDEFAULT
                    .equals(var);
        case ErlangPackage.TOP_TYPE__TYPE:
            return type != null;
        case ErlangPackage.TOP_TYPE__LEFT_OPERAND:
            return leftOperand != null;
        case ErlangPackage.TOP_TYPE__OP:
            return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
        case ErlangPackage.TOP_TYPE__RIGHT_OPERAND:
            return rightOperand != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID,
            final Class<?> baseClass) {
        if (baseClass == Type200.class) {
            switch (derivedFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == Type300.class) {
            switch (derivedFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == Type400.class) {
            switch (derivedFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == Type500.class) {
            switch (derivedFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == Type.class) {
            switch (derivedFeatureID) {
            case ErlangPackage.TOP_TYPE__TYPE_NAME:
                return ErlangPackage.TYPE__TYPE_NAME;
            case ErlangPackage.TOP_TYPE__VALUE:
                return ErlangPackage.TYPE__VALUE;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID,
            final Class<?> baseClass) {
        if (baseClass == Type200.class) {
            switch (baseFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == Type300.class) {
            switch (baseFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == Type400.class) {
            switch (baseFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == Type500.class) {
            switch (baseFeatureID) {
            default:
                return -1;
            }
        }
        if (baseClass == Type.class) {
            switch (baseFeatureID) {
            case ErlangPackage.TYPE__TYPE_NAME:
                return ErlangPackage.TOP_TYPE__TYPE_NAME;
            case ErlangPackage.TYPE__VALUE:
                return ErlangPackage.TOP_TYPE__VALUE;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (value: ");
        result.append(value);
        result.append(", var: ");
        result.append(var);
        result.append(", op: ");
        result.append(op);
        result.append(')');
        return result.toString();
    }

} // TopTypeImpl
