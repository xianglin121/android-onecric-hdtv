package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.DataScheduleBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface BasketballDataScheduleView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<DataScheduleBean> list);
}
