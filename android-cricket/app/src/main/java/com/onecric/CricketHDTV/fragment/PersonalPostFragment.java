package com.onecric.CricketHDTV.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.onecric.CricketHDTV.Constant;
import com.onecric.CricketHDTV.R;
import com.onecric.CricketHDTV.activity.CommunityCommentActivity;
import com.onecric.CricketHDTV.adapter.PersonalPostThemeAdapter;
import com.onecric.CricketHDTV.adapter.ThemeCommunityAdapter;
import com.onecric.CricketHDTV.model.CommunityBean;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.model.ThemeClassifyBean;
import com.onecric.CricketHDTV.presenter.user.PersonalPostPresenter;
import com.onecric.CricketHDTV.view.MvpFragment;
import com.onecric.CricketHDTV.view.theme.ThemeCommunityHotView;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

public class PersonalPostFragment extends MvpFragment<PersonalPostPresenter> implements ThemeCommunityHotView, View.OnClickListener {

    private PersonalPostThemeAdapter mGroupAdapter;
    private String userid;
    private int id;

    public static PersonalPostFragment newInstance(String id) {
        PersonalPostFragment fragment = new PersonalPostFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    private SmartRefreshLayout smart_rl;
    private RecyclerView rv_community;
    private ThemeCommunityAdapter mAdapter;
    private RecyclerView rv_group;
    private LinearLayout ll_select;

    private int mPage = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personal_post;
    }

    @Override
    protected PersonalPostPresenter createPresenter() {
        return new PersonalPostPresenter(this);
    }

    @Override
    protected void initUI() {
        smart_rl = findViewById(R.id.smart_rl);
        rv_community = findViewById(R.id.rv_community);
        rv_group = findViewById(R.id.rv_group);
        ll_select = findViewById(R.id.ll_select);
        ll_select.setOnClickListener(this);
        mGroupAdapter = new PersonalPostThemeAdapter(R.layout.item_personal_post_head, new ArrayList<>());
        mGroupAdapter.setOnItemClickListener((adapter, view, position) -> {
//                CommunityDetailActivity.forward(getContext(), mGroupAdapter.getItem(position).getId());
            ThemeClassifyBean item = (ThemeClassifyBean) adapter.getItem(position);
            id = item.getId();
            List<ThemeClassifyBean> data = adapter.getData();
            for (ThemeClassifyBean bean : data) {
                bean.setSelected(false);
            }
            item.setSelected(true);
            adapter.notifyDataSetChanged();
            //todo 调用接口根据筛选条件获取数据
            smart_rl.setNoMoreData(false);
            mvpPresenter.getData(true, 1, Integer.parseInt(this.userid), id);
        });
        rv_group.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_group.setAdapter(mGroupAdapter);

    }

    @Override
    protected void initData() {
        userid = getArguments().getString("id");
        MaterialHeader materialHeader = new MaterialHeader(getContext());
        materialHeader.setColorSchemeColors(getContext().getResources().getColor(R.color.c_DC3C23));
        smart_rl.setRefreshHeader(materialHeader);
        smart_rl.setRefreshFooter(new ClassicsFooter(getContext()));
        smart_rl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mvpPresenter.getData(false, mPage, Integer.parseInt(userid), id);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mvpPresenter.getData(true, 1, Integer.parseInt(userid), id);
            }
        });

        mAdapter = new ThemeCommunityAdapter(R.layout.item_theme_community, new ArrayList<>());
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CommunityCommentActivity.forward(getContext(), mAdapter.getItem(position).getUid(), mAdapter.getItem(position).getId());
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.ll_like) {
                    CommunityBean item = mAdapter.getItem(position);
                    int like = item.getLikes();
                    if (item.getIs_likes() == 1) {
                        like--;
                        item.setIs_likes(0);
                    } else {
                        like++;
                        item.setIs_likes(1);
                    }
                    item.setLikes(like);
                    mAdapter.notifyItemChanged(position, Constant.PAYLOAD);
                    mvpPresenter.doCommunityLike(item.getId());
                }
            }
        });
        rv_community.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_community.setAdapter(mAdapter);

        smart_rl.autoRefresh();
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
    public void getDataSuccess(List<ThemeClassifyBean> classifyList, CommunityBean refining) {
        if (mPage == 1) {
            if (classifyList != null) {
                mGroupAdapter.setNewData(classifyList);
            }
//            if (refining != null) {
//                if (!TextUtils.isEmpty(refining.getTitle())) {
//                    tv_notice.setText(refining.getTitle());
//                }
//            }
        }
    }

    @Override
    public void getList(boolean isRefresh, List<CommunityBean> list) {
        if (isRefresh) {
            smart_rl.finishRefresh();
            mPage = 2;
            if (list != null) {
                if (list.size() > 0) {
                    hideEmptyView();
                } else {
                    showEmptyView();
                }
                mAdapter = new ThemeCommunityAdapter(R.layout.item_theme_community, list);
                rv_community.setAdapter(mAdapter);
//                mAdapter.setNewData(list);
            } else {
                mAdapter.setNewData(new ArrayList<>());
                showEmptyView();
            }
        } else {
            mPage++;
            if (list != null && list.size() > 0) {
                smart_rl.finishLoadMore();
                mAdapter.addData(list);
            } else {
                smart_rl.finishLoadMoreWithNoMoreData();
            }
        }
    }


    @Override
    public void getDataFail(String msg) {
        smart_rl.finishRefresh();
        smart_rl.finishLoadMore();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_select:
                break;
        }
    }
}
