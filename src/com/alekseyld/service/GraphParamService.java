package com.alekseyld.service;

/*
 * Created by Alekseyld on 12.4.2019.
 */

import com.alekseyld.model.GraphParams;
import com.alekseyld.observable.Observer;
import com.alekseyld.repository.GraphParamsRepository;
import com.alekseyld.repository.base.IRepository;
import com.alekseyld.repository.base.ObservableRepositoryDecorator;
import com.alekseyld.service.base.IObservableService;
import com.alekseyld.service.base.ISaveableService;

import java.io.File;

public class GraphParamService
        implements IObservableService<GraphParams>, ISaveableService<GraphParams, File> {

    private ObservableRepositoryDecorator<GraphParams, File> mRepository;

    public GraphParamService() {
        IRepository<GraphParams, File> repository = new GraphParamsRepository();

        mRepository = new ObservableRepositoryDecorator<>(repository);
    }

    @Override
    public void set(GraphParams obj) {
        mRepository.set(obj);
    }

    @Override
    public void update(GraphParams obj) {
        mRepository.update(obj);
    }

    @Override
    public GraphParams get() {
        return mRepository.get();
    }

    @Override
    public void saveTo(IRepository.IDistanation<File> distanation) {
        mRepository.saveTo(distanation);
    }

    @Override
    public void loadFrom(IRepository.IDistanation<File> distanation) {
        mRepository.loadFrom(distanation);
    }

    @Override
    public void addObserver(Observer<GraphParams> observer) {
        mRepository.addObserver(observer);
    }

    @Override
    public void removeObserver(Observer<GraphParams> observer) {
        mRepository.removeObserver(observer);
    }
}
