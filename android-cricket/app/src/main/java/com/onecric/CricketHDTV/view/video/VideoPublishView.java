package com.onecric.CricketHDTV.view.video;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

public interface VideoPublishView extends BaseView<JsonBean> {
    void getTokenSuccess(String token);
}
