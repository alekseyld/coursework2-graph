package com.alekseyld.ui.plotframe.helper;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.model.Coordinates;
import com.alekseyld.service.CoordinatesService;
import com.alekseyld.service.base.IObservableService;
import com.alekseyld.service.base.ServiceLocator;
import com.alekseyld.ui.base.presenter.AbstractPresenter;
import com.alekseyld.ui.plotframe.helper.interfaces.ITablePanelPresenter;
import com.alekseyld.ui.plotframe.helper.interfaces.ITablePanelView;

public class TablePanelPresenter extends AbstractPresenter<ITablePanelView> implements ITablePanelPresenter {

    private IObservableService<Coordinates> mCoordinatesService;

    @SuppressWarnings("unchecked")
    public TablePanelPresenter() {

        mCoordinatesService = ServiceLocator.getObservableService(CoordinatesService.class);

        mCoordinatesService.addObserver(this::onCoordinatesUpdate);
    }

    private void onCoordinatesUpdate(Coordinates updatedObj) {
        mView.updateTable(updatedObj);
    }
}
