package com.hiraas.pm4j.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;

/**
 * Created by ramazan on 03.11.14.
 */
public abstract class PmCommandImpl<T_PM_PARENT extends PmImpl> extends PmImpl<T_PM_PARENT> implements Serializable {

    private static Log log = LogFactory.getLog(PmCommandImpl.class);

    public PmCommandImpl(final T_PM_PARENT parent) {
        super(parent);
    }

    public final void doIt() {
        log.info(getPmParent().getClass().getSimpleName() + " - doIt");
        log.info(getPmParent().getClass().getSimpleName() + " - Validiere vor doIt");
        validate();
        log.info(getPmParent().getClass().getSimpleName() + " - Validierung abgeschlossen");
        if (getValid()) {
            log.info(getPmParent().getClass().getSimpleName() + " - Pm Command " + getTitle() + " ist valide");
            beforeDoIt();
            doItImpl();
            afterDoIt();
        } else {
            log.info(getPmParent().getClass().getSimpleName() + " - Pm Command " + getTitle() + " ist nicht valide");
        }
    }

    protected abstract void doItImpl();

    /**
     * Zum überschreiben durch den Entwickler
     */
    public void afterDoItImpl() {

    }

    protected final void afterDoIt(){
        afterDoItImpl();
    }

    public void beforeDoItImpl(){

    }

    protected final void beforeDoIt(){
        beforeDoItImpl();
    }




}
