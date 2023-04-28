package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.ReserveMatchBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface MyReserveView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<ReserveMatchBean> list);

    void doReserveSuccess(int position);
}
