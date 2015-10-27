package com.xtc.mvpdaggerretrofit.ui.login;

import com.xtc.mvpdaggerretrofit.ActivityScope;
import com.xtc.mvpdaggerretrofit.AppComponent;
import com.xtc.mvpdaggerretrofit.data.gituser.GitUserServiceModule;
import com.xtc.mvpdaggerretrofit.data.user.UserServiceModule;

import dagger.Component;

/**
 * Created by ouyangfan on 2015/10/23.
 */
@ActivityScope
@Component(
        modules = {LoginModule.class, UserServiceModule.class, GitUserServiceModule.class},
        dependencies = {AppComponent.class}
)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
    LoginPresenter getLoginPresenter();
}
