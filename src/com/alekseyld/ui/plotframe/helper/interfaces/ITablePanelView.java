package com.alekseyld.ui.plotframe.helper.interfaces;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.model.Coordinates;
import com.alekseyld.ui.base.view.IView;

public interface ITablePanelView extends IView<ITablePanelPresenter> {

    void updateTable(Coordinates coordinates);

}
