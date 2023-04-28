package com.onecric.CricketHDTV.presenter.theme;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.model.ThemeClassifyBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.theme.GroupSelectView;

import java.util.List;


public class GroupSelectPresenter extends BasePresenter<GroupSelectView> {
    public GroupSelectPresenter(GroupSelectView view) {
        attachView(view);
    }

    public void getData() {
        addSubscription(apiStores.getCommunityClassify(CommonAppConfig.getInstance().getToken()),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        List<ThemeClassifyBean> classifyList = JSONObject.parseArray(data, ThemeClassifyBean.class);
                        mvpView.getDataSuccess(classifyList);
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
