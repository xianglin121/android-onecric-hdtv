package com.onecric.CricketHDTV.view.theme;

import com.onecric.CricketHDTV.model.HeadlineBean;
import com.onecric.CricketHDTV.model.MovingBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface HeadlineDetailView extends BaseView<HeadlineBean> {
    void getDataSuccess(HeadlineBean model, List<HeadlineBean> list);

    void getTokenSuccess(String token);

    void getList(boolean isRefresh, List<MovingBean> list);

    void doCommentSuccess(Integer cid);

    void doFollowSuccess();
}
