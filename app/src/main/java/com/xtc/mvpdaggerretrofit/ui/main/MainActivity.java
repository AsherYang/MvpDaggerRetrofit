package com.xtc.mvpdaggerretrofit.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xtc.mvpdaggerretrofit.AppComponent;
import com.xtc.mvpdaggerretrofit.R;
import com.xtc.mvpdaggerretrofit.ui.common.BaseActivity;
import com.xtc.mvpdaggerretrofit.ui.login.LoginActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements MainView {

    @Bind(R.id.txt)
    TextView txt;
    @Bind(R.id.edit)
    EditText edit;
    @Bind(R.id.btn)
    Button btn;

    @Inject
    MainPresenter mainPresenter;

    @OnClick(R.id.btn)
    void btnOnClick() {
        mainPresenter.onBtnClick();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void showTextView(String message) {
        txt.setText(message);
    }

    @Override
    public String getEditText() {
        return edit.getText().toString();
    }

}
