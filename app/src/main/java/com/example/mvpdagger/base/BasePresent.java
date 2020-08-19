package com.example.mvpdagger.base;

import java.lang.ref.WeakReference;

public abstract class BasePresent<V>{
    protected WeakReference<V> mTWeakReference;
    public void AttachView(V view) {       //进行绑定
        mTWeakReference = new WeakReference<V>(view);
    }
    public void onDetachView() {       //进行解绑
        if (mTWeakReference != null)
            mTWeakReference.clear();
    }
    public V getView() {
        return mTWeakReference.get();
    }
}
