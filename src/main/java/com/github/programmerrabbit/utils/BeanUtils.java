package com.github.programmerrabbit.utils;

import com.github.programmerrabbit.test.Assert;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by yangwen on 2016/12/3.
 */
public class BeanUtils {
    public static void copyProperties(Object source, Object target) {
        Assert.isNotNull(source, "[BeanUtils] source can't be null - rabbit");
        Assert.isNotNull(target, "[BeanUtils] target can't be null - rabbit");

        try {
            BeanInfo sourceBeanInfo = Introspector.getBeanInfo(source.getClass());
            PropertyDescriptor[] sourcePDs = sourceBeanInfo.getPropertyDescriptors();
            Map<String, PropertyDescriptor> sourcePDMap = MapUtils.newHashMap();
            for (PropertyDescriptor sourcePD : sourcePDs) {
                sourcePDMap.put(sourcePD.getName(), sourcePD);
            }

            BeanInfo targetBeanInfo = Introspector.getBeanInfo(target.getClass());
            PropertyDescriptor[] targetPDs = targetBeanInfo.getPropertyDescriptors();

            for (PropertyDescriptor targetPD : targetPDs) {
                if (!"class".equals(targetPD.getName())) {
                    PropertyDescriptor sourcePD = sourcePDMap.get(targetPD.getName());
                    if (sourcePD != null && sourcePD.getReadMethod() != null) {
                        Method readMethod = sourcePD.getReadMethod();
                        Object value = readMethod.invoke(source);
                        Method writeMethod = targetPD.getWriteMethod();
                        writeMethod.invoke(target, value);
                    }
                }
            }
        } catch (Throwable throwable) {
            throw new RuntimeException("[BeanUtils] can't copy properties from source to target - rabbit", throwable);
        }
    }
}
