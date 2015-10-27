package com.xtc.mvpdaggerretrofit.ui.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xtc.mvpdaggerretrofit.AppComponent;
import com.xtc.mvpdaggerretrofit.R;
import com.xtc.mvpdaggerretrofit.data.api.ApiService;
import com.xtc.mvpdaggerretrofit.data.gituser.GitUserServiceModule;
import com.xtc.mvpdaggerretrofit.data.gituser.IGetGitUser;
import com.xtc.mvpdaggerretrofit.data.gituser.OnGetGitUserListener;
import com.xtc.mvpdaggerretrofit.data.user.UserServiceModule;
import com.xtc.mvpdaggerretrofit.model.GitUserBean;
import com.xtc.mvpdaggerretrofit.model.User;
import com.xtc.mvpdaggerretrofit.ui.common.BaseActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ouyangfan on 2015/10/23.
 */
public class LoginActivity extends BaseActivity implements LoginView {
    @Bind(R.id.username)
    EditText username;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.register)
    Button register;
    @Bind(R.id.login)
    Button login;

    @Inject
    LoginPresenter loginPresenter;

    /**
     * 该user 是通过Modules从AppServiceModule处依赖而来,可以直接@Inject初始化
     */
    @Inject
    User user;

    /**
     * 该apiService 是通过dependencies从AppComponent再从ApiServiceModule处依赖而来
     */
    @Inject
    ApiService apiService;

    /**
     * 该gitUser(接口中的方法)是通过Modules从GitUserServiceModule处依赖而来,
     * 将Retrofit访问网络逻辑放入Module层,并提供结果值出来。
     * 这种方式是抽离出来,将业务层放入Module而不是之前的V-P层。
     */
    @Inject
    IGetGitUser gitUser;

    @OnClick(R.id.register)
    void registerBtnClick() {
        String user = username.getText().toString();
        gitUser.getGitUserFromNet(user, apiService, mOnGetGitUserListener);
    }

    @OnClick(R.id.login)
    void loginBtnClick() {
        loginPresenter.onLoginBtnOnClick(user);
    }

    /**
     * 每个界面必须的初始化component操作.已经在基类BaseActivity中提供方法.
     *
     * @param appComponent appComponent 用来提供全局单例对象
     */
    @Override
    protected void setupComponent(AppComponent appComponent) {
        // 关键的就是这句话,将appComponent和Module关联起来
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .userServiceModule(new UserServiceModule())
                .gitUserServiceModule(new GitUserServiceModule())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    /**
     * 界面显示
     *
     * @param message msg
     */
    @Override
    public void showMessage(String message) {
//        String msg = message + "\t" + username.getText().toString() + "\t" + password.getText().toString();
//        String msg = user.getName();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 监听Retrofit 返回的网络结果
     */
    private OnGetGitUserListener mOnGetGitUserListener = new OnGetGitUserListener() {
        @Override
        public void onSuccess(GitUserBean gitUserBean) {
            loginPresenter.onRegisterBtnOnClick(gitUserBean);
        }

        @Override
        public void onError(String error) {
            showMessage(error);
        }
    };
}
