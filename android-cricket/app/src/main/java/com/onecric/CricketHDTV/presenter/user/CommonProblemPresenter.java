package com.onecric.CricketHDTV.presenter.user;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.model.ProblemBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.user.CommonProblemView;

public class CommonProblemPresenter extends BasePresenter<CommonProblemView> {
    public CommonProblemPresenter(CommonProblemView view) {
        attachView(view);
    }

    public void getList() {
        addSubscription(apiStores.getCommonProblemList(CommonAppConfig.getInstance().getToken(), 2),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        mvpView.getDataSuccess(JSONObject.parseArray(data, ProblemBean.class));
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
