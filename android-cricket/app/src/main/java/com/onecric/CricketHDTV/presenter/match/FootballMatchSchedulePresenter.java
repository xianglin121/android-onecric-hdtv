package com.onecric.CricketHDTV.presenter.match;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.event.UpdateFootballCollectCountEvent;
import com.onecric.CricketHDTV.model.FootballMatchBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.match.FootballMatchScheduleView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class FootballMatchSchedulePresenter extends BasePresenter<FootballMatchScheduleView> {
    public FootballMatchSchedulePresenter(FootballMatchScheduleView view) {
        attachView(view);
    }

    public void getList(boolean isRefresh, int type, String date, int page, String id) {
        addSubscription(apiStores.getFootballList(CommonAppConfig.getInstance().getToken(), type, date, page, id),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        List<FootballMatchBean> list = JSONObject.parseArray(JSONObject.parseObject(data).getString("data"), FootballMatchBean.class);
                        mvpView.getDataSuccess(isRefresh, list);
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

    public void doCollect(int type, int id) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", type);
        jsonObject.put("id", id);
        addSubscription(apiStores.doMatchCollect(CommonAppConfig.getInstance().getToken(), getRequestBody(jsonObject)),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        EventBus.getDefault().post(new UpdateFootballCollectCountEvent());
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
