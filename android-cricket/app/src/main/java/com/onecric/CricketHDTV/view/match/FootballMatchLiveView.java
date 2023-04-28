package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.LiveAnchorBean;
import com.onecric.CricketHDTV.model.LiveBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface FootballMatchLiveView extends BaseView<JsonBean> {
    void getDataSuccess(List<LiveAnchorBean> list);

    void getDataSuccess(boolean isRefresh, List<LiveBean> list);
}
