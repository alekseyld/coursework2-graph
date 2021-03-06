package com.alekseyld.model;

import java.awt.*;
import java.io.Serializable;

/*
 * Created by Alekseyld on 12.4.2019.
 */

public class GraphParams implements Serializable {

    public static GraphParams getDefaultParams() {
        return new GraphParams()
                .setGraphColor(GraphColors.RED)
                .setNeedGrid(true)
                .setGridColor(GridColors.GREEN)
                .setGraphicsFunc(GraphicsFunc.FIRST)
                .setIntervalTo(15)
                .setParamA(2)
                .setParamA2(4)
                .setIntervalFrom(0)
                .setMinY(0)
                .setMaxY(50);
    }

    private GraphColors graphColor;

    private GraphicsFunc graphicsFunc;

    private boolean needGrid;
    private GridColors gridColor;

    private double paramA;
    private double paramA2;

    private double intervalTo;
    private double intervalFrom;

    private double minY;
    private double maxY;

    public GraphicsFunc getGraphicsFunc() {
        return graphicsFunc;
    }

    public GraphParams setGraphicsFunc(GraphicsFunc graphicsFunc) {
        this.graphicsFunc = graphicsFunc;
        return this;
    }

    public GraphColors getGraphColorEnum() {
        return graphColor;
    }

    public Color getGraphColor() {
        return graphColor.color;
    }

    public GraphParams setGraphColor(GraphColors graphColor) {
        this.graphColor = graphColor;
        return this;
    }

    public GridColors getGridColorEnum() {
        return gridColor;
    }

    public Color getGridColor() {
        return gridColor.color;
    }

    public GraphParams setGridColor(GridColors gridColor) {
        this.gridColor = gridColor;
        return this;
    }

    public double getParamA() {
        return paramA;
    }

    public GraphParams setParamA(double paramA) {
        this.paramA = paramA;
        return this;
    }

    public double getParamA2() {
        return paramA2;
    }

    public GraphParams setParamA2(double paramA2) {
        this.paramA2 = paramA2;
        return this;
    }

    public double getIntervalTo() {
        return intervalTo;
    }

    public GraphParams setIntervalTo(double intervalTo) {
        this.intervalTo = intervalTo;
        return this;
    }

    public double getIntervalFrom() {
        return intervalFrom;
    }

    public GraphParams setIntervalFrom(double intervalFrom) {
        this.intervalFrom = intervalFrom;
        return this;
    }

    public boolean isNeedGrid() {
        return needGrid;
    }

    public GraphParams setNeedGrid(boolean needGrid) {
        this.needGrid = needGrid;
        return this;
    }

    public double getMinY() {
        return minY;
    }

    public GraphParams setMinY(double minY) {
        this.minY = minY;
        return this;
    }

    public double getMaxY() {
        return maxY;
    }

    public GraphParams setMaxY(double maxY) {
        this.maxY = maxY;
        return this;
    }

    public enum GraphColors{
        RED(" ?????????????? ", Color.red),
        BLUE(" ?????????? ", Color.blue),
        BLACK(" ???????????? ", Color.black);

        protected String name;
        protected Color color;

        GraphColors(String name, Color color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public static GraphColors getEnumByName(String name) {

            if (name.equals(RED.name)) {
                return RED;
            } else if (name.equals(BLUE.name)) {
                return BLUE;
            } else if (name.equals(BLACK.name)) {
                return BLACK;
            } else {
                return RED;
            }
        }
    }

    public enum GridColors{
        GREEN("??????????????", Color.green),
        YELLOW("????????????", Color.yellow),
        GREY("??????????", Color.gray);

        protected String name;
        protected Color color;

        GridColors(String name, Color color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public static GridColors getEnumByName(String name) {

            if (name.equals(GREEN.name)) {
                return GREEN;
            } else if (name.equals(YELLOW.name)) {
                return YELLOW;
            } else if (name.equals(GREY.name)) {
                return GREY;
            } else {
                return GREEN;
            }
        }
    }
}
