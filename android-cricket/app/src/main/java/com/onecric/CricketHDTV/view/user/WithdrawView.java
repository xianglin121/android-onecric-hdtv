package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.AccountBean;
import com.onecric.CricketHDTV.view.BaseView;

public interface WithdrawView extends BaseView<AccountBean> {
    void getCodeSuccess();

    void getBalanceSuccess(int isPayPwd, String balance, double withdrawalRadio);

    void applyWithdrawSuccess();
}
