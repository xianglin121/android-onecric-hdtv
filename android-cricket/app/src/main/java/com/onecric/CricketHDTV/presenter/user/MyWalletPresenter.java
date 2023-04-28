package com.onecric.CricketHDTV.presenter.user;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.model.BalanceBean;
import com.onecric.CricketHDTV.model.WithdrawBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.user.MyWalletView;

import java.util.List;

public class MyWalletPresenter extends BasePresenter<MyWalletView> {
    public MyWalletPresenter(MyWalletView view) {
        attachView(view);
    }

    public void getList(boolean isRefresh, int type, int page) {
        addSubscription(apiStores.getBalanceChangeList(CommonAppConfig.getInstance().getToken(), type, page),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        List<BalanceBean> list = JSONObject.parseArray(JSONObject.parseObject(data).getString("data"), BalanceBean.class);
                        mvpView.getDataSuccess(isRefresh, list);
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

    public void getList(boolean isRefresh, int page) {
        addSubscription(apiStores.getWithdrawList(CommonAppConfig.getInstance().getToken(), page),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        List<WithdrawBean> list = JSONObject.parseArray(JSONObject.parseObject(data).getString("data"), WithdrawBean.class);
                        mvpView.getWithdrawDataSuccess(isRefresh, list);
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
