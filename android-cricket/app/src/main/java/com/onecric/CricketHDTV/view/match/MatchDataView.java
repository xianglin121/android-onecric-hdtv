package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.MatchDataClassifyBean;
import com.onecric.CricketHDTV.model.MatchDataFirstBean;
import com.onecric.CricketHDTV.model.MatchDataFollowBean;
import com.onecric.CricketHDTV.model.MatchDataSecondBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface MatchDataView extends BaseView<JsonBean> {
    void getFollowListSuccess(List<MatchDataFollowBean> list);

    void getClassifyListSuccess(List<MatchDataClassifyBean> list);

    void getCountryListSuccess(List<MatchDataFirstBean> list);

    void getListSuccess(int position, List<MatchDataSecondBean> list);
}
