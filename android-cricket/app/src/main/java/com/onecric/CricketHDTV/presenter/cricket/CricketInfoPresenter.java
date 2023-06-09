package com.onecric.CricketHDTV.presenter.cricket;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.model.CricketInfoBean;
import com.onecric.CricketHDTV.model.CricketPointsBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.cricket.CricketInfoView;

import java.util.List;
import java.util.TimeZone;

public class CricketInfoPresenter extends BasePresenter<CricketInfoView> {
    public CricketInfoPresenter(CricketInfoView view) {
        attachView(view);
    }

    public void getData(int matchId) {
        JSONObject jsonObject = new JSONObject();
        TimeZone timeZone = TimeZone.getDefault();
        jsonObject.put("timezone", timeZone.getID());
        jsonObject.put("match_id", matchId);
        addSubscription(apiStores.getCricketDetailInfo(getRequestBody(jsonObject)), new ApiCallback() {
            @Override
            public void onSuccess(String data, String msg) {
                mvpView.getDataSuccess(JSONObject.parseObject(data, CricketInfoBean.class));
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

    public void getPointsList(int tournamentId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tournament_id", tournamentId);
        addSubscription(apiStores.getTournamentPointsList(getRequestBody(jsonObject)), new ApiCallback() {
            @Override
            public void onSuccess(String data, String msg) {
                List<CricketPointsBean> list = JSONObject.parseArray(data, CricketPointsBean.class);
                mvpView.getPointsDataSuccess(list);
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
