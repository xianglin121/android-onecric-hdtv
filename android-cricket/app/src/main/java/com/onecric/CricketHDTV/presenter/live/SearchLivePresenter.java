package com.onecric.CricketHDTV.presenter.live;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.model.Channel;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.live.SearchLiveView;

import java.util.List;

public class SearchLivePresenter extends BasePresenter<SearchLiveView> {
    public SearchLivePresenter(SearchLiveView view) {
        attachView(view);
    }

    public void getList() {
        addSubscription(apiStores.getHotMatchClassify(),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        List<Channel> hotMatch = JSONObject.parseArray(JSONObject.parseObject(data).getString("hot_match"), Channel.class);
                        mvpView.getHotMatchClassifySuccess(hotMatch);
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
