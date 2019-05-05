package com.alekseyld.service;

/*
 * Created by Alekseyld on 12.4.2019.
 */

import com.alekseyld.model.Coordinates;
import com.alekseyld.observable.Observer;
import com.alekseyld.repository.CoordinatesRepository;
import com.alekseyld.repository.base.IRepository;
import com.alekseyld.repository.base.ObservableRepositoryDecorator;
import com.alekseyld.service.base.IObservableService;
import com.alekseyld.service.base.ISaveableService;

import java.io.File;

public class CoordinatesService
        implements IObservableService<Coordinates>, ISaveableService<Coordinates, File> {

    private ObservableRepositoryDecorator<Coordinates, Object> mRepository;

    public CoordinatesService() {
        IRepository<Coordinates, Object> repository = new CoordinatesRepository();

        mRepository = new ObservableRepositoryDecorator<>(repository);
    }

    @Override
    public void set(Coordinates obj) {
        mRepository.set(obj);
    }

    @Override
    public void update(Coordinates obj) {
        mRepository.set(obj);
    }

    @Override
    public Coordinates get() {
        return mRepository.get();
    }

    @Override
    public void saveTo(IRepository.IDistanation distanation) {
        mRepository.saveTo(distanation);
    }

    @Override
    public void loadFrom(IRepository.IDistanation distanation) {
        mRepository.loadFrom(distanation);
    }

    @Override
    public void addObserver(Observer<Coordinates> observer) {
        mRepository.addObserver(observer);
    }

    @Override
    public void removeObserver(Observer<Coordinates> observer) {
        mRepository.removeObserver(observer);
    }
}
