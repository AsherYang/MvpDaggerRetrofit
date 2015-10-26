package com.xtc.mvpdaggerretrofit.ui.main;

/**
 * Created by ouyangfan on 2015/10/23.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onBtnClick() {
        mainView.showTextView(mainView.getEditText());
    }

}
