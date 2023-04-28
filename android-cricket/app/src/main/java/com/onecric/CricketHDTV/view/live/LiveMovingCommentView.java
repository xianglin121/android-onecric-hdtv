package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.MovingBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface LiveMovingCommentView extends BaseView<JsonBean> {
    void getData(MovingBean bean);

    void getTokenSuccess(String token);

    void getList(List<MovingBean> list);

    void doCommentSuccess(Integer cid);
}
