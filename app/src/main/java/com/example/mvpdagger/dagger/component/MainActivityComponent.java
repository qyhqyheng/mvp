package com.example.mvpdagger.dagger.component;

import com.example.mvpdagger.MainActivity;
import com.example.mvpdagger.dagger.module.MainActivityModule;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
     void in(MainActivity mainActivity);
}
