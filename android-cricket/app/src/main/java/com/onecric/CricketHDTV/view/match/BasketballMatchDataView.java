package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.DataInfoBean;
import com.onecric.CricketHDTV.model.DataMatchTypeBean;
import com.onecric.CricketHDTV.model.DataSeasonBean;
import com.onecric.CricketHDTV.model.DataStatusBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface BasketballMatchDataView extends BaseView<JsonBean> {
    void getDetailSuccess(List<DataSeasonBean> seasonList, DataInfoBean info, DataStatusBean statusBean, List<DataMatchTypeBean> matchTypeList);
}
