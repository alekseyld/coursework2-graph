package com.alekseyld.ui.plotframe.graph;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.model.Coordinates;
import com.alekseyld.model.GraphParams;
import com.alekseyld.service.CoordinatesService;
import com.alekseyld.service.GraphParamService;
import com.alekseyld.service.base.IObservableService;
import com.alekseyld.service.base.IService;
import com.alekseyld.service.base.ServiceLocator;
import com.alekseyld.ui.base.presenter.AbstractPresenter;
import com.alekseyld.ui.plotframe.graph.interfaces.IGraphPanelPresenter;
import com.alekseyld.ui.plotframe.graph.interfaces.IGraphPanelView;

public class GraphPanelPresenter extends AbstractPresenter<IGraphPanelView> implements IGraphPanelPresenter {

    private IObservableService<GraphParams> mGraphParamsService;
    private IService<Coordinates> mCoordinatesService;

    @SuppressWarnings("unchecked")
    public GraphPanelPresenter() {

        mGraphParamsService = ServiceLocator.getObservableService(GraphParamService.class);
        mCoordinatesService = ServiceLocator.getObservableService(CoordinatesService.class);

        mGraphParamsService.addObserver(this::onGraphParamsUpdate);
    }

    private void onGraphParamsUpdate(GraphParams updatedObj) {
        mView.drawGraph(updatedObj);
    }

    @Override
    public void updateCoordinates(Coordinates coordinates) {
        mCoordinatesService.set(coordinates);
    }
}
