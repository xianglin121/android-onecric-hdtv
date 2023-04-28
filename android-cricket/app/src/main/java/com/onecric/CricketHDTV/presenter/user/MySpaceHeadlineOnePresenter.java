package com.onecric.CricketHDTV.presenter.user;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.model.HeadlineBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.user.MySpaceHeadlineOneView;

import java.util.List;


public class MySpaceHeadlineOnePresenter extends BasePresenter<MySpaceHeadlineOneView> {
    public MySpaceHeadlineOnePresenter(MySpaceHeadlineOneView view) {
        attachView(view);
    }

    public void getList(boolean isRefresh, int page, int id) {
        addSubscription(apiStores.getHeadlinePublishList(CommonAppConfig.getInstance().getToken(), page, id, 1),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        if (!TextUtils.isEmpty(data)) {
                            List<HeadlineBean> list = JSONObject.parseArray(JSONObject.parseObject(data).getString("data"), HeadlineBean.class);
                            mvpView.getDataSuccess(isRefresh, list);
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

    public void delete(int position, int id) {
        addSubscription(apiStores.deleteHeadline(CommonAppConfig.getInstance().getToken(), id),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        mvpView.doDeleteSuccess(position);
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
