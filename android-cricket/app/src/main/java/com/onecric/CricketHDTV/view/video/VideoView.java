package com.onecric.CricketHDTV.view.video;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.ShortVideoBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface VideoView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<ShortVideoBean> list);
}
