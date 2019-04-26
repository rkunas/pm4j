package com.hiraas.pm4j.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ramazan on 08.11.14.
 */
public final class PmArrayList<T_ELEMENT extends PmRowImpl> extends ArrayList<T_ELEMENT> implements Serializable {
    // Ist kein zähler der Rows sondern eine Variable um einer Row eine identifizierung zu geben
    private Long rowIdenter = 0L;

    // Dieses teil tantzt was aus der reihe
    private Boolean changed = Boolean.FALSE;

    public PmArrayList() {
        super();
    }

    public Boolean getChanged() {
        return changed;
    }

    @Override
    public boolean add(T_ELEMENT t_element) {
        rowIdenter++;
        changed = Boolean.TRUE;

        t_element.setRowId(rowIdenter);
        return super.add(t_element);
    }

    @Override
    public final boolean remove(Object o) {
        changed = Boolean.TRUE;
        return super.remove(o);
    }

    public void removeRow(T_ELEMENT row) {
        remove(row);
    }

    public void reset() {
        changed = Boolean.FALSE;
    }

    public void moveUp(T_ELEMENT el) {

        final int indexToMove = this.indexOf(el);
        if (indexToMove != 0) {
            Collections.swap(this, indexToMove, indexToMove - 1);
            changed = Boolean.TRUE;
        }

    }

    /**
     * Sollte aufgerufen werden wenn eine veränderung an der Liste ausgeführt wird
     */
    public void writePmAttributes() {
        for (PmRowImpl row : this) {
            row.writePmAttributesImpl();
        }
    }

    public void clear() {
        super.removeAll(this);
        super.clear();
    }

    public void moveDown(T_ELEMENT el) {

        final int indexToMove = this.indexOf(el);

        if (indexToMove != size() - 1) {
            Collections.swap(this, indexToMove, indexToMove + 1);
            changed = Boolean.TRUE;
        }

    }

    public final Long getRowIndenter() {
        return rowIdenter;
    }

    public final void setRowIdenter(Long counter) {
        this.rowIdenter = counter;
    }
}
