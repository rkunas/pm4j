package eu.kunas.pm4j.utils;

import eu.kunas.pm4j.core.PmAttrImpl;
import eu.kunas.pm4j.core.PmBeanImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Schreibt und liest von und zu der Bean und dem PM
 * <p/>
 * Created by Kunas on 03.07.2015.
 */
public class BeanReadWriteUtil<T_BEAN> {

    public final String GET = "get";

    protected static Log log = LogFactory.getLog(BeanReadWriteUtil.class);

    public void readBeanToPms(T_BEAN bean, PmBeanImpl pm) {
        if (bean == null) {
            return;
        }
        if (pm == null) {
            return;
        }
        try {
            Field[] pmFields = pm.getClass().getDeclaredFields();

            for (Field pmField : pmFields) {
                if (PmAttrImpl.class.isAssignableFrom(pmField.getType())) {
                    PmAttrImpl pmAttr = (PmAttrImpl) pmField.get(pm);
                    Object beanFieldValue = getBeanFieldValue(bean, pmField);
                    if (beanFieldValue != null) {
                        pmAttr.setValue(beanFieldValue);
                    }

                }
            }
        } catch (NoSuchFieldException exc) {
            log.error("Unable to get field from bean " + bean.getClass().toString());
        } catch (IllegalAccessException exc) {
            // TODO: Wodurch wird diese Exception genau ausgel�st ?
            log.error("IllegalAccess " + exc.getMessage());
        }
    }

    private Object getBeanFieldValue(T_BEAN bean, Field pmField) throws NoSuchFieldException, IllegalAccessException {
        Method beanFieldMethod = null;
        String methodNameString = null;
        Object methodsValue = null;

        try {
            methodNameString = buildGetterMethodName(pmField);
            beanFieldMethod = bean.getClass().getMethod(methodNameString);
            methodsValue = beanFieldMethod.invoke(bean);
            return methodsValue;

        } catch (NoSuchMethodException exc) {
            log.error("Metod " + methodNameString + " not found on Bean " + bean.getClass().toString() + ". Please check the Bean, it has to follow Java Code Style for getter Methods");

        } catch (InvocationTargetException exc) {
            log.error("Method " + methodNameString + " not possible to invoke");

        } finally {
            return methodsValue;
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
}
