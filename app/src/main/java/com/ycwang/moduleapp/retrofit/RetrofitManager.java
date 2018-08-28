package com.ycwang.moduleapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ycwang.
 * @date 2018-8-28.
 */
public class RetrofitManager {


    public static Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build();
        return retrofit;
    }
}
