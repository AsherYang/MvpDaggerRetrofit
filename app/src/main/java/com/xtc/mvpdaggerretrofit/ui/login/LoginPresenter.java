package com.xtc.mvpdaggerretrofit.ui.login;

import com.xtc.mvpdaggerretrofit.model.GitUserBean;
import com.xtc.mvpdaggerretrofit.model.User;

/**
 * Created by ouyangfan on 2015/10/23.
 */
public interface LoginPresenter {
    public void onRegisterBtnOnClick(GitUserBean userBean);
    public void onLoginBtnOnClick(User user);
}
