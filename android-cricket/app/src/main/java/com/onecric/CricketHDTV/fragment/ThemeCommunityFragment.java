package com.onecric.CricketHDTV.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.onecric.CricketHDTV.CommonAppConfig;
import com.onecric.CricketHDTV.R;
import com.onecric.CricketHDTV.activity.CommunityPublishActivity;
import com.onecric.CricketHDTV.activity.ThemeCollectionActivity;
import com.onecric.CricketHDTV.adapter.ChannelPagerAdapter;
import com.onecric.CricketHDTV.custom.CustomPagerInnerTitleView;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.presenter.theme.ThemeCommunityPresenter;
import com.onecric.CricketHDTV.util.ToastUtil;
import com.onecric.CricketHDTV.util.WordUtil;
import com.onecric.CricketHDTV.view.MvpFragment;
import com.onecric.CricketHDTV.view.theme.ThemeCommunityView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;

import java.util.ArrayList;
import java.util.List;

public class ThemeCommunityFragment extends MvpFragment<ThemeCommunityPresenter> implements ThemeCommunityView {

    public static ThemeCommunityFragment newInstance() {
        ThemeCommunityFragment fragment = new ThemeCommunityFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    private MagicIndicator mIndicator;
    private List<String> mTitles;
    private ViewPager mViewPager;
    private ChannelPagerAdapter mPagerAdapter;
    private List<Fragment> mViewList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_theme_community;
    }

    @Override
    protected ThemeCommunityPresenter createPresenter() {
        return new ThemeCommunityPresenter(this);
    }

    @Override
    protected void initUI() {
        mTitles = new ArrayList<>();
        mViewList = new ArrayList<>();

        mIndicator = rootView.findViewById(R.id.indicator);
        mViewPager = rootView.findViewById(R.id.view_pager);
        rootView.findViewById(R.id.iv_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(CommonAppConfig.getInstance().getUid())) {
                    ToastUtil.show(getString(R.string.please_login));
                    return;
                }
                ThemeCollectionActivity.forward(getContext(), 1);
            }
        });
        rootView.findViewById(R.id.iv_publish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(CommonAppConfig.getInstance().getToken())) {
                    CommunityPublishActivity.forward(getContext());
                }else {
                    ToastUtil.show(getString(R.string.please_login));
                }
            }
        });
    }

    @Override
    protected void initData() {
        mTitles.add(WordUtil.getString(getActivity(), R.string.theme_hot));
        mTitles.add(WordUtil.getString(getActivity(), R.string.follow));

        mViewList.add(ThemeCommunityHotFragment.newInstance());
        mViewList.add(ThemeCommunityFollowFragment.newInstance());
        initViewPager();
    }

    private void initViewPager() {
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitles == null ? 0 : mTitles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int index) {
                CustomPagerInnerTitleView titleView = new CustomPagerInnerTitleView(context);
//                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.rightMargin = DpUtil.dp2px(12);
//                titleView.setContentView(R.layout.item_ym_indicator);
//                titleView.setLayoutParams(layoutParams);
//                SuperTextView tv_name = titleView.findViewById(R.id.tv_name);
                titleView.setText(mTitles.get(index));
                titleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index, false);
                    }
                });
                return titleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        commonNavigator.setAdjustMode(true);
        mIndicator.setNavigator(commonNavigator);
        mPagerAdapter = new ChannelPagerAdapter(getChildFragmentManager(), mViewList);
        mViewPager.setOffscreenPageLimit(mViewList.size());
        mViewPager.setAdapter(mPagerAdapter);
        ViewPagerHelper.bind(mIndicator, mViewPager);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void getDataSuccess(JsonBean model) {

    }

    @Override
    public void getDataFail(String msg) {

    }
}
