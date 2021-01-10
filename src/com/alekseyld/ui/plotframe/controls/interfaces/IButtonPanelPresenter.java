package com.alekseyld.ui.plotframe.controls.interfaces;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.model.GraphParams;
import com.alekseyld.model.GraphicsFunc;
import com.alekseyld.ui.base.presenter.IPresenter;

import java.io.File;

/*
 * Created by Alekseyld on 13.4.2019.
 */

public interface IButtonPanelPresenter
        extends IPresenter<IButtonPanelView> {

    void graphColorChanged(GraphParams.GraphColors color);
    void gridColorChanged(GraphParams.GridColors color);
    void graphFuncChanged(GraphicsFunc graphicsFunc);
    void needGridChanged(boolean needGrid);
    void intervalToChanged(double xmax);
    void intervalFromChanged(double xmin);
    void paramAChanged(double a);
    void paramA2Changed(double a);
    void minYChanged(double ymin);
    void maxYChanged(double ymax);

    double getIntervalFrom();
    double getIntervalTo();

    double getMinY();
    double getMaxY();

    void saveGraph(File file);
    void loadGraph(File file);

}
