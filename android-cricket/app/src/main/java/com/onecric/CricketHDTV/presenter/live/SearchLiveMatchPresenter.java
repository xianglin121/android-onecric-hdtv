package com.onecric.CricketHDTV.presenter.live;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.model.MatchListBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.live.SearchLiveMatchView;

import java.util.List;


public class SearchLiveMatchPresenter extends BasePresenter<SearchLiveMatchView> {
    public SearchLiveMatchPresenter(SearchLiveMatchView view) {
        attachView(view);
    }

    public void searchMatch(boolean isRefresh, String content) {
        addSubscription(apiStores.searchMatch(content),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        List<MatchListBean> list = JSONObject.parseArray(JSONObject.parseObject(data).getString("data"), MatchListBean.class);
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

    public void doReserve(int position, int matchId, int type) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("match_id", matchId);
        jsonObject.put("type", type);
        addSubscription(apiStores.reserveMatchTwo(CommonAppConfig.getInstance().getToken(), getRequestBody(jsonObject)),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        mvpView.doReserveSuccess(position);
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
