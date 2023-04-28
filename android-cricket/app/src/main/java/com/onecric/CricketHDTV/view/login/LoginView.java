package com.onecric.CricketHDTV.view.login;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

public interface LoginView extends BaseView<JsonBean> {
    void loginIsSuccess(boolean isSuccess);
    void showCountryList();
}
