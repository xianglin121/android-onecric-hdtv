package com.onecric.CricketHDTV.view.theme;

import com.onecric.CricketHDTV.model.HeadlineBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface ThemeCollectionHeadlineView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<HeadlineBean> list);
}
