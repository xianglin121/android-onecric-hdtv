package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.MessageBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface MyMessageView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<MessageBean> list);
}
