package eu.kunas.pm4j.utils;

import eu.kunas.pm4j.core.PmAttrImpl;
import eu.kunas.pm4j.core.PmBeanImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;

/**
 * Created by Kunas on 03.07.2015.
 */
public class BeanReadWriteUtil<T_BEAN> {

    protected static Log log = LogFactory.getLog(BeanReadWriteUtil.class);

    public void read(T_BEAN bean, PmBeanImpl pm) {
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
                    Field beanField = bean.getClass().getField(pmField.getName());
                    pmAttr.setValue(beanField.get(bean));
                }
            }
        } catch (NoSuchFieldException exc) {
            log.error("Unable to get field from bean " + bean.getClass().toString());
        } catch (IllegalAccessException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
