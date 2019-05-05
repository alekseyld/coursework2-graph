package com.alekseyld.repository.base;

/*
 * Created by Alekseyld on 13.4.2019.
 */

public interface IRepository<T, DistType> {

    void set(T obj);
    void update(T obj);
    T get();

    void saveTo(IDistanation<DistType> distanation);
    boolean loadFrom(IDistanation<DistType> distanation);

    interface IDistanation<DistType> {
        DistType getDistanation();
    }
}
