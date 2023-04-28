package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.UserBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface MyFollowInnerView extends BaseView<List<UserBean>> {
    void getDataSuccess(boolean isRefresh, List<UserBean> list);

    void doFollowSuccess(int id);
}
