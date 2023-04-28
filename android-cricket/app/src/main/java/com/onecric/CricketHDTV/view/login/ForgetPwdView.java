package com.onecric.CricketHDTV.view.login;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

public interface ForgetPwdView extends BaseView<JsonBean> {
    void forgetPwdSuccess(String msg);

    void forgetPwdFail(String msg);
}
