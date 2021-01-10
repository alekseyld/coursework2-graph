package com.alekseyld.service.base;

/*
 * Created by Alekseyld on 12.4.2019.
 */

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {

    private static ServiceLocator locatorInstance = new ServiceLocator();

    private static ServiceLocator getInstance(){
        return locatorInstance;
    }

    public static  <ServiceType extends IService> IService
        getService(Class<ServiceType> type){
        return getInstance().createOrGetInstance(type);
    }

    public static  <ServiceType extends ISaveableService> ISaveableService
        getSaveableService(Class<ServiceType> type){
        return (ISaveableService) getInstance().createOrGetInstance(type);
    }

    public static  <ServiceType extends IObservableService> IObservableService
        getObservableService(Class<ServiceType> type){
        return (IObservableService) getInstance().createOrGetInstance(type);
    }

    private ServiceLocator() {
    }

    private Map<Class, IService> instances = new HashMap<>();

    private IService createOrGetInstance(Class type){

        if (instances.keySet().contains(type)) {
            return instances.get(type);
        }

        try {

            IService service = (IService) type.newInstance();

            instances.put(type, service);

            return service;

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
