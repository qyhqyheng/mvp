package com.example.mvpdagger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mvpdagger.base.BasePresent;
import com.example.mvpdagger.base.BaseView;

public abstract class BaseActivity<V extends BaseView,P extends BasePresent> extends Activity implements View.OnClickListener{
    protected P basePresenter;
    <T extends View> T FindViewById(int id){
        T view = findViewById(id);
        if(view instanceof Button){
            ((Button) view).setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onClick(View v) {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        basePresenter = createPresenter();
        if (basePresenter != null){
            basePresenter.AttachView((V) this);
        }
        super.onCreate(savedInstanceState);
    }
    protected abstract P createPresenter();
}
