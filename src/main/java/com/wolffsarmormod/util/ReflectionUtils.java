package com.wolffsarmormod.util;

import java.lang.reflect.Field;

public class ReflectionUtils
{
    private ReflectionUtils() {}

    public static <T> Object getValue(String fieldName, Class<T> clazz, T instance, Object defaultValue) {
        try
        {
            Field privateField = clazz.getDeclaredField(fieldName);
            privateField.setAccessible(true);
            return privateField.get(instance);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    public static <T> int getIntValue(String fieldName, Class<T> clazz, T instance, int defaultValue) {
        if (getValue(fieldName, clazz, instance, defaultValue) instanceof Integer intValue) {
            return intValue;
        }
        return defaultValue;
    }

    public static <T> float getFloatValue(String fieldName, Class<T> clazz, T instance, float defaultValue) {
        if (getValue(fieldName, clazz, instance, defaultValue) instanceof Float floatValue) {
            return floatValue;
        }
        return defaultValue;
    }

    public static <T> double getDoubleValue(String fieldName, Class<T> clazz, T instance, double defaultValue) {
        if (getValue(fieldName, clazz, instance, defaultValue) instanceof Double doubleValue) {
            return doubleValue;
        }
        return defaultValue;
    }

    public static <T> boolean getBooleanValue(String fieldName, Class<T> clazz, T instance, boolean defaultValue) {
        if (getValue(fieldName, clazz, instance, defaultValue) instanceof Boolean booleanValue) {
            return booleanValue;
        }
        return defaultValue;
    }
}
