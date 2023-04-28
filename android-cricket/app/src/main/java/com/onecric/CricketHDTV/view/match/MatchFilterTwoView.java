package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.FilterBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface MatchFilterTwoView extends BaseView<JsonBean> {
    void getDataSuccess(List<FilterBean> competitionList, List<FilterBean> countryList, int countryCount, int selectCountryCount);
}
