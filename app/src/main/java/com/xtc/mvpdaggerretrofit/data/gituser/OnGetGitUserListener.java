package com.xtc.mvpdaggerretrofit.data.gituser;

import com.xtc.mvpdaggerretrofit.model.GitUserBean;

/**
 * Created by ouyangfan on 2015/10/27.
 */
public interface OnGetGitUserListener {
    public void onSuccess(GitUserBean gitUserBean);
    public void onError(String error);
}
