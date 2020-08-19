package com.example.mvpdagger.present;

import android.util.Log;
import com.example.mvpdagger.ModulBack;
import com.example.mvpdagger.base.BasePresent;

public class LoginPresent extends BasePresent implements PresentContract.mLoginModule,ModulBack{
    public PresentContract.mLoginModule mModule;
    public PresentContract.mLoginView mLoginView;
    public ModulBack modulBack;

    public LoginPresent(PresentContract.mLoginView loginView){
        mLoginView = loginView;
        if(mModule==null){
            mModule = this;
        }
    }
    public LoginPresent(){}

    public void LoginInitial(){
        if(mModule==null){
            mModule = this;
        }
        mLoginView = (PresentContract.mLoginView)getView();
    }

    public void getLoginData(String msg){
        mModule.CreatModul(this,msg);
    }

    @Override
    public void DataApi(String name) {
        mLoginView.LoginV(name);
    }

    @Override
    public void LoginCallBack(String data) {
        mLoginView.LoginV(data);
        Log.e("MainActivity","data = "+data);
    }

    @Override
    public void CreatModul(ModulBack modulBack, String msg){
        modulBack.LoginCallBack(msg);
    }
}
