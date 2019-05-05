package com.alekseyld.repository;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.model.GraphParams;
import com.alekseyld.repository.base.AbstractModelRepository;

import java.io.*;

public class GraphParamsRepository extends AbstractModelRepository<GraphParams, File> {

    public GraphParamsRepository() {
        model = GraphParams.getDefaultParams();
    }

    @Override
    public void update(GraphParams obj) {
        model.setGraphColor(obj.getGraphColorEnum())
                .setGridColor(obj.getGridColorEnum())
                .setIntervalTo(obj.getIntervalTo())
                .setParamA(obj.getParamA());
    }

    @Override
    public void saveTo(IDistanation<File> distanation) {
        if (model == null)
            return;

        try {

            FileOutputStream fos = new FileOutputStream(distanation.getDistanation());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(model);
            oos.flush();
            oos.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean loadFrom(IDistanation<File> distanation) {

        try {

            FileInputStream fis = new FileInputStream(distanation.getDistanation());
            ObjectInputStream oin = new ObjectInputStream(fis);
            model = (GraphParams) oin.readObject();
            return true;

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return false;
    }
}
