package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.SpeakerBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface SpeakerHistoryView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<SpeakerBean> list);
}
