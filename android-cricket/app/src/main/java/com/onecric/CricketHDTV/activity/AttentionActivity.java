package com.onecric.CricketHDTV.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.onecric.CricketHDTV.R;
import com.onecric.CricketHDTV.custom.CustomPagerTitleView;
import com.onecric.CricketHDTV.fragment.FansFragment;
import com.onecric.CricketHDTV.fragment.FollowInnerFragment;
import com.onecric.CricketHDTV.view.BaseActivity;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发公司：东莞市梦幻科技有限公司
 * 时间：2021/10/25
 */
public class AttentionActivity extends BaseActivity {
    public static void forward(Context context, int type, int uid) {
        Intent intent = new Intent(context, AttentionActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("uid", uid);
        context.startActivity(intent);
    }

    private MagicIndicator magicIndicator;
    private List<String> mTitles;
    private ViewPager mViewPager;
    private List<Fragment> mViewList;
    private int type;

    @Override
    public int getLayoutId() {
        return R.layout.activity_live_more_function;
    }

    @Override
    protected void initView() {
        mTitles = new ArrayList<>();
        mViewList = new ArrayList<>();
        magicIndicator = findViewById(R.id.indicator_one);
        mViewPager = findViewById(R.id.viewpager);
    }

    @Override
    protected void initData() {
//        mTitles.add(getString(R.string.user_my_reserve));
        type = getIntent().getIntExtra("type", 0);
        int uid = getIntent().getIntExtra("uid", 0);
        String title = "";
        if (type == 0) {
            title = getString(R.string.anchor);
        } else if (type == 1) {
            title = getString(R.string.author);
        } else {
            title = getString(R.string.fans_1);
        }
        mTitles.add(title);
//        mViewList.add(MyReserveFragment.newInstance());
        if (type == 0 || type == 1) {
            mViewList.add(FollowInnerFragment.newInstance(type,uid));
        } else {
            mViewList.add(FansFragment.newInstance(uid));
        }

        initViewPager();
    }

    private void initViewPager() {
        //初始化指示器
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int index) {
                CustomPagerTitleView titleView = new CustomPagerTitleView(context);
//                titleView.setNormalColor(getResources().getColor(R.color.c_666666));
//                titleView.setSelectedColor(getResources().getColor(R.color.c_DC3C23));
//                titleView.setText(mTitles.get(index));
//                titleView.setTextSize(17);
//                titleView.getPaint().setFakeBoldText(true);
                titleView.setNormalColor(getResources().getColor(R.color.white));
                titleView.setSelectedColor(getResources().getColor(R.color.white));
                titleView.setText(mTitles.get(index));
                titleView.setTextSize(18);
                titleView.setOnPagerTitleChangeListener(new CustomPagerTitleView.OnPagerTitleChangeListener() {
                    @Override
                    public void onSelected(int index, int totalCount) {
                    }

                    @Override
                    public void onDeselected(int index, int totalCount) {
                    }

                    @Override
                    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {

                    }

                    @Override
                    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {

                    }
                });
                titleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mViewPager != null) {
                            mViewPager.setCurrentItem(index);
                        }
                    }
                });
                return titleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
/*                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                linePagerIndicator.setLineWidth(DpUtil.dp2px(25));
                linePagerIndicator.setLineHeight(DpUtil.dp2px(3));
                linePagerIndicator.setXOffset(DpUtil.dp2px(0));
                linePagerIndicator.setYOffset(DpUtil.dp2px(1));
                linePagerIndicator.setRoundRadius(DpUtil.dp2px(2));
                linePagerIndicator.setColors(getResources().getColor(R.color.c_DC3C23));
                return linePagerIndicator;*/
                return null;
            }
        });
        //初始化viewpager
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mViewList.get(i);
            }

            @Override
            public int getCount() {
                return mViewList.size();
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }
}
