package eu.kunas.pm4j;

import java.io.Serializable;

/**
 * Created by kunasra on 26.01.15.
 */
public class PmBooleanAttrImpl<T_PM_PARENT> extends PmAttrImpl<T_PM_PARENT, Boolean> implements Serializable {
    public PmBooleanAttrImpl(T_PM_PARENT parent) {
        super(parent);
    }

    @Override
    protected void changeCheck(Boolean originVal, Boolean newVal) {
        log.info("Checking " + getTitle());
        if (newVal == null && originVal == null) {
            log.info("Both null: " + newVal + " " + originVal);
            return;
        }

        if (newVal == null && originVal != null) {
            log.info("New Value is null: " + newVal + " " + originVal);
            changed = Boolean.TRUE;
            return;
        }

        if (newVal != null && originVal == null) {
            log.info("Origin is null: " + newVal + " " + originVal);
            changed = Boolean.TRUE;
            return;
        }

        if (!newVal.equals(originVal)) {
            log.info("Different: " + newVal + " " + originVal);
            changed = Boolean.TRUE;
        }
    }
}
