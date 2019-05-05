package com.alekseyld.ui.plotframe.controls.interfaces;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.model.GraphParams;
import com.alekseyld.ui.base.presenter.IPresenter;

import java.io.File;

/*
 * Created by Alekseyld on 13.4.2019.
 */

public interface IButtonPanelPresenter extends IPresenter<IButtonPanelView> {

    void graphColorChanged(GraphParams.GraphColors color);
    void gridColorChanged(GraphParams.GridColors color);
    void needGridChanged(boolean needGrid);
    void intervalToChanged(double xmax);
    void intervalFromChanged(double xmin);
    void paramAChanged(double a);

    double getIntervalFrom();
    double getIntervalTo();

    void saveGraph(File file);
    void loadGraph(File file);

}
