package com.hiraas.pm4j.core;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Diese klasse stellt ein minimales pm dar.
 * Alle Pms sind sozusagen durch ein parent miteinander verbunden.
 * <p>
 * Diese Klasse kann von komplexeren PMs sowie von kleinen Attributen geerbt werden
 * <p>
 * Bei der Instanziierung kann es mit und ohne ein Parent Instanziiert werden
 * <p>
 * Created by ramazan on 24.10.14.
 */
public class PmImpl<T_PM_PARENT extends PmImpl> implements Serializable {

    protected static Log log = LogFactory.getLog(PmImpl.class);

    //Drückt aus ob ein pm gültig ist
    private Boolean valid = Boolean.TRUE;
    // Drückt die Sichtbarkeit in einer Maske aus
    private Boolean visible = Boolean.TRUE;
    // Drückt aus ob das PM Aktiv ist, editierbar ist
    private Boolean enabled = Boolean.TRUE;
    // Gibt an ob das Value gefuellt sein muss
    private Boolean required;
    // Im idealfall hat das entsprechende UI Widget ein Label welches dieses Feld liest
    private String title = "DEFAULT_TITLE";
    // Eltern Element
    private T_PM_PARENT pmParent;

    // Liste der Kind Pms
    protected List<PmImpl> childs = new ArrayList<>(0);

    public PmImpl(T_PM_PARENT parent) {
        this.pmParent = parent;
        this.addThisAsChildToParent(parent, this);
    }

    /**
     * Fügt diese instanz in die Liste der Childs im Parent Objekt hinzu
     *
     * @param parent
     * @param child
     */
    protected void addThisAsChildToParent(PmImpl parent, PmImpl child) {
        parent.childs.add(child);
    }

    public PmImpl() {

    }

    public final Boolean getRequired() {
        Boolean returnOfRequiredImpl = getRequiredImpl();
        if(returnOfRequiredImpl != null){
            required = returnOfRequiredImpl;
        }
        return required;
    }

    public Boolean getRequiredImpl(){
        return null;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Stößt irgendeine art von validierung an
     */
    public final void validate() {
        Boolean returnOfValidateImpl = validateImpl();
        setValid(returnOfValidateImpl);
    }

    /**
     * Implementierung einer Speziellen Validate methode
     * Default verhalten der Methode ist das das jeweilige pmold valide ist
     *
     * @return
     */
    protected Boolean validateImpl() {
        return Boolean.TRUE;
    }

    public final Boolean getValid() {
        return valid;
    }

    public final void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Boolean getEnabledImpl() {
        return null;
    }

    public final Boolean getEnabled() {
        Boolean enabledFromImpl = getEnabledImpl();
        if (enabledFromImpl != null) {
            enabled = enabledFromImpl;
        }
        return enabled;
    }

    public final void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public T_PM_PARENT getPmParent() {
        return pmParent;
    }
}
