package com.alekseyld.ui.base.view;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.ui.base.presenter.IPresenter;

import java.awt.*;

public class AbstractViewPanel<Presenter extends IPresenter>
        extends Panel implements IView<Presenter> {

    protected Presenter mPresenter;

    public AbstractViewPanel(Presenter presenter) {
        this.mPresenter = presenter;
    }
}
