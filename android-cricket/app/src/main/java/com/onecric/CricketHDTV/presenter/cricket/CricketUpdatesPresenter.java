package com.onecric.CricketHDTV.presenter.cricket;

import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.view.cricket.CricketUpdatesView;

public class CricketUpdatesPresenter extends BasePresenter<CricketUpdatesView> {
    public CricketUpdatesPresenter(CricketUpdatesView view) {
        attachView(view);
    }
}
