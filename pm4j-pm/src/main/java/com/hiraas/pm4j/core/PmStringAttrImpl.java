package com.hiraas.pm4j.core;

import com.hiraas.pm4j.middletier.FeedbackBucket;

import java.io.Serializable;

/**
 * Created by kunasra on 26.11.14.
 */
public class PmStringAttrImpl<T_PM_PARENT extends PmImpl> extends PmAttrImpl<T_PM_PARENT, String> implements Serializable {
    public PmStringAttrImpl(T_PM_PARENT parent) {
        super(parent);
    }

    @Override
    public Class getPmAttrType() {
        return String.class;
    }

    @Override
    protected void changeCheck(String originVal, String newVal) {
        if (originVal == null && newVal == null) {
            return;
        }
        if (originVal == null && newVal != null) {
            if (newVal != null & newVal == "") {
                return;
            } else {
                changed = Boolean.TRUE;
                return;
            }
        }

        if (originVal != null && newVal == null) {
            if (originVal != null & originVal == "") {
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
    protected Boolean validateImpl(FeedbackBucket feedbackBucket) {
        if (!getRequired()) {
            return true;
        }
        if (value == null) {
            // TODO: Fehler Liste sammeln
            log.info(getTitle() + "Wert ist erforderlich");
            return false;
        }
        if (value != null & value == "") {
            log.info(getTitle() + "Wert ist erforderlich");
            return false;
        }

        return true;
    }
}
