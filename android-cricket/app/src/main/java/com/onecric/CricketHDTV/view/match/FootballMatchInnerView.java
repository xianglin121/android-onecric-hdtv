package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.FootballMatchBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface FootballMatchInnerView extends BaseView<List<FootballMatchBean>> {
    void getDataSuccess(boolean isRefresh, List<FootballMatchBean> list);
}
