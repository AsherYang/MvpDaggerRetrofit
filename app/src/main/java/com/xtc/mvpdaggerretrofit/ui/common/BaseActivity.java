package com.xtc.mvpdaggerretrofit.ui.common;

import android.app.Activity;
import android.os.Bundle;

import com.xtc.mvpdaggerretrofit.App;
import com.xtc.mvpdaggerretrofit.AppComponent;


/**
 * Created by ouyangfan on 2015/10/22.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent((AppComponent) App.get(this).component());
    }

    protected abstract void setupComponent(AppComponent appComponent);
}
