package com.onecric.CricketHDTV.view.user;

import com.onecric.CricketHDTV.model.CoinBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface ChargeView extends BaseView<List<CoinBean>> {
    void paySuccess(String url);

    void payFail(String msg);
}
