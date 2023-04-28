package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.FootballMatchBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface FootballMatchScheduleView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<FootballMatchBean> list);
}
