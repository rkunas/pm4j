package com.hiraas.pm4j.core;

import com.hiraas.pm4j.middletier.FeedbackBucket;

import java.io.Serializable;

/**
 * Created by kunasra on 26.11.14.
 */
public class PmDoubleAttrImpl<T_PM_PARENT extends PmImpl> extends PmAttrImpl<T_PM_PARENT, Double> implements Serializable {

    public PmDoubleAttrImpl(T_PM_PARENT parent) {
        super(parent);
    }

    @Override
    public Class getPmAttrType() {
        return Double.class;
    }

    @Override
    protected void changeCheck(Double originVal, Double newVal) {
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
    protected Boolean validateImpl(FeedbackBucket feedbackBucket) {
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
