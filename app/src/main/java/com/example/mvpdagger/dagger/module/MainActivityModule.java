package com.example.mvpdagger.dagger.module;

import com.example.mvpdagger.MainActivity;
import com.example.mvpdagger.present.DaggerPresent;
import com.example.mvpdagger.present.LoginPresent;
import com.example.mvpdagger.present.PresentContract;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    PresentContract.mLoginView loginView;
    PresentContract.DaggerView daggerView;
    public MainActivityModule(PresentContract.mLoginView mLoginView,PresentContract.DaggerView daggerView) {
        this.loginView = mLoginView;
        this.daggerView = daggerView;
    }
    @Provides
    LoginPresent provideLoginPresenter() {
        return new LoginPresent(loginView);
    }

    @Provides
    DaggerPresent provideDaggerPresenter() {
        return new DaggerPresent(daggerView);
    }
}
