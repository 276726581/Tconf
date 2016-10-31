package com.timogroup.tconf.util;

import org.apache.commons.beanutils.BeanMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TimoRD on 2016/9/22.
 */
public final class BeanMapUtil {

    private BeanMapUtil() {

    }

    public static Map<String, Object> getPropertyMap(Object obj, String... propertyArray) {
        Map<String, Object> map = new HashMap<>();
        BeanMap beanMap = new BeanMap(obj);
        for (String prop : propertyArray) {
            Object property = beanMap.get(prop);
            map.put(prop, property);
        }

        return map;
    }
}
