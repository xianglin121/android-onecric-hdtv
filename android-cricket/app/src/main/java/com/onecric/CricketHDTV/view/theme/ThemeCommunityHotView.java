package com.onecric.CricketHDTV.view.theme;

import com.onecric.CricketHDTV.model.CommunityBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.ThemeClassifyBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface ThemeCommunityHotView extends BaseView<JsonBean> {
    void getDataSuccess(List<ThemeClassifyBean> classifyList, CommunityBean refining);

    void getList(boolean isRefresh, List<CommunityBean> list);
}
