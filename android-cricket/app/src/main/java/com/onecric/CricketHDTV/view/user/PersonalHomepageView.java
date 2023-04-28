package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.UserBean;
import com.onecric.CricketHDTV.view.BaseView;

public interface PersonalHomepageView extends BaseView<UserBean> {
    void doFollowSuccess(int id);
}
