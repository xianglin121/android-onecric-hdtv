package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.MatchListBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface HotMatchInnerView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<MatchListBean> list);
}
