package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.Channel;
import com.onecric.CricketHDTV.model.MatchListBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface SearchLiveView extends BaseView<List<MatchListBean>> {
    void getHotMatchClassifySuccess(List<Channel> list);
}
