package com.onecric.CricketHDTV.presenter.match;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.model.DataInfoBean;
import com.onecric.CricketHDTV.model.DataSeasonBean;
import com.onecric.CricketHDTV.model.FootballDataStatusBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.match.FootballMatchDataView;

import java.util.List;

public class FootballMatchDataPresenter extends BasePresenter<FootballMatchDataView> {
    public FootballMatchDataPresenter(FootballMatchDataView view) {
        attachView(view);
    }

    public void getDetail(int id, int seasonId, int stageId, int sonId) {
        addSubscription(apiStores.getFootballMatchDataDetail(id, seasonId, stageId, sonId),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        List<DataSeasonBean> seasonList = JSONObject.parseArray(JSONObject.parseObject(data).getString("season"), DataSeasonBean.class);
                        DataInfoBean info = JSONObject.parseObject(JSONObject.parseObject(data).getString("info"), DataInfoBean.class);
                        FootballDataStatusBean dataStatusBean = JSONObject.parseObject(data, FootballDataStatusBean.class);
                        mvpView.getDetailSuccess(seasonList, info, dataStatusBean);
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
