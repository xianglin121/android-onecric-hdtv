package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.BasketballDetailBean;
import com.onecric.CricketHDTV.model.ReportBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface BasketballMatchDetailView extends BaseView<BasketballDetailBean> {
    void getReportListSuccess(List<ReportBean> list);

    void doReportSuccess();
}
