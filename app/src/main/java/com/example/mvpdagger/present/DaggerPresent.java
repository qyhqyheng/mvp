package com.example.mvpdagger.present;

import com.example.mvpdagger.ModulBack;

public class DaggerPresent implements PresentContract.DaggerModule,ModulBack{
    PresentContract.DaggerModule daggerModule;
    PresentContract.DaggerView daggerView;
    public DaggerPresent(PresentContract.DaggerView daggerView){
        this.daggerView = daggerView;
        if(daggerModule==null){
            daggerModule = this;
        }
    }

    public void DaggerData(String data){
        daggerModule.CreatModul(this,data);
    }

    @Override
    public void DaggerApi(String name) {

    }

    @Override
    public void CreatModul(ModulBack modulBack, String msg) {
        modulBack.LoginCallBack(msg);
    }

    @Override
    public void LoginCallBack(String data) {
        daggerView.DaggerV(data);
    }
}
