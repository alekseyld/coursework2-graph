package com.alekseyld.service.base;

/*
 * Created by Alekseyld on 12.4.2019.
 */

public interface IService<T> {

    void set(T obj);
    void update(T obj);
    T get();

}
