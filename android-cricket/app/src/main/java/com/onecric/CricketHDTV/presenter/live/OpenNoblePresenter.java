package com.onecric.CricketHDTV.presenter.live;

import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.live.OpenNobleView;


public class OpenNoblePresenter extends BasePresenter<OpenNobleView> {
    public OpenNoblePresenter(OpenNobleView view) {
        attachView(view);
    }

    public void buyNoble(int id, int anchorId) {
        addSubscription(apiStores.buyNoble(CommonAppConfig.getInstance().getToken(), id, anchorId),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        mvpView.getDataSuccess(null);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getDataFail(msg);
                    }

                    @Override
                    public void onError(String msg) {
                        mvpView.getDataFail(msg);
                    }

                    @Override
                    public void onFinish() {

                    }
                });
    }
}
