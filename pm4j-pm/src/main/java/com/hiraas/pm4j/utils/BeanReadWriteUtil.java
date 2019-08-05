package com.hiraas.pm4j.utils;

import com.hiraas.pm4j.core.PmAttrImpl;
import com.hiraas.pm4j.core.PmBeanImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Schreibt und liest von und zu der Bean und dem PM
 * <p>
 * Created by Kunas on 03.07.2015.
 */
public class BeanReadWriteUtil<T_BEAN> {

    public final String GET = "get";
    public final String SET = "set";

    protected static Log log = LogFactory.getLog(BeanReadWriteUtil.class);

    public void readPmsToBean(PmBeanImpl pm, T_BEAN bean) {
        if (pm == null) {
            return;
        }
        if (bean == null) {
            return;
        }

        Field[] pmFields = pm.getClass().getDeclaredFields();

        for (Field pmField : pmFields) {
            if (PmAttrImpl.class.isAssignableFrom(pmField.getType())) {
                setBeanFieldValue(bean, pmField, pm);

            }
        }

    }

    public void readBeanToPms(T_BEAN bean, PmBeanImpl pm) {
        if (bean == null) {
            return;
        }
        if (pm == null) {
            return;
        }
        Field[] pmFields = pm.getClass().getDeclaredFields();

        for (Field pmField : pmFields) {
            if (PmAttrImpl.class.isAssignableFrom(pmField.getType())) {
                getBeanFieldValue(bean, pmField, pm);
            }
        }
    }

    private void setBeanFieldValue(T_BEAN bean, Field pmField, PmBeanImpl pm) {
        String methodNameString = null;
        Method beanFieldMethod = null;
        try {
            PmAttrImpl pmAttr = (PmAttrImpl) pmField.get(pm);

            methodNameString = buildSetterMethodName(pmField);

            beanFieldMethod = bean.getClass().getMethod(methodNameString,pmAttr.getPmAttrType());

            beanFieldMethod.invoke(bean, pmAttr.getValue());
        } catch (IllegalAccessException exc) {
            log.error("Pm field not found " + pmField.getName());
        } catch (NoSuchMethodException exc) {
            log.error("Method " + methodNameString + " not found on Bean" + bean.getClass().toString() + ". Please check the Bean, it has to follow Java Code Styls for setter Methods.");
        } catch (InvocationTargetException exc) {
            log.error("Not possible to invoke Bean " + bean.getClass() + " at Method " + methodNameString);
        }
    }

    private void getBeanFieldValue(T_BEAN bean, Field pmField, PmBeanImpl pm) {
        Method beanFieldMethod = null;
        String methodNameString = null;
        Object methodsValue = null;

        try {

            PmAttrImpl pmAttr = (PmAttrImpl) pmField.get(pm);
            methodNameString = buildGetterMethodName(pmField);
            beanFieldMethod = bean.getClass().getMethod(methodNameString);
            methodsValue = beanFieldMethod.invoke(bean);

            if (methodsValue != null) {
                pmAttr.setValue(methodsValue);
            }

        } catch (NoSuchMethodException exc) {
            log.error("Metod " + methodNameString + " not found on Bean " + bean.getClass().toString() + ". Please check the Bean, it has to follow Java Code Style for getter Methods.");

        } catch (InvocationTargetException exc) {
            log.error("Method " + methodNameString + " not possible to invoke");
        } catch (IllegalAccessException exc) {
            log.error("Pm field not found " + pmField.getName());
        }
    }

    private String buildGetterMethodName(Field pmField) {

        StringBuilder methodNameStringBuilder = new StringBuilder();

        String fieldNameFirstCharUpperCase = pmField.getName().substring(0, 1).toUpperCase();
        String fieldNameWithoutFirstChar = pmField.getName().substring(1, pmField.getName().length());

        methodNameStringBuilder.append(GET);
        methodNameStringBuilder.append(fieldNameFirstCharUpperCase);
        methodNameStringBuilder.append(fieldNameWithoutFirstChar);

        return methodNameStringBuilder.toString();
    }

    private String buildSetterMethodName(Field pmField) {

        StringBuilder methodNameStringBuilder = new StringBuilder();

        String fieldNameFirstCharUpperCase = pmField.getName().substring(0, 1).toUpperCase();
        String fieldNameWithoutFirstChar = pmField.getName().substring(1, pmField.getName().length());

        methodNameStringBuilder.append(SET);
        methodNameStringBuilder.append(fieldNameFirstCharUpperCase);
        methodNameStringBuilder.append(fieldNameWithoutFirstChar);

        return methodNameStringBuilder.toString();
    }
}
