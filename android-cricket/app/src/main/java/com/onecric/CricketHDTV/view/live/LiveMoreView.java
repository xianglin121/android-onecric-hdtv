package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.HistoryLiveBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.LiveBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface LiveMoreView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<LiveBean> list);
    void getDataHistorySuccess(boolean isRefresh, List<HistoryLiveBean> list);
}
