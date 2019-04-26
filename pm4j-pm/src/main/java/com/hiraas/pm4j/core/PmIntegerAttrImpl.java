package com.hiraas.pm4j.core;

import java.io.Serializable;

/**
 * Created by kunasra on 26.11.14.
 */
public class PmIntegerAttrImpl<T_PM_PARENT extends PmImpl> extends PmAttrImpl<T_PM_PARENT, Integer> implements Serializable {

    public PmIntegerAttrImpl(T_PM_PARENT parent) {
        super(parent);
    }

    @Override
    protected void changeCheck(Integer originVal, Integer newVal) {
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

    @Override
    protected Boolean validateImpl() {
        if (!getRequired()) {
            return true;
        }
        if (value == null) {
            log.info(getTitle() + "Wert ist erforderlich");
            return false;
        }

        return true;
    }
}
