package com.onecric.CricketHDTV.view.cricket;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.ScorecardBatterBean;
import com.onecric.CricketHDTV.model.ScorecardBowlerBean;
import com.onecric.CricketHDTV.model.ScorecardWicketBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

/**
 * 开发公司：东莞市梦幻科技有限公司
 * 时间：2022/8/26
 */
public interface CricketScorecardView extends BaseView<JsonBean> {
    void getHomeDataSuccess(List<ScorecardBatterBean> batterList, List<ScorecardBowlerBean> bowlerList, List<ScorecardWicketBean> wicketList, String extras, String noBattingName);

    void getAwayDataSuccess(List<ScorecardBatterBean> batterList, List<ScorecardBowlerBean> bowlerList, List<ScorecardWicketBean> wicketList, String extras, String noBattingName);
}
