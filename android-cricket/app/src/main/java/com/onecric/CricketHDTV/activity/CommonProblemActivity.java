package com.onecric.CricketHDTV.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.onecric.CricketHDTV.R;
import com.onecric.CricketHDTV.adapter.CommonProblemAdapter;
import com.onecric.CricketHDTV.model.ProblemBean;
import com.onecric.CricketHDTV.presenter.user.CommonProblemPresenter;
import com.onecric.CricketHDTV.util.WordUtil;
import com.onecric.CricketHDTV.view.MvpActivity;
import com.onecric.CricketHDTV.view.user.CommonProblemView;

import java.util.ArrayList;
import java.util.List;

public class CommonProblemActivity extends MvpActivity<CommonProblemPresenter> implements CommonProblemView, View.OnClickListener {

    public static void forward(Context context) {
        Intent intent = new Intent(context, CommonProblemActivity.class);
        context.startActivity(intent);
    }

    private RecyclerView recyclerView;
    private CommonProblemAdapter mAdapter;

    @Override
    protected CommonProblemPresenter createPresenter() {
        return new CommonProblemPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_common_problem;
    }

    @Override
    protected void initView() {
        setTitleText(WordUtil.getString(this, R.string.user_common_problem));

        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        mAdapter = new CommonProblemAdapter(R.layout.item_common_problem, new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        mvpPresenter.getList();
    }

    @Override
    public void getDataSuccess(List<ProblemBean> list) {
        if (list != null) {
            mAdapter.setNewData(list);
        }
    }

    @Override
    public void getDataFail(String msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }
}
