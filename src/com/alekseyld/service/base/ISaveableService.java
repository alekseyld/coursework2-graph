package com.alekseyld.service.base;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.repository.base.IRepository;

public interface ISaveableService<T, Y> extends IService<T> {

    void saveTo(IRepository.IDistanation<Y> distanation);
    void loadFrom(IRepository.IDistanation<Y> distanation);

}
