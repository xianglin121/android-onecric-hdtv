package com.onecric.CricketHDTV.view.cricket;

import com.onecric.CricketHDTV.model.CricketTournamentBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

/**
 * 开发公司：东莞市梦幻科技有限公司
 * 时间：2022/8/26
 */
public interface CricketView extends BaseView<JsonBean> {
    void getDataSuccess(List<CricketTournamentBean> list);

    void getDataSuccess(boolean isRefresh, int total, List<CricketTournamentBean> list);
}
