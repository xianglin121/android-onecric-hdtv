package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.ActivityBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface ActivityCenterView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<ActivityBean> list);
}
