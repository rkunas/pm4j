package eu.kunas.pm4j;

import java.io.Serializable;

/**
 * Dieses PM stellt ein Auswahl Element dar. Er kann als Option in einem Attribut verwendet werden
 *
 * Created by kunasra on 08.12.14.
 */
public class PmOption<T_PM_BEAN> implements Serializable {
    public T_PM_BEAN value;
    public String label;

    public PmOption(T_PM_BEAN object, String label) {
        this.value = object;
        this.label = label;
    }
    public PmOption() {

    }

    public T_PM_BEAN getValue() {
        return value;
    }

    public void setValue(T_PM_BEAN value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
