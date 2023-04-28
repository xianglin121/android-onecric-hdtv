package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.Channel;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface HotMatchView extends BaseView<JsonBean> {
    void getDataSuccess(List<Channel> hotMatch, List<Channel> football, List<Channel> basketball);
}
