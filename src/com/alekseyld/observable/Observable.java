package com.alekseyld.observable;

/*
 * Created by Alekseyld on 13.4.2019.
 */

public interface Observable<T> {

    void addObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObserver(T obj);

}
