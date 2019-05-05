package com.alekseyld.ui.plotframe.controls;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.model.GraphParams;
import com.alekseyld.service.GraphParamService;
import com.alekseyld.service.base.IObservableService;
import com.alekseyld.service.base.ISaveableService;
import com.alekseyld.service.base.ServiceLocator;
import com.alekseyld.ui.base.presenter.AbstractPresenter;
import com.alekseyld.ui.plotframe.controls.interfaces.IButtonPanelPresenter;
import com.alekseyld.ui.plotframe.controls.interfaces.IButtonPanelView;

import java.io.File;

public class ButtonPanelPresenter extends AbstractPresenter<IButtonPanelView> implements IButtonPanelPresenter {

    private ISaveableService<GraphParams, File> mGraphParamsService;

    private boolean update = false;

    @SuppressWarnings("unchecked")
    public ButtonPanelPresenter() {

        mGraphParamsService = ServiceLocator.getSaveableService(GraphParamService.class);

        ((IObservableService<GraphParams>)mGraphParamsService).addObserver(this::onUpdateGraphParams);
    }

    private void onUpdateGraphParams(GraphParams updated){
        if (update) {
            update = false;
            return;
        }

        mView.setGraphParams(updated);
    }

    private void updateGraphParams(GraphParams graphParams){
        update = true;

        if (!mView.isUpdating()) {
            mGraphParamsService.update(graphParams);
        }
    }

    @Override
    public void graphColorChanged(GraphParams.GraphColors color) {
        updateGraphParams(
                mGraphParamsService.get().setGraphColor(color)
        );
    }

    @Override
    public void gridColorChanged(GraphParams.GridColors color) {
        updateGraphParams(
                mGraphParamsService.get().setGridColor(color)
        );
    }

    @Override
    public void needGridChanged(boolean needGrid) {
        updateGraphParams(
                mGraphParamsService.get().setNeedGrid(needGrid)
        );
    }

    @Override
    public void intervalToChanged(double xmax) {
        updateGraphParams(
                mGraphParamsService.get().setIntervalTo(xmax)
        );
    }


    @Override
    public void paramAChanged(double a) {
        updateGraphParams(
                mGraphParamsService.get().setParamA(a)
        );
    }

    @Override
    public void saveGraph(File file) {
        mGraphParamsService.saveTo(() -> file);
    }

    @Override
    public void loadGraph(File file) {
        mGraphParamsService.loadFrom(() -> file);
    }

    @Override
    public void intervalFromChanged(double xmin) {
        updateGraphParams(
                mGraphParamsService.get().setIntervalFrom(xmin)
        );
    }

    @Override
    public double getIntervalFrom() {
        return mGraphParamsService.get().getIntervalFrom();
    }

    @Override
    public double getIntervalTo() {
        return mGraphParamsService.get().getIntervalTo();
    }
}
