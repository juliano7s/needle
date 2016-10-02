package com.creationguts.needle.model;

/**
 * Base class for value objects
 * Created by Juliano on 10/1/16.
 */
public abstract class BaseVO {

    public BaseVO(long id) {
        setId(id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
}
