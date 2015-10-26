package com.xtc.mvpdaggerretrofit.data.api;

import com.xtc.mvpdaggerretrofit.model.GitUserBean;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by ouyangfan on 2015/10/26.
 * <p/>
 * 使用Retrofit
 * 1、定义接口
 *
 * @GET("/users/{user}"), 添加这个注解会调用服务器，
 * 参数url基于BASE URL，服务调用的参数以'/'开头，其中{user}是从EditText获取的字符串。
 * @Path("user") String user 就是我们从EditText获取的字符串。
 * 服务器端响应的数据则会被存储到POJO实例中去。
 */
public interface ApiService {
    @GET("/users/{user}")
    public void getUsers(@Path("user") String user, Callback<GitUserBean> callback);
}
