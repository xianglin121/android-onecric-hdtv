package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.FootballDetailBean;
import com.onecric.CricketHDTV.model.ReportBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface FootballMatchDetailView extends BaseView<FootballDetailBean> {
    void getReportListSuccess(List<ReportBean> list);

    void doReportSuccess();
}
