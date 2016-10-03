package com.creationguts.needle.model;

import java.io.Serializable;

/**
 * Base class for value objects
 * Created by Juliano on 10/1/16.
 */
public abstract class BaseVO<T extends Serializable> {

    public BaseVO(T id) {
        setId(id);
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    private T id;
}
