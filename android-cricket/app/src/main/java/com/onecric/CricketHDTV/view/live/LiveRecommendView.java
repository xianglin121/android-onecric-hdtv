package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.BannerBean;
import com.onecric.CricketHDTV.model.HistoryLiveBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.LiveBean;
import com.onecric.CricketHDTV.model.LiveMatchBean;
import com.onecric.CricketHDTV.model.LiveMatchListBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface LiveRecommendView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<LiveBean> list);

    void getDataHistorySuccess(boolean isRefresh, List<HistoryLiveBean> list);

    void getDataSuccess(List<LiveMatchBean> list);

    void getDataSuccess(List<LiveBean> freeList, List<LiveBean> todayList, List<LiveBean> historyList);

    void doReserveSuccess(int position);

    void getBannerSuccess(List<BannerBean> list, int position);

    void getMatchSuccess(List<LiveMatchListBean.MatchItemBean> today,List<LiveMatchListBean.MatchItemBean> upcoming);


}
