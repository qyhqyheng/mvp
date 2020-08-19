package com.example.mvpdagger.present;

import com.example.mvpdagger.base.BaseModul;
import com.example.mvpdagger.base.BasePresent;
import com.example.mvpdagger.base.BaseView;

public interface PresentContract {
    interface mLoginView extends BaseView<LoginPresent>{
        void LoginV(String msg);
    }

    interface mLoginModule extends BaseModul {
        void DataApi(String name);
    }

    interface DaggerView extends BaseView<LoginPresent>{
        void DaggerV(String msg);
    }

    interface DaggerModule extends BaseModul {
        void DaggerApi(String name);
    }
}
