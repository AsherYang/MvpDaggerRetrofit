package com.xtc.mvpdaggerretrofit.data.gituser;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ouyangfan on 2015/10/27.
 */
@Module
public class GitUserServiceModule {
    @Provides
    public IGetGitUser provideGetGitUser() {
        return new GitUserImpl();
    }
}
