package com.onecric.CricketHDTV.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.onecric.CricketHDTV.R;
import com.onecric.CricketHDTV.model.DataAttackBean;
import com.onecric.CricketHDTV.model.DataDefenseBean;
import com.onecric.CricketHDTV.model.DataWinRateBean;
import com.onecric.CricketHDTV.model.FootballDataStatusBean;
import com.onecric.CricketHDTV.util.DpUtil;
import com.onecric.CricketHDTV.util.GlideUtil;
import com.onecric.CricketHDTV.view.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发公司：东莞市梦幻科技有限公司
 * 时间：2022/1/10
 */
public class FootballDataStatusFragment extends BaseFragment implements View.OnClickListener {
    public static FootballDataStatusFragment newInstance() {
        FootballDataStatusFragment fragment = new FootballDataStatusFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    private TextView tv_total, tv_goal_count, tv_average_goal_count;
    private TextView tv_home_win_rate, tv_away_win_rate, tv_draw;
    private ViewPager mViewPager;
    private List<Fragment> mViewList;
    private TextView tv_statistic;
    private LinearLayout ll_indicator;
    private List<ImageView> indicatorList;
    //胜率
    private ImageView iv_win_home_logo;
    private TextView tv_win_home_name;
    private TextView tv_win_rate_home;
    private ImageView iv_win_away_logo;
    private TextView tv_win_away_name;
    private TextView tv_win_rate_away;
    //进攻
    private ImageView iv_attack_home_logo;
    private TextView tv_attack_home_name;
    private TextView tv_attack_rate_home;
    private ImageView iv_attack_away_logo;
    private TextView tv_attack_away_name;
    private TextView tv_attack_rate_away;
    //防守
    private ImageView iv_defense_home_logo;
    private TextView tv_defense_home_name;
    private TextView tv_defense_rate_home;
    private ImageView iv_defense_away_logo;
    private TextView tv_defense_away_name;
    private TextView tv_defense_rate_away;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_football_data_status;
    }

    @Override
    protected void initUI() {
        tv_total = findViewById(R.id.tv_total);
        tv_goal_count = findViewById(R.id.tv_goal_count);
        tv_average_goal_count = findViewById(R.id.tv_average_goal_count);
        tv_home_win_rate = findViewById(R.id.tv_home_win_rate);
        tv_away_win_rate = findViewById(R.id.tv_away_win_rate);
        tv_draw = findViewById(R.id.tv_draw);
        mViewPager = findViewById(R.id.view_pager);
        tv_statistic = findViewById(R.id.tv_statistic);
        ll_indicator = findViewById(R.id.ll_indicator);
        iv_win_home_logo = findViewById(R.id.iv_win_home_logo);
        tv_win_home_name = findViewById(R.id.tv_win_home_name);
        tv_win_rate_home = findViewById(R.id.tv_win_rate_home);
        iv_win_away_logo = findViewById(R.id.iv_win_away_logo);
        tv_win_away_name = findViewById(R.id.tv_win_away_name);
        tv_win_rate_away = findViewById(R.id.tv_win_rate_away);
        iv_attack_home_logo = findViewById(R.id.iv_attack_home_logo);
        tv_attack_home_name = findViewById(R.id.tv_attack_home_name);
        tv_attack_rate_home = findViewById(R.id.tv_attack_rate_home);
        iv_attack_away_logo = findViewById(R.id.iv_attack_away_logo);
        tv_attack_away_name = findViewById(R.id.tv_attack_away_name);
        tv_attack_rate_away = findViewById(R.id.tv_attack_rate_away);
        iv_defense_home_logo = findViewById(R.id.iv_defense_home_logo);
        tv_defense_home_name = findViewById(R.id.tv_defense_home_name);
        tv_defense_rate_home = findViewById(R.id.tv_defense_rate_home);
        iv_defense_away_logo = findViewById(R.id.iv_defense_away_logo);
        tv_defense_away_name = findViewById(R.id.tv_defense_away_name);
        tv_defense_rate_away = findViewById(R.id.tv_defense_rate_away);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    @Override
    protected void initData() {
        //初始化viewpager
        mViewList = new ArrayList<>();
        mViewList.add(FootballDataStatusGoalFragment.newInstance());
        mViewList.add(FootballDataStatusCornerFragment.newInstance());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    tv_statistic.setText("进球数分布");
                }else if (i == 1) {
                    tv_statistic.setText("角球数分布");
                }
                for (int j = 0; j < indicatorList.size(); j++) {
                    ImageView imageView = indicatorList.get(j);
                    int width = DpUtil.dp2px(6);
                    if (j == i) {
                        width = DpUtil.dp2px(12);
                        imageView.setBackgroundColor(getResources().getColor(R.color.c_E3AC72));
                    }else {
                        imageView.setBackgroundColor(getResources().getColor(R.color.line_color));
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, DpUtil.dp2px(3));
                    layoutParams.rightMargin = DpUtil.dp2px(8);
                    imageView.setLayoutParams(layoutParams);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mViewList.get(i);
            }

            @Override
            public int getCount() {
                return mViewList.size();
            }
        });
        mViewPager.setOffscreenPageLimit(mViewList.size());
        indicatorList = new ArrayList<>();
        for (int i = 0; i < mViewList.size(); i++) {
            ImageView view = new ImageView(getContext());
            int width = DpUtil.dp2px(6);
            if (i == 0) {
                width = DpUtil.dp2px(12);
                view.setBackgroundColor(getResources().getColor(R.color.c_E3AC72));
            }else {
                view.setBackgroundColor(getResources().getColor(R.color.line_color));
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, DpUtil.dp2px(3));
            layoutParams.rightMargin = DpUtil.dp2px(8);
            view.setLayoutParams(layoutParams);
            indicatorList.add(view);
            ll_indicator.addView(view);
        }
    }

    public void setData(FootballDataStatusBean bean) {
        if (bean != null) {
            if (!TextUtils.isEmpty(bean.getTotal())) {
                tv_total.setText(bean.getTotal());
            }
            if (!TextUtils.isEmpty(bean.getTotalScore())) {
                tv_goal_count.setText(bean.getTotal());
            }
            if (!TextUtils.isEmpty(bean.getTotalPointsPerGame())) {
                tv_average_goal_count.setText(bean.getTotalPointsPerGame());
            }
            if (!TextUtils.isEmpty(bean.getHomeTeamVictory())) {
                tv_home_win_rate.setText(bean.getTotal());
            }
            if (!TextUtils.isEmpty(bean.getAwayTeamWins())) {
                tv_away_win_rate.setText(bean.getAwayTeamWins());
            }
            if (!TextUtils.isEmpty(bean.getDraw())) {
                tv_draw.setText(bean.getDraw());
            }
            ((FootballDataStatusGoalFragment)mViewList.get(0)).setData(bean.getNumberOfPointsDifference());
            ((FootballDataStatusCornerFragment)mViewList.get(1)).setData(bean.getCornerLicksStatistics());
            if (bean.getWinRate() != null) {
                if (bean.getWinRate().size() > 0) {
                    DataWinRateBean dataWinRateBean = bean.getWinRate().get(0);
                    GlideUtil.loadTeamImageDefault(getContext(), dataWinRateBean.getLogo(), iv_win_home_logo);
                    if (!TextUtils.isEmpty(dataWinRateBean.getName())) {
                        tv_win_home_name.setText(dataWinRateBean.getName());
                    }
                    if (!TextUtils.isEmpty(dataWinRateBean.getWon_rate())) {
                        tv_win_rate_home.setText(dataWinRateBean.getWon_rate());
                    }
                }
                if (bean.getWinRate().size() > 1) {
                    DataWinRateBean dataWinRateBean = bean.getWinRate().get(1);
                    GlideUtil.loadTeamImageDefault(getContext(), dataWinRateBean.getLogo(), iv_win_away_logo);
                    if (!TextUtils.isEmpty(dataWinRateBean.getName())) {
                        tv_win_away_name.setText(dataWinRateBean.getName());
                    }
                    if (!TextUtils.isEmpty(dataWinRateBean.getWon_rate())) {
                        tv_win_rate_away.setText(dataWinRateBean.getWon_rate());
                    }
                }
            }
            if (bean.getAttack() != null) {
                if (bean.getAttack().size() > 0) {
                    DataAttackBean dataBean = bean.getAttack().get(0);
                    GlideUtil.loadTeamImageDefault(getContext(), dataBean.getLogo(), iv_attack_home_logo);
                    if (!TextUtils.isEmpty(dataBean.getName())) {
                        tv_attack_home_name.setText(dataBean.getName());
                    }
                    if (!TextUtils.isEmpty(dataBean.getDefensive_rebounds())) {
                        tv_attack_rate_home.setText(dataBean.getDefensive_rebounds());
                    }
                }
                if (bean.getWinRate().size() > 1) {
                    DataAttackBean dataBean = bean.getAttack().get(1);
                    GlideUtil.loadTeamImageDefault(getContext(), dataBean.getLogo(), iv_attack_away_logo);
                    if (!TextUtils.isEmpty(dataBean.getName())) {
                        tv_attack_away_name.setText(dataBean.getName());
                    }
                    if (!TextUtils.isEmpty(dataBean.getDefensive_rebounds())) {
                        tv_attack_rate_away.setText(dataBean.getDefensive_rebounds());
                    }
                }
            }
            if (bean.getDefense() != null) {
                if (bean.getDefense().size() > 0) {
                    DataDefenseBean dataBean = bean.getDefense().get(0);
                    GlideUtil.loadTeamImageDefault(getContext(), dataBean.getLogo(), iv_defense_home_logo);
                    if (!TextUtils.isEmpty(dataBean.getName())) {
                        tv_defense_home_name.setText(dataBean.getName());
                    }
                    if (!TextUtils.isEmpty(dataBean.getDefensive_rebounds())) {
                        tv_defense_rate_home.setText(dataBean.getDefensive_rebounds());
                    }
                }
                if (bean.getDefense().size() > 1) {
                    DataDefenseBean dataBean = bean.getDefense().get(1);
                    GlideUtil.loadTeamImageDefault(getContext(), dataBean.getLogo(), iv_defense_away_logo);
                    if (!TextUtils.isEmpty(dataBean.getName())) {
                        tv_defense_away_name.setText(dataBean.getName());
                    }
                    if (!TextUtils.isEmpty(dataBean.getDefensive_rebounds())) {
                        tv_defense_rate_away.setText(dataBean.getDefensive_rebounds());
                    }
                }
            }
        }
    }
}
