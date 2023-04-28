package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.MovingBean;
import com.onecric.CricketHDTV.model.ReserveLiveBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface LiveAnchorView extends BaseView<List<MovingBean>> {
    void getReserveListSuccess(List<ReserveLiveBean> list);

    void doReserveSuccess(int position);
}
