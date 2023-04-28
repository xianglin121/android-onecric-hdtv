package com.onecric.CricketHDTV.view.login;

import com.onecric.CricketHDTV.model.ConfigurationBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.UserBean;
import com.onecric.CricketHDTV.view.BaseView;

public interface MainView extends BaseView<JsonBean> {
    void getVisitorUserSigSuccess(String userId, String userSig);

    void getDataSuccess(UserBean model);

    void getConfigSuccess(ConfigurationBean bean);
}
