package com.onecric.CricketHDTV.view.theme;

import com.onecric.CricketHDTV.model.CommunityBean;
import com.onecric.CricketHDTV.model.ThemeClassifyBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface CommunityDetailView extends BaseView<ThemeClassifyBean> {
    void getDataSuccess(boolean isRefresh, List<CommunityBean> list);
}
