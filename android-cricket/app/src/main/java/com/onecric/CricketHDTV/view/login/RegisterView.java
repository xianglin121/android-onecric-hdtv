package com.onecric.CricketHDTV.view.login;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

public interface RegisterView extends BaseView<JsonBean> {
    void registerSuccess(String msg);

    void registerFail(String msg);
}
