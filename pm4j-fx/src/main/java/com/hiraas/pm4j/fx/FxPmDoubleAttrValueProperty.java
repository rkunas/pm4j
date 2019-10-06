package com.hiraas.pm4j.fx;

import com.hiraas.pm4j.core.PmDoubleAttrImpl;
import javafx.beans.InvalidationListener;
import javafx.beans.property.StringPropertyBase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FxPmDoubleAttrValueProperty extends StringPropertyBase {

    protected static Log log = LogFactory.getLog(FxPmDoubleAttrValueProperty.class);

    private PmDoubleAttrImpl pmAttr;

    private FxPmDoubleAttrValueProperty() {

    }

    public FxPmDoubleAttrValueProperty(PmDoubleAttrImpl pm) {
        this.pmAttr = pm;
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
        Double value = (Double)pmAttr.getValue();
        log.info("Setting to FX " + value);
        return String.valueOf(value);
    }

    @Override
    public void set(String s) {
        log.info("Getting from FX " + s);
        pmAttr.setValue(Double.valueOf(s));
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
