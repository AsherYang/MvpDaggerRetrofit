package com.xtc.mvpdaggerretrofit.data.gituser;

import com.xtc.mvpdaggerretrofit.data.api.ApiService;
import com.xtc.mvpdaggerretrofit.model.GitUserBean;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ouyangfan on 2015/10/27.
 */
public class GitUserImpl implements IGetGitUser {

    private OnGetGitUserListener mUserListener;

    @Override
    public void getGitUserFromNet(String user, ApiService apiService,
                                  OnGetGitUserListener userListener) {
        mUserListener = userListener;
        apiService.getUsers(user, mCallback);
    }

    private Callback<GitUserBean> mCallback = new Callback<GitUserBean>() {
        @Override
        public void success(GitUserBean gitUserBean, Response response) {
            mUserListener.onSuccess(gitUserBean);
        }

        @Override
        public void failure(RetrofitError error) {
            mUserListener.onError(error.getMessage());
        }
    };

}
