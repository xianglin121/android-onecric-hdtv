package com.onecric.CricketHDTV.presenter.match;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.match.FootballMatchView;

public class FootballMatchPresenter extends BasePresenter<FootballMatchView> {
    public FootballMatchPresenter(FootballMatchView view) {
        attachView(view);
    }

    public void getCollectCount() {
        addSubscription(apiStores.getFootballList(CommonAppConfig.getInstance().getToken(), 4, null, 1, null),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        mvpView.getCollectCountSuccess(JSONObject.parseObject(data).getIntValue("total"));
                    }

                    @Override
                    public void onFailure(String msg) {
                    }

                    @Override
                    public void onError(String msg) {
                    }

                    @Override
                    public void onFinish() {

                    }
                });
    }
}
