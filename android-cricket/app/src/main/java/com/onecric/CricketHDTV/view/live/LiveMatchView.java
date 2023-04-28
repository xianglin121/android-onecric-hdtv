package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.LiveBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface LiveMatchView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<LiveBean> list);
}
