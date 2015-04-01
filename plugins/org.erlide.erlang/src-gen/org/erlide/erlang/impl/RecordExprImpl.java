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
import org.erlide.erlang.RecordExpr;
import org.erlide.erlang.RecordTuple;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Record Expr</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.erlide.erlang.impl.RecordExprImpl#getRef <em>Ref</em>}</li>
 * <li>{@link org.erlide.erlang.impl.RecordExprImpl#getRecord <em>Record</em>}</li>
 * <li>{@link org.erlide.erlang.impl.RecordExprImpl#getRec <em>Rec</em>}</li>
 * <li>{@link org.erlide.erlang.impl.RecordExprImpl#getField <em>Field</em>}</li>
 * <li>{@link org.erlide.erlang.impl.RecordExprImpl#getTuple <em>Tuple</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecordExprImpl extends ExpressionImpl implements RecordExpr {
    /**
     * The cached value of the '{@link #getRef() <em>Ref</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRef()
     * @generated
     * @ordered
     */
    protected Expression ref;

    /**
     * The cached value of the '{@link #getRecord() <em>Record</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRecord()
     * @generated
     * @ordered
     */
    protected RecordExpr record;

    /**
     * The cached value of the '{@link #getRec() <em>Rec</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRec()
     * @generated
     * @ordered
     */
    protected Expression rec;

    /**
     * The cached value of the '{@link #getField() <em>Field</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getField()
     * @generated
     * @ordered
     */
    protected Expression field;

    /**
     * The cached value of the '{@link #getTuple() <em>Tuple</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTuple()
     * @generated
     * @ordered
     */
    protected RecordTuple tuple;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RecordExprImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErlangPackage.Literals.RECORD_EXPR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getRef() {
        return ref;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRef(final Expression newRef,
            NotificationChain msgs) {
        final Expression oldRef = ref;
        ref = newRef;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.RECORD_EXPR__REF, oldRef,
                    newRef);
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
    public void setRef(final Expression newRef) {
        if (newRef != ref) {
            NotificationChain msgs = null;
            if (ref != null) {
                msgs = ((InternalEObject) ref)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.RECORD_EXPR__REF, null, msgs);
            }
            if (newRef != null) {
                msgs = ((InternalEObject) newRef)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.RECORD_EXPR__REF, null, msgs);
            }
            msgs = basicSetRef(newRef, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.RECORD_EXPR__REF, newRef, newRef));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RecordExpr getRecord() {
        return record;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRecord(final RecordExpr newRecord,
            NotificationChain msgs) {
        final RecordExpr oldRecord = record;
        record = newRecord;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.RECORD_EXPR__RECORD,
                    oldRecord, newRecord);
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
    public void setRecord(final RecordExpr newRecord) {
        if (newRecord != record) {
            NotificationChain msgs = null;
            if (record != null) {
                msgs = ((InternalEObject) record)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.RECORD_EXPR__RECORD, null, msgs);
            }
            if (newRecord != null) {
                msgs = ((InternalEObject) newRecord)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.RECORD_EXPR__RECORD, null, msgs);
            }
            msgs = basicSetRecord(newRecord, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.RECORD_EXPR__RECORD, newRecord, newRecord));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getRec() {
        return rec;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRec(final Expression newRec,
            NotificationChain msgs) {
        final Expression oldRec = rec;
        rec = newRec;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.RECORD_EXPR__REC, oldRec,
                    newRec);
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
    public void setRec(final Expression newRec) {
        if (newRec != rec) {
            NotificationChain msgs = null;
            if (rec != null) {
                msgs = ((InternalEObject) rec)
                        .eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.RECORD_EXPR__REC, null, msgs);
            }
            if (newRec != null) {
                msgs = ((InternalEObject) newRec)
                        .eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.RECORD_EXPR__REC, null, msgs);
            }
            msgs = basicSetRec(newRec, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.RECORD_EXPR__REC, newRec, newRec));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Expression getField() {
        return field;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetField(final Expression newField,
            NotificationChain msgs) {
        final Expression oldField = field;
        field = newField;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.RECORD_EXPR__FIELD,
                    oldField, newField);
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
    public void setField(final Expression newField) {
        if (newField != field) {
            NotificationChain msgs = null;
            if (field != null) {
                msgs = ((InternalEObject) field).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.RECORD_EXPR__FIELD, null, msgs);
            }
            if (newField != null) {
                msgs = ((InternalEObject) newField).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.RECORD_EXPR__FIELD, null, msgs);
            }
            msgs = basicSetField(newField, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.RECORD_EXPR__FIELD, newField, newField));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RecordTuple getTuple() {
        return tuple;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetTuple(final RecordTuple newTuple,
            NotificationChain msgs) {
        final RecordTuple oldTuple = tuple;
        tuple = newTuple;
        if (eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this,
                    Notification.SET, ErlangPackage.RECORD_EXPR__TUPLE,
                    oldTuple, newTuple);
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
    public void setTuple(final RecordTuple newTuple) {
        if (newTuple != tuple) {
            NotificationChain msgs = null;
            if (tuple != null) {
                msgs = ((InternalEObject) tuple).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.RECORD_EXPR__TUPLE, null, msgs);
            }
            if (newTuple != null) {
                msgs = ((InternalEObject) newTuple).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE
                                - ErlangPackage.RECORD_EXPR__TUPLE, null, msgs);
            }
            msgs = basicSetTuple(newTuple, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ErlangPackage.RECORD_EXPR__TUPLE, newTuple, newTuple));
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
        case ErlangPackage.RECORD_EXPR__REF:
            return basicSetRef(null, msgs);
        case ErlangPackage.RECORD_EXPR__RECORD:
            return basicSetRecord(null, msgs);
        case ErlangPackage.RECORD_EXPR__REC:
            return basicSetRec(null, msgs);
        case ErlangPackage.RECORD_EXPR__FIELD:
            return basicSetField(null, msgs);
        case ErlangPackage.RECORD_EXPR__TUPLE:
            return basicSetTuple(null, msgs);
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
        case ErlangPackage.RECORD_EXPR__REF:
            return getRef();
        case ErlangPackage.RECORD_EXPR__RECORD:
            return getRecord();
        case ErlangPackage.RECORD_EXPR__REC:
            return getRec();
        case ErlangPackage.RECORD_EXPR__FIELD:
            return getField();
        case ErlangPackage.RECORD_EXPR__TUPLE:
            return getTuple();
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
        case ErlangPackage.RECORD_EXPR__REF:
            setRef((Expression) newValue);
            return;
        case ErlangPackage.RECORD_EXPR__RECORD:
            setRecord((RecordExpr) newValue);
            return;
        case ErlangPackage.RECORD_EXPR__REC:
            setRec((Expression) newValue);
            return;
        case ErlangPackage.RECORD_EXPR__FIELD:
            setField((Expression) newValue);
            return;
        case ErlangPackage.RECORD_EXPR__TUPLE:
            setTuple((RecordTuple) newValue);
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
        case ErlangPackage.RECORD_EXPR__REF:
            setRef((Expression) null);
            return;
        case ErlangPackage.RECORD_EXPR__RECORD:
            setRecord((RecordExpr) null);
            return;
        case ErlangPackage.RECORD_EXPR__REC:
            setRec((Expression) null);
            return;
        case ErlangPackage.RECORD_EXPR__FIELD:
            setField((Expression) null);
            return;
        case ErlangPackage.RECORD_EXPR__TUPLE:
            setTuple((RecordTuple) null);
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
        case ErlangPackage.RECORD_EXPR__REF:
            return ref != null;
        case ErlangPackage.RECORD_EXPR__RECORD:
            return record != null;
        case ErlangPackage.RECORD_EXPR__REC:
            return rec != null;
        case ErlangPackage.RECORD_EXPR__FIELD:
            return field != null;
        case ErlangPackage.RECORD_EXPR__TUPLE:
            return tuple != null;
        }
        return super.eIsSet(featureID);
    }

} // RecordExprImpl
