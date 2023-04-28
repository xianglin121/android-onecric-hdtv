package com.onecric.CricketLive365.view.user;

import com.onecric.CricketLive365.model.JsonBean;
import com.onecric.CricketLive365.model.UserBean;
import com.onecric.CricketLive365.view.BaseView;

import java.util.List;

public interface MyFansView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<UserBean> list);

    void doFollowSuccess(int id);
}
