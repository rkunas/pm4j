package eu.kunas.pm4j.core;


import eu.kunas.pm4j.utils.BeanReadWriteUtil;

import java.io.Serializable;

/**
 * Diese Klasse enthaelt das Basis Objekt
 * Es ist wie eine art schlüsselobjekt. Auf diesem Objekt wird zwar gearbeitet,
 * aber die klasse welche von dieser klasse erbt kann die Childs losgelöst aufbehwaren
 * <p/>
 * Eine Bean stellt ein Komplexes Objekt dar
 * <p/>
 * Created by ramazan on 23.10.14
 */
public abstract class PmBeanImpl<T_PM_PARENT, T_PM_BEAN> extends PmImpl<T_PM_PARENT> implements Serializable {

    protected T_PM_BEAN pmBean;

    public PmBeanImpl(T_PM_PARENT parent) {
        super(parent);
    }

    public PmBeanImpl() {

    }

    /**
     * gibt das pmBean zurück ohne es mit den aktuellen attributen zu befüllen
     *
     * @return
     */
    public T_PM_BEAN getPmBeanWithoutAttrRead() {
        return pmBean;
    }

    /**
     * Füllt die Attribute vom PmBean
     */
    public void writePmAttributesImpl() {
        BeanReadWriteUtil readObject = new BeanReadWriteUtil<T_PM_BEAN>();
        readObject.readBeanToPms(pmBean, this);
    }

    public Boolean getChanged() {
        return Boolean.FALSE;
    }

    /**
     * Methode kann werwendet überschrieben werden um die Attribute zurückzu setzen es wird nach dem WriteAttributes aufgerufen
     */
    protected void resetImpl() {

    }

    public final void reset() {
        resetImpl();
    }

    /**
     * Füllt das PmBean mit den Werten des Attributes
     */
    public void readPmAttributesImpl() {
        BeanReadWriteUtil readObject = new BeanReadWriteUtil<T_PM_BEAN>();
        readObject.readPmsToBean(this, pmBean);
    }

    public final T_PM_BEAN getPmBean() {
        readPmAttributesImpl();
        return pmBean;
    }

    public void setPmBean(T_PM_BEAN pmBean) {
        // Das Bean setzen
        this.pmBean = pmBean;

        // Die Attribute setzen
        this.writePmAttributesImpl();

        // Reset der Attrbute Meta Daten
        this.reset();
    }
}
