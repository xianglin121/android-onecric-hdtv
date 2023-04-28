package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.ShortVideoBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface MySpaceVideoTwoView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<ShortVideoBean> list);
}
