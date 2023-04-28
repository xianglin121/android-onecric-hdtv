package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

public interface MyTaskView extends BaseView<JsonBean> {
    void getDataSuccess(String url, String img);
}
