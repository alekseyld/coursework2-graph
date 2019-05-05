package com.alekseyld.repository.base;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.observable.Observable;
import com.alekseyld.observable.Observer;

import java.util.Vector;

public class ObservableRepositoryDecorator<T, DistType> implements IRepository<T, DistType>, Observable<T> {

    private IRepository<T, DistType> decoratedRepository;

    private Vector<Observer<T>> observers;

    public ObservableRepositoryDecorator(IRepository<T, DistType> decoratedRepository) {
        this.decoratedRepository = decoratedRepository;

        observers = new Vector<>();
    }

    @Override
    public void addObserver(Observer<T> observer) {
        if (!observers.contains(observer)) {
            observers.addElement(observer);
        }
    }

    @Override
    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(T obj) {
        for (Observer<T> observer: observers) {
            observer.update(obj);
        }
    }

    @Override
    public void set(T obj) {
        decoratedRepository.set(obj);
        notifyObserver(obj);
    }

    @Override
    public void update(T obj) {
        decoratedRepository.update(obj);
        notifyObserver(obj);
    }

    @Override
    public T get() {
        return decoratedRepository.get();
    }

    @Override
    public void saveTo(IDistanation<DistType> distanation) {
        decoratedRepository.saveTo(distanation);
    }

    @Override
    public boolean loadFrom(IDistanation<DistType> distanation) {
        boolean result = decoratedRepository.loadFrom(distanation);

        if (result) {
            notifyObserver(decoratedRepository.get());
        }

        return result;
    }
}
