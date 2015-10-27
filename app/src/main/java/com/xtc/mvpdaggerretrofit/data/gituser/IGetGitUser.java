package com.xtc.mvpdaggerretrofit.data.gituser;

import com.xtc.mvpdaggerretrofit.data.api.ApiService;

/**
 * Created by ouyangfan on 2015/10/27.
 */
public interface IGetGitUser {
    public void getGitUserFromNet(String user, ApiService apiService, OnGetGitUserListener userListener);
}
