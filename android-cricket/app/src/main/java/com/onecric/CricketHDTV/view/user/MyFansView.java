package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.UserBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface MyFansView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<UserBean> list);

    void doFollowSuccess(int id);
}
