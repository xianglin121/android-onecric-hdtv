package com.onecric.CricketHDTV.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.onecric.CricketHDTV.R;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.presenter.theme.CreatorApplyPresenter;
import com.onecric.CricketHDTV.util.WordUtil;
import com.onecric.CricketHDTV.view.MvpActivity;
import com.onecric.CricketHDTV.view.theme.CreatorApplyView;

public class CreatorApplyActivity extends MvpActivity<CreatorApplyPresenter> implements CreatorApplyView, View.OnClickListener {

    public static void forward(Context context) {
        Intent intent = new Intent(context, CreatorApplyActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected CreatorApplyPresenter createPresenter() {
        return new CreatorApplyPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_creator_apply;
    }

    @Override
    protected void initView() {
        setTitleText(WordUtil.getString(this, R.string.title_creator_apply));

    }

    @Override
    protected void initData() {
    }

    @Override
    public void getDataSuccess(JsonBean model) {

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
