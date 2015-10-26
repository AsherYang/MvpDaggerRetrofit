package com.xtc.mvpdaggerretrofit.ui.main;

import com.xtc.mvpdaggerretrofit.ActivityScope;
import com.xtc.mvpdaggerretrofit.AppComponent;

import dagger.Component;

/**
 * Created by ouyangfan on 2015/10/23.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
    MainPresenter getMainPresenter();
}
