package com.xtc.mvpdaggerretrofit.ui.login;

import com.xtc.mvpdaggerretrofit.data.api.ApiService;
import com.xtc.mvpdaggerretrofit.data.gituser.IGetGitUser;
import com.xtc.mvpdaggerretrofit.data.gituser.OnGetGitUserListener;
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
    public void onRegisterBtnOnClick(String userName, IGetGitUser gitUser, ApiService apiService) {
        loginView.showProgress();
        gitUser.getGitUserFromNet(userName, apiService, mOnGetGitUserListener);
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
        loginView.hideProgress();
        loginView.showMessage(msg);
    }

    /**
     * 监听Retrofit 返回的网络结果
     */
    private OnGetGitUserListener mOnGetGitUserListener = new OnGetGitUserListener() {
        @Override
        public void onSuccess(GitUserBean gitUserBean) {
            String msg = "retrofit success, userName = " + gitUserBean.getName();
            showMsg(msg);
        }

        @Override
        public void onError(String error) {
            showMsg(error);
        }
    };
}
