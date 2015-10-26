package com.xtc.mvpdaggerretrofit.ui.login;

import com.xtc.mvpdaggerretrofit.data.api.ApiService;
import com.xtc.mvpdaggerretrofit.model.GitUserBean;
import com.xtc.mvpdaggerretrofit.model.User;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ouyangfan on 2015/10/23.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onRegisterBtnOnClick(String user, ApiService apiService) {
        if (user == null || "".equals(user)) {
            showMsg("请输入正确的gitHub用户名!");
        }else {
            getGitUserFromNet(user, apiService);
        }
    }

    @Override
    public void onLoginBtnOnClick(User user) {
        String msg = "该User是直接从Module中Inject过来的，userName = " + user.getName();
        showMsg(msg);
    }

    /**
     * 从网络获取user
     *
     * @param user       EditText中输入的userName
     * @param apiService retrofit 提供的RestApi
     */
    private void getGitUserFromNet(String user, ApiService apiService) {
        apiService.getUsers(user, mGitUserCallback);
    }

    /**
     * 访问网络异步回调
     */
    private Callback<GitUserBean> mGitUserCallback = new Callback<GitUserBean>() {
        @Override
        public void success(GitUserBean gitUserBean, Response response) {
            String msg = "retrofit success, userName = " + gitUserBean.getName();
            showMsg(msg);
        }

        @Override
        public void failure(RetrofitError error) {
            String msg = "retrofit fail = " + error.getMessage();
            showMsg(msg);
        }

    };

    /**
     * 界面显示
     *
     * @param msg msg
     */
    private void showMsg(String msg) {
        loginView.showMessage(msg);
    }

}
