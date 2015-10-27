package com.xtc.mvpdaggerretrofit.ui.login;

import com.xtc.mvpdaggerretrofit.model.GitUserBean;
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
    public void onRegisterBtnOnClick(GitUserBean userBean) {
        String msg = "retrofit success, userName = = " + userBean.getName();
        showMsg(msg);
    }

    @Override
    public void onLoginBtnOnClick(User user) {
        String msg = "该User是直接从Module中Inject过来的，userName = " + user.getName();
        showMsg(msg);
    }

    /**
     * 界面显示
     *
     * @param msg msg
     */
    private void showMsg(String msg) {
        loginView.showMessage(msg);
    }

}
