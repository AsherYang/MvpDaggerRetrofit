package com.xtc.mvpdaggerretrofit.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xtc.mvpdaggerretrofit.AppComponent;
import com.xtc.mvpdaggerretrofit.R;
import com.xtc.mvpdaggerretrofit.data.api.ApiService;
import com.xtc.mvpdaggerretrofit.data.gituser.GitUserServiceModule;
import com.xtc.mvpdaggerretrofit.data.gituser.IGetGitUser;
import com.xtc.mvpdaggerretrofit.data.user.UserServiceModule;
import com.xtc.mvpdaggerretrofit.model.User;
import com.xtc.mvpdaggerretrofit.ui.common.BaseActivity;
import com.xtc.mvpdaggerretrofit.ui.customview.MetaballView;

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
    @Bind(R.id.metaball_view)
    MetaballView metaballView;

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
        loginPresenter.onRegisterBtnOnClick(user, gitUser, apiService);
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
        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {
        metaballView.setPaintMode(1);
    }

    /**
     * 界面显示
     *
     * @param message msg
     */
    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示进度条
     */
    @Override
    public void showProgress() {
        metaballView.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏进度条
     */
    @Override
    public void hideProgress() {
        metaballView.setVisibility(View.GONE);
    }

}
