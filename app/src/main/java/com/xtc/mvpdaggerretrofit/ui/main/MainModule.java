package com.xtc.mvpdaggerretrofit.ui.main;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ouyangfan on 2015/10/22.
 */
@Module
public class MainModule {

    private MainView mainView;

    public MainModule(MainView mainView) {
        this.mainView = mainView;
    }

    @Provides
    public MainView provideView(){
        return mainView;
    }

    @Provides
    public MainPresenter providePresenter() {
        return new MainPresenterImpl(mainView);
    }
}
