package com.alekseyld.service.base;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.observable.Observer;

public interface IObservableService<T> extends IService<T> {

    void addObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);

}
