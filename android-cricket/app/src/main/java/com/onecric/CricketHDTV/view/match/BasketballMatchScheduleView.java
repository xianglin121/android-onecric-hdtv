package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.BasketballMatchBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface BasketballMatchScheduleView extends BaseView<List<BasketballMatchBean>> {
    void getDataSuccess(boolean isRefresh, List<BasketballMatchBean> list);
}
