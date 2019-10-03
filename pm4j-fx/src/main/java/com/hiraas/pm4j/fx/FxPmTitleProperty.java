package com.hiraas.pm4j.fx;

import com.hiraas.pm4j.core.PmImpl;
import com.hiraas.pm4j.core.PmStringAttrImpl;
import javafx.beans.InvalidationListener;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class FxPmTitleProperty extends StringProperty {

    private PmImpl pm;

    public FxPmTitleProperty(PmImpl pm){
        this.pm = pm;
    }


    @Override
    public void bind(ObservableValue<? extends String> observableValue) {

    }

    @Override
    public void unbind() {

    }

    @Override
    public boolean isBound() {
        return false;
    }

    @Override
    public Object getBean() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String get() {
        return pm.getTitle();
    }

    @Override
    public void set(String s) {

    }

    @Override
    public void addListener(ChangeListener<? super String> changeListener) {

    }

    @Override
    public void removeListener(ChangeListener<? super String> changeListener) {

    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }
}
