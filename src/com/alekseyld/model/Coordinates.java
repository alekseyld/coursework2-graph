package com.alekseyld.model;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Coordinates {

    private Map<Double, Double> coordinates = new HashMap<>();

    public Map<Double, Double> getCoordinates() {
        return coordinates;
    }

    public Coordinates setCoordinates(Map<Double, Double> coordinates) {
        this.coordinates = coordinates;
        return this;
    }
}
