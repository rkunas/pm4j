package eu.kunas.pm4j.core;

/*
 * Copyright (c) 2014. THINKERLAB
 */

import java.io.Serializable;

/**
 * Created by ramazan on 24.10.14.
 */
public class PmRowImpl<T_PARENT, T_PM_BEAN> extends PmBeanImpl<T_PARENT, T_PM_BEAN> implements Serializable {

    private Long rowId;

    public PmRowImpl(T_PARENT parent) {
        super(parent);
    }

    public final Long getRowId() {
        return rowId;
    }

    public final void setRowId(Long rowId) {
        this.rowId = rowId;
    }
}
