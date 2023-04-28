package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

public interface FootballMatchView extends BaseView<JsonBean> {
    void getCollectCountSuccess(int count);
}
