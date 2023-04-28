package com.onecric.CricketHDTV.presenter.match;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.model.BasketballIndexBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.match.FootballMatchIndexView;

public class FootballMatchIndexPresenter extends BasePresenter<FootballMatchIndexView> {
    public FootballMatchIndexPresenter(FootballMatchIndexView view) {
        attachView(view);
    }

    public void getDetail(int id) {
        addSubscription(apiStores.getFootballIndexDetail(id),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        BasketballIndexBean basketballIndexBean = JSONObject.parseObject(data, BasketballIndexBean.class);
                        mvpView.getDataSuccess(basketballIndexBean);
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
