package com.onecric.CricketHDTV.view.match;

import com.onecric.CricketHDTV.model.MatchSearchBean;
import com.onecric.CricketHDTV.view.BaseView;

import java.util.List;

public interface SearchMatchView extends BaseView<MatchSearchBean> {
    void getMoreData(int type,List<MatchSearchBean> list);
    void getDataSuccess(List<MatchSearchBean> bean,int type);
    void getDataFail(String msg,int type);
}
