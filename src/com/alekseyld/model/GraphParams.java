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
                .setIntervalTo(15)
                .setParamA(2)
                .setIntervalFrom(0)
                .setMinY(0)
                .setMaxY(50);
    }

    private GraphColors graphColor;

    private boolean needGrid;
    private GridColors gridColor;

    private double paramA;

    private double intervalTo;
    private double intervalFrom;

    private double minY;
    private double maxY;

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
        RED(" красный ", Color.red),
        BLUE(" синий ", Color.blue),
        BLACK(" черный ", Color.black);

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
        GREEN("Зеленый", Color.green),
        YELLOW("Желтый", Color.yellow),
        GREY("Серый", Color.gray);

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
