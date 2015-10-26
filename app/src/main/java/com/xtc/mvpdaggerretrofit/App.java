package com.xtc.mvpdaggerretrofit;

import android.app.Application;
import android.content.Context;

import com.xtc.mvpdaggerretrofit.data.api.ApiServiceModule;

/**
 * Created by ouyangfan on 2015/10/22.
 * <p/>
 * <p/>
 * MVP 模式
 * <p/>
 * data 数据来源,MVP中的M, 使用Retrofit获取数据data
 * model 实体bean,本应该也放在data中,为了方便抽出来,bean在很多地方可以用的到
 * ui 视图,V和P都在这里
 * <p/>
 * dagger2 可以使mvp的V–>P–>M的之间依赖也轻松解决 方便不少
 */
public class App extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    /**
     * Application中初始化构建图
     */
    private void setupGraph() {
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiServiceModule(new ApiServiceModule())
                .build();
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }
}
