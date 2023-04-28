package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.BasketballDetailBean;
import com.onecric.CricketHDTV.model.CricketMatchBean;
import com.onecric.CricketHDTV.model.FootballDetailBean;
import com.onecric.CricketHDTV.model.LiveRoomBean;
import com.onecric.CricketHDTV.model.UpdatesBean;
import com.onecric.CricketHDTV.model.UserBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface LiveDetailView extends BaseView<LiveRoomBean> {
    void getDataSuccess(FootballDetailBean bean);

    void getDataSuccess(BasketballDetailBean bean);

    void doFollowSuccess();

    void getDataSuccess(UserBean bean);

    void getUpdateUserData(LiveRoomBean bean);

    void sendBgDanmuSuccess(int id, int anchorId, int level, String text, String msg);

    void sendBroadcastResponse(boolean isSuccess, String msg);

    void getMatchDataSuccess(CricketMatchBean model);

    void getUpdatesDataSuccess(List<UpdatesBean> list);

    void showLikeSuccess();
}
