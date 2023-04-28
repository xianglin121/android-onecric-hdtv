package com.onecric.CricketHDTV.presenter.match;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.model.FootballHistoryIndexDetailBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.match.FootballHistoryIndexDetailView;

public class FootballHistoryIndexDetailPresenter extends BasePresenter<FootballHistoryIndexDetailView> {
    public FootballHistoryIndexDetailPresenter(FootballHistoryIndexDetailView view) {
        attachView(view);
    }

    public void getDetail(int id, int companyId) {
        addSubscription(apiStores.getFootballHistoryIndexDetail(id, companyId),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        if (!TextUtils.isEmpty(JSONObject.parseObject(data).getString("data"))) {
                            mvpView.getDataSuccess(JSONObject.parseObject(JSONObject.parseObject(data).getString("data"), FootballHistoryIndexDetailBean.class));
                        }
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
