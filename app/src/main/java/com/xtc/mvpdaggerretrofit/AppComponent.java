package com.xtc.mvpdaggerretrofit;

import com.xtc.mvpdaggerretrofit.data.api.ApiService;
import com.xtc.mvpdaggerretrofit.data.api.ApiServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ouyangfan on 2015/10/22.
 */
@Singleton
@Component(
        modules = {AppModule.class, ApiServiceModule.class}
)
public interface AppComponent {
    void inject(App app);

    ApiService getApiService();
}
