package com.wolffsarmormod.client.model;

import com.wolffsarmormod.common.types.InfoType;
import com.wolffsmod.client.model.IModelBase;

public interface IFlanModel<T extends InfoType> extends IModelBase
{
    void setType(T type);
}
