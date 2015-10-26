package com.xtc.mvpdaggerretrofit;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ouyangfan on 2015/10/22.
 *
 * Module 提供provides
 */
@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    public Application provideApplication(){return app;}
}
