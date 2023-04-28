package com.onecric.CricketHDTV.presenter.theme;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.model.HeadlineBean;
import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.retrofit.ApiCallback;
import com.onecric.CricketHDTV.view.theme.ThemeHeadlineInnerView;

import java.util.ArrayList;
import java.util.List;


public class ThemeHeadlineInnerPresenter extends BasePresenter<ThemeHeadlineInnerView> {
    public ThemeHeadlineInnerPresenter(ThemeHeadlineInnerView view) {
        attachView(view);
    }

    public void getList(boolean isRefresh, int id, int page) {
        addSubscription(apiStores.getHeadlineList(CommonAppConfig.getInstance().getToken(), page, id),
                new ApiCallback() {
                    @Override
                    public void onSuccess(String data, String msg) {
                        if (!TextUtils.isEmpty(data)) {
                            List<HeadlineBean> list = JSONObject.parseArray(JSONObject.parseObject(JSONObject.parseObject(data).getString("list")).getString("data"), HeadlineBean.class);
                            List<HeadlineBean> banners = JSONObject.parseArray(JSONObject.parseObject(data).getString("banner"), HeadlineBean.class);
                            mvpView.getDataSuccess(isRefresh, list, banners);
                        }else {
                            mvpView.getDataSuccess(isRefresh, new ArrayList<>(),  new ArrayList<>());
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
