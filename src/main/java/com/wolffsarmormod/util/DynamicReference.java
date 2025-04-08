package com.wolffsarmormod.util;

public class DynamicReference
{
    private String value;

    public DynamicReference(String value)
    {
        this.value = value;
    }

    public String get()
    {
        return value;
    }

    public void update(String newValue)
    {
        value = newValue;
    }
}
