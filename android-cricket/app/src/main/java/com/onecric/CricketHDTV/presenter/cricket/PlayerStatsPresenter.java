package com.onecric.CricketHDTV.presenter.cricket;

import com.onecric.CricketHDTV.presenter.BasePresenter;
import com.onecric.CricketHDTV.view.cricket.PlayerStatsView;

public class PlayerStatsPresenter extends BasePresenter<PlayerStatsView> {
    public PlayerStatsPresenter(PlayerStatsView view) {
        attachView(view);
    }
}
