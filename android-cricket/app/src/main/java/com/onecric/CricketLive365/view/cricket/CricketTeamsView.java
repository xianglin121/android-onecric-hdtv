package com.onecric.CricketLive365.view.cricket;

import com.onecric.CricketLive365.model.CricketPlayerBean;
import com.onecric.CricketLive365.model.JsonBean;
import com.onecric.CricketLive365.view.BaseView;

import java.util.List;

/**
 * 开发公司：东莞市梦幻科技有限公司
 * 时间：2022/8/26
 */
public interface CricketTeamsView extends BaseView<JsonBean> {
    void getDataSuccess(List<CricketPlayerBean> batters, String batterCount, List<CricketPlayerBean> bowlers, String bowlersCount, List<CricketPlayerBean> allRounder, String allRounderCount);
}
