package com.onecric.CricketHDTV.presenter.user;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.model.CoinBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.user.ChargeView;

public class ChargePresenter extends BasePresenter<ChargeView> {
    public ChargePresenter(ChargeView view) {
        attachView(view);
    }

    public void getList() {
        addSubscription(apiStores.getCoinList(CommonAppConfig.getInstance().getToken()),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        mvpView.getDataSuccess(JSONObject.parseArray(data, CoinBean.class));
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

    public void doPay(int id, int type) {
        addSubscription(apiStores.getPayUrl(CommonAppConfig.getInstance().getToken(), id, type),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        mvpView.paySuccess(JSONObject.parseObject(data).getString("url"));
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.payFail(msg);
                    }

                    @Override
                    public void onError(String msg) {
                        mvpView.payFail(msg);
                    }

                    @Override
                    public void onFinish() {

                    }
                });
    }
}
