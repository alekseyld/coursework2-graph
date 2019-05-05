package com.alekseyld.ui.plotframe.graph.interfaces;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.model.Coordinates;
import com.alekseyld.ui.base.presenter.IPresenter;

public interface IGraphPanelPresenter extends IPresenter<IGraphPanelView> {

    void updateCoordinates(Coordinates coordinates);

}
