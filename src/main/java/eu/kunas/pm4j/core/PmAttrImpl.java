package eu.kunas.pm4j.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Created by ramazan on 02.11.14.
 */
public class PmAttrImpl<T_PM_PARENT, T_PM_BEAN extends Object> extends PmImpl<T_PM_PARENT> implements Serializable {

    protected static Log log = LogFactory.getLog(PmAttrImpl.class);
    protected Boolean changed = Boolean.FALSE;
    protected T_PM_BEAN value;
    protected T_PM_BEAN defaultValue;

    public PmAttrImpl(T_PM_PARENT parent) {
        super(parent);
    }

    public T_PM_BEAN getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(T_PM_BEAN defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Class getPmAttrType() {
        Type c1 = getClass().getGenericSuperclass();
        ParameterizedType c2 = (ParameterizedType)c1;

        Class beanClassofPm = null;

        if(c2.getActualTypeArguments().length == 2) {
             beanClassofPm = (Class) c2.getActualTypeArguments()[1];
        }
        if(c2.getActualTypeArguments().length == 1) {
             beanClassofPm = (Class) c2.getActualTypeArguments()[0];
        }

        return beanClassofPm;
    }

    /**
     * Das ist eine spezialmethode um die PmOptions in ein SelectItem zu convertieren
     * @return
     */
    /** public final SelectItem[] getJsfOptions() {

     // TODO: Evt eine Utility bauen um die PmOption Liste Erstellung was zu vereinfachen
     List<PmOption> pmOptionList = getPmOptions();

     List<SelectItem> selectItemList = new ArrayList<SelectItem>();

     for (PmOption pmOption : pmOptionList) {
     SelectItem item = new SelectItem(pmOption.getValue(), pmOption.getLabel());
     selectItemList.add(item);
     }

     // Sortierung evt brauchbar auch zum einschalten und auschalten
     SortUtil.resortSelectItemsByLabel(selectItemList);
     return selectItemList.toArray(new SelectItem[selectItemList.size()]);
     } **/

    /**
     * Liefert eine leere liste falls es nicht überschrieben wird
     *
     * @return
     */
    public List<PmOption> getPmOptions() {
        return Collections.emptyList();
    }

    public Boolean getChanged() {
        return changed;
    }

    public final T_PM_BEAN getValue() {
        if (value == null) {
            value = getDefaultValue();
        }
        return value;
    }

    public final void setValue(T_PM_BEAN value1) {
        T_PM_BEAN value2 = beforeValueSetImpl(value1);
        beforeValueSetImpl();
        changeCheck(this.value, value2);
        this.value = value2;
        afterValueSetImpl();
    }

    /**
     * Diese Methode kann überschrieben werden. Hier in dieser Methode kann der Wert verändert werden falls es irgendwie verfälscht wird
     */
    public T_PM_BEAN beforeValueSetImpl(T_PM_BEAN val) {
        return val;
    }

    /**
     * Diese Methode kann überschrieben werden von der jeweiligen Speziellisierten inner class
     */
    public void beforeValueSetImpl() {

    }

    /**
     * Methode wird nach den Setzen des Values aufgerufen
     */
    public void afterValueSetImpl() {

    }


    public void reset() {
        changed = Boolean.FALSE;
    }

    /**
     * Prüft ob eine Veränderung des Wertes vorliegt
     *
     * @param originVal
     * @param newVal
     */
    protected void changeCheck(T_PM_BEAN originVal, T_PM_BEAN newVal) {

        if (value instanceof String) {

            String newValString = (String) newVal;
            String originValString = (String) originVal;

            if (originValString == null && newValString == null) {
                return;
            }
            if (originValString == null && newValString != null) {
                if (newValString.isEmpty()) {
                    return;
                } else {
                    changed = Boolean.TRUE;
                    return;
                }
            }

            if (originValString != null && newValString == null) {
                if (originValString.isEmpty()) {
                    return;
                } else {
                    changed = Boolean.TRUE;
                    return;
                }
            }

            if (!newValString.equals(originValString)) {
                changed = Boolean.TRUE;
            }
        } else {

            // log.info("Checking " + getTitle());
            if (newVal == null && originVal == null) {
                //   log.info("Both null: " + newVal + " " + originVal);
                return;
            }

            if (newVal == null && originVal != null) {
                //   log.info("New Value is null: " + newVal + " " + originVal);
                changed = Boolean.TRUE;
                return;
            }

            if (newVal != null && originVal == null) {
                // log.info("Origin is null: " + newVal + " " + originVal);
                changed = Boolean.TRUE;
                return;
            }

            if (!newVal.equals(originVal)) {
                //log.info("Different: " + newVal + " " + originVal);
                changed = Boolean.TRUE;
            }
        }
    }
}