package com.onecric.CricketHDTV.presenter.live;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.model.LiveBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.live.LiveMatchView;

import java.util.ArrayList;
import java.util.List;


public class LiveMatchPresenter extends BasePresenter<LiveMatchView> {
    public LiveMatchPresenter(LiveMatchView view) {
        attachView(view);
    }

    public void getList(boolean isRefresh, int type, int page) {
        addSubscription(apiStores.getLivingList(CommonAppConfig.getInstance().getToken(), page, type, 0),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        if (!TextUtils.isEmpty(data)) {
                            List<LiveBean> list = JSONObject.parseArray(JSONObject.parseObject(data).getString("data"), LiveBean.class);
                            mvpView.getDataSuccess(isRefresh, list);
                        }else {
                            mvpView.getDataSuccess(isRefresh, new ArrayList<>());
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
