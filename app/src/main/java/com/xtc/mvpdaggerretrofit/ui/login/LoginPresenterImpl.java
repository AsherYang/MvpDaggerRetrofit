package com.xtc.mvpdaggerretrofit.ui.login;

import com.xtc.mvpdaggerretrofit.model.User;

/**
 * Created by ouyangfan on 2015/10/23.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onRegisterBtnOnClick() {
        loginView.showMessage("register");
    }

    @Override
    public void onLoginBtnOnClick(User user) {
        loginView.showMessage("login userName = " + user.getName());
    }
}
