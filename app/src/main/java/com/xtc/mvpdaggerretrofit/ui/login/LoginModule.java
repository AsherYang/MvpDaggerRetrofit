package com.xtc.mvpdaggerretrofit.ui.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ouyangfan on 2015/10/23.
 */
@Module
public class LoginModule {

    private LoginView loginView;

    public LoginModule(LoginView loginView) {
        this.loginView = loginView;
    }

    @Provides
    public LoginView provideView() {
        return loginView;
    }

    @Provides
    public LoginPresenter providePresenter() {
        return new LoginPresenterImpl(loginView);
    }

}
