package com.onecric.CricketHDTV.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.onecric.CricketHDTV.R;
import com.onecric.CricketHDTV.model.JsonBean;
import com.onecric.CricketHDTV.presenter.login.LoginPresenter;
import com.onecric.CricketHDTV.view.MvpActivity;
import com.onecric.CricketHDTV.view.login.LoginView;

/**
 * 开发公司：东莞市梦幻科技有限公司
 * 时间：2022/9/1
 */
public class LoginNewActivity extends MvpActivity<LoginPresenter> implements LoginView, View.OnClickListener {
    public static void forward(Context context) {
        Intent intent = new Intent(context, LoginNewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_new;
    }

    @Override
    protected void initView() {
        findViewById(R.id.tv_forget_pwd).setOnClickListener(this);
        findViewById(R.id.btn_register).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void loginIsSuccess(boolean isSuccess) {

    }

    @Override
    public void showCountryList() {

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
            case R.id.tv_forget_pwd:
                ForgetPwdNewActivity.forward(this);
                break;
            case R.id.btn_register:
                RegisterNewActivity.forward(this);
                break;
        }
    }
}
