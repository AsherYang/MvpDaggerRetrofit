package com.xtc.mvpdaggerretrofit.ui.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xtc.mvpdaggerretrofit.AppComponent;
import com.xtc.mvpdaggerretrofit.R;
import com.xtc.mvpdaggerretrofit.data.AppServiceModule;
import com.xtc.mvpdaggerretrofit.data.api.ApiService;
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

    /** 该user 是通过Modules从AppServiceModule处依赖而来,可以直接@Inject初始化 */
    @Inject
    User user;

    /** 该apiService 是通过dependencies从AppComponent再从ApiServiceModule处依赖而来  */
    @Inject
    ApiService apiService;

    @OnClick(R.id.register)
    void registerBtnClick() {
        String user = username.getText().toString();
        loginPresenter.onRegisterBtnOnClick(user, apiService);
    }

    @OnClick(R.id.login)
    void loginBtnClick() {
        loginPresenter.onLoginBtnOnClick(user);
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        // 关键的就是这句话,将appComponent和Module关联起来
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .appServiceModule(new AppServiceModule())
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


    @Override
    public void showMessage(String message) {
//        String msg = message + "\t" + username.getText().toString() + "\t" + password.getText().toString();
//        String msg = user.getName();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
