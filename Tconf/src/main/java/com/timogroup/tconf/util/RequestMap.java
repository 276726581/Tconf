package com.timogroup.tconf.util;

import com.timogroup.tconf.exception.BadRequestException;
import org.apache.commons.lang.math.NumberUtils;

import java.util.Map;

/**
 * Created by TimoRD on 2016/10/31.
 */
public class RequestMap {

    private Map<String, String> map;

    public RequestMap(Map<String, String> map) {
        this.map = map;
    }

    public String getAsString(String key) {
        String val = map.get(key);
        if (null == val) {
            throw new BadRequestException(String.format("Required String parameter '%s' is not present", key));
        }

        return val;
    }

    public int getAsInt(String key) {
        String val = getAsString(key);
        int value = NumberUtils.toInt(val);
        return value;
    }

    public short getAsShort(String key) {
        String val = getAsString(key);
        short value = NumberUtils.toShort(val);
        return value;
    }

    public long getAsLong(String key) {
        String val = getAsString(key);
        long value = NumberUtils.toLong(val);
        return value;
    }

    public byte getAsByte(String key) {
        String val = getAsString(key);
        byte value = NumberUtils.toByte(val);
        return value;
    }

    public float getAsFloat(String key) {
        String val = getAsString(key);
        float value = NumberUtils.toFloat(val);
        return value;
    }

    public double getAsDouble(String key) {
        String val = getAsString(key);
        double value = NumberUtils.toDouble(val);
        return value;
    }

    public int getAsInt(String key, int defaultValue) {
        String val = map.get(key);
        int value = NumberUtils.toInt(val, defaultValue);
        return value;
    }

    public short getAsShort(String key, short defaultValue) {
        String val = map.get(key);
        short value = NumberUtils.toShort(val, defaultValue);
        return value;
    }

    public long getAsLong(String key, long defaultValue) {
        String val = map.get(key);
        long value = NumberUtils.toLong(val, defaultValue);
        return value;
    }

    public byte getAsByte(String key, byte defaultValue) {
        String val = map.get(key);
        byte value = NumberUtils.toByte(val, defaultValue);
        return value;
    }

    public float getAsFloat(String key, float defaultValue) {
        String val = map.get(key);
        float value = NumberUtils.toFloat(val, defaultValue);
        return value;
    }

    public double getAsDouble(String key, double defaultValue) {
        String val = map.get(key);
        double value = NumberUtils.toDouble(val, defaultValue);
        return value;
    }
}
