package eu.kunas.pm4j;


import java.io.Serializable;

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
public class PmImpl<T_PM_PARENT> implements Serializable {

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

    public PmImpl(T_PM_PARENT parent) {
        this.pmParent = parent;
    }

    public PmImpl() {

    }

    public Boolean getRequired() {
        return required;
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
        setValid(validateImpl());
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
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
