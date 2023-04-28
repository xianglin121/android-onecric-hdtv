package com.onecric.CricketHDTV.view.cricket;

import com.onecric.CricketHDTV.model.CricketInfoBean;
import com.onecric.CricketHDTV.model.CricketPointsBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

/**
 * 开发公司：东莞市梦幻科技有限公司
 * 时间：2022/8/26
 */
public interface CricketInfoView extends BaseView<CricketInfoBean> {
    void getPointsDataSuccess(List<CricketPointsBean> list);
}
