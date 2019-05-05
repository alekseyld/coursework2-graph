package com.alekseyld.repository;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.model.Coordinates;
import com.alekseyld.repository.base.AbstractModelRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CoordinatesRepository extends AbstractModelRepository<Coordinates, Object> {

    public CoordinatesRepository() {
        model = new Coordinates();
    }

    @Override
    public void update(Coordinates obj) {
        model.setCoordinates(obj.getCoordinates());
    }

    @Override
    public void saveTo(IDistanation distanation) {
        throw new NotImplementedException();
    }

    @Override
    public boolean loadFrom(IDistanation distanation) {
        throw new NotImplementedException();
    }
}
