package com.example.mvpdagger;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.example.mvpdagger.common.MyTouchListener;
import com.example.mvpdagger.dagger.component.DaggerMainActivityComponent;
import com.example.mvpdagger.dagger.module.MainActivityModule;
import com.example.mvpdagger.present.DaggerPresent;
import com.example.mvpdagger.present.LoginPresent;
import com.example.mvpdagger.present.PresentContract;
import com.example.mvpdagger.view.LoginView;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<LoginView,LoginPresent> implements PresentContract.mLoginView ,PresentContract.DaggerView{
    Button bt_login;
    MyTouchListener myTouchListener;
    @Inject
    LoginPresent loginpresenter;

    @Inject
    DaggerPresent daggerPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_login = FindViewById(R.id.bt_login);
        basePresenter.LoginInitial();
        DaggerMainActivityComponent component= (DaggerMainActivityComponent) DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this,this))
                .build();
        component.in(this);
//        myTouchListener = new MyTouchListener();
        bt_login.setOnTouchListener(new MyTouchListener());
    }

    @Override
    protected LoginPresent createPresenter() {
        Log.e("MainActivity","createPresenter---onCreate111");
        return new LoginPresent();
    }

    @Override
    public void onClick(View v) {
        if(v==bt_login){
//            loginpresenter.getLoginData("View_LoginData");
            daggerPresent.DaggerData("DaggerData");
            basePresenter.getLoginData("View_LoginData");
        }
    }

    @Override
    public void LoginV(String msg) {
        Log.e("MainActivity","LoginV---msg = "+msg);
    }

    @Override
    public void DaggerV(String msg) {
        Log.e("MainActivity","DaggerV---msg = "+msg);
    }

}
