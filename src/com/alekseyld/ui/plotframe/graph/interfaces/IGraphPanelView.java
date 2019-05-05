package com.alekseyld.ui.plotframe.graph.interfaces;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.model.Coordinates;
import com.alekseyld.model.GraphParams;
import com.alekseyld.ui.base.view.IView;

public interface IGraphPanelView extends IView<IGraphPanelPresenter> {

    void drawGraph(GraphParams graphParams);
    void drawGraph(GraphParams graphParams, Coordinates coordinates);

}
