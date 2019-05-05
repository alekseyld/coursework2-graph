package com.alekseyld.ui.plotframe.graph;

import com.alekseyld.model.Coordinates;
import com.alekseyld.model.GraphParams;
import com.alekseyld.ui.base.view.AbstractViewPanel;
import com.alekseyld.ui.plotframe.controls.ButtonPanel;
import com.alekseyld.ui.plotframe.graph.interfaces.IGraphPanelPresenter;
import com.alekseyld.ui.plotframe.graph.interfaces.IGraphPanelView;

import java.awt.*;

public class GraphPanel extends AbstractViewPanel<IGraphPanelPresenter> implements IGraphPanelView {

    private Plotter mPlotter;

    public GraphPanel(IGraphPanelPresenter presenter, int x, int y, int wG, int hG, ButtonPanel buttonPanel) {
        super(presenter);

        mPlotter = new Plotter(wG, hG);

        setBackground(Color.WHITE);
        setBounds(x, y, wG, hG);
    }

    @Override
    public void drawGraph(GraphParams graphParams, Coordinates coordinates) {
        mPlotter.plot(getGraphics(), graphParams, coordinates);
    }

    @Override
    public void paint(Graphics g) {
        drawGraph(GraphParams.getDefaultParams());
    }

    @Override
    public void drawGraph(GraphParams graphParams) {
        Coordinates coordinates = mPlotter.plot(getGraphics(), graphParams);

        mPresenter.updateCoordinates(coordinates);
    }
}
