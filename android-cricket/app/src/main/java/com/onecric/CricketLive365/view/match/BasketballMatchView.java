package com.onecric.CricketLive365.view.match;

import com.onecric.CricketLive365.model.JsonBean;
import com.onecric.CricketLive365.view.BaseView;

public interface BasketballMatchView extends BaseView<JsonBean> {
    void getCollectCountSuccess(int count);
}
