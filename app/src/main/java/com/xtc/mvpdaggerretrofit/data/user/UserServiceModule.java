package com.xtc.mvpdaggerretrofit.data.user;

import com.xtc.mvpdaggerretrofit.model.User;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ouyangfan on 2015/10/26.
 */
@Module
public class UserServiceModule {
    @Provides
    User provideUser() {
        User user = new User();
        user.setId("1");
        user.setName("ouyangfan");
        return user;
    }
}
