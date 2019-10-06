package com.hiraas.pm4j.fx;

import com.hiraas.pm4j.core.PmStringAttrImpl;
import javafx.beans.InvalidationListener;
import javafx.beans.property.StringPropertyBase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FxPmStringAttrValueProperty extends StringPropertyBase {

    protected static Log log = LogFactory.getLog(FxPmStringAttrValueProperty.class);

    private PmStringAttrImpl pmAttr;

    private FxPmStringAttrValueProperty() {

    }

    public FxPmStringAttrValueProperty(PmStringAttrImpl pm) {
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
        String value = (String) pmAttr.getValue();
        log.info("Setting to FX " + value);
        return value;
    }

    @Override
    public void set(String s) {
        log.info("Getting from FX " + s);
        pmAttr.setValue(s);
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
