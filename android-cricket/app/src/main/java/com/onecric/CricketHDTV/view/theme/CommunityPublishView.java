package com.onecric.CricketHDTV.view.theme;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

public interface CommunityPublishView extends BaseView<JsonBean> {
    void getTokenSuccess(String token);
}
