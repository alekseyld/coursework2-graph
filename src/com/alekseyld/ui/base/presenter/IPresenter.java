package com.alekseyld.ui.base.presenter;

/*
 * Created by Alekseyld on 13.4.2019.
 */

import com.alekseyld.ui.base.view.IView;

public interface IPresenter<T extends IView> {

    void setView(T view);

}
