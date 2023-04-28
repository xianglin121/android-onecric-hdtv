package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.BalanceBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.WithdrawBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface MyWalletView extends BaseView<JsonBean> {
    void getDataSuccess(boolean isRefresh, List<BalanceBean> list);

    void getWithdrawDataSuccess(boolean isRefresh, List<WithdrawBean> list);
}
