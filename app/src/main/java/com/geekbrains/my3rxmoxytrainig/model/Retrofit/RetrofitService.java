package com.geekbrains.my3rxmoxytrainig.model.Retrofit;

import com.geekbrains.my3rxmoxytrainig.model.gson.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("/users/{user}")
    Observable <User> getUser(@Path("user") String user);
}
