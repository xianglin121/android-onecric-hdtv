package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.DataInfoBean;
import com.onecric.CricketHDTV.model.DataSeasonBean;
import com.onecric.CricketHDTV.model.FootballDataStatusBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface FootballMatchDataView extends BaseView<JsonBean> {
    void getDetailSuccess(List<DataSeasonBean> seasonList, DataInfoBean info, FootballDataStatusBean statusBean);
}
