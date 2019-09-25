package com.hiraas.pm4j;

import java.lang.reflect.Field;

public abstract class PmRest {

    protected Field getDeclaredField(Class clazz, String field) {
        for (Field f : clazz.getDeclaredFields()) {
            if (f.getName().toLowerCase().equals(field)) {
                return f;
            }
        }
        return null;
    }
}
