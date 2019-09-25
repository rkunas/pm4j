package com.hiraas.pm4j;

import com.hiraas.pm4j.core.PmCommandImpl;
import com.hiraas.pm4j.core.PmImpl;
import com.hiraas.pm4j.core.PmRoot;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class PmRestCommand<T_PM extends PmRoot> extends PmRest {

    public void doIt(HttpServletRequest httpServletRequest, T_PM pm ) {

        String fullPath = (String) httpServletRequest.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

        List<String> steps = Arrays.asList(fullPath.split("/"));
        steps = steps.subList(2, steps.size());
        steps = steps.subList(0, steps.size() - 1);

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
            Method method = current.getClass().getMethod("doIt");
            method.invoke(current);
        } catch (NoSuchMethodException exc) {
            exc.printStackTrace();
        } catch (IllegalAccessException exc) {
            exc.printStackTrace();
        } catch (InvocationTargetException exc) {
            exc.printStackTrace();
        }

    }




}
