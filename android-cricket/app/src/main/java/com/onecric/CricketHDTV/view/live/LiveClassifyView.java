package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.LiveClassifyBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface LiveClassifyView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<LiveClassifyBean> list);

    void doReserveSuccess(int position);
}
