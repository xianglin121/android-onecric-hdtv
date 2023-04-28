package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.UserBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface SearchAnchorView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<UserBean> list);

    void doFollowSuccess(int id);
}
