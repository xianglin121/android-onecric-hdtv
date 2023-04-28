package com.onecric.CricketHDTV.view;

import com.onecric.CricketHDTV.model.CricketMatchDataBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.LinkDataBean;

import java.util.List;


/**
 * 开发公司：东莞市梦幻科技有限公司
 * 时间：2022/8/26
 */
public interface CricketLiveView extends BaseView<JsonBean> {
    void getDataSuccess(List<CricketMatchDataBean> bean);

    void getInfoSuccess(LinkDataBean bean);

    void getDataFail(String msg);

}
