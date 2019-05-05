package com.alekseyld.ui.base.presenter;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.ui.base.view.IView;

public class AbstractPresenter<View extends IView> implements IPresenter<View> {

    protected View mView;

    @Override
    public void setView(View view) {
        this.mView = view;
    }
}
