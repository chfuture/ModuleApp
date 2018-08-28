package com.ycwang.moduleapp.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author ycwang.
 * @date 2018-8-28.
 */
public class RetrofitActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        IUserBiz iUserBiz = RetrofitManager.getRetrofit().create(IUserBiz.class);
        Call<List<MyUser>> call = iUserBiz.getUsers();
        call.enqueue(new Callback<List<MyUser>>() {
            @Override
            public void onResponse(Call<List<MyUser>> call, Response<List<MyUser>> response) {

            }

            @Override
            public void onFailure(Call<List<MyUser>> call, Throwable t) {

            }
        });
    }
}
