package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.CommunityBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface MySpaceCommunityOneView extends BaseView<JsonBean> {
    void getList(boolean isRefresh, List<CommunityBean> list);
}
