package com.alekseyld.repository.base;

/*
 * Created by Alekseyld on 13.4.2019.
 */

public abstract class AbstractModelRepository<T, DistType> implements IRepository<T, DistType> {

    protected T model;

    @Override
    public void set(T model) {
        this.model = model;
    }

    @Override
    public T get() {
        return model;
    }

}
