package eu.kunas.pm4j;

import java.io.Serializable;

/**
 * Created by kunasra on 26.11.14.
 */
public class PmStringAttrImpl<T_PM_PARENT> extends PmAttrImpl<T_PM_PARENT, String> implements Serializable {
    public PmStringAttrImpl(T_PM_PARENT parent) {
        super(parent);
    }

    @Override
    protected void changeCheck(String originVal, String newVal) {
        if (originVal == null && newVal == null) {
            return;
        }
        if (originVal == null && newVal != null) {
            if (newVal.isEmpty()) {
                return;
            } else {
                changed = Boolean.TRUE;
                return;
            }
        }

        if (originVal != null && newVal == null) {
            if (originVal.isEmpty()) {
                return;
            } else {
                changed = Boolean.TRUE;
                return;
            }
        }

        if (!newVal.equals(originVal)) {
            changed = Boolean.TRUE;
        }
    }

    @Override
    protected Boolean validateImpl() {
        if (!getRequired()) {
            return true;
        }
        if (value == null) {
            // TODO: Fehler Liste sammeln
            log.info(getTitle() + "Wert ist erforderlich");
            return false;
        }
        if (value.isEmpty()) {
            log.info(getTitle() + "Wert ist erforderlich");
            return false;
        }

        return true;
    }
}
