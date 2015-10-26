package com.xtc.mvpdaggerretrofit.ui.login;

import com.xtc.mvpdaggerretrofit.ActivityScope;
import com.xtc.mvpdaggerretrofit.AppComponent;
import com.xtc.mvpdaggerretrofit.data.AppServiceModule;

import dagger.Component;

/**
 * Created by ouyangfan on 2015/10/23.
 */
@ActivityScope
@Component(
        modules = {LoginModule.class, AppServiceModule.class},
        dependencies = {AppComponent.class}
)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
    LoginPresenter getLoginPresenter();
}
