package com.alekseyld.ui.plotframe.controls.interfaces;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.model.GraphParams;
import com.alekseyld.ui.base.view.IView;

/*
 * Created by Alekseyld on 13.4.2019.
 */

public interface IButtonPanelView extends IView<IButtonPanelPresenter> {

    void setGraphParams(GraphParams graphParams);
    boolean isUpdating();

}
