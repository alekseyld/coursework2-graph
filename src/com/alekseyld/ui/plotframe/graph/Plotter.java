package com.alekseyld.ui.plotframe.graph;

import com.alekseyld.model.Coordinates;
import com.alekseyld.model.GraphParams;

import java.awt.*;
import java.text.DecimalFormat;

/*
 * Created by Alekseyld on 13.4.2019.
 */

public class Plotter {

    private DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    private int wG, hG;
    private double Xmin=0, Xmax=10, Ymin=0, Ymax=50.0;
    private boolean status;
    private Color clr;
    private Color gclr;

    public Plotter(int wG, int hG) {//, ButtonPanel buttonPanel
        this.wG = wG;
        this.hG = hG;
    }

    public int getwG() {
        return wG;
    }

    public int gethG() {
        return hG;
    }

    private  double myFunc(double a, double x) {
        return Math.pow(a, x);
    }

    public void plot(Graphics Fig, GraphParams graphParams, Coordinates coordinates) {


    }

    public Coordinates plot(Graphics Fig, GraphParams graphParams) {

        Coordinates coordinates = new Coordinates();

        Xmin = graphParams.getIntervalFrom();
        Xmax = graphParams.getIntervalTo();

        Ymin = graphParams.getMinY();
        Ymax = graphParams.getMaxY();

        status = graphParams.isNeedGrid();
        gclr = graphParams.getGridColor();
        clr = graphParams.getGraphColor();

        int h, w, s = 20;
        h = hG - 2 * s;
        w = wG - 2 * s;
        Fig.clearRect(0,0, wG, hG);

        int k, nums = 10;
        Fig.setColor(Color.BLACK);
        Fig.drawLine(s, s, s, h + s);
        Fig.drawLine(s, s + h, s + w, s + h);

        int maxYCoordinate = 1000;

        for (k = 0; k <= nums; k++) {
            Fig.drawLine(s+k*w/nums, s+h,s+k*w/nums, s+h+5);
            Fig.drawLine(s-5, s+k*h/nums, s, s + k*h/nums);
            Fig.drawString(decimalFormat.format(Xmin + k * (Xmax - Xmin)/ nums), s + k*w/nums-5, s+h+15);
            maxYCoordinate = s + h - 1 - k * h / nums;
            Fig.drawString(decimalFormat.format(Ymin+k*(Ymax - Ymin)/ nums), s - 17, maxYCoordinate);
        }

        if (status) {
            Fig.setColor(gclr);
            for (k = 1; k <= nums; k++) {
                Fig.drawLine(s+k*w/nums, s, s+k*w/nums, h+s);
                int y1 = s + (k - 1) * h / nums;
                Fig.drawLine(s, y1, s+w, y1);
            }
        }

        Fig.setColor(clr);

        double dx = (Xmax - Xmin) / w;
        double dy = (Ymax - Ymin) / h;
        double x1, x2, y1, y2;
        int h1, h2, w1, w2;

        x1 = Xmin;
        y1 = myFunc(graphParams.getParamA(), x1);
        w1 = s;
        h1 = h + s - (int)Math.round(y1/dy);
        int step = 5;

        boolean isDrawing = true;

        for (int i = 0; i < w; i += step) {
            x2 = i * dx;
            double y = myFunc(graphParams.getParamA(), i);
            y2 = myFunc(graphParams.getParamA(), x2);

            coordinates.getCoordinates().put((double) i, y);

            w2 = s + (int)Math.round(x2/dx);
            h2 = h + s - (int)Math.round(y2/dy);

            if (isDrawing) {
                Fig.drawLine(w1, h1, w2, h2);
            }

            if (h2 < maxYCoordinate) {
                isDrawing = false;
            }

            //Fig.drawRect(w1-w, h1-2, 4,4);

            x1 = x2;
            y1 = y2;
            w1 = w2;
            h1 = h2;
        }

        return coordinates;
    }

}
