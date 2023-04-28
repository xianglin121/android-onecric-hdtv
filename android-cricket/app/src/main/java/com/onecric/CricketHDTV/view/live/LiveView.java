package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.LiveBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface LiveView extends BaseView<JsonBean> {
    void getOtherDataSuccess(List<LiveBean> list);
}
