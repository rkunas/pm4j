package eu.kunas.pm4j.core;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.Serializable;

/**
 * Created by ramazan on 20.11.14.
 */
public class PmDateTimeAttrImpl<T_PM_PARENT> extends PmAttrImpl<T_PM_PARENT, DateTime> implements Serializable {

    private DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm:ss MM.dd.yyy");
    private String stringValue;

    public PmDateTimeAttrImpl(T_PM_PARENT parent) {
        super(parent);
    }

    public String getStringValue() {
        if (getValue() != null) {
            stringValue = formatter.print(getValue());
        } else {
            stringValue = formatter.print(new DateTime());
        }
        return stringValue;
    }

    public void setStringValue(String val) {
        this.stringValue = val;
        setValue(stringToDateTime(val));
    }

    private final DateTime stringToDateTime(String s) {
        return formatter.parseDateTime(s);
    }
}
