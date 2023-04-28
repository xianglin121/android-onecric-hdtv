package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.DataScheduleBean;
import com.onecric.CricketHDTV.model.DataStageBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface FootballDataScheduleView extends BaseView<JsonBean> {
    void getStageDataSuccess(List<DataStageBean> list);

    void getDataSuccess(List<DataScheduleBean> list);
}
