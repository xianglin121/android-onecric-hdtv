package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.CommunityBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface CommunityCommentView extends BaseView<JsonBean> {
    void getData(CommunityBean bean);

    void getTokenSuccess(String token);

    void getList(List<CommunityBean> list);

    void doCommentSuccess(Integer cid);
}
