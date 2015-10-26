package com.xtc.mvpdaggerretrofit.data.api;

import com.xtc.mvpdaggerretrofit.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by ouyangfan on 2015/10/26.
 * <p/>
 * 使用Retrofit
 * 1、定义接口
 */
public interface ApiService {
    @GET("/users")
    public void getUsers(Callback<List<User>> callback);
}
