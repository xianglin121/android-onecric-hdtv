package com.onecric.CricketHDTV.view.live;

import com.onecric.CricketHDTV.model.CommunityBean;
import com.onecric.CricketHDTV.model.HeadlineBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.LiveBean;
import com.onecric.CricketHDTV.model.MatchListBean;
import com.onecric.CricketHDTV.model.UserBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface SearchComplexView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<UserBean> anchorList, List<LiveBean> liveList, List<MatchListBean> matchList, List<HeadlineBean> headlineList, List<CommunityBean> communityList);

    void doFollowSuccess(int id);

    void doReserveSuccess(int position);
}
