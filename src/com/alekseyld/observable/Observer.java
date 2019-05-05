package com.alekseyld.observable;

/*
 * Created by Alekseyld on 13.4.2019.
 */

public interface Observer<T>{
    void update(T updatedObj);
}
