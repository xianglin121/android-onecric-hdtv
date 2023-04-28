package com.onecric.CricketHDTV.view.theme;

import com.onecric.CricketHDTV.model.CommunityBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface ThemeCollectionCommunityView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<CommunityBean> list);
}
