package com.hiraas.pm4j.core;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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

    private PmFeedback pmFeedback = new PmFeedback();

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
        if (returnOfRequiredImpl != null) {
            required = returnOfRequiredImpl;
        }
        return required;
    }

    public Boolean getRequiredImpl() {
        return null;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getTitle() {
        // der Title wird gesetzt wenn vorhanden
        new PmTitleAnnotationUtil().invoke();
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Stößt validierung an.
     */
    public final void validate() {
        PmFeedback newFeedbackContainer = new PmFeedback();
        Boolean returnOfValidateImpl = validateImpl(newFeedbackContainer);
        this.pmFeedback = newFeedbackContainer;
        setValid(returnOfValidateImpl);
    }

    /**
     * Implementierung einer Speziellen Validate methode
     * Default verhalten der Methode ist das das jeweilige pmold valide ist
     *
     * @return
     */
    protected Boolean validateImpl(PmFeedback feedback) {
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

    protected T_PM_PARENT getPmParent() {
        return pmParent;
    }

    /**
     * Sucht nach einer PmTitle Annotation und setzt den Title
     */
    private class PmTitleAnnotationUtil {
        public void invoke() {

            if (pmParent == null) {
                return;
            }

            Arrays.stream(pmParent.getClass().getDeclaredFields()).forEach(field -> {

                if (!field.isAnnotationPresent(PmTitle.class)) {
                    return;
                }

                try {
                    PmImpl pm = (PmImpl) field.get(getPmParent());
                    if (pm.equals(PmImpl.this)) {
                        PmTitle title = field.getAnnotation(PmTitle.class);
                        PmImpl.this.title = title.value();
                        log.info(pmParent.getClass().getSimpleName() + " - Title of " + field.getName() + " is " + title.value());
                    }

                } catch (IllegalAccessException exc) {
                    log.error(exc);
                }
            });

        }
    }
}
