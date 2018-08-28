package com.ycwang.moduleapp.retrofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author ycwang.
 * @date 2018-8-28.
 */
public interface IUserBiz {

    @GET("user")
    Call<List<MyUser>> getUsers();


}
