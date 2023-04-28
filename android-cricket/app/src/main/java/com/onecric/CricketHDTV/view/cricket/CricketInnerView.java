package com.onecric.CricketHDTV.view.cricket;

import com.onecric.CricketHDTV.model.CricketPointsBean;
import com.onecric.CricketHDTV.model.CricketStatsBean;
import com.onecric.CricketHDTV.model.CricketTeamBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.UpdatesBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

/**
 * 开发公司：东莞市梦幻科技有限公司
 * 时间：2022/8/26
 */
public interface CricketInnerView extends BaseView<JsonBean> {
    void getTeamDataSuccess(List<CricketTeamBean> list);

    void getPointsDataSuccess(List<CricketPointsBean> list);

    void getUpdatesDataSuccess(List<UpdatesBean> list);

    void getStatsDataSuccess(CricketStatsBean cricketStatsBean);
}
