package com.onecric.CricketHDTV.view.cricket;

import com.onecric.CricketHDTV.model.BattingBean;
import com.onecric.CricketHDTV.model.BowlingBean;
import com.onecric.CricketHDTV.model.FieldingBean;
import com.onecric.CricketHDTV.model.PlayerProfileBean;
import com.onecric.CricketHDTV.model.RecentMatchesBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

/**
 * 开发公司：东莞市梦幻科技有限公司
 * 时间：2022/8/26
 */
public interface PlayerProfileView extends BaseView<PlayerProfileBean> {
    void getDataSuccess(String teams, List<RecentMatchesBean> list, String profile);

    void getDataSuccess(BattingBean batting, BowlingBean bowling, FieldingBean fielding, List<RecentMatchesBean> list);
}
