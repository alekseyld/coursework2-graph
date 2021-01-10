package com.alekseyld.model;/*
 * Created by Alekseyld on 10.1.2021.
 */

import java.awt.*;

public enum GraphicsFunc {
    FIRST("y = a1 * e ^ x - a2 * e ^-x",
            (double a1, double a2, double x) ->
                    a1 * Math.exp(x) - a2 * Math.exp(-x)
    ),

    SECOND("y = a1 * cos(x)^2 - a2 * sin(x)^2",
            (double a1, double a2, double x) ->
                    a1 * Math.pow(Math.cos(x), 2) - a2 * Math.pow(Math.sin(x), 2)
    );

    protected String name;
    protected GraphsFunction func;

    GraphicsFunc(String name, GraphsFunction func) {
        this.name = name;
        this.func = func;
    }

    @FunctionalInterface
    public interface GraphsFunction {
        double calculate(double a1, double a2, double x);
    }

    public String getName() {
        return name;
    }

    public GraphsFunction getFunc() {
        return func;
    }

    public static GraphicsFunc getEnumByName(String name) {

        if (name.equals(SECOND.name)) {
            return SECOND;
        } else {
            return FIRST;
        }
    }
}
