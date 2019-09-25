package com.hiraas.pm4j;

import com.hiraas.pm4j.core.PmRoot;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class PmRestValue<T_PM extends PmRoot> extends PmRest {


    public void setValue(HttpServletRequest httpServletRequest, T_PM pm, String pmVal) {
        String fullPath = (String) httpServletRequest.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

        List<String> steps = Arrays.asList(fullPath.split("/"));
        String value = steps.get(steps.size()-1);
        steps = steps.subList(2, steps.size());
        steps = steps.subList(0, steps.size() - 2);

        Object current = pm;

        for (String fieldString : steps) {
            try {
                Field field = getDeclaredField(current.getClass(), fieldString);
                current = field.get(current);

            } catch (IllegalAccessException exc) {
                exc.printStackTrace();
            }
        }

        try {
            Method method = current.getClass().getMethod("setValue",Object.class);
            method.invoke(current,value);
        } catch (NoSuchMethodException exc) {
            exc.printStackTrace();
        } catch (IllegalAccessException exc) {
            exc.printStackTrace();
        } catch (InvocationTargetException exc) {
            exc.printStackTrace();
        }
    }
}
