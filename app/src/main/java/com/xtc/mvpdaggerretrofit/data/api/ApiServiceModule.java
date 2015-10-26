package com.xtc.mvpdaggerretrofit.data.api;

import android.app.Application;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by ouyangfan on 2015/10/26.
 * <p/>
 * 使用dagger2
 * <p/>
 * 主要是提供一些RestApi
 */
@Module
public class ApiServiceModule {
    // ENDPOINT 为BASE_URL
    private static final String ENDPOINT = "";

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter(Application application, OkHttpClient okHttpClient) {
        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setClient(new OkClient(okHttpClient)).setEndpoint(ENDPOINT);
        return builder.build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(RestAdapter restAdapter) {
        return restAdapter.create(ApiService.class);
    }

}
